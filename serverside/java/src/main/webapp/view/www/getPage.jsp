<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var url = "${ctx}/site/${pageUrl}";
    function doJumpPage(flag) {
        var curPage = ${page.page};
        var totalPage = ${page.totalPages};
        var nextPage = 1;
        if (flag == "first") {
            nextPage = 1;
        } else if (flag == "end") {
            nextPage = totalPage;
        } else if (flag == "prev") {
            nextPage = curPage - 1;
            if (nextPage < 1) {
                nextPage = 1;
            }
        } else if (flag == "next") {
            nextPage = curPage + 1;
            if (nextPage > totalPage) {
                nextPage = totalPage;

            }
        }
        window.location = url + "&pageNo=" + nextPage;
    }
    function doJumpPageAt(page) {
        var curPage = ${page.page};
        var totalPage = ${page.totalPages};
        var nextPage = 1;
        if (page > totalPage) {
            nextPage = totalPage;
        } else if (page < nextPage) {
            nextPage = 1;
        }
        else {
            nextPage = page;
        }

        window.location = url + "&pageNo=" + nextPage;

    }
</script>
<c:if test="${page.records>7}">
    <br>
    <div align="right" style="height:30px;">

        <a href="javascript:doJumpPage('first')">首页</a>&nbsp;
        <a href="javascript:doJumpPage('prev')">上一页</a>&nbsp;
        <a href="javascript:doJumpPage('next')">下一页</a>&nbsp;
        <a href="javascript:doJumpPage('end')">末页</a>&nbsp;

        当前第
            ${page.page}
        页

        共
            ${page.totalPages}
        页

        总共
            ${page.records}
        条记录&nbsp;

        <input type="text" size="3" name="" id="jump"/>
        <input type="button" value="跳转" onclick="doJumpPageAt(document.getElementById('jump').value)"/>
    </div>
</c:if>

