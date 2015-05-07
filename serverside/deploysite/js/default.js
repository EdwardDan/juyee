var errAjaxMsg = "<div class=\"errMsg\">数据出错或服务器正忙，请稍候重新尝试！</div>";
var openWindowId = "winOpenId";
var listGridId = "listGrid";

//判断浏览器是否ipad
function checkIsIpad() {
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    return userAgent.indexOf("Safari") > -1;
}
//判断浏览器是否IE
function checkIsIE() {
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    return (userAgent.indexOf("MSIE") > -1);
}

//判断某obj是否存在
function checkObj(objId) {
    return ($('#' + objId).length > 0);
}

//显示或隐藏元素
function showObj(checkObj, objName) {
    document.getElementById(objName).style.display = checkObj.checked ? "" : "none";
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
        data: "",
        success: function (ret) {
            if (objName != null) {
                $("#" + objName + "").html(ret);
            }
        }, error: function () {
            if (objName != null) {
                $("#" + objName + "").html(errAjaxMsg);
            }
        }
    });
}
function loadAjaxDataCallback(objName, url, callback) {
     //显示加载提示信息
    var msg = "<br><br>&nbsp;正在获取数据......";
    $("#" + objName + "").html(msg);
    $.ajax({
        url: url,
        cache: false,
        data: "",
        success: function (ret) {
            if (objName != null) {
                $("#" + objName + "").html(ret);
            }
            if (callback != null) {
                callback(ret);
            }
        }, error: function () {
            if (objName != null) {
                $("#" + objName + "").html(errAjaxMsg);
            }
        }
    });
}

/**
 * 同步获取ajax数据
 * @param url
 * 返回json字符串
 */
function getAjaxData(url) {
    var ret = $.ajax({
        url: url,
        async: false,
        cache: false
    }).responseText;
    if (ret != null) {
        if (ret.indexOf("{") >= 0) {
            return eval("(" + ret + ")");
        }
    }
    return ret;
}

/**
 * 表单存储
 * @param url
 * @param formId
 * @param callbackFunc
 */
function saveAjaxData(url, formId, callbackFunc, opts) {
    //    if (formId == null || "" == formId)formId = "bean";
    var sendData = "";

    if (formId != null && $('#' + formId).length > 0) {
        sendData = $("#" + formId).serializeArray();
    }
    $.ajax({
        type: 'POST',
        url: url,
        data: sendData,
        dataType: 'json',
        success: function (data) {
            var isCallBackExec = false;
            if (data.success) {
                if (!opts || opts.showSuccessInfo !== false) {
                    isCallBackExec = true;
                    showInfoMsg(data.msg, null, callbackFunc);
                }
                if (opts) {
                    if (opts.windowId) {
                        closeWindow(opts.windowId);
                    }
                    if (opts.gridId) refreshGrid(opts.gridId);
                    if (opts.zTreeId) refreshTree(opts.zTreeId);
                    if (opts.iframeId) refreshIframGrid(opts.iframeId,null);
                } else {
                    closeWindow();
                    refreshGrid();
                    refreshTree();
                }

            } else {
                showErrorMsg(data.msg);
            }
            if (callbackFunc && !isCallBackExec) {
                if ($.isFunction(callbackFunc)) {
                    callbackFunc(data);
                } else {
                    eval(callbackFunc);
                }
            }
        },
        error: function (xmlR, status, e) {
            openNewWindow("errorWindow", "错误", null, false, 600, 400);
            $("#errorWindow").panel("body").html(xmlR.responseText);
//            showErrorMsg("[" + e + "]" + xmlR.responseText);
        }
    });
}

function createFrame(url, id) {
    if (id == null) id = "mainContentFrame";
    return '<iframe scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:100%;" id="' + id + '" name="' + id + '"></iframe>';
}

//弹出窗口
var myWindowsOpened = false; //弹出标志，避免2次加载
function openWindow(title, url, isRefreshGrid, width, height,iframeId) {
    openNewWindow(null, title, url, isRefreshGrid, width, height,iframeId);
}
function openNewWindow(windowId, title, url, isRefreshGrid, width, height,iframeId) {
    if (windowId == null) windowId = openWindowId;
    if ($('#' + windowId).length <= 0) {
        $("body").append("<div id=\"" + windowId + "\"></div>");
    }
    if (width == null) width = 700;
    if (height == null) height = 450;
    var left = ($(window).width() - width) * 0.5;
    var top = ($(window).height() - height) * 0.5 - 30;
    var opts = {
        title: title,
        href: url,
        loadingMessage: "正在加载数据......",
        iconCls: "icon-edit",
        width: width,
        height: height,
        left: left,
        top: top,
        modal: true,
        shadow: true,
        collapsible: false,  //折叠按钮
        minimizable: false,  //最小化按钮
        maximizable: true,  //最大化按钮
        closed: true,
        resizable: true,
        onClose: function () {
            if (isRefreshGrid != null) {
                if (isRefreshGrid) {
                    refreshGrid(null);
                    refreshIframGrid(iframeId, null);
                }
            }
        }
    };
    if ($.isPlainObject(title)) {
        opts = $.extend(opts, title);
    }
    var win = $('#' + windowId).window(opts);

    /********modify by chenjp at 20130620 begin********/
//    $('#' + windowId).window('open');
//    $('#' + windowId).window("refresh");

        //设置1个标志位，解决首次弹出窗口时会造成2次加载问题
    $('#' + windowId).window('open');
    if (myWindowsOpened) {
        $('#' + windowId).window('refresh');
    } else {
        myWindowsOpened = true;
    }
    /********modify by chenjp at 20130620 end********/

    var windowStack = $(window.top).data("windowStack") || [];
    windowStack.push(win);
    $(window.top).data("windowStack", windowStack);
}

//刷新grid
function refreshGrid(gridId) {
    if (gridId == null)gridId = listGridId;
    if ($('#' + gridId).length <= 0) return;
    $("#" + gridId).trigger("reloadGrid");
}
//刷新iframe's grid
function refreshIframGrid(iframeId, gridId) {
    if (gridId != null) {
        window.setTimeout('doRefreshIframGrid(\"' + iframeId + '\",\"' + gridId + '\")', 500);
    } else {
        window.setTimeout('doRefreshIframGrid(\"' + iframeId + '\")', 500);
    }
}
function doRefreshIframGrid(iframeId, gridId) {
    if (iframeId == null||iframeId == "null")iframeId = "tab1";
    if (gridId == null)gridId = listGridId;
    if ($('#' + iframeId).length <= 0) return;
    document.getElementById(iframeId).contentWindow.$("#" + gridId).trigger("reloadGrid");
}

function refreshWindow(windowId) {
    windowId = windowId || openWindowId;
    var winEle = $("#" + windowId);
    if (winEle.length == 1) {
        $(winEle).window('refresh');
    }
}

//关闭弹出窗口
function closeWindow(windowId) {
    var windowStack = $(window.top).data("windowStack");
    if ($.isArray(windowStack)) {
        while (windowStack && windowStack.length > 0) {
            var win = windowStack.pop();
            if ($(win).length && !($(win).window("options").closed)) {
                $(win).window('close');
                break;
            }
        }
    }
//    if (windowId == null) windowId = openWindowId;
//    if ($('#' + windowId).length <= 0) return;
//    $('#' + windowId).window('close');
}

//删除列表记录
function doGridDelete(url, msg, opts) {
    if (msg == null) msg = "您确定要删除此记录吗?";
    $.messager.confirm('系统提示', msg, function (r) {
        if (r) {
            saveAjaxData(url, null, null, opts);
        }
    });
}

//登录页居中
function adjustDivPostionCenter(divName) {
    var postop = ($(document).height() - $("#" + divName).height()) / 2;
    var posleft = ($(window).width() - $("#" + divName).width()) / 2;
    var loginTop = 120;
    if (postop < loginTop) postop = loginTop;
    $("#" + divName).css({"left": posleft + "px", "top": postop + "px"});
    $("#" + divName).show();
}

//grid 加载之后调整宽度
function adjustGridAfterLoad(gridW, height) {
    if (!gridW) {
        gridW = $(".gridQueryArea").width();
    }
    if (!height) {
        height = 360;
    }
    $("#listGrid").setGridWidth(gridW);
    $("#listGrid").setGridHeight(height);
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function showErrorMsg(msgString) {
    showInfoMsg(msgString, "error");
}
function showInfoMsg(msgString, msgType, fn) {
    var title = "系统提示";
    if (msgType == null || "" == msgType) msgType = "info";
    if (msgType == "info" || msgType == "warning") {
        title = "系统提示";
    } else if (msgType == "error") {
        title = "出错了";
    }
    title = "&nbsp;<img src='"+CONTEXT_NAME+"/skin/default/jquery/easyui/images/top_icon.png' border=0 align='absmiddle'/> "+title;
    if ($.browser.msie && $.browser.version == 9 && window.parent !== window) {
        window.parent.$.messager.alert(title, msgString, msgType, fn);
    } else {
        $.messager.alert(title, msgString, msgType, fn);
    }
}

//选择日历
function calendar(objName, dateType) {
    var json = "";
    if (dateType != null) {
        if ('all' == dateType) {
            json += "dateFmt:'yyyy-MM-dd HH:mm:ss'";
        } else if ('datetime' == dateType) {
            json += "dateFmt:'yyyy-MM-dd HH:mm'";
        } else {
            json += "dateFmt:'yyyy-MM-dd'";
        }
    }
    if (objName != null && objName != "") {
        if (json != "") {
            json = "el:'" + objName + "'," + json;
        } else {
            json = "el:'" + objName + "'";
        }
    }
    if (json != "") json = "{" + json + "}";
    WdatePicker(eval("(" + json + ")"));
}
//选择日历
function calendarByJson(customJson) {
    if (customJson != null) {
        WdatePicker(customJson);
    }
}

//计算年龄
function getAge(brithday, returnObj) {
    if (brithday == null || brithday == "") return "";
    var aDate = new Date();
    var thisYear = aDate.getFullYear();
    var brith = brithday.substr(0, 4);
    var age = parseInt(thisYear) - parseInt(brith);
    if (returnObj != null) {
        returnObj.val(age);
    } else {
        return age;
    }
}

//for grid
function booleanFormat(cellvalue, options, rowObject) {
    return cellvalue == "true" ? "是" : "否";
}
//for grid
function validFormat(cellvalue, options, rowObject) {
    return cellvalue == "true" ? "有效" : "无效";
}

//input check
function validateForm(formName) {
    return $("#" + formName).validationEngine('validateform');
}
function validateInit(conditions, formName) {
    for (var i = 0; i < conditions.length; i++) {
        var cond = conditions[i];
        //下面两个效果相同
        $("#" + formName + " [name=" + cond.name + "]").attr("data-validation-engine", cond.rule);
        //            $("#bean [name=" + cond.name + "]").addClass(cond.rule);
    }
    $("#" + formName).validationEngine('attach', {
        promptPosition: "bottomRight",
        isOverflown: true,
        overflownDIV: "#winOpenId"
    });
}
//default filter for tree
function defaultFilter(treeId, parentNode, childNodes) {
    if (!childNodes) return null;
    for (var i = 0, l = childNodes.length; i < l; i++) {
        childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
    }
    return childNodes;
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

/*********************function description***begin****************************************
 *js控制动态增加删除行，无须指定tableId和firstRow，仅需要设置一个隐藏的标准行id=standarditem
 *********************function description***begin****************************************/
/***增加行***
 *srcitem可选，为可指定ID的标准行，若无该参数则取id=standarditem的所在行
 *currentRow 在firefox下需要传递this进来
 *****/
function addRow(srcitem, currentRow) {
    var srcObj;
    if (srcitem) {
        srcObj = srcitem;
    } else {
        if (!standarditem) {
            alert("未设置标准行，请在'Block} -->'后设置标准行！");
            return;
        }
        srcObj = standarditem;
    }
    var curRow;
    var row;
    if (currentRow) {
        curRow = currentRow.parentNode;
        row = curRow.parentElement.parentElement.insertRow(-1);
    }else{
        curRow = getRowTr();
        row = curRow.parentElement.insertRow(curRow.rowIndex + 1);
    }
    var cellcount = srcObj.cells.length;
    for (var i = 0; i < cellcount; i++) {
        var cell = row.insertCell(i);
        cell.align = srcObj.cells[i].align;
        cell.innerHTML = srcObj.cells[i].innerHTML;
        cell.style.display = srcObj.cells[i].style.display;

        //增加行的默认样式
        cell.className = "td_light";
    }
}
/**
 ***删除行***
 */
function delRow(currentRow) {
    if (confirm("确定要删除吗!")) {
        if (currentRow) {
            var trObj = currentRow.parentNode;
            trObj.parentElement.parentElement.deleteRow(trObj.parentElement.rowIndex);
        }else{
            var trObj = getRowTr();
            trObj.parentElement.deleteRow(trObj.rowIndex);
        }
    }
}
//获取当前obj动作触发时所在的tr
//搜索过程：event-->obj-->td-->tr
function getRowTr() {
    return event.srcElement.parentElement.parentElement;
}
//提交表单时需要删除标准行
//srcitem可选
function standarditemDisable(srcitem) {
    var srcObj;
    if (srcitem)
        srcObj = srcitem;
    else {
        srcObj = standarditem;
    }
    if (srcObj)
        srcObj.parentElement.deleteRow(srcObj.rowIndex);
}

/**
 * 功能：去除select中重复的选项 .
 * 说明：参数select为一个传入的select，
 * 如：var select = document.getElementById("innerSysPerson");
 *    removeRepeatOption(select)；
 * @param select
 */
function removeRepeatOption(select) {
    for (var i = 0; i < select.options.length; i++) {
        for (var j = i + 1; j < select.options.length; j++) {
            if (select.options[i].value == select.options[j].value) {
                $(select.options[j]).remove();
            }
        }
    }
}
/*********************function description***end****************************************/
function ajustTreeHeight() {
    $("#treeLeft").height($("#mainContent").height() - 29);
    $(window).resize(function () {
        window.setTimeout(function () {
            $("#treeLeft").height($("#mainContent").height() - 29)
        }, 500);
    })
}

function getElementValue(doc, tag) {
    var startTag = "<" + tag + ">";
    var endTag = "</" + tag + ">";
    return getElementValueByTag(doc, startTag, endTag);
}
function getElementValueByTag(doc, startTag, endTag) {
    var pStart = doc.indexOf(startTag);
    var pEnd = doc.indexOf(endTag);
    var ret = "";
    if (pStart >= 0 && pEnd > pStart) {
        ret = doc.substring(pStart + startTag.length, pEnd);
    }
    return ret;
}

function getNotNullNumber(s) {
    if (null == s || "" == s) {
        return 0;
    } else {
        return parseFloat(s);
    }
}

//xml模板中输入框适应单元格高度
function autoResize(obj) {
    if (obj.parentElement) {
        obj.style.height = obj.parentElement.offsetHeight + "px";
    }
}

//调用fr打印
function printFR(reportName, param) {
    openFullWindow(CONTEXT_NAME + "/ReportServer?reportlet=report/" + encodeURI(reportName) + ".cpt&" + encodeURI(param), 900, 550);
}

/*********************function description*******************************************
 *如果有小数则四舍五入(小数点后指定位数len)
 **************************************************************************************/
function roundNumber(oldNum, len) {
    if (null == len) len = 2;
    var add = 0;
    var s1 = oldNum + "";
    var start = s1.indexOf(".");
    if (start == -1) return oldNum;
    if (s1.substr(start + len + 1, 1) >= 5)add = 1;
    var temp = Math.pow(10, len);
    var s = Math.floor(oldNum * temp) + add;
    return (s / temp);
}

//禁止按钮再次点击
function disableBtn(btn, showName) {
    if (showName == null) showName = "稍候.";
    btn.value = showName;
    btn.disabled = true;
}
//放开按钮
function enableBtn(btn, showName) {
    if (showName == null) showName = "确定";
    btn.value = showName;
    btn.disabled = false;
}

/**
 * 根据显示对象的宽度、字的宽度设置显示的字数。
 * @param dom 显示对象中要显示内容的元素的标示，比如：<span class="cutString">${item.task.title}</span>，则dom为“span.cutString”
 *            默认为"span.cutString".
 * @param constantLength 为显示对象中显示的固定长度，默认为135.
 * @param wordWidth 为字的宽度，默认为12.74。
 * @param parentNodeName 显示对象的元素标签名，默认为"td".
 */
function setContentByRowWidth(dom, constantLength, wordWidth, parentNodeName) {

    if (constantLength == null || constantLength == "" || constantLength == undefined) {
        constantLength = 135;
    }

    if (wordWidth == null || wordWidth == "" || wordWidth == undefined) {
        wordWidth = 12.74;
    }

    if (dom == null || dom == "" || dom == undefined) {
        dom = "span.cutString";
    }

    if (parentNodeName == null || parentNodeName == "" || parentNodeName == undefined) {
        parentNodeName = "td";
    }

//    String.prototype.Trim = function () {
//        return this.replace(/(^\s*)|(\s*$)/g, "");
//    };

    var clientWidth;
    var wordAmount;
    var x = $(dom).toArray();
    var content;
    var length = x.length;
    var contentLength;
    for (var i = 0; i < length; i++) {
        clientWidth = $(x[i]).parentsUntil(parentNodeName).parent(parentNodeName).width();
        if (i == 0 || clientWidth != $(x[i - 1]).parentsUntil(parentNodeName).parent(parentNodeName).width()) {
            wordAmount = parseFloat(clientWidth - constantLength) / wordWidth;
            wordAmount = Math.round(wordAmount);
        }

        content = $(x[i]).html();
        content = $.trim(content);

        contentLength = content.length;
        while (content.substring(contentLength - 3, contentLength) == "...") {
            content = content.substring(0, contentLength - 3);
            contentLength = content.length;
        }
        if (contentLength > wordAmount) {
            content = content.substr(0, wordAmount) + "...";
            $(x[i]).html(content);
        }
    }
}

//查看大图
function openBigPhoto(url) {
    var photoWindow = window.open(CONTEXT_NAME + '/view/common/blank.jsp', 'pic', 'width=' + screen.width + ',height=' + screen.height + ',top=0,left=0,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=yes,status=yes');
    photoWindow.document.writeln("<img src='" + url + "' border=0>");
    photoWindow.document.close();
}

/**
 *   获得图表
 * @param swf  URL of SWF file of the chart type that we intend to use
 * @param id   Id for the chart - You can give any id for the chart. Just make sure that if you're using multiple charts in the same HTML page, each chart should have a unique Id
 * @param w    Required width
 * @param h    Required height
 */
function getChart(dataUrl, chartdiv, swf, w, h) {
    if (checkIsIpad()) {
        FusionCharts.setCurrentRenderer('javascript');
    } else {
        FusionCharts.setCurrentRenderer(GALLERY_RENDERER);
    }
    var chartId = "myChart_" + Math.random() * 10;
    var myChart = new FusionCharts(swf, chartId, w, h, "0", "0");
    myChart.setDataURL(dataUrl);
    myChart.render(chartdiv);
}

/**
 * 根据日期获取星期
 * @param date
 * @param week
 */
function getWeek(date, week) {
    var dateStr = document.getElementById(date).value.substr(0, 10);
    var weeks = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    var dateArr = dateStr.split('-');
    if (dateArr.length == 3) {
        document.getElementById(week).innerHTML = weeks[new Date(dateArr[0], dateArr[1] - 1, dateArr[2]).getDay()];
    }
}
//加载安全质量监督列表的按钮
function loadJdGridButton(jdTypeCode,jdAttributeCode){
    $(".gridQueryArea").append('<div style="float:right;padding-right: 10px" id="gridButton"></div>');
    loadAjaxData("gridButton",CONTEXT_NAME+"/jdRecord/gridButton.do?jdTypeCode="+jdTypeCode+"&jdAttributeCode="+jdAttributeCode);
}