package com.yzy.demo.util;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzyh
 * @date 2021/8/26 10:43
 */
public class PartitionUtil {

    /**
     * 生成表分区脚本
     * @param tableNames  表名集合
     * @throws IOException
     */
    public static void generatePartitionScripts(String[] tableNames) throws IOException {
        FileReader reader = new FileReader("D:\\region.txt");
        BufferedReader bf = new BufferedReader(reader);
        BufferedWriter out = new BufferedWriter(new FileWriter("partition.sql"));
        String region = null;
        List<String> regions = new ArrayList<>();
        String createTableSpace = "CREATE TABLESPACE {fbpm_mof} LOGGING DATAFILE '/u01/app/oracle/oradata/UFGOVDB1/{fbpm_mof}.dbf'\n" +
                "SIZE 10M AUTOEXTEND ON NEXT 200M MAXSIZE 30720M EXTENT MANAGEMENT LOCAL;";
        // 创建表空间
        while ((region = bf.readLine()) != null) {
            regions.add(region);
            String fbpmMofName = "fbpm_mof_" + region;
            String createTableSpaceResult = createTableSpace.replace("{fbpm_mof}", fbpmMofName);
            out.write(createTableSpaceResult);
            out.write("\n");
        }
        bf.close();
        String defaultTableSpace = createTableSpace.replace("{fbpm_mof}", "fbpm_mof_default");
        out.write(defaultTableSpace + "\n");
        out.write("\n--每张表的分区规则--\n");
        // 编写每个表的分区规则
        for (String table: tableNames) {
            String commentStart =  "\n--" +table + "表分区执行\n";
            out.write(commentStart);
            String renameSql = "rename {table} to {table}_BACKUP;\n";
            renameSql = renameSql.replace("{table}", table);
            out.write(renameSql);
            String createSqlStart = "create table " + table + "  partition by list (MOF_DIV_CODE)\n(\n";
            out.write(createSqlStart);
            regions.forEach(eachRegion ->{
                //partition ACT_RU_TASK_mof_div_369900000 values ('369900000') tablespace fbpm_mof_369900000,
                String partitionSql ="partition " + table  + eachRegion + " values ('" + eachRegion
                        + "') tablespace fbpm_mof_" + eachRegion + ",\n";
                try {
                    out.write(partitionSql);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.write("partition " + table + "null values (null) tablespace fbpm_mof_default\n");
            String createSqlEnd = ") as select * from " + table +"_BACKUP;\n";
            out.write(createSqlEnd);
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        //需要表分区的表
        String[] tableNames = {"ACT_RU_TASK","ACT_HI_TASKINST","ACT_RU_EXECUTION", "ACT_HI_PROCINST",
        "ACT_RU_ACTINST","ACT_RU_IDENTITYLINK","ACT_HI_COMMENT","ACT_PROC_HI_STATE","ACT_BIZRELATIONS"};
        generatePartitionScripts(tableNames);
        System.out.println("done!");
    }
}
