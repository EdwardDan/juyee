package com.justonetech.biz.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * description: 记录同步日志
 * User: Chenjp
 * Date: 12-12-7 下午2:22
 */
public class LogFileUtils {
    /**
     * 记录日志
     * @param path 文件路径
     * @param content 日志内容
     * @param append 是否追加
     * @return .
     */
    public static boolean logFile(String path, String content, boolean append) {
        boolean res = true;
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, append);
            if (append) {
                content = System.getProperty("line.separator") + content;
            }
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            res = false;
            ex.printStackTrace();
        }
        return res;
    }
}
