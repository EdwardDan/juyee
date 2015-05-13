package com.justonetech.system.manager;

import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.utils.FileUtils;
import jxl.write.WriteException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Excel打印导出处理类
 */
@Service
public class ExcelPrintManager {
    private Logger logger = LoggerFactory.getLogger(ExcelPrintManager.class);

    @Autowired
    private ConfigManager configManager;

    /**
     * 获取Excel模板地址
     *
     * @param request      。
     * @param templateName 模板文件名
     * @return 实际路径名
     */
    public String getExcelTemplateFileName(HttpServletRequest request, String templateName) {
        //去除了request.getContextPath()，此处是要获取文件的绝对路径，不需要contextPath
        String name = "/view/printTemplate/" + templateName;
        return request.getRealPath(name);
    }

    /**
     * 获取输出文件地址
     *
     * @param className .
     * @param fileName  .
     * @return .
     */
    public String getOutputFileName(String className, String fileName) {
        String path = configManager.getFilePath() + File.separator + className;
        File file = new File(path);
        //判断如果没有该目录，就创建目录
        if (!file.isDirectory()) {
            FileUtils.mkDirs(path);
        }

        //替换文件名中的"/"符号，避免寻找目标文件地址报错
        Pattern pattern = Pattern.compile("[^\\/|\\\\]*");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            fileName = fileName.replace("/", "_");
        }

        return path + File.separator + fileName;
    }

    /**
     * 保存Excel输出文件
     *
     * @param templateFile 模板文件名
     * @param beans        表单数据
     * @param outputFile   输出文件名
     * @throws java.io.IOException
     */
    private void saveExcelFile(String templateFile, Map beans, String outputFile) throws IOException {
        //把数据压入模板中，并输出文件到目标地址
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(templateFile, beans, outputFile);
    }

    /**
     * 读取已经生成的Excel文件，并下载
     *
     * @param response   .
     * @param outputFile 输出文件
     * @throws java.io.IOException
     */
    public void readExcelFile(HttpServletResponse response, String outputFile) throws IOException {
        FileInputStream inputStream = null;
        //根据路径找到文件
        File file = new File(outputFile);

        //如果找不到该文件，则抛出异常
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.debug(file + "不存在！");
        }

        response.reset();
        response.setHeader("Server", "pdampmis");
        response.setContentType("Application/vnd.ms-excel");
        response.setCharacterEncoding("gb2312");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(file.getName().getBytes(), "ISO8859-1"));
        IOUtils.copyLarge(inputStream, response.getOutputStream());
        response.getOutputStream().flush();
    }

    /**
     * Excel打印接口
     *
     * @param response     .
     * @param request      .
     * @param className    类名
     * @param templateName 模板文件名，比如 contAuditReportPrint.xls
     * @param beans        表单数据 Map
     * @param fileName     输出文件名，比如 2009年11月_第11期.xls
     * @throws java.io.IOException
     */
    public void printExcel(HttpServletResponse response, HttpServletRequest request, String className, String templateName, Map beans, String fileName) throws IOException {
        //获取模板文件
        String templateFile = getExcelTemplateFileName(request, templateName);
        logger.debug("templateFile===" + templateFile);

        //获取输出文件
        String outputFile = getOutputFileName(className, fileName);
        logger.debug("outputFile===" + outputFile);

        //保存输出文件
        saveExcelFile(templateFile, beans, outputFile);

        //读取输出文件
        readExcelFile(response, outputFile);
    }

    /**
     * Excel打印接口
     *
     * @param response     .
     * @param request      .
     * @param className    类名
     * @param templateName 模板文件名，比如 contAuditReportPrint.xls
     * @param beans        表单数据 Map
     * @param fileName     输出文件名，比如 2009年11月_第11期.xls
     * @param map          需要合并的列
     * @throws java.io.IOException .
     */
    public void printExcel(HttpServletResponse response, HttpServletRequest request, String className, String templateName, Map beans, String fileName, Map map) throws Exception {
        //获取模板文件
        String templateFile = getExcelTemplateFileName(request, templateName);
        System.out.println("templateFile===" + templateFile);
        //获取输出文件
        String outputFile = getOutputFileName(className, fileName);
        System.out.println("outputFile===" + outputFile);

        HSSFWorkbook hssfWorkbook = transformXLSToHSSFWorkbook(templateFile, beans);
        //合并单元格
        if(!map.isEmpty()){
            setMergerCells(hssfWorkbook, map);
        }

        FileOutputStream fileOut = new FileOutputStream(outputFile);
        hssfWorkbook.write(fileOut);
        fileOut.close();
//        读取输出文件
        readExcelFile(response, outputFile);
    }

    public HSSFWorkbook transformXLSToHSSFWorkbook(String templateFile, Map beans) throws Exception {
        InputStream inp = new FileInputStream(templateFile);
        //把数据压入模板中，并输出文件到目标地址
        XLSTransformer transformer = new XLSTransformer();
        HSSFWorkbook hssfWorkbook = transformer.transformXLS(inp, beans);
        inp.close();
        return hssfWorkbook;
    }

    /**
     * 根据起始列和结束列位置进行合并
     *
     * @param hssfWorkbook .
     * @param map          page=3&offset=299&mergerCellsList=List<int[]>           .
     * @throws Exception .
     */
    public void setMergerCells(HSSFWorkbook hssfWorkbook, Map map) throws Exception {

        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

        //获得默认第一个sheet
        int page = JspHelper.getInteger(map.get("page"));   //同一个sheet中含有多张相同页面的页数
        int offset = JspHelper.getInteger(map.get("offset"));   //两个相同页面间的偏移量
        List<int[]> list = (List<int[]>) map.get("mergerCellsList");     //要合并的单元格的list

        if (page == 0) {
            mergerCellsList(list, hssfSheet, 0);
        } else {
            for (int i = 0; i < page; i++) {
                mergerCellsList(list, hssfSheet, i * offset);
            }
        }
        //added by chenjp 20100307 解决打印缩放比例与模板设置不一致的问题
//        hssfSheet.getPrintSetup().setScale(hssfSheet.getPrintSetup().getScale());
    }

    /**
     * 进行单元格合并
     *
     * @param list    .
     * @param sheet   .
     * @param offsetY .
     * @throws jxl.write.WriteException .
     */
    public void mergerCellsList(List<int[]> list, HSSFSheet sheet, int offsetY) throws WriteException {
        for (int ints[] : list) {
            //合并既可以是横向的，也可以是纵向的。合并后的单元格不能再次进行合并,从0开始,int数组顺序为(int col1, int row1, int col2, int row2)
            sheet.addMergedRegion(new Region(ints[1] + offsetY, (short) ints[0], ints[3] + offsetY, (short) ints[2]));
        }
    }
}
