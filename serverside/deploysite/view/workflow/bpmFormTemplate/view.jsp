<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function viewTemplate(column) {
        var strFeatures = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no;resizable:yes";
        openFullWindow("${ctx}/bpmFormTemplate/viewTemplate.do?id=${bean.id}&column=" + column + "");
    }
    function viewFormHtml() {
        var strFeatures = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no;resizable:yes";
        openFullWindow("${ctx}/bpmFormTemplate/viewFormHtml.do?id=${bean.id}");
    }
    function downloadPar(id) {
        window.location = "${ctx}/bpmFormTemplate/blobDownload.do?id=" + id;
    }
    function doBatch() {
        if (confirm("是否要批量更新所有简化评定的引用模板？")) {
            window.location = "";
        }
    }
</script>
<div class="no_scrollbar">
    <div class="form_div">
        <table cellpadding="1" cellspacing="1" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">编码：</td>
                <td class="form_content">&nbsp;
                    ${bean.code}                    </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">名称：</td>
                <td class="form_content">&nbsp;
                    ${bean.name}                    </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">模板分类：</td>
                <td class="form_content">&nbsp;
                    ${bean.category.name}                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">上传时间：</td>
                <td class="form_content">&nbsp;
                    <fmt:formatDate value="${bean.uploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label">页面模板：</td>
                <td class="form_content" style="width:80%">&nbsp;
                    <input type="button" class="button_normal" onclick="viewTemplate('htmlTemplate')"
                           value="查看" <c:if test="${empty bean.htmlTemplate}">disabled</c:if>>
                    <input type="button" class="button_normal" onclick="viewFormHtml()"
                           value="网页" <c:if test="${empty bean.htmlTemplate}">disabled</c:if>>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">Excel模板：</td>
                <td class="form_content">&nbsp;
                    <input type="button" class="button_normal" onclick="viewTemplate('parHtml')"
                           value="查看" <c:if test="${empty bean.parHtml}">disabled</c:if>>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">Excel模板定义：</td>
                <td class="form_content">&nbsp;
                    <input type="button" class="button_normal" onclick="viewTemplate('parXml')"
                           value="查看" <c:if test="${empty bean.parXml}">disabled</c:if>>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">模板下载:</td>
                <td class="form_content">&nbsp;
                    <input type="button" class="button_normal_long"
                           onclick="downloadPar(${bean.id});"
                           value="下载模板" <c:if test="${empty bean.formPar}">disabled</c:if>>
                </td>
            </tr>
            <c:if test="${isGeneralTemplate}">
                <tr class="td_dark">
                    <td align="right" width="40%">更新模板：</td>
                    <td>
                        <input type="button" class="button_normal_long"
                               onclick="doBatch();"
                               value="批量更新">
                    </td>
                </tr>
            </c:if>
        </table>

        <table cellpadding="1" cellspacing="1" class="form_table" id="go">
            <tr class="tr_title">
                <td align="center" colspan="6">字段映射</td>
            </tr>



            <tr class="tr_header" align="center">
                <td width="30%" nowrap>数据库字段</td>
                <td width="30%" nowrap>模板定义KEY</td>
                <td width="30%" nowrap>列表显示名称</td>
                <td width="30%" nowrap>列表显示宽度</td>
                <td width="5%" nowrap>是否生效</td>
                <td width="5%" nowrap>列表显示</td>
            </tr>
            <c:forEach items="${list}" var="listcolumn">
                <input type="hidden" name="no">
                <tr align="center" class="tr_dark">
                    <td nowrap>
                        <input type="text" class="input_none" name="column_${s.index+1}" value="${listcolumn.column}"
                               readonly style="text-align:center">
                    </td>
                    <td nowrap>
                        <input type="text" name="key_${s.index+1}" value="${listcolumn.key}" readonly
                        <c:choose>
                               <c:when test="${listcolumn.isExpired}">class="input_alert"
                               title="定义（${listcolumn.key}）在页面模板中不存在!" </c:when>
                               <c:otherwise>class="input_none"</c:otherwise>
                        </c:choose>
                                >
                    </td>
                    <td nowrap>
                        <input type="text" class="input_none" name="gridName_${s.index+1}"
                               value="${listcolumn.gridName}"
                               readonly>
                    </td>
                    <td nowrap>
                        <input type="text" class="input_text" name="gridWidth_${s.index+1}"
                               value="${listcolumn.gridWidth}"
                               style="width:60px">%
                    </td>
                    <td nowrap>
                        <input type="checkbox" name="isValid_${s.index+1}" value="1"
                               <c:if test="${listcolumn.isValid}">checked</c:if> disabled>
                    </td>
                    <td nowrap>
                        <input type="checkbox" name="isGridShow_${s.index+1}" value="1"
                               <c:if test="${listcolumn.isGridShow}">checked</c:if> disabled>
                    </td>
                </tr>
            </c:forEach>
            <tr class="tr_light">
                <td class="form_content" colspan="6" style="text-align: center;">
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</div>