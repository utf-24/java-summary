package com.yzy.demo.redis;

import lombok.Data;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.ZParams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author young
 * @date 2019/6/27 10:04
 */
public class Chapter07 {
    private static final Pattern QUERY_RE = Pattern.compile("[+-]?[a-z']{2,}");
    private static final Pattern WORDS_RE = Pattern.compile("[a-z']{2,}");
    private static final Set<String> STOP_WORDS = new HashSet<String>();
    public static final char WORD_WITHOUT_PREFIX = '0';
    public static final int SET_DEFAULT_TTL = 30;
    static {
        for (String word :
                ("able about across after all almost also am among " +
                        "an and any are as at be because been but by can " +
                        "cannot could dear did do does either else ever " +
                        "every for from get got had has have he her hers " +
                        "him his how however if in into is it its just " +
                        "least let like likely may me might most must my " +
                        "neither no nor not of off often on only or other " +
                        "our own rather said say says she should since so " +
                        "some than that the their them then there these " +
                        "they this tis to too twas us wants was we were " +
                        "what when where which while who whom why will " +
                        "with would yet you your").split(" "))
        {
            STOP_WORDS.add(word);
        }
    }
    public static void main(String[] args) {
        new Chapter07().run();
    }

    public void run(){
    }

    public Query parse(String queryStr){
        Set<String> current = new HashSet<>();
        Query query = new Query();
        Matcher matcher = QUERY_RE.matcher(queryStr);
        while(matcher.find()){
            String word = matcher.group().trim();
            char prefix = word.charAt(0);
            if(prefix == '+' || prefix == '-'){
                word = word.substring(1);
            }else{
                prefix = WORD_WITHOUT_PREFIX;
            }
            //搜索词不符合规范，跳过
            if(word.length()<2 || STOP_WORDS.contains(word)){
                continue;
            }
            // 统计 -关键词
            if(prefix == '-'){
                query.unwanted.add(word);
                continue;
            }
            // 将所有同义词加入all集合
            if(!current.isEmpty() && prefix ==WORD_WITHOUT_PREFIX){
                query.all.add(new ArrayList<>(current));
                current.clear();
            }
            // 将+关键词加入current
            current.add(word);
        }

        if(!current.isEmpty()){
            query.all.add(new ArrayList<>(current));
        }

        return query;
    }

    /**
     * 根据内容获取有效的候选词
     *
     * @param content
     * @return
     */
    public Set<String> tokenize(String content){
        Matcher matcher = QUERY_RE.matcher(content);
        Set<String> resultSet = new HashSet<>();
        while(matcher.find()){
            String word = matcher.group().trim();
            if(word.length()>2 && !STOP_WORDS.contains(word)){
                resultSet.add(word);
            }
        }

        return resultSet;
    }

    /**
     * 对文档简历反向索引
     *
     * @param conn
     * @param docId
     * @param content
     * @return
     */
    public int indexDocument(Jedis conn, String docId, String content){
        Set<String> wordSet = tokenize(content);
        //开始文档索引事务
        Transaction trans = conn.multi();
        for(String word: wordSet){
            trans.sadd("idx:"+word,docId);
        }

        return trans.exec().size();
    }

    private String setCommon(
            Transaction trans, String method, int ttl, String... items)
    {
        String[] keys = new String[items.length];
        for (int i = 0; i < items.length; i++){
            keys[i] = "idx:" + items[i];
        }

        String id = UUID.randomUUID().toString();
        try{
            trans.getClass()
                    .getDeclaredMethod(method, String.class, String[].class)
                    .invoke(trans, "idx:" + id, keys);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        trans.expire("idx:" + id, ttl);
        return id;
    }

    public String intersect(Transaction trans, int ttl, String... items) {
        return setCommon(trans, "sinterstore", ttl, items);
    }

    public String union(Transaction trans, int ttl, String... items) {
        return setCommon(trans, "sunionstore", ttl, items);
    }

    public String difference(Transaction trans, int ttl, String... items) {
        return setCommon(trans, "sdiffstore", ttl, items);
    }

    private String zsetCommon(
            Transaction trans, String method, int ttl, ZParams params, String... sets)
    {
        String[] keys = new String[sets.length];
        for (int i = 0; i < sets.length; i++) {
            keys[i] = "idx:" + sets[i];
        }

        String id = UUID.randomUUID().toString();
        try{
            trans.getClass()
                    .getDeclaredMethod(method, String.class, ZParams.class, String[].class)
                    .invoke(trans, "idx:" + id, params, keys);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        trans.expire("idx:" + id, ttl);
        return id;
    }

    public String zintersect(
            Transaction trans, int ttl, ZParams params, String... sets)
    {
        return zsetCommon(trans, "zinterstore", ttl, params, sets);
    }

    public String zunion(
            Transaction trans, int ttl, ZParams params, String... sets)
    {
        return zsetCommon(trans, "zunionstore", ttl, params, sets);
    }

    public String parseAndSearch(Jedis conn, String queryStr,int ttl){
        Query query = parse(queryStr);
        if(query.all.isEmpty()){
            System.out.println("没有候选词！");
            return null;
        }

        List<String> toIntersect = new ArrayList<>();
        for(List<String> syn: query.all){
            if(syn.size() == 1){
                toIntersect.add(syn.get(0));
            }
            if(syn.size()>1){
                //对同义词集合进行并集运算
                Transaction trans = conn.multi();
                toIntersect.add(union(trans,ttl, syn.toArray(new String[syn.size()])));
                trans.exec();
            }
        }
        String interSectResult = null;
        if(toIntersect.size()>1){
            Transaction trans = conn.multi();
            // 对所有并集运算的结果求交集,这样做符合精准查询
            // 每个筛选的候选词反向索引文档求交集
            interSectResult = intersect(trans,ttl,
                    toIntersect.toArray(new String[toIntersect.size()]));
            trans.exec();
        }
        if(toIntersect.size() == 1){
            interSectResult = toIntersect.get(0);
        }

        if(!query.unwanted.isEmpty()) {
            // 如果有过滤词汇，求差集
            String[] keys = query.unwanted
                    .toArray(new String[query.unwanted.size() + 1]);
            //没懂？不应该在 index为0的位置插入interSecResult吗？
            keys[keys.length - 1] = interSectResult;
            Transaction trans = conn.multi();
            interSectResult = difference(trans, ttl, keys);
            trans.exec();
        }
        return interSectResult;
    }

    /**
     *
     * @param id
     * @param conn
     * @param queryStr
     * @param sort
     * @param start
     * @param num
     * @return
     */
    public SearchResult searchAndSort(Jedis conn, String queryStr,
                                      String sort, int start, int num){
        boolean desc = sort.startsWith("-");
        if(desc){
            sort = sort.substring(1);
        }
        String by = "kb:doc:*->"+sort;
        boolean alpha = !"updated".equals(sort) && !"id".equals(sort) && "created".equals(sort);
        String id = parseAndSearch(conn, queryStr,300);

        Transaction trans = conn.multi();
        trans.scard("idx:" + id);
        SortingParams params = new SortingParams();
        if (desc) {
            params.desc();
        }
        if (alpha){
            params.alpha();
        }
        params.by(by);
        params.limit(0, 20);
        trans.sort("idx:" + id, params);
        List<Object> results = trans.exec();

        return new SearchResult(id,
                ((Long)results.get(0)).longValue(),
                (List<String>)results.get(1));
    }

    @Data
    public class Query{
        public final List<List<String>> all = new ArrayList<>();
        public final Set<String> unwanted = new HashSet<>();
    }

    public class SearchResult {
        public final String id;
        public final long total;
        public final List<String> results;

        public SearchResult(String id, long total, List<String> results) {
            this.id = id;
            this.total = total;
            this.results = results;
        }
    }

}
