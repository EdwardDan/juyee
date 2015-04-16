<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    var formId="bean" ;
    refreshMarkStatue();
    function doSet(button, id) {
        openFullWindow("${ctx}/excelJdTasksPosition/map.do?id=" + id, 900, 600);
    }
    //保存成功后切换到单位工程tab页面
    function save(btn) {
        saveAjaxData("${ctx}/excelJdTasksOld/save.do", formId,jumpTab,"notClose");
    }
    function jumpTab(){
        $('#tabsChild').tabs('select',"单位工程");
    }

    function refreshMarkStatue(){
        $("#mark").html(getAjaxData("${ctx}/excelJdTasksPosition/markCheck.do?id=${bean.id}"));

    }
</script>


<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_dark">
        <td class="form_label_right">
            报监日期：
        </td>
        <td class="form_content">
            &nbsp;<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>
        </td>
        <td class="form_content" colspan="2">
            &nbsp;
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right" width="15%">
            流转编号：
        </td>
        <td class="form_content" width="35%">
            &nbsp;${bean.flowCode}
        </td>
        <td class="form_label_right" width="15%">
            监督任务书编号：
        </td>
        <td class="form_content" width="35%">
            &nbsp;${bean.jdTaskCode}
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">
            报建编号：
        </td>
        <td class="form_content">
            &nbsp;${bean.bjbh}
        </td>
        <td class="form_label_right">
            标段号：
        </td>
        <td class="form_content">
            &nbsp;${bean.bid}
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">
            项目名称：
        </td>
        <td class="form_content" colspan="3">
            &nbsp;${bean.projectName}
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">
            工程地点：
        </td>
        <td class="form_content" colspan="3">
            &nbsp;${bean.projectAdd}
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">
            所在县区：
        </td>
        <td class="form_content">
            &nbsp;${bean.belongArea}
        </td>
        <td class="form_label_right">
            合同价：
        </td>
        <td class="form_content">
            &nbsp;${bean.contMoney}
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">建设单位：</td>
        <td class="form_content" colspan="3">&nbsp;${bean.jsUnitName}</td>

    </tr>
    <tr class="tr_light">
        <td class="form_label_right">建设单位地址：</td>
        <td class="form_content">&nbsp;${bean.jsUnitAdd}</td>
        <td class="form_label_right">邮政编码：</td>
        <td class="form_content">&nbsp;${bean.zipcode}</td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">联系人：</td>
        <td class="form_content">&nbsp;${bean.jsLinkman}</td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">&nbsp;${bean.jsPhone}</td>
    </tr>
</table>

<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_header">
        <td colspan="6">参建单位</td>
    </tr>

    <tr class="tr_dark">
        <td class="form_label_right">施工总包单位：</td>
        <td class="form_content">&nbsp;${bean.sgzbUnitName}</td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">&nbsp;${bean.sgzbLinkman}</td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">&nbsp;${bean.sgzbPhone}</td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">施工单位：</td>
        <td class="form_content">&nbsp;${bean.sgUnitName}</td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">&nbsp;${bean.sgLinkman}</td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">&nbsp;${bean.sgPhone}</td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">勘察单位：</td>
        <td class="form_content">&nbsp;${bean.kcUnitName}</td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">&nbsp;${bean.kcLinkman}</td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">&nbsp;${bean.kcPhone}</td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">设计单位：</td>
        <td class="form_content">&nbsp;${bean.sjUnitName}</td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">&nbsp;${bean.sjLinkman}</td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">&nbsp;${bean.sjPhone}</td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">监理单位：</td>
        <td class="form_content">&nbsp;${bean.jlUnitName}</td>
        <td class="form_label_right">联系人：</td>
        <td class="form_content">&nbsp;${bean.jlLinkman}</td>
        <td class="form_label_right">联系电话：</td>
        <td class="form_content">&nbsp;${bean.jlPhone}</td>
    </tr>
    <tr class="tr_light">
        <td colspan="6" class="form_content">
            &nbsp;&nbsp;&nbsp;&nbsp; 建安量工作量： &nbsp;${bean.jagzl}
            （万元），建筑面积：&nbsp;${bean.buildArea}（㎡），单体数量：&nbsp;${bean.dtsl}（个）。
        </td>
    </tr>
</table>
<form:form commandName="bean">
    <form:hidden path="id"></form:hidden>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td colspan="4">信息维护</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目属地：</td>
            <td class="form_content"> &nbsp;
                <sys:code code="${EXCEL_JDTASK_POSITION}" name="position" type="select" defaultName="${bean.position}"
                          sysCodeDetailId="" disabled="" id="position"  isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
            <td class="form_label_right">工程性质：</td>
            <td class="form_content"> &nbsp;
                <sys:code code="${EXCEL_JDTASK_PROPERTY}" name="property" type="select" defaultName="${bean.property}"
                          sysCodeDetailId="" disabled="" id="type" isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">是否远程监控：</td>
            <td class="form_content">&nbsp;
                <input type="checkbox" name="isRemoteMonitor" id="isRemoteMonitor" value="1"
                       <c:if test="${bean.isRemoteMonitor == true}">checked</c:if> />
            </td>
            <td class="form_label_right">地图标注：</td>
            <td class="form_content">&nbsp;
                <input type='button' value='标注' onclick='doSet(this,"${bean.id}")'
                       class='button_normal'> <div id="mark" style="float:left;"> </div>
            </td>

        </tr>
        <tr class="tr_light">
            <td class="form_label_right">是否管理人员考勤：</td>
            <td class="form_content"> &nbsp;
                <input type="checkbox" name="isManagerCheck" id="isManagerCheck" value="1"
                       <c:if test="${bean.isManagerCheck == true}">checked</c:if> />
            </td>
            <td class="form_label_right">${EXCEL_JDTASK_OTHER1.name}：</td>
            <td class="form_content">&nbsp;
                <sys:code code="${EXCEL_JDTASK_OTHER1.code}" name="other1" type="select" defaultName="${bean.other1}"
                           id="other1" isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">${EXCEL_JDTASK_OTHER2.name}：</td>
            <td class="form_content">&nbsp;
                <sys:code code="${EXCEL_JDTASK_OTHER2.code}" name="other2" type="select" defaultName="${bean.other2}"
                          sysCodeDetailId="" disabled="" id="other2" isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
            <td class="form_label_right">${EXCEL_JDTASK_OTHER3.name}：</td>
            <td class="form_content"> &nbsp;
                <sys:code code="${EXCEL_JDTASK_OTHER3.code}" name="other3" type="select" defaultName="${bean.other3}"
                          sysCodeDetailId="" disabled="" id="other3" isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">${EXCEL_JDTASK_OTHER4.name}：</td>
            <td class="form_content">  &nbsp;
                <sys:code code="${EXCEL_JDTASK_OTHER4.code}" name="other4" type="select" defaultName="${bean.other4}"
                          sysCodeDetailId="" disabled="" id="other4"  isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
            <td class="form_label_right">${EXCEL_JDTASK_OTHER5.name}：</td>
            <td class="form_content"> &nbsp;
                <sys:code code="${EXCEL_JDTASK_OTHER5.code}" name="other5" type="select" defaultName="${bean.other5}"
                          sysCodeDetailId="" disabled="" id="other5" isSaveName="true"
                          isAlowedNull="true"
                          onChange=""/>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_td_line" colspan="4">
                <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</form:form>
</div>
