package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.Sample;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysSequenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统功能设置
 * User: Chen Junping
 * Date: 12-2-1
 */
@Controller
public class SysFunctionController extends BaseCRUDActionController<Sample> {
    private Logger logger = LoggerFactory.getLogger(SysFunctionController.class);

    @Autowired
    private SysSequenceManager sysSequenceManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String sequenceGrid(Model model) {

        return "view/system/sysFunction/sequenceGrid";
    }

    /**
     * 更新最大序列号
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void sequenceGridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);

            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            List<Map<String, Object>> errorList = new ArrayList<Map<String, Object>>();

            Map<String, String> comments = sysSequenceManager.getComments();
            Map<String, Long> sequences = sysSequenceManager.findAllSysSequence();
            Map<String, String> tables = sysSequenceManager.getTables();

            int i = 0;
            String tmp = "select max(id) from {0}";
            for (String className : tables.keySet()) {
                i++;
                String tableName = tables.get(className);
                if (tableName.startsWith("SHARE") || tableName.startsWith("SYS_SEQUENCE")) continue;

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", i);
                map.put("tableName", tableName);
                map.put("comment", comments.get(tableName));

                try {
                    String sql = FormatUtils.format(tmp, tableName);
                    logger.debug("execute sql:{}", sql);
                    String lastId = simpleQueryManager.getStringBySql(FormatUtils.format(sql, tableName));
                    if (null == lastId) {
                        lastId = "";
                    }
                    String code = className.toUpperCase();
                    String sequenceId = "";
                    if (null != sequences.get(code)) {
                        sequenceId = sequences.get(code).toString();
                    }
                    map.put("maxId", lastId);
                    map.put("sequenceId", String.valueOf(sequenceId));

                    if (!StringHelper.isEmpty(lastId)) {
                        if (StringHelper.isEmpty(sequenceId) || Long.valueOf(lastId) >= Long.valueOf(sequenceId)) {
                            retList.add(map);
                        }
                    }
                } catch (Exception e) {
                    map.put("maxId", e.getMessage());
                    errorList.add(map);
                    logger.debug("Error:" + e.getMessage());
                }
            }
            if (retList.size() == 0) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", i);
                map.put("tableName", "当前无需更新最大记录数！");
                retList.add(map);
            }
            if (errorList.size() > 0) {
                retList.addAll(errorList);
            }

            //输出显示
            pageModel = new Page<Map<String, Object>>(page, rows, retList);
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 更新最大序列号 -- 保存操作
     *
     * @param response .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void updateSquence(HttpServletResponse response) throws Exception {
        try {
            Map<String, Long> sequences = sysSequenceManager.findAllSysSequence();
            Map<String, String> tables = sysSequenceManager.getTables();

            for (String className : tables.keySet()) {
                String tableName = tables.get(className);
                try {
                    sysSequenceManager.updateMaxRecord(sequences, className, tableName);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("");
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "更新成功");
    }
}