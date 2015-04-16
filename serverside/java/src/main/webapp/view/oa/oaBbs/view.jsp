<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    //修改发帖
    function newPost() {
        var parentId = $("#parentId").val();
        window.location = "${ctx}/oaBbs/newPost.do?parentId=" + parentId;
    }
    //回帖
    function reply(id) {
        var parentId = $("#parentId").val();
        window.location = "${ctx}/oaBbs/reply.do?parentId=" + parentId + "&id=" + id;
    }
    //返回列表
    function reBackList() {
        window.location = "${ctx}/oaBbs/grid.do";
    }
    //移除
    function removeBbs(id, flag) {
        if (confirm("确定移除此贴吗？")) {
            loadAjaxData("view", "${ctx}/oaBbs/remove.do?id=" + id + "&flag=" + flag);
        }
    }
    //关闭(设置无效)
    function closeBbs(id, flag) {
        if (confirm("确定关闭此贴吗？关闭后将不能再回复！")) {
            loadAjaxData("view", "${ctx}/oaBbs/close.do?id=" + id + "&flag=" + flag);
        }
    }
    //设置精华
    function setIsTop(id) {
        if (confirm("确定将此贴设置为精华吗？")) {
            loadAjaxData("view", "${ctx}/oaBbs/setIsTop.do?id=" + id);
        }
    }
    //只看此人（楼主）
    function onlyThisPerson(id, flag) {
        loadAjaxDataCallback("view", "${ctx}/oaBbs/onlyThisPerson.do?id=" + id + "&flag=" + flag, callbackEvent);
    }
    //回调函数处理跳转页面
    function callbackEvent(ret) {
        var obj = eval("(" + ret + ")");
        if (obj.success) {
            loadAjaxData("view", "${ctx}/oaBbs/view.do?id=" + obj.id);
        }
    }
</script>
<style type="text/css">
    .button_bar_bg {
        height: 3px;
        background-image: url(${themePath}/img/tab_bar_bg.jpg);
        background-repeat: repeat-x;
        border-top: none;
        border-right: none;
        border-bottom: none;
        border-left: 1px solid #FFFFFF;
        background-position: bottom;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div" style="text-align: center;" id="view">
        <br>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <input type="hidden" name="parentId" id="parentId" value="${bean.id}">
            <tr>
                <td rowspan="2" style="width: 105px;height: 100px;">&nbsp;<img src="${themePath}/img/bbs.jpg"></td>
                <td style="text-align: left;">
                    &nbsp;【${bean.type.name}】${bean.title}
                    <c:if test="${bean.isTop}">&nbsp;<span style="color: red;">精</span></c:if>
                </td>
                <td style="text-align:right;">
                    <c:if test="${!bean.isTop && (canManager || createUser == loginName ) && bean.isValid}">
                        <input type="button" class="button_long" value="设置精华" onclick="setIsTop('${bean.id}')">
                    </c:if>
                    浏览/回复：${bean.visitTimes} / ${bean.replyTimes}&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td style="text-align: left;">
                    &nbsp;${bean.personName} 发表于
                    <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a onclick="onlyThisPerson('${bean.id}','lz')" style="cursor: pointer;">[只看楼主]</a>
                    <c:if test="${null!=bean.document}"> ${docButton}</c:if>
                </td>
                <td style="text-align:right;">
                    <c:if test="${bean.isValid}">
                        <a onclick="newPost()" style="cursor: pointer;">编辑 </a>
                        |<a onclick="closeBbs('${bean.id}','view')" style="cursor: pointer;"> 关闭</a>
                        |<a onclick="removeBbs('${bean.id}','removeParent')" style="cursor: pointer;"> 移除</a>
                    </c:if>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td class="button_bar_bg" colspan="3">
                    <img src="${themePath}/system/icons/tm.gif" width="1" height="1">
                </td>
            </tr>
        </table>
        <br>
        <c:forEach items="${list}" var="item" varStatus="status">
            <c:if test="${status.index != 0}">
                <hr>
                <br>
            </c:if>
            <table cellpadding="0" cellspacing="0" class="form_table" border="0">
                <tr>
                    <td rowspan="2" style="width: 105px;height: 100px;">&nbsp;<img src="${themePath}/img/bbs.jpg"></td>
                    <td style="text-align: left;">
                        &nbsp;${item.personName} 发表于
                        <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a onclick="onlyThisPerson('${item.id}','notlz')" style="cursor: pointer;">[只看此人]</a>
                        <c:if test="${null!=item.docId}"> ${item.docButton}</c:if>
                    </td>
                    <td style="text-align:right;">
                        <c:if test="${canEdit || canManager || createUser == loginName}">
                            <a onclick="reply('${item.id}')" style="cursor: pointer;">编辑</a>
                            |<a onclick="removeBbs('${item.id}','removeChild')" style="cursor: pointer;"> 移除</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: left;">
                        &nbsp;<sys:toHtml>${item.content}</sys:toHtml>
                    </td>
                </tr>
            </table>
            <br>
        </c:forEach>
        <table cellpadding="0" cellspacing="0" class="form_table" border="0">
            <tr class="tr_button">
                <td>
                    <input type="button" class="button_confirm" value="回复"
                           <c:if test="${bean.isValid}">onclick="reply('');"</c:if>>
                    <input type="button" class="button_long" value="返回列表" onclick="reBackList();">
                </td>
            </tr>
        </table>
    </div>
</form:form>