package com.justonetech.biz.manager.indexGrid;

import java.util.List;
import java.util.Vector;

/**
 * description: 系统首页版块定制的数据结构
 * User: Chenjp
 * Date: 14-4-3 下午1:24
 */
public class CustomGridData {
    private int orderNo;
    private int checkedNo;
    private String modelCode;
    private String modelName;
    private String moreLink;
    private String[] cols;
    private String[] aligns;
    private int[] widths;
    private List<Vector<Object>> list;

    public CustomGridData() {
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getCheckedNo() {
        return checkedNo;
    }

    public void setCheckedNo(int checkedNo) {
        this.checkedNo = checkedNo;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMoreLink() {
        return moreLink;
    }

    public void setMoreLink(String moreLink) {
        this.moreLink = moreLink;
    }

    public String[] getCols() {
        return cols;
    }

    public void setCols(String[] cols) {
        this.cols = cols;
    }

    public String[] getAligns() {
        return aligns;
    }

    public void setAligns(String[] aligns) {
        this.aligns = aligns;
    }

    public int[] getWidths() {
        return widths;
    }

    public void setWidths(int[] widths) {
        this.widths = widths;
    }

    public List<Vector<Object>> getList() {
        return list;
    }

    public void setList(List<Vector<Object>> list) {
        this.list = list;
    }
}