package com.justonetech.biz.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * description: 计算代码总行数
 * User: Chenjp
 * Date: 14-11-4 下午3:34
 */
public class ProjectLineCounter {
    List<File> list = new ArrayList<File>();
    int linenumber = 0;
    private String fileTypes = "java,jsp,html,js,cpt,xml";   //计算文件类型

    FileReader fr = null;
    BufferedReader br = null;

    public void counter(String projectName) {
//      String path = System.getProperty("user.dir");
        String path = ProjectLineCounter.class.getResource("/").getPath();  // 同下个path
        System.out.println("path = " + path);
        path = path.substring(0, path.length() - 24) + projectName + "/src";
        path = "/E:/svn/hkjjw/serverside/java/src";
        System.out.println(path);
        File file = new File(path);
        File files[] = null;
        files = file.listFiles();
        addFile(files);
        isDirectory(files);
        readLinePerFile();
        System.out.println("Total:" + linenumber + "行");
    }

    // 判断是否是目录
    public void isDirectory(File[] files) {
        if(files != null){
        for (File s : files) {
            if (s.isDirectory()) {
                File file[] = s.listFiles();
                addFile(file);
                isDirectory(file);
                continue;
            }
        }
        }
    }

    //将src下所有文件组织成list
    public void addFile(File file[]) {
        if(file != null){
        for (int index = 0; index < file.length; index++) {
            list.add(file[index]);
            // System.out.println(list.size());
        }
        }
    }

    //读取非空白行
    public void readLinePerFile() {
        try {
            for (File s : list) {
                int yuan = linenumber;
                if (s.isDirectory()) {
                    continue;
                }
                if(!fileTypes.contains(FilenameUtils.getExtension(s.getName()))){
                    continue;
                }
                fr = new FileReader(s);
                br = new BufferedReader(fr);
                String i = "";
                while ((i = br.readLine()) != null) {
                    if (isBlankLine(i))
                        linenumber++;
                }
                System.out.print(s.getName());
                System.out.println("\t\t有" + (linenumber - yuan) + "行");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                }
            }
        }
    }

    //是否是空行
    public boolean isBlankLine(String i) {
        if (i.trim().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {
        ProjectLineCounter lc = new ProjectLineCounter();
        String projectName = "HKJJW_MIS"; //这里传入你的项目名称
        lc.counter(projectName);
    }
}
