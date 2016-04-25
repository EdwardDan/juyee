package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.domain.bean.proj.ProjectInfoContent;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gq on 2016/4/21.
 * 项目信息逻辑类
 */
@Service
public class ProjectInfoContentManager {
    private Logger logger = LoggerFactory.getLogger(ProjectInfoContentManager.class);

    @Autowired
    private ProjInfoService projInfoService;

    /**
     * 设置填报内容
     *
     * @param model    .
     * @param content .
     */
    public void setReportContent(Model model, String content) {
        ProjectInfoContent projectInfoContent = null;
        if (!StringHelper.isEmpty(content) && !"null".equals(content)) {
            projectInfoContent = (ProjectInfoContent) JSONObject.toBean(JSONObject.fromObject(content), ProjectInfoContent.class);
        } else {
            projectInfoContent = new ProjectInfoContent();
        }
        model.addAttribute("content", projectInfoContent);
    }

    /**
     * 获取填报内容
     *
     * @param id     .
     * @param isView .
     * @return .
     */
    public ProjectInfoContent getReportContent(Long id, Boolean isView) {
        ProjInfo data = projInfoService.get(id);
        String projContent = data.getProjContent();
        if (!StringHelper.isEmpty(projContent)) {
            if (!"null".equals(projContent)) {
                ProjectInfoContent content = new JSONDeserializer<ProjectInfoContent>().use(null, ProjectInfoContent.class).deserialize(projContent);
                return content;
            }
        }
        return null;
    }

    /**
     * 将页面输入转成json
     *
     * @param data    已有数据
     * @param request 页面获取数据
     * @return json .
     */
    public String getRequestContent(ProjInfo data, HttpServletRequest request) {
        ProjectInfoContent content = null;
        if (data != null) {
            if (data.getId() != null) {
                content = getReportContent(data.getId(), false);
            }
        }
        if (content == null) {
            content = new ProjectInfoContent();
        }
        List<String> fields = getFieldList();
        for (String column : fields) {
            String getMethodName = "get" + column.substring(0, 1).toUpperCase() + column.substring(1);
            String setMethodName = "set" + column.substring(0, 1).toUpperCase() + column.substring(1);
            String value = request.getParameter(column);
            try {
                Method getMethod = content.getClass().getMethod(getMethodName);
                String returnType = getMethod.getGenericReturnType().toString();

                if (returnType.indexOf("java.lang.String") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, String.class);
                    setMethod.invoke(content, value);

                } else if (returnType.indexOf("java.lang.Double") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, Double.class);
                    setMethod.invoke(content, !StringHelper.isEmpty(value) ? JspHelper.getDouble(value) : null);

                } else if (returnType.indexOf("java.lang.Integer") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, Integer.class);
                    setMethod.invoke(content, !StringHelper.isEmpty(value) ? JspHelper.getInteger(value) : null);

                } else if (returnType.indexOf("java.sql.Date") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, Date.class);
                    setMethod.invoke(content, !StringHelper.isEmpty(value) ? JspHelper.getDate(value) : null);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new JSONSerializer().include().exclude("*.class").serialize(content);
    }

    /**
     * 得到类的所有属性
     *
     * @return .
     */
    private List<String> getFieldList() {
        List<String> ret = new ArrayList<String>();
        Field[] fields = ProjectInfoContent.class.getDeclaredFields();
        for (Field field : fields) {
            String column = field.getName();
            ret.add(column);
        }
        return ret;
    }

}
