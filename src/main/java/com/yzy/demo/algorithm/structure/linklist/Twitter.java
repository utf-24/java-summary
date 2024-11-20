package com.yzy.demo.algorithm.structure.linklist;

import java.util.*;

/**
 * 设计Node对象，包含关注人的list集合，自己发送的推文集合；
 * 设计 哈希， 用户id -> node ， 推特id-> id时间戳
 * 维护全局time 时间戳
 * 获取前10条最新推文，根据每个用户的推文和已有的结果依次比较合并产生新的答案；
 */
public class Twitter {
    private class UserInfo {
        LinkedList<Integer> tweets;
        Set<Integer> followees;
        UserInfo() {
            tweets = new LinkedList<>();
            followees = new HashSet<>();
        }
    }

    /**
     * userId -> userInfo
     */
    Map<Integer, UserInfo> users;

    /**
     * tweetId -> tweetTime
     */
    Map<Integer, Integer> tweetId2Time;

    // 最新条数，时间戳
    private int recentMax,time;


    public Twitter() {
        recentMax = 10;
        users = new HashMap<>();
        tweetId2Time = new HashMap<>();
    }

    public void initUser(int userId) {
        users.put(userId, new UserInfo());
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            initUser(userId);
        }
        if (users.get(userId).tweets.size() == recentMax) {
            users.get(userId).tweets.removeLast();
        }
        users.get(userId).tweets.addFirst(tweetId);
        tweetId2Time.put(tweetId, ++time);
    }

    public List<Integer> getNewsFeed(int userId) {
        UserInfo userInfo = users.getOrDefault(userId, new UserInfo());
        List<Integer> result = new LinkedList<>(userInfo.tweets);
        for (int followee : userInfo.followees) {
            if (followee == userId) continue;
            List<Integer> followeeTweets = users.get(followee).tweets;
            List<Integer> tempResult = new LinkedList<>();
            int rIdx = 0, fIdx = 0, curTweetId = -1;
            if ( fIdx < followeeTweets.size()) {
                while (rIdx < result.size() && fIdx < followeeTweets.size()) {
                    curTweetId = followeeTweets.get(fIdx);
                    if(tweetId2Time.get(curTweetId) > tweetId2Time.get(result.get(rIdx))) {
                        tempResult.add(curTweetId);
                        fIdx++;
                    } else {
                        tempResult.add(result.get(rIdx));
                        rIdx++;
                    }
                    if (tempResult.size() == recentMax) break;
                }
            }
            while (fIdx < followeeTweets.size() && tempResult.size() < recentMax) {
                tempResult.add(followeeTweets.get(fIdx));
                fIdx++;
            }
            for (; rIdx < result.size() && tempResult.size() < recentMax; rIdx++) {
                tempResult.add(result.get(rIdx));
            }

            result = new LinkedList<>(tempResult);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followeeId)) initUser(followeeId);
        if (!users.containsKey(followerId)) initUser(followerId);
        users.get(followerId).followees.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).followees.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.postTweet(2, 2);
        twitter.postTweet(3, 3);
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.postTweet(3, 6);
        twitter.postTweet(1, 7);
        twitter.postTweet(2, 8);
        twitter.postTweet(3, 9);
        twitter.postTweet(1, 10);
        twitter.postTweet(2, 11);
        twitter.postTweet(3, 12);
        twitter.follow(1,2);
        twitter.follow(1,3);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 3);
        System.out.println(twitter.getNewsFeed(1));
    }
}
