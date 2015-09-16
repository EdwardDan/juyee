<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"dealContent", rule:"validate[required,maxSize[200]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(operationId,btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/oaReceive/save.do?operationId="+operationId, formId);
    }
    //选择处理人和处理部门时 自动将选择项 显示在下面的拟办栏中
    function addNb(){
      var dealPersons = $("#dealPersonsNames").val();
        var dealDepts = $("#dealDeptsNames").val();
        $("#dealContent").val("请 "+dealPersons+","+dealDepts+"阅。");
    }
</script>
<style type="text/css">
    .td_border {
        /*border: 1px solid;*/
        border-top-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-top-style: solid;
        border-bottom-style: solid;
        border-left-style: solid;
        border-right-style: solid;
        border-top-color: #333;
        border-bottom-color: #333;
        border-left-color: #333;
        border-right-color: #333;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="node" id="node" value="${node.id}">
    <input type="hidden" name="step" id="step" value="${bean.step.id}">
    <input type="hidden" name="openTime" id="openTime" value="${openTime}">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
            <tr>
                <td class="head_title form_border" colspan="6">上海市交通建设工程管理中心文件处理单</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="5">&nbsp;&nbsp;文件类型：${bean.type.name}</td>
                <td class="form_label" align="right">${bean.code}&nbsp;&nbsp;</td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文文号：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.fileCode}</td>
                <td class="td_border" align="right">办理时限：</td>
                <td class="td_border" align="left">&nbsp;<fmt:formatDate value="${bean.limitDate}" pattern="yyyy-MM-dd"/> </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">标题：</td>
                <td class="td_border" align="left" colspan="5">&nbsp;${bean.title} </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文单位：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.sourceDept}</td>
                <td class="td_border" align="right">份数：</td>
                <td class="td_border" align="left">&nbsp;${bean.fs} </td>
            </tr>

            <tr class="tr_light">
                <td class="td_border" align="right" style="width: 10%;">登记日期：</td>
                <td class="td_border" align="left" style="width: 23%;">&nbsp;<fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/> </td>
                <td class="td_border" align="right" style="width: 10%;">成文日期：</td>
                <td class="td_border" align="left" style="width: 23%;">&nbsp;<fmt:formatDate value="${bean.writtenDate}" pattern="yyyy-MM-dd"/> </td>
                <td class="td_border" align="right" style="width: 10%;">页数：</td>
                <td class="td_border" align="left" style="width: 24%;">&nbsp;${bean.ys} </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">提供部门：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.deptName}</td>
                <td class="td_border" align="right">密级：</td>
                <td class="td_border" align="left">&nbsp;${bean.secret.name}</td>
            </tr>


            <tr class="tr_light">
                <td class="td_border" align="right">紧急程度：</td>
                <td class="td_border" align="left">&nbsp;${bean.urgent.name}</td>
                <td class="td_border" align="right">公文种类：</td>
                <td class="td_border" align="left">&nbsp;${bean.fileType.name}</td>
                <td class="td_border" align="right">牵头部门：</td>
                <td class="td_border" align="left">&nbsp;${bean.startDept}</td>
            </tr>
           <tr  class="tr_light">
               <td class="td_border" align="right">附件：</td>
               <td class="td_border" align="left" colspan="5">
               &nbsp;<c:forEach items="${docAttachs}" var="docName">&nbsp;${docName.fileName}&nbsp;
               </c:forEach>${documentFile}
               </td>
           </tr>
            <tr class="tr_dark">
                <td class="td_border" align="center" colspan="6"> &nbsp;  &nbsp; &nbsp;处理人：
                    <select name="ccUsers" id="ccUsers" size="3" multiple style="width:200px"
                            class="input_light">
                        <c:forEach var="sysUser" items="${sysUserHM}">
                            <option value="${sysUser.key}">${sysUser.value}</option>
                        </c:forEach>
                    </select>
                    <img src="${themePath}/workflow/user.gif" alt="请选择处理人" border="0"
                         style="cursor:pointer"
                         onclick="multiSelectSysUser('ccUsers','dealPersons','dealPersonsNames',addNb)">
                    <img src="${themePath}/workflow/file_delete.gif" width="16"
                         height="16" border="0" alt="移除选中人员" align="absbottom"
                         onClick="removeMultiSelectOpt('ccUsers','dealPersons','dealPersonsNames')">
                    <input type="hidden" name="dealPersons" id="dealPersons"
                           value="${bean.dealPersons}">
                    <input type="hidden" name="dealPersonsNames" id="dealPersonsNames">

                &nbsp;  &nbsp;&nbsp;&nbsp;
                处理部门：
                    <select name="ccDepts" id="ccDepts" size="3" multiple style="width:200px"
                            class="input_light">
                        <c:forEach var="sysDept" items="${sysDeptHM}">
                            <option value="${sysDept.key}">${sysDept.value}</option>
                        </c:forEach>
                    </select>
                    <img src="${themePath}/workflow/dept.gif" alt="请选择处理部门" border="0"
                         style="cursor:pointer"
                         onclick="multiSelectSysDeptOwner('ccDepts','dealDepts','dealDeptsNames',addNb)">
                    <img src="${themePath}/workflow/file_delete.gif" width="16"
                         height="16" border="0" alt="移除选中部门" align="absbottom"
                         onClick="removeMultiSelectOpt('ccDepts','dealDepts','dealDeptsNames')">
                    <input type="hidden" name="dealDepts" id="dealDepts"
                           value="${bean.dealDepts}">
                    <input type="hidden" name="dealDeptsNames" id="dealDeptsNames">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">批办：</td>
                <td class="td_border" align="left" colspan="5">
                    <form:textarea path="dealContent" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td  align="center" colspan="6">
                    <c:forEach items="${operations}" var="operation" >
                        <input type="button" value="${operation.name}" class="button_normal_longer"
                               onclick="save('${operation.id}',this.value)">&nbsp;
                    </c:forEach>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>