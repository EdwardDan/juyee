package com.fr.report;

import com.fr.base.Parameter;
import com.fr.data.AbstractTableData;
import com.justonetech.biz.manager.JdRecordManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.utils.SpringContextUtil;

import java.util.List;

/**
 * 采用程序集方式打印报表 -- 每个报表独立定制
 * 程序地址：com.fr.report.Test_1
 * 调用方式：ReportServer?reportlet=report/{definitionCode}_{formCode}.cpt&pid={pid}&fid={fid}
 * definitionCode:流程定义编码
 * formCode:表单模板编码
 * 参数pid:bpmProcessInstanceId
 * 参数fid:formTemplateId
 * 注意：cpt名称与编码保持一致，eg:{definitionCode}_{formCode}.cpt
 * http://localhost:8080/mis/ReportServer?reportlet=report/Test_1.cpt&pid=77&fid=6
 */
public class JdRecordSafePrint extends AbstractTableData {


    // 列名数组，保存程序数据集所有列名
    private String[] columnNames = null;
    // 定义程序数据集的列数量
    private int columnNum = 1;
    // 保存查询表的实际列数量
    private int colNum = 0;
    // 保存查询得到列值
    private List valueList = null;

    // 构造函数，定义表结构，该表有10个数据列，列名为column#0，column#1，。。。。。。column#9
    public JdRecordSafePrint() {
        // 定义tableName参数
        this.parameters = new Parameter[]{new Parameter("id")};

        // 定义程序数据集列名
        columnNames = new String[]{
                "施工进度"
        };
        columnNum = columnNames.length;
        colNum = columnNum;
    }

    // 实现其他四个方法
    public int getColumnCount() {
        return columnNum;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public int getRowCount() {
        init();
        return valueList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        init();
        if (columnIndex >= colNum) {
            return null;
        }
        return ((Object[]) valueList.get(rowIndex))[columnIndex];
    }

    // 准备数据
    public void init() {
        // 确保只被执行一次
        if (valueList != null) {
            return;
        }
        // 保存得到的数据库表名
        String id = parameters[0].getValue().toString();
        JdRecordManager jdRecordManager = (JdRecordManager) SpringContextUtil.getBean("jdRecordManager");

        valueList = jdRecordManager.getJdRecordCheckBoxs(JspHelper.getLong(id), Constants.POLLING_FORM_CLASS_SAFE);
    }

    // 释放一些资源，因为可能会有重复调用，所以需释放valueList，将上次查询的结果释放掉
    public void release() throws Exception {
        super.release();
        this.valueList = null;
    }

}
