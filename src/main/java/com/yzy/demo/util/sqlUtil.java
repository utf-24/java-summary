package com.yzy.demo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yangzyh
 * @date 2021/8/28 11:26
 */
public class sqlUtil {

    /**
     * ACT_DB_SHARDING_CONFIG_BACKUP 批量操生成insert
     */
    public static void generateInsertSql () throws IOException {
        FileReader reader = new FileReader("D:\\region1.txt");
        BufferedReader bf = new BufferedReader(reader);
        String sql = "INSERT INTO ACT_DB_SHARDING_CONFIG_BACKUP (RG_CODE, FISCAL_YEAR, DB_NAME) VALUES ";
        String region = null;
        while ((region = bf.readLine()) != null) {
            String resultSql = "('" + region + "', '2021', 'ds5');";
            resultSql = sql + resultSql;
            System.out.println(resultSql);
        }
    }

    public static void main(String[] args) throws IOException {
        generateInsertSql();
    }

}
