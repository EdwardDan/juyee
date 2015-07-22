<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function doCheckAll(){
        var checked = document.getElementById("checkAll").checked;
        $("input[name=stageIds]").each(function(){
            $(this).attr("checked",checked);
        });
    }
</script>
<style type="text/css">
    .td_normal{
        min-width: 60px;
        height: 30px;
    }
    .td_change{
        color: red;
    }
</style>
<div class="form_div">
    <form action="" name="form1" id="form1" method="post">
    <table cellpadding="1" cellspacing="1" width="100%" border="0" <c:if test="${not empty id}">style="display: none"</c:if>>
        <tr class="tr_light">
            <td align="right" width="20%" nowrap>选择阶段：</td>
            <td align="left" nowrap style="line-height: 25px">
                <table width="100%" cellpadding="0" cellspacing="0" border="0">
                    <c:if test="${fn:length(list)>0}">
                    <tr>
                        <td height="25" width="35%">
                            <input type="checkbox" name="checkAll" id="checkAll" value="" onclick="doCheckAll()" checked="true">全部
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    </c:if>
                    <c:forEach  items="${list}" var="item">
                        <tr>
                            <td height="25">
                                <input type="checkbox" name="stageIds" value="${item.id}" checked="true">${item.name}&nbsp;
                            </td>
                            <td>
                                <sys:code code="${DATA_STAGE_RESULT}" name="result_${item.id}" type="select" defaultName="" sysCodeDetailId="" disabled="" id="result_${item.id}" isAlowedNull="true"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" colspan="2" align="center">
                <input type="hidden" name="projectId" id="projectId" value="${projectId}"/>
                <input type="hidden" name="projectName" id="projectName" value="${projectName}"/>
                <input type="hidden" name="bidName" id="bidName" value="${bidName}"/>
                <input type="hidden" name="jsDept" id="jsDept" value="${jsDept}"/>
                <input type="hidden" name="year" id="year" value="${year}"/>
                <input type="hidden" name="categoryId" id="categoryId" value="${categoryId}"/>
                <input type="button" value="确定" class="button_confirm" onclick="printStageData(this)">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
    </form>
</div>