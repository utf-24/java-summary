package com.yzy.demo;

import java.io.File;

/**
 * @author young
 * @date 2019/9/28 14:49
 */
public class ChangeFileName {
    private static String dir ;

    private static void renameFiles(String path){
        File folder = new File(dir);
        if(folder.exists()){
            File[] fileArray = folder.listFiles();
            for(File file: fileArray) {
                String fileName = file.getName();
                String[] prefix = fileName.split("夺");
                String pre = prefix[0];
                String newName = "夺权野兽" + pre + ".m4a";
                String parentDir = file.getParent();
                if (file.renameTo(new File(parentDir + "/" + newName))) {
                    System.out.println("after change: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        renameFiles(dir);
    }
}
