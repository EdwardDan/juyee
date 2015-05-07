<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function viewDefine(column) {
        var strFeatures = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no;resizable:yes";
        openFullWindow("${ctx}/bpmProcessTemplate/viewDefine.do?id=${bean.id}&column=" + column + "");
    }
    function viewEmz() {
        var strFeatures = "dialogWidth=900px;dialogHeight=700px;center=yes;help=no;resizable:yes";
        openWindow("${ctx}/bpmProcessTemplate/viewEmz.do?id=${bean.id}");
    }

    function downloadPar(id) {
        window.location = "${ctx}/bpmProcessTemplate/blobDownload.do?id=" + id;
    }
</script>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
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
            <td class="form_label">Visio页面:</td>
            <td class="form_content">&nbsp;
                <input type="button" class="button_normal" onclick="viewDefine('vmlHtml')"
                       value="查看" <c:if test="${empty bean.vmlHtml}">disabled</c:if>>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">Visio节点定义:</td>
            <td class="form_content">&nbsp;
                <input type="button" class="button_normal" onclick="viewDefine('topologyXml')"
                       value="查看" <c:if test="${empty bean.topologyXml}">disabled</c:if>>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">模板下载:</td>
            <td class="form_content">&nbsp;
                <input type="button" class="button_normal_long"
                       onclick="downloadPar(${bean.id});"
                       value="下载模板" <c:if test="${empty bean.visioPar}">disabled</c:if>>
            </td>
        </tr>
        

        
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>