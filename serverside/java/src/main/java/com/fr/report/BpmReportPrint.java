package com.fr.report;

import com.fr.base.Parameter;
import com.fr.data.AbstractTableData;
import com.fr.general.data.TableDataException;
import com.justonetech.biz.manager.workflow.BpmReportManager;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.utils.SpringContextUtil;

/**
 * 采用程序集方式打印报表 -- 流程通用
 * 程序地址：com.fr.report.BpmReportPrint
 * 调用方式：ReportServer?reportlet=report/{definitionCode}_{formCode}.cpt&pid={pid}&fid={fid}
 * definitionCode:流程定义编码
 * formCode:表单模板编码
 * 参数pid:bpmProcessInstanceId
 * 参数fid:formTemplateId
 * 注意：cpt名称与编码保持一致，eg:{definitionCode}_{formCode}.cpt
 * http://localhost:8080/mis/ReportServer?reportlet=report/Test_1.cpt&pid=77&fid=6
 * author:chenjp
 * date:2012-5-17
 */
public class BpmReportPrint extends AbstractTableData {
    private String[][] data;

    public BpmReportPrint() {
        // 定义tableName参数
        this.parameters = new Parameter[]{new Parameter("pid"), new Parameter("fid")};
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
            String pid = parameters[0].getValue().toString();
            String fid = parameters[1].getValue().toString();
            BpmReportManager bpmReportManager = (BpmReportManager) SpringContextUtil.getBean("bpmReportManager");

            this.data = bpmReportManager.getBpmDatas(JspHelper.getLong(pid), JspHelper.getLong(fid));
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