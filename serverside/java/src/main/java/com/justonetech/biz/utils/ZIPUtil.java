package com.justonetech.biz.utils;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;


public class ZIPUtil {

    public ZIPUtil() {
    }

    public void CreateZipFile(String filePath, String zipFilePath) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFilePath);
            zos = new ZipOutputStream(fos);
            writeZipFile(new File(filePath), zos, "");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (zos != null)
                    zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void writeZipFile(File f, ZipOutputStream zos, String hiberarchy) {
        if (f.exists()) {
            if (f.isDirectory()) {
                hiberarchy += f.getName() + "/";
                File[] fif = f.listFiles();
                for (int i = 0; i < fif.length; i++) {
                    writeZipFile(fif[i], zos, hiberarchy);
                }

            } else {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(f);
                    ZipEntry ze = new ZipEntry(hiberarchy + f.getName());
                    zos.putNextEntry(ze);
                    byte[] b = new byte[1024];
                    while (fis.read(b) != -1) {
                        zos.write(b);
                        b = new byte[1024];
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fis != null)
                            fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

    private static ZIPUtil zu = null;

    public static ZIPUtil getInstance() {
        if (zu == null)
            zu = new ZIPUtil();
        return zu;

    }
    public void zip(String inputFileName,String targetName) throws Exception {
           zip(targetName, new File(inputFileName));
       }

       private void zip(String zipFileName, File inputFile) throws Exception {
           ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
           zip(out, inputFile, "");
           System.out.println("zip done");
           out.close();
       }

       private void zip(ZipOutputStream out, File f, String base) throws Exception {
           if (f.isDirectory()) {
              File[] fl = f.listFiles();
//              out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
              base = base.length() == 0 ? "" : base + "/";
              for (int i = 0; i < fl.length; i++) {
              zip(out, fl[i], base + fl[i].getName());
            }
           }else {
              out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
              FileInputStream in = new FileInputStream(f);
              int b;
              System.out.println(base);
              while ( (b = in.read()) != -1) {
               out.write(b);
            }
            in.close();
          }
       }





}
