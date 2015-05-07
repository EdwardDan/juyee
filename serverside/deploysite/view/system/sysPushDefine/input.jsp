<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
//            {name:"modelName", rule:"validate[required,maxSize[100]]"},
            {name:"pushDelay", rule:"validate[required,custom[integer],maxSize[4]"}
            //{name:"orderNo", rule:"validate[required,custom[integer],maxSize[4]"}
        ];
        validateInit(validateCondition, formId);
        changeTaskImg();
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        if (document.getElementById("menu").value == "" || document.getElementById("menu").value == null) {
            showInfoMsg("请选择一个子模块！");

        } else {
            //提交表单
            saveAjaxData("${ctx}/sysPushDefine/save.do", formId);
        }
    }

    //切换任务图标
    function changeTaskImg(){
        var sel = document.getElementById("taskImg").value;
        var imgObj = document.getElementById("taskImgId");
        if(sel != ""){
            imgObj.src="${themePath}/index_new/task_img/"+sel+".png";
            imgObj.style.display = "";
        }else{
            imgObj.style.display = "none";
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">模块名称：</td>
                <td class="form_content">
                    <select name="menu" id="menu">
                        <c:forEach items="${menus}" var="item">
                            <option value="<c:if test="${item.isLeaf==true}">${item.id}</c:if>" <c:if test="${item.id==bean.menu.id}">selected </c:if>><c:if
                                    test="${item.parent.id == null}">○</c:if>${item.target} ${item.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">首页推送图标:</td>
                <td class="form_content" valign="middle" height="70">
                    <select name="taskImg" id="taskImg" onchange="changeTaskImg()">
                        <option value="">==请选择==</option>
                        <c:forEach items="${TASK_ICON_LIST}" var="item" varStatus="status">
                            <option value="${item}" <c:if test="${item == bean.taskImg}">selected</c:if>>图标${status.index+1}(${item}.png)</option>
                        </c:forEach>
                    </select>&nbsp;
                    <img src="${themePath}/index_new/task_img/${bean.taskImg}.png" id="taskImgId" border="0" style="display: none" align="absmiddle"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">推送时间间隔(天)：</td>
                <td class="form_content">
                    <form:input path="pushDelay" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">排序号：</td>
                <td class="form_content">
                    <form:input path="orderNo" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label" valign="top">查询语句：</td>
                <td class="form_content" valign="top">
                    <form:textarea path="querySql" cssClass="input_textarea_long"/>
                    样例：select nvl(count(t.id),0) as num from oa_knowledge t
                    where ROUND(TO_NUMBER(sysdate - t.report_date))<={delay}
                    and t.id not in(select table_id from sys_visit_record where table_name='OaKnowledge' and create_user='{userName}')
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>