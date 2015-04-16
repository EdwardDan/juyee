<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        loadAjaxData("getData", "${ctx}/oaBbs/getData.do?pageNum=1&pageSize=10");
    });
    //发帖
    function newPost() {
        window.location = "${ctx}/oaBbs/newPost.do";
    }
    //回帖
    function reply(parentId) {
        window.location = "${ctx}/oaBbs/reply.do?parentId=" + parentId;
    }
    //浏览
    function view(parentId) {
        window.location = "${ctx}/oaBbs/view.do?id=" + parentId;
    }
    //按条件查询
    function queryData(msg, obj) {
        var a = document.getElementsByTagName("a");
        for (var i = 0; i < a.length; i++) {
            a[i].setAttribute("style", "cursor: pointer;text-align: center;");
        }
        obj.setAttribute("style", "cursor: pointer;text-align: center;color: #0000ff;font-weight: bold;");
        var title = $("#title").val();
        var time = $("#time").val();
        var order = $("#order").val();
        loadAjaxData("getData", "${ctx}/oaBbs/getData.do?title=" + title + "&time=" + time + "&order=" + order + "&msg=" + msg);
    }
    //根据类型查询
    function queryDataByType(typeId, obj) {
        var a = document.getElementsByTagName("a");
        for (var i = 0; i < a.length; i++) {
            a[i].setAttribute("style", "cursor: pointer;text-align: center;");
        }
        obj.setAttribute("style", "cursor: pointer;text-align: center;color: #0000ff;font-weight: bold;");
        loadAjaxData("getData", "${ctx}/oaBbs/getData.do?typeId=" + typeId);
    }
</script>
<div class="form_div" style="text-align: center;">
    <br>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">
        <tr style="height: 25px;">
            <td style="width: 45px;">
                <a onclick="queryDataByType('',this)"
                   style="cursor: pointer;text-align: center;color: #0000ff;font-weight: bold;">全部</a>|
            </td>
            <td style="text-align: left;">
                <c:forEach items="${types}" var="item">
                    <a onclick="queryDataByType('${item.typeId}',this)"
                       style="cursor: pointer;text-align: center;">${item.typeName}</a>
                    <c:if test="${item.code != 'qt'}">|</c:if>
                </c:forEach>
            </td>
            <td style="text-align: right;">
                <c:if test="${canEdit}">
                    <input type="button" class="button_add_long" value="发表新帖" onclick="newPost()">&nbsp;
                </c:if>
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table" border="0">
        <tr style="height: 25px;">
            <td class="form_border" style="width: 45px;">筛选：</td>
            <td style="width: 90px;text-align: left;">&nbsp;
                <input type="text" class="input_text" style="width: 90%" name="title" id="title" value="${title}">
            </td>
            <td style="width: 90px;">
                <select name="time" id="time" class="form_select_long" style="width: 80px;">
                    <option value="">全部时间</option>
                    <option value="oneDay" <c:if test="${time == 'oneDay'}">selected</c:if>>一天</option>
                    <option value="twoDay" <c:if test="${time == 'twoDay'}">selected</c:if>>两天</option>
                    <option value="threeDay" <c:if test="${time == 'threeDay'}">selected</c:if>>三天</option>
                    <option value="oneWeek" <c:if test="${time == 'oneWeek'}">selected</c:if>>一周</option>
                    <option value="oneMonth" <c:if test="${time == 'oneMonth'}">selected</c:if>>一个月</option>
                    <option value="threeMonth" <c:if test="${time == 'threeMonth'}">selected</c:if>>三个月</option>
                </select>
            </td>
            <td style="width: 90px;">
                <select name="order" id="order" class="form_select_long" style="width: 80px;">
                    <option value="">排序</option>
                    <option value="new" <c:if test="${time == 'new'}">selected</c:if>>最新发表</option>
                    <option value="last" <c:if test="${time == 'last'}">selected</c:if>>最后回复</option>
                </select>
            </td>
            <td style="text-align: left;">
                &nbsp;<input type="button" class="btn_Search" value="查询" onclick="queryData('',this);">
            </td>
            <td style="width: 600px;"></td>
            <td style="width: 38px;text-align: center;">
                <a onclick="queryData('new',this)" style="cursor: pointer;">最新</a>&nbsp;|
            </td>
            <td style="width: 38px;text-align: center;">
                <a onclick="queryData('hot',this)" style="cursor: pointer;">热门</a>&nbsp;|
            </td>
            <td style="width: 38px;text-align: center;">
                <a onclick="queryData('top',this)" style="cursor: pointer;">精华</a>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
    <hr>
    <br>

    <div id="getData"></div>
</div>