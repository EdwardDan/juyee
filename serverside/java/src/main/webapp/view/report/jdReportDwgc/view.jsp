<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    //添加单位工程
    function addDwgc() {
        var v = $("#dwgcIds").val();
        if (v != "") {
            saveAjaxData("${ctx}/jdReportDwgc/save.do?id=${bean.id}&dwgcIds="+v, null, refreshPage);
        }
    }
    //刷新页面
    function refreshPage() {
        window.location.reload();
    }

    //删除关联
    function doDelete(btn,id) {
        $.messager.confirm('系统提示', '确定要删除此单位工程吗?', function(r) {
            if (r) {
                saveAjaxData("${ctx}/jdReportDwgc/delete.do?id="+id, null, refreshPage);
            }
        });
    }
</script>
<div class="form_div">
    <div align="center" class="tr_dark">
        <div class="div_space"></div>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:if test="${canEdit}">
                <tr class="tr_dark">
                    <td align="right" colspan="5">
                        <input type="button" value="添加" class="button_all"
                               onclick="multiSelectTaskDwgc(null,'dwgcIds',null,'${bean.jdTaskCode}',addDwgc);">
                        <input type="hidden" name="dwgcIds" id="dwgcIds">
                    </td>
                </tr>
            </c:if>
            <tr class="tr_header">
                <td class="form_border" width="5%">序号</td>
                <td class="form_border" width="35%">单位工程名称</td>
                <td class="form_border" width="20%">结构类型/层数</td>
                <td class="form_border" width="20%">单位工程面积(㎡)</td>
                <td class="form_border" width="15%">备注</td>
                <c:if test="${canEdit}">
                    <td class="form_border" width="5%">操作</td>
                </c:if>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
                <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                    <td class="form_border">&nbsp;${status.index+1}</td>
                    <td class="form_border" align="left">&nbsp;${item.dwgcName}</td>
                    <td class="form_border" nowrap>&nbsp;${item.dwgcTypeDesc}<c:if
                            test="${not empty item.cs}">/${item.cs}</c:if></td>
                    <td class="form_border" align="right" nowrap><fmt:formatNumber value="${item.buildArea}"
                                                                                   pattern="#,###.##"/>&nbsp;</td>
                    <td class="form_border" nowrap>&nbsp;</td>
                    <c:if test="${canEdit}">
                        <td class="form_border" nowrap>
                            <input type="button" value="删除" class="button_normal" onclick="doDelete(this,'${item.relate.id}')"/>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <tr class="tr_button">
                <td class="form_td_line" colspan="9">
                    <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</div>