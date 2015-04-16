package com.justonetech.biz.utils;


import com.justonetech.core.utils.JspHelper;
import jxl.Workbook;
import jxl.write.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.util.StringHelper;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class ExcelUtil {

    // jqgrid上显示出来的属性
    private String properties;
    private String[] cols;

    public String[] getCols() {
        return cols;
    }

    public void setCols(String[] cols) {
        this.cols = cols;
    }

    public void setProperties(String properties) {
        cols = properties.split(",");
        this.properties = properties;
    }


    /**
     * 导出EXCEL当hql
     *
     * @param fileName  文件名/sheet名
     * @param showtitle 导出的EXCEL列名
     * @param dataList  数据列表,注:一定要传与页面显示的相同的bean列表，不然会报找不到属性，
     * @return .
     */

    public String exportExcelwhenhql(String fileName, String[] showtitle, List dataList, String[] indexes, String filePath) {
        try {
            OutputStream os;
            WritableWorkbook wwb;
            os = new FileOutputStream(filePath + fileName + ".xls");
            wwb = Workbook.createWorkbook(os);
//                    response.setContentType("aplication/vnd.ms-excel");
//        response
//                .addHeader("Content-Disposition", "inline; filename="
//                        + new String(fileName.getBytes("GB2312"), "ISO8859_1")
//                        + ".xls");
// 添加第一个工作表并设置第一个Sheet的名字

            WritableSheet sheet = wwb.createSheet(fileName, 0);
            Label label;
            exportExcel(fileName, showtitle, dataList, indexes, "header", sheet);
            WritableCellFormat wcfcell = formatCell("");
            // 下面是填充数据
            if (dataList != null && dataList.size() > 0) {
                for (int i = 0; i < dataList.size(); i++) {
                    for (int j = 0; j < cols.length; j++) {
                        String value = "";
                        try {
                            value = PropertyUtils.getProperty(dataList.get(i), cols[j]).toString();
                        } catch (Exception e) {
                            value = "";
                        } finally {
                            if (!StringHelper.isEmpty(value)) {
                                if (value.equals("true")) {
                                    value = "是";
                                }
                                if (value.equals("false")) {
                                    value = "否";
                                }
                                label = new Label(j, i + 1, value, wcfcell);
                            } else {
                                label = new Label(j, i + 1, "  ", wcfcell);
                            }
                        }
                        sheet.addCell(label);
                        label = null;
                    }
                }
            }
            wwb.write();
            // 关闭
            wwb.close();
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     * 导出EXCEL当sql
     *
     * @param fileName  文件名/sheet名
     * @param showtitle 导出的EXCEL列名
     * @param dataList  数据列表,注:一定要传与页面显示的相同的bean列表，不然会报找不到属性
     * @param indexes  筛选的导出列索引
     * @param filePath  文件路径
     * @param actualIndexs  筛选的导出列对应的实际查询结果的列索引
     * @return .
     */

    public boolean exportExcelwhensql(String fileName, String[] showtitle, List dataList, String[] indexes, String filePath, String actualIndexs) {
        try {
//            System.out.println("....................indexes = " + indexes.length);
//            System.out.println("....................actualIndexs = " + actualIndexs);
            String[] actualIndex = actualIndexs.split(",");

            // 创建Excel工作薄
            OutputStream os;
            WritableWorkbook wwb;
            os = new FileOutputStream(filePath + fileName + ".xls");
            wwb = Workbook.createWorkbook(os);
            // 添加第一个工作表并设置第一个Sheet的名字
            WritableSheet sheet = wwb.createSheet(fileName, 0);
            Label label;
            exportExcel(fileName, showtitle, dataList, indexes, "header", sheet);
            WritableCellFormat wcfcell = formatCell("");
            // 下面是填充数据
            if (dataList != null && dataList.size() > 0) {
                for (int i = 0; i < dataList.size(); i++) {
                    Object[] ss = (Object[]) dataList.get(i);
                    for (int j = 0; j < indexes.length; j++) {
                        String aIndex = actualIndex[j];
                        String value = JspHelper.getString(ss[Integer.parseInt(aIndex) - 1]);
//                        System.out.println("value = " + value);
                        if (!StringHelper.isEmpty(value)) {
                            if (value.equals("true")) {
                                value = "是";
                            }
                            if (value.equals("false")) {
                                value = "否";
                            }
                            label = new Label(j, i + 1, value, wcfcell);
                        } else {
                            label = new Label(j, i + 1, "  ", wcfcell);
                        }
                        sheet.addCell(label);
                        label = null;
                    }
                }
            }
            wwb.write();
            // 关闭
            wwb.close();
            os.flush();
            os.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {

        }
    }

    public void exportExcel(String fileName, String[] showtitle, List dataList, String[] indexes, String cell, WritableSheet sheet)
            throws Exception {
        //第一行
        Label label;
        WritableCellFormat wcf = formatCell(cell);
        if (showtitle != null) {
            for (int i = 0; i < showtitle.length; i++) {
                if (showtitle[i].equals("操作")) {
                    break;
                }
                label = new Label(i, 0, showtitle[i], wcf);
                sheet.setColumnView(i, 25);
                sheet.addCell(label);
            }
        }
    }

    public WritableCellFormat formatCell(String cell) throws Exception {
        //给cell添加样式
        if (cell.equals("header")) {
            WritableFont wf = new WritableFont(WritableFont.TAHOMA, 14, WritableFont.NO_BOLD, false);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcf.setBackground(jxl.format.Colour.GRAY_25);
            return wcf;
        } else {
            WritableFont wfcell = new WritableFont(WritableFont.TIMES, 12, WritableFont.NO_BOLD, false);
            WritableCellFormat wcfcell = new WritableCellFormat(wfcell);
            wcfcell.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            return wcfcell;
        }

    }
//
//    public void downloadExcelToZip(HttpServletResponse response, String filename, String filePath,int count) {
//        String tmpFileName = filename+".zip";
//        byte[] buffer = new byte[1024];
//        String strZipPath = filePath + tmpFileName;
//        try {
//            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
//                    strZipPath));
//            // 需要同时下载的多个文件
//
//            File[] filedow = new File[count];
//            for(int i=0;i<count;i++){
//                filedow[i]=new File(filePath+filename+(i+1)+".xls");
//            }
//            for (int i = 0; i < filedow.length; i++) {
//                FileInputStream fis = new FileInputStream(filedow[i]);
//                out.putNextEntry(new ZipEntry(filedow[i].getName()));
//                //设置压缩文件内的字符编码，不然会变成乱码
//                out.setEncoding("GBK");
//                int len;
//                // 读入需要下载的文件的内容，打包到zip文件
//                while ((len = fis.read(buffer)) > 0) {
//                    out.write(buffer, 0, len);
//                }
//                out.closeEntry();
//                fis.close();
//            }
//            out.close();
////            this.downFile(response, strZipPath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}



