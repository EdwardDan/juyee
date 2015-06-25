var errAjaxMsg = "<div class=\"errMsg\">数据出错或服务器正忙，请稍候重新尝试！</div>";

//查看信息
function viewInfo(id) {
    openFullWindow("${ctx}/site/infoView.do?id=" + id, 1024, 768);
}
//查看图片
function viewPic(id) {
    openFullWindow("${ctx}/site/picView.do?id=" + id, 1024, 768);
}

/**
 * 异步获取ajax数据
 * @param objName
 * @param url
 */
function loadAjaxData(objName, url) {
//    showLoadMsg(objName);
//    alert(url);
    $.ajax({
        url: url,
        cache: false,
        data:"",
        success: function(ret) {
            $("#" + objName + "").html(ret);
        },error:function() {
            $("#" + objName + "").html(errAjaxMsg);
        }
    });
}
function loadAjaxDataCallback(objName, url, callback) {
    $.ajax({
        url: url,
        cache: false,
        data:"",
        success: function(ret) {
            if (objName != null) {
                $("#" + objName + "").html(ret);
            }
            if (callback != null) {
                callback(ret);
            }
        },error:function() {
            if (objName != null) {
                $("#" + objName + "").html(errAjaxMsg);
            }
        }
    });
}

/**
 * 弹出窗口--居中
 * @param url
 * @param width
 * @param height
 * @param windowName  弹出窗口名称
 */
function openFullWindow(url, width, height, windowName) {
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;
    var args = 'width=' + width + ', height=' + height + ', top=' + top + ', left=' + left;
    args += ', toolbar=no, scrollbars=yes, menubar=no, location=no, resizable=yes';
    if (windowName != null) {
        window.open(url, windowName + "", args);
    } else {
        window.open(url, 'oWin', args);
    }
}

/**
 * 关闭窗口不提示
 */
function closeFullWindow() {
    window.opener = null;
    //window.opener=top;
    window.open("", "_self");
    window.close();
}