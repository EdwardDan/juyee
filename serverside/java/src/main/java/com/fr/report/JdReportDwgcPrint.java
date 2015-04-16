package com.fr.report;

import com.fr.base.Parameter;
import com.fr.data.AbstractTableData;
import com.fr.general.data.TableDataException;
import com.justonetech.biz.manager.JdReportManager;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.utils.SpringContextUtil;

/**
 * User: Chen Junping
 * Date: 12-5-28
 * 单位工程打印类
 */
public class JdReportDwgcPrint extends AbstractTableData {
    private String[][] data;
    public JdReportDwgcPrint(){
        this.parameters = new Parameter[]{new Parameter("id")};
    }
    @Override
    public int getColumnCount() throws TableDataException {
        init();

        return data[0].length;
    }

    @Override
    public String getColumnName(int columnIndex) throws TableDataException {
        init();
        return data[0][columnIndex];
    }

    @Override
    public int getRowCount() throws TableDataException {
        init();
        return data.length-1;
    }

    @Override
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

            this.data = jdReportManager.getDwgcDatas(JspHelper.getLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void release() throws Exception {
        super.release();
        this.data = null;
    }
}
