package com.fr.report;

import com.fr.base.Parameter;
import com.fr.data.AbstractTableData;
import com.fr.general.data.TableDataException;
import com.justonetech.biz.manager.JdReportManager;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.utils.SpringContextUtil;

/**
 * 监督报告打印类
 * User: Chen Junping
 * Date: 12-5-21
 */
public class JdReportPrint extends AbstractTableData {
    private String[][] data;

    public JdReportPrint() {
        // 定义tableName参数
        this.parameters = new Parameter[]{new Parameter("id")};
    }

    //获取列数
    public int getColumnCount() throws TableDataException {
        init();
        return data[0].length;
    }

    //获取列的名称为数组中第一行的值
    public String getColumnName(int columnIndex) throws TableDataException {
        init();
        return data[0][columnIndex];
    }

    //获取行数为数据的长度-1
    public int getRowCount() throws TableDataException {
        init();
        return data.length - 1;
    }

    //获取值
    public Object getValueAt(int rowIndex, int columnIndex) {
        init();
        if (columnIndex >= data[0].length) {
            return null;
        }
        return data[rowIndex + 1][columnIndex];
    }

    public void init() {
        // 确保只被执行一次
        if (data != null) {
            return;
        }

        try {
            // 保存得到的数据库表名
            String id = parameters[0].getValue().toString();
            JdReportManager jdReportManager = (JdReportManager) SpringContextUtil.getBean("jdReportManager");

            this.data = jdReportManager.getDatas(JspHelper.getLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 释放一些资源，因为可能会有重复调用，所以需释放valueList，将上次查询的结果释放掉
    public void release() throws Exception {
        super.release();
        this.data = null;
    }
}
