<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        if (${pageNum == 1}) {
            $("#upPage").get(0).disabled = true;
        }
        if (${pageNum*pageSize >= totalListSize}) {
            $("#downPage").get(0).disabled = true;
        }
    });
    // 上一页下一页
    function seekNext(index) {
        $("#pageNum").val(parseInt($("#pageNum").val()) + parseInt(index));
        loadAjaxData("getData", "${ctx}/oaBbs/getData.do?pageNum=" + $("#pageNum").val() + "&pageSize=" + $("#pageSize").val() + "&title=${title}&time=${time}&order=${order}");
    }
    // 改变每页显示数量
    function seePageSize() {
        loadAjaxData("getData", "${ctx}/oaBbs/getData.do?pageNum=1&pageSize=" + $("#pageSize").val() + "&title=${title}&time=${time}&order=${order}");
    }
    // 改变每行显示数量||回车事件
    function seeTdNum() {
        loadAjaxData("getData", "${ctx}/oaBbs/getData.do?pageNum=" + $("#pageNum").val() + "&pageSize=" + $("#pageSize").val() + "&title=${title}&time=${time}&order=${order}");
    }
    // 页数回车事件
    function keyDown(e) {
        var ev = window.event || e;
        if (ev.keyCode == 13) {
            seeTdNum();
        }
    }
</script>
<table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 99%;">
    <tr class="tr_header">
        <td style="width: 40%;" nowrap>主题</td>
        <td style="width: 10%;" nowrap>附件</td>
        <td style="width: 15%;" nowrap>浏览/回复</td>
        <td style="width: 20%;" nowrap>发表人</td>
        <td style="width: 20%;" nowrap>最后回复</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr class="tr_light">
            <td>
                &nbsp;<a onclick="view('${item.id}')"
                   style="cursor: pointer;color: #0000ff;">【${item.typeName}】${item.title}</a>
                <c:if test="${item.isTop}">&nbsp;<span style="color: red;">精</span></c:if>
            </td>
            <td style="text-align: center;">&nbsp;${item.docButton}</td>
            <td style="text-align: center;">
                &nbsp;${item.visitTimes}/${item.replyTimes}
            </td>
            <td style="text-align: center;">
                <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm"/> <br> ${item.personName}
            </td>
            <td style="text-align: center;">
                <fmt:formatDate value="${item.lastReplyTime}" pattern="yyyy-MM-dd HH:mm"/>
                <br> ${item.lastReplyPerson}
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float: left;padding-left: 500px">
            <input type="button" onclick="seekNext(-1)" value="上一页" id="upPage">&nbsp;
            当前第<input type="text" size="3" value="${pageNum}" onkeydown="keyDown(event)" id="pageNum" name="pageNum"/>页
            &nbsp;<input type="button" onclick="seekNext(1)" value="下一页" id="downPage">&nbsp;&nbsp;
            <select id="pageSize" name="pageSize" onchange="seePageSize()">
                <option value="10" <c:if test="${pageSize ==10}">selected="true" </c:if>>10</option>
                <option value="20" <c:if test="${pageSize ==20}">selected="true"</c:if>>20</option>
                <option value="50" <c:if test="${pageSize ==50}">selected="true" </c:if>>50</option>
            </select>
        </div>
        <div style="float: right;padding-right: 15px">
            <label> 一共${totalListSize}条记录</label>
        </div>
    </div>
</div>

