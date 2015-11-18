<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printView() {
        window.open("${ctx}/sgPermit/printView.do?id=${bean.id}", "交通建管中心技术审查表", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
</script>
<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr class="tr_dark">
    <td class="form_label_right" style="width: 20%;" nowrap>报建编号：</td>
    <td class="form_content" style="width: 80%;">${bean.bjbh}</td>
</tr>
<tr class="tr_light">
    <td class="form_label_right">项目名称：</td>
    <td class="form_content">${bean.projectName}</td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">建设单位：</td>
    <td class="form_content">${bean.buildName}</td>
</tr>
<tr class="tr_light">
    <td class="form_content" colspan="2">
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
        沪交管收字（${bean.hjgYear}）第&nbsp;${bean.hjgNum}&nbsp;号
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">申请人：</td>
    <td class="form_content">${bean.applyPerson}</td>
</tr>
<tr class="tr_light">
    <td class="form_label_right">申请事项：</td>
    <td class="form_content">${bean.applyMatter}</td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">申请号：</td>
    <td class="form_content">${bean.applyNum}</td>
</tr>
<tr>
    <td colspan="2">
        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
            <tr class="tr_header">
                <td style="width: 5%;">序号</td>
                <td style="width: 50%;">申请材料名称</td>
                <td style="width: 20%;">材料齐全情况</td>
                <td style="width: 8%;">份数</td>
                <td style="width: 15%;">附件</td>
            </tr>
            <c:forEach items="${applyList}" var="map">
                <c:set value="upLoad${map.no}" var="upLoadNo"/>
                <tr class="tr_dark">
                    <td>${map.no}</td>
                    <td style="text-align: left;">${map.materialName}</td>
                    <td>
                        有<input type="radio" name="isFull${map.no}" value="1" disabled="true"
                                <c:if test="${map.isFull=='true'}">checked="checked"</c:if>>
                        无<input type="radio" name="isFull${map.no}" value="0" disabled="true"
                                <c:if test="${map.isFull=='false'}">checked="checked"</c:if>>
                    </td>
                    <td>${map.num}</td>
                    <td>${map[upLoadNo]}</td>
                </tr>
            </c:forEach>
        </table>
    </td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">材料提交人：</td>
    <td class="form_content">${bean.materialPerson}</td>
</tr>
<tr class="tr_light">
    <td class="form_label_right">材料提交人联系电话：</td>
    <td class="form_content">${bean.materialPersonPhone}</td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">材料提交人联系地址：</td>
    <td class="form_content">${bean.materialPersonAddress}</td>
</tr>
<tr class="tr_light">
    <td class="form_label_right">收件人：</td>
    <td class="form_content">${bean.receivePerson}</td>
</tr>
<tr class="tr_dark">
    <td class="form_label_right">收件人联系电话：</td>
    <td class="form_content">${bean.receivePersonPhone}</td>
</tr>
<c:if test="${bean.status==STATUS_SUBMIT||bean.status==STATUS_CS_PASS||bean.status==STATUS_FH_PASS||bean.status==STATUS_SH_PASS||bean.status==STATUS_FGLD_PASS||bean.status==STATUS_ZXLD_PASS}">
    <tr>
        <td colspan="2">
            <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                <tr class="tr_header">
                    <td style="width: 5%;">序号</td>
                    <td style="width: 25%;">提交材料名称</td>
                    <td style="width: 40%;">审核要求</td>
                    <td style="width: 8%;">初审意见</td>
                    <td style="width: 8%;">复核意见</td>
                    <td style="width: 8%;">审核意见</td>
                </tr>
                <c:forEach items="${submitList}" var="map">
                    <tr class="tr_dark">
                        <td>${map.no}</td>
                        <td style="text-align: left;">${map.materialName}</td>
                        <td style="text-align: left;">${map.auditReq}</td>
                        <td>
                            <c:if test="${map.csOpinion=='true'}">符合</c:if>
                            <c:if test="${map.csOpinion=='false'}">不符合</c:if>
                        </td>
                        <td>
                            <c:if test="${map.fhOpinion=='true'}">符合</c:if>
                            <c:if test="${map.fhOpinion=='false'}">不符合</c:if>
                        </td>
                        <td>
                            <c:if test="${map.shOpinion=='true'}">符合</c:if>
                            <c:if test="${map.shOpinion=='false'}">不符合</c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</c:if>
<c:if test="${(bean.status==STATUS_CS_PASS)}">
    <tr class="tr_dark">
        <td class="form_label_right">初审意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
        </td>
    </tr>
</c:if>

<c:if test="${(bean.status==STATUS_FH_PASS)}">
    <tr class="tr_dark">
        <td class="form_label_right">初审意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">复核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
        </td>
    </tr>
</c:if>

<c:if test="${(bean.status==STATUS_SH_PASS)}">
    <tr class="tr_dark">
        <td class="form_label_right">初审意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">复核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">审核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
        </td>
    </tr>
</c:if>

<c:if test="${(bean.status==STATUS_FGLD_PASS)}">
    <tr class="tr_dark">
        <td class="form_label_right">初审意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">复核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">审核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">分管领导审核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
        </td>
    </tr>
</c:if>

<c:if test="${(bean.status==STATUS_ZXLD_PASS)}">
    <tr class="tr_dark">
        <td class="form_label_right">初审意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">复核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">审核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_light">
        <td class="form_label_right">分管领导审核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
        </td>
    </tr>
    <tr class="tr_dark">
        <td class="form_label_right">中心领导审核意见：</td>
        <td class="form_content">
            <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
        </td>
    </tr>
</c:if>

<tr class="tr_button">
    <td class="form_content" colspan="2" style="text-align: center;">
        <input type="button" value="打印" class="button_all" onclick="printView()">
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>