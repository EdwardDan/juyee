<%@ tag pageEncoding="UTF-8" %><%--
   用来处理复选项
 1、在jsp页面中引入taglib
    <%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
  2、 在需要翻译系统代码列表的地方使用如下代码：
    <sys:checkbox code="NetConstructionUnitProperty" checkedNames="${bean.buildPropertyDesc}" inputType="radio" isSaveName="false" showType="print" colNum="3"/>
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
        %><%@ tag import="com.justonetech.core.utils.FormatUtils"
        %><%@ tag import="com.justonetech.core.utils.StringHelper"
        %><%@ tag import="com.justonetech.system.domain.SysCodeDetail"
        %><%@ tag import="com.justonetech.system.manager.CustomSkin"
        %><%@ tag import="com.justonetech.system.manager.SysCodeManager"
        %><%@ tag import="org.springframework.context.ApplicationContext"
        %><%@ tag import="org.springframework.web.context.support.WebApplicationContextUtils"
        %>
<%@ tag import="java.util.List" %>
<%@ attribute name="code" type="java.lang.String" required="true" description="系统代码code"
        %><%@ attribute name="showType" type="java.lang.String" description="显示方式：edit(编辑)/view(查看)/print(打印)"
        %><%@ attribute name="name" type="java.lang.String" description="表单控件的名称"
        %><%@ attribute name="checkedIds" type="java.lang.String" description="选择的id集合，逗号分隔"
        %><%@ attribute name="checkedNames" type="java.lang.String" description="选择的name集合，逗号分隔"
        %><%@ attribute name="onClick" type="java.lang.String" description="属性点击触发事件"
        %><%@ attribute name="isSaveName" type="java.lang.Boolean" description="是否存储中文名称，不存id"
        %><%@ attribute name="colNum" type="java.lang.Integer" description="每行显示数量，0为不换行"
        %><%@ attribute name="inputType" type="java.lang.String" description="输入框类型：radio(单选项)/checkbox(复选项)" %><%

    ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession(true).getServletContext());
    SysCodeManager sysCodeManager = (SysCodeManager) applicationContext.getBean("sysCodeManager");
    CustomSkin customSkin = (CustomSkin) applicationContext.getBean("customSkin");
    String customSkinName = customSkin.getCustomSkinName();

    String contextPath = request.getContextPath();
    String tmp_edit = "<input type='{0}' name='{1}' value='{2}' {3}>{4}&nbsp;&nbsp;&nbsp;&nbsp;";
    String tmp_view = "<img src='" + contextPath + "/skin/"+customSkinName+"/index/{0}'>&nbsp;{1}&nbsp;&nbsp;&nbsp;&nbsp;";
    String tmp_print = "<img src='" + contextPath + "/skin/"+customSkinName+"/index/{0}'>&nbsp;{1}&nbsp;&nbsp;&nbsp;&nbsp;";
    List<SysCodeDetail> sysCodeDetails = sysCodeManager.getCodeListByCode(code);
    StringBuilder ret = new StringBuilder();
    int i = 1;
    for (SysCodeDetail sysCodeDetail : sysCodeDetails) {
        Boolean checked = false;
        String value = String.valueOf(sysCodeDetail.getId());
        if (!StringHelper.isEmpty(checkedIds)) {
            if (("," + checkedIds + ",").contains("," + sysCodeDetail.getId() + ",")) {
                checked = true;
            }
        }
        if (!StringHelper.isEmpty(checkedNames)) {
            if (("," + checkedNames + ",").contains("," + sysCodeDetail.getName() + ",")) {
                checked = true;
            }
        }
        if (isSaveName) {
            value = sysCodeDetail.getName();
        }
        if (showType.equals("edit")) {
            ret.append(FormatUtils.format(tmp_edit, inputType, name, value, checked ? "checked" : "", sysCodeDetail.getName()));

        } else if (showType.equals("view")) {
            ret.append(FormatUtils.format(tmp_view, checked ? "checked.gif" : "unchecked.gif", sysCodeDetail.getName()));

        } else if (showType.equals("print")) {
            ret.append(FormatUtils.format(tmp_print, checked ? "checked.gif" : "unchecked.gif", sysCodeDetail.getName()));
        }
        if (colNum > 0 && i % colNum == 0 && i < sysCodeDetails.size()) {
            ret.append("<br>");
        }
        i++;
    }
//    System.out.println("ret = " + ret);
    out.print(ret.toString());
%>