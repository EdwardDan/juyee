//package com.justonetech.biz.utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.DateUtil;
//
//import java.io.InputStream;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ReadExcelPoi {
//    Workbook wb = null;
//
//    public ReadExcelPoi(InputStream inp) {
//        try {
//            wb = WorkbookFactory.create(inp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String getCellFormatValue(Cell cell) {
//        String ret = "";
//        if(cell==null)
//            return ret;
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    ret = String.valueOf(cell.getDateCellValue());
//                } else {
//                    cell.setCellType(Cell.CELL_TYPE_STRING);
//                    String temp = cell.getStringCellValue();
//                    //判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
//                    if (temp.indexOf(".") > -1) {
//                        ret = String.valueOf(new Double(temp)).trim();
//                    } else {
//                        ret = temp.trim();
//                    }
//                }
//                break;
//            case Cell.CELL_TYPE_STRING:
//                ret = cell.getStringCellValue().trim();
//                break;
//            case Cell.CELL_TYPE_FORMULA:
//                cell.setCellType(Cell.CELL_TYPE_STRING);
//                ret = cell.getStringCellValue();
//                if (ret != null) {
//                    ret = ret.replaceAll("#N/A", "").trim();
//                }
//                break;
//            case Cell.CELL_TYPE_BLANK:
//                ret = "";
//                break;
//            case Cell.CELL_TYPE_BOOLEAN:
//                ret = Boolean.toString(cell.getBooleanCellValue());
//                break;
//            case Cell.CELL_TYPE_ERROR:
//                ret = "";
//                break;
//
//            default:
//                ret = "";
//                break;
//        }
//        return ret;
//    }
//
//    /**
//     * 获取指定开始行到结束行的数据，放入map
//     *
//     * @param sheetIndex
//     * @param startRowNo
//     * @param endRowNo
//     * @return
//     */
//    public Map<String, String> getMapData(int sheetIndex, int startRowNo, int endRowNo) {
//        Map<String, String> dataMap = new HashMap<String, String>();
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//        if (endRowNo == 0) {
//            endRowNo = sheet.getLastRowNum();
//        }
//        for (int r = startRowNo; r <= endRowNo; r++) {
//            Row row = sheet.getRow(r);
//            short lastCellNum = row.getLastCellNum();
//            for (int i = 0; i < lastCellNum; i++) {
//                Cell cell = row.getCell(i);
////                System.out.println(r + "|" + i + " = " + getCellFormatValue(cell));
//                dataMap.put(r + "_" + i, getCellFormatValue(cell));
//            }
//        }
//        return dataMap;
//    }
//
//    public Sheet getSheet(int sheetIndex) {
//        return wb.getSheetAt(sheetIndex);
//    }
//
//    //获取单元格类型
//    public int getCellDataType(int sheetIndex, int columnNo, int rowNo){
//       return getCell(sheetIndex, columnNo, rowNo).getCellType();
//    }
//
//    /**
//     * 获取某个单元格数据
//     *
//     * @param sheetIndex .
//     * @param rowNo      .
//     * @param columnNo   .
//     * @return .
//     */
//    public String getCellData(int sheetIndex, int columnNo, int rowNo) {
//        Cell cell = getCell(sheetIndex, columnNo, rowNo);
//        return getCellFormatValue(cell);
//    }
//    public Cell getCell(int sheetIndex, int columnNo, int rowNo) {
//        Sheet sheet = getSheet(sheetIndex);
//        return sheet.getRow(rowNo).getCell(columnNo);
//    }
//    public Timestamp getCellDateValue(int sheetIndex, int columnNo, int rowNo){
//        Cell cell = getCell(sheetIndex, columnNo, rowNo);
//        if(cell.getDateCellValue() != null){
//            return new Timestamp(cell.getDateCellValue().getTime());
//        }
//        return null;
//    }
//
//    /**
//     * 获取指定开始行的所有行数据
//     *
//     * @return List<String[]>
//     */
//    public List<String[]> getListData(int sheetIndex, int checkRowNo, int startRowNo) {
//        List<String[]> ret = new ArrayList<String[]>();
//        int columnNum = 0;
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//        if (sheet.getRow(checkRowNo) != null) {
//            columnNum = sheet.getRow(checkRowNo).getLastCellNum() - sheet.getRow(checkRowNo).getFirstCellNum();
//        }
////        System.out.println("columnNum = " + columnNum);
//        if (columnNum > 0) {
//            int r = 0;
//            for (Row row : sheet) {
//                r++;
//                if (r < (startRowNo + 1)) continue;
////                System.out.println("r = " + r);
//                String[] singleRow = new String[columnNum];
//                short lastCellNum = row.getLastCellNum();
//                for (int i = 0; i < lastCellNum; i++) {
//                    Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
//                    singleRow[i] = getCellFormatValue(cell);
//                }
//                ret.add(singleRow);
//            }
//        }
//        return ret;
//    }
//
//    /**
//     * 获取指定列数的所有数据.
//     *
//     * @return List<String[]>.
//     */
//    public List<String[]> getListData(int sheetIndex, int columnNum) {
//        List<String[]> ret = new ArrayList<String[]>();
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//        if (sheet != null) {
//            int lastRowNum = sheet.getLastRowNum();
//            int firstRowNum = sheet.getFirstRowNum();
//
//            Row row;
//            Cell cell;
//            if (columnNum > 0) {
//                for (int i = firstRowNum; i < lastRowNum; i++) {
//                    row = sheet.getRow(i);
//                    if (row != null) {
//                        if ((row.getLastCellNum() - row.getFirstCellNum()) != columnNum) {
//                            continue;
//                        }
//
//                        String[] singleRow = new String[columnNum];
//                        for (int j = 0; j < columnNum; j++) {
//                            cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
//                            singleRow[j] = getCellFormatValue(cell);
//                        }
//
//                        ret.add(singleRow);
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//    /**
//     * 返回Excel最大行index值，实际行数要加1
//     *
//     * @return
//     */
//    public int getRowNum(int sheetIndex) {
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//        return sheet.getLastRowNum();
//    }
//
//    /**
//     * 返回数据的列数
//     *
//     * @return
//     */
//    public int getColumnNum(int sheetIndex, int rowNo) {
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowNo);
//        if (row != null && row.getLastCellNum() > 0) {
//            return row.getLastCellNum();
//        }
//        return 0;
//    }
//
//    /**
//     * 获取某一行数据
//     *
//     * @param rowIndex 计数从0开始，rowIndex为0代表header行
//     * @return
//     */
//    public String[] getRowData(int sheetIndex, int rowIndex) {
//        int columnNum = 0;
//        Sheet sheet = wb.getSheetAt(sheetIndex);
//        if (sheet.getRow(rowIndex) != null) {
//            columnNum = sheet.getRow(rowIndex).getLastCellNum() - sheet.getRow(rowIndex).getFirstCellNum();
//        }
//        String[] singleRow = new String[columnNum];
//        if (columnNum > 0) {
//            Row row = sheet.getRow(rowIndex);
//            short lastCellNum = row.getLastCellNum();
//            for (int i = 0; i < lastCellNum; i++) {
//                Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
//                singleRow[i] = getCellFormatValue(cell);
//            }
//        }
//        return singleRow;
//    }
//
//    /**
//     * 获取某一列数据
//     *
//     * @param colIndex
//     * @return
//     */
//    public String[] getColumnData(int sheetIndex, int colIndex, int checkRowNo) {
//        String[] dataArray = null;
////        if (colIndex > this.getColumnNum(sheetIndex, checkRowNo)) {
////            return dataArray;
////        } else {
////            if (this.dataList != null && this.dataList.size() > 0) {
////                dataArray = new String[this.getRowNum(sheetIndex) + 1];
////                int index = 0;
////                for (String[] rowData : dataList) {
////                    if (rowData != null) {
////                        dataArray[index] = rowData[colIndex];
////                        index++;
////                    }
////                }
////            }
////        }
//        return dataArray;
//    }
//}
