/****************************************************
 描述：从类似XML文档的字符串中读取指定元素的值
 返回：字符串
 没有找到返回空字符串
 例如：var doc="<id>123</id><name>ABC</name>"
 var tag="id"
 var ret=getElementValue(doc, tag)
 结果：ret="123"
 ****************************************************/
function getIdElement(doc) {
    return getElementValue(doc, "id");
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
    //	alert(pStart);
    //	alert(pEnd);
    if (pStart >= 0 && pEnd > pStart) {
        ret = doc.substring(pStart + startTag.length, pEnd);

    }
    return ret;
}

//增加项目标识到context中
function addProjectIdToContext(context) {
    if (context != null && context != "") {
        var s = window.location + "";
        var pattern = /\/([0-9]{1,10})\//;
        var retStr = pattern.exec(s);
        //        alert(retStr[1]);
        if (retStr != null) {
            return context + "/" + retStr[1];
        }
    }
    return context;
}

// 获取http request
function getHttpRequest() {
    var xmlhttp = false;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch (e) {
            try {
                xmlhttp = new XMLHttpRequest();
            }
            catch (e) {
                xmlhttp = false;
            }
        }
    }
    if (!xmlhttp) {
        document.write('浏览器不支持XMLHTTP技术，请更换您的浏览器!');
        return null;
    } else {
        return xmlhttp;
    }
}

// 通过调用xmlhttp方式异步执行jsp动态页面，callback方法通过事件响应对返回结果进行处理.
function doRequest(url, method, callback, param) {
    var xmlhttp = getHttpRequest();
    if (!url)return;
    url += (url.indexOf("?") != -1) ? "&rand=" + Math.random() : "?rand=" + Math.random();
    if (!method)method = "POST";
    if (method == "GET") {
        xmlhttp.open(method, url, true);
    }
    else {
        xmlhttp.open(method, url, true);
        xmlhttp.setRequestHeader("Method", "POST " + url + " HTTP/1.1");
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    }
    if (callback) {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                var ret = xmlhttp.ResponseText;
                callback(ret);
            }
        }
    }
    xmlhttp.send(param);
}


/***********
 *同步方式，动态加载文件，返回数据
 **************/
function getUrlContent(url, method) {
    var xmlhttp = getHttpRequest();
    var retStr = "";
    if (!url) return "";
    url += (url.indexOf("?") != -1) ? "&rand=" + Math.random() : "?rand=" + Math.random();
    if (!method) method = "POST";
    if (method == "GET") {
        xmlhttp.open(method, url, false);
    }
    else {
        xmlhttp.open(method, url, false);
        xmlhttp.setRequestHeader("Method", "POST " + url + " HTTP/1.1");
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    }
    xmlhttp.send(null);
    retStr = xmlhttp.ResponseText;
    return retStr;
}


/*******************************************************************
 描述：获取一个Select 的所有value的字符串
 ********************************************************************/
function getSelectValues(select) {
    var result = "";
    for (var i = 0; i < select.options.length; i++) {
        if (i == 0) {
            result = select.options[i].value;
        }
        else {
            result = result + "," + select.options[i].value;
        }
    }
    return result;
}

/******************************************************************
 描述：获取一个Select 的所有name的字符串
 *******************************************************************/
function getSelectNames(select) {
    var result = "";
    for (var i = 0; i < select.options.length; i++) {
        if (i == 0) {
            result = select.options[i].text;
        }
        else {
            result = result + "," + select.options[i].text;
        }
    }
    return result;
}

//初始化选中某项
function initSelectOption(select, code) {
    for (var i = 0; i < select.options.length; i++) {
        if (select.options[i].code = code) {
            select.options[i].selected = true;
            break;
        }
    }
}

/******************************************************************
 描述：获取当前选中的名称
 *******************************************************************/
function getSelectedName(select) {
    var ret = "";
    var options = select.options;
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            if (options[i].value != "") {
                ret = options[i].text;
                break;
            }
        }
    }
    return ret;
}

/******************************************************************
 描述：给指定Select 添加一条option
 *******************************************************************/
function addSelectOption(code, name, select) {
    var options = select.options;
    var index = getSelectOptionIndex(code, select);
    if (index < options.length) {
        options[index].text = name;
    }
    else {
        //名称和值重复则不再加入
        var f = false;
        for (var i = 0; i < options.length; i++) {
            if (options[i].text == name && options[i].value == code) {
                f = true;
                break;
            }
        }
        if (!f) {
            var option = new Option();
            option.value = code;
            option.text = name;
            options[index] = option;
        }
    }
}

/******************************************************************
 描述：将select中选中的option上移
 *******************************************************************/
function upSelectOption(select, inputid, inputname) {
    var index = select.selectedIndex;
    if (index == -1)
        return;
    exchangeSelectOption(select, index, index - 1);
    if (inputid != null) {
        inputid.value = getSelectValues(select);
    }
    if (inputname != null) {
        inputname.value = getSelectNames(select);
    }
}

/******************************************************************
 描述：将select中选中的option下移
 *******************************************************************/
function downSelectOption(select, inputid, inputname) {
    var index = select.selectedIndex;
    if (index == -1)
        return;
    exchangeSelectOption(select, index, index + 1);
    if (inputid != null) {
        inputid.value = getSelectValues(select);
    }
    if (inputname != null) {
        inputname.value = getSelectNames(select);
    }
}

/******************************************************************
 描述：给指定Select中的两个option交换先后位置
 *******************************************************************/
function exchangeSelectOption(select, index1, index2) {
    var options = select.options;
    if (index1 >= options.length || index1 < 0 || index2 >= options.length || index2 < 0)
        return;
    if (index1 == index2)
        return;

    var index1Option = new Option();
    index1Option.value = select.options[index1].value;
    index1Option.text = select.options[index1].text;
    var index2Option = new Option();
    index2Option.value = select.options[index2].value;
    index2Option.text = select.options[index2].text;
    select.options[index1] = index2Option;
    select.options[index2] = index1Option;
    select.options[index2].selected = true;
}

/*********************function description*******************************************
 Fun Desc:   根据code获取在Select列表框中的序号，如果code不存在，则为select的length。
 **************************************************************************************/
function getSelectOptionIndex(code, select) {
    var options = select.options;
    var result = options.length;
    for (var i = 0; i < options.length; i++) {
        if (options[i].value == code && code != "") {
            result = i;
            break;
        }
    }
    return result;
}

/*********************function description*******************************************
 Fun Desc:删除所有选定的Option
 **************************************************************************************/
function removeSelectedOption(select, inputValues, inputNames) {
    var options = select.options;
    if (options.length > 0)
        for (var i = options.length - 1; i >= 0; i--) {
            if (options[i].selected) {
                select.remove(i);
            }
        }

    if (inputValues != null) {
        inputValues.value = getSelectValues(select);
    }
    if (inputNames != null) {
        inputNames.value = getSelectNames(select);
    }
}
/*********************function description*******************************************
 Fun Desc:清空指定选择框的所有Option
 **************************************************************************************/
function removeOption(select, inputValues, inputNames) {
    var options = select.options;
    if (options.length > 0)
        for (var i = options.length - 1; i >= 0; i--) {
            select.remove(i);
        }

    if (inputValues != null) {
        inputValues.value = "";
    }
    if (inputNames != null) {
        inputNames.value = "";
    }
}
/*********************function description*******************************************
 Fun Desc:   判断Select列表框是否有记录选中
 **************************************************************************************/
function isOptionSelected(select) {
    var options = select.options;
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            return true;
        }
    }
    return false;
}

/*********************function description*******************************************
 *根据radio名称及缺省值设置选中状态
 **************************************************************************************/
function initRadio(objName, defaultValue) {
    var radioObj = eval("document.all." + objName);
    for (var i = 0; i < getArrayLength(radioObj); i++) {
        var check_obj = getArrayElement(radioObj, i);
        check_obj.checked = check_obj.value == defaultValue;
    }
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

/***************设置图片大小********************/
var defaultWidth = 700; //默认显示图片宽度为500象素
function DrawImage(ImgD, picwidth) {
    if (picwidth == null) picwidth = defaultWidth;
    var image = new Image();
    image.src = ImgD.src;
    if (image.width > 0 && image.height > 0) {

        if (picwidth == 0) picwidth = image.width;
        if (image.width / image.height >= 1) {
            if (image.width > picwidth) {
                ImgD.width = picwidth;
                ImgD.height = (image.height * picwidth) / image.width;
            } else {
                ImgD.width = image.width;
                ImgD.height = image.height;
            }
        } else {
            if (image.height > picwidth) {
                ImgD.height = picwidth;
                ImgD.width = (image.width * picwidth) / image.height;
            } else {
                ImgD.width = image.width;
                ImgD.height = image.height;
            }
        }
    }
}

//取得对象数组的长度
function getArrayLength(eobj) {
    var len = 0;
    if (eobj) {
        len = 1;
        if (eobj.length) len = eobj.length;
    }
    return len;
}

//取得对象数组的元素
function getArrayElement(eobj, ei) {
    if (eobj && eobj.length) {
        var len = 1;
        len = eobj.length;
        if (ei >= len) ei = len - 1;
        return eobj[ei];
    } else {
        return eobj;
    }
}

/*********************function description***begin****************************************
 *js控制动态增加删除行，无须指定tableId和firstRow，仅需要设置一个隐藏的标准行id=standarditem
 *********************function description***begin****************************************/
/***增加行***
 *srcitem可选，为可指定ID的标准行，若无该参数则取id=standarditem的所在行
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
    var curRow = getRowTr();


    if (currentRow) {
        curRow = currentRow;
    }
    var row = curRow.parentElement.insertRow(curRow.rowIndex + 1);
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
function delRow() {
    if (confirm("确定要删除吗!")) {
        var trObj = getRowTr();
        trObj.parentElement.deleteRow(trObj.rowIndex);
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
/*********************function description***end****************************************/


/*********************function description*******************************************
 Fun Name: trimquotes()
 Fun Desc:  去除字符串两边的引号
 creator: LFC
 date:
 **************************************************************************************/
function trimquotes(action) {
    if (null == action || "" == action) return "";
    var newAction = action.substring(1, action.length);
    newAction = newAction.substring(0, newAction.length - 1);
    return newAction;
}

function trimLeft(s) {
    while (s.substring(0, 1) == ' ') {
        s = s.substring(1, s.length);
    }
    return s;
}

function trimRight(s) {
    while (s.substring(s.length - 1, s.length) == ' ') {
        s = s.substring(0, s.length - 1);
    }
    return s;
}


function trim(s) {
    s = trimLeft(s);
    s = trimRight(s);
    return s;
}

var focusId = 0;
var dataArray = new Array();
function getFocusId(obj) {
    for (var i = 0; i < dataArray.length; i++) {
        if (dataArray[i] == obj) {
            focusId = i;
            break;
        }
    }
}

function stringToDate(sDate) {
    if (sDate.length == 0)
        return null;
    else {
        var year = (sDate.substring(0, 4)) * 1;
        var month = (sDate.substring(5, 7)) * 1 - 1;
        var day = (sDate.substring(8, 10)) * 1;
        return new Date(year, month, day);
    }

}

function calcDays(startDate, endDate) {
    if ((startDate == "") || (endDate == "")) {
        return "";
    }

    var iScrap = (Date.parse(stringToDate(endDate)) - Date.parse(stringToDate(startDate))) / 86400000 + 1
    iScrap = iScrap + .1
    return parseInt(iScrap);
}

/**********************************************************
 *函数名称：messageDlg(title, msg, buttons)
 **********************************************************/
function messageDlg(title, msg, buttons) {
    var url = CONTEXT_NAME + "/common/dialog/Dialog.jsp?title=" + title + "&msg=" + msg + "&buttons=" + buttons;
    var strFeatures = "dialogWidth=400px;dialogHeight=140px;center=yes;help=no;status=no";
    //alert(url);
    return showModalDialog(url, "", strFeatures);
}

/*********************function description*******************************************
 Fun Desc:   设置表单输入框变灰，不可写状态
 **************************************************************************************/
function setFormDisabled(form) {
    var e = form.elements;
    for (var i = 0; i < e.length; i++) {
        e(i).disabled = true;
    }
}
//置表单输入框恢复可写状态
function setFormEnable(form) {
    var e = form.elements;
    for (var i = 0; i < e.length; i++) {
        e(i).disabled = false;
    }
}

function setElementHidden(form, liketag) {
    var elements = form.elements;
    for (var i = 0; i < elements.length; i++) {
        var e = elements[i];
        if (e.name.indexOf(liketag) >= 0) {
            e.style.display = "none";
        }
    }

}

/*********************function description*******************************************
 Fun Desc:   日期比较
 **************************************************************************************/
function dayCompare(startDate, endDate) {
    if ((startDate == "") || (endDate == "")) {
        return false;
    }
    //年份比较
    var startS = startDate.indexOf('-');
    var yearS = startDate.substring(0, startS);
    var startE = endDate.indexOf('-');
    var yearE = endDate.substring(0, startE);
    if ((yearS - yearE) > 0)
        return false;

    //月份比较
    startS++;
    var startS2 = startDate.indexOf('-', startS);
    var monthS = startDate.substring(startS, startS2);

    startE++;
    var startE2 = endDate.indexOf('-', startE);
    var monthE = endDate.substring(startE, startE2);
    if ((yearS - yearE) == 0) {
        if ((monthS - monthE) > 0)
            return false;
    }

    //日期比较
    var dayS = startDate.substring(startS2 + 1);
    var dayE = endDate.substring(startE2 + 1);
    if ((yearS - yearE) == 0 && (monthS - monthE) == 0 && (dayS - dayE) > 0)
        return false;
    return true;
}

//时间比较
function datetimeCompare(startTime, endTime) {
    if (startTime == "" || endTime == "") return false;

    return Date.parse(endTime.replace(/-/g, "/")) > Date.parse(startTime.replace(/-/g, "/"));
}

//判断输入框的内容是否合法<!--- test_element_valid用于判断输入框的内容是否合法,请不要删除! -->
document.writeln("<div id='test_element_valid' style='display:none'></div>");
function check_valid(form) {
    var counttemp, strtemp;
    var strarray = new Array();
    var elements = form.elements;
    for (var i = 0; i < elements.length; i++) {
        counttemp = 0;
        strtemp = "";
        var element = elements[i];
        if (element.type == 'text' || element.type == 'textarea') {
            try {
                var v = element.value;
                if (v.indexOf("\"") >= 0) {
                    counttemp = 0;
                    strtemp = "";
                    //alert("请不要输入双引号\"");
                    //return false;
                    if (confirm("您输入的数据中存在[半角]双引号，您是否希望系统自动将[半角]双引号转换成中文[全角]的双引号?")) {
                        strarray = v.split("\"");
                        for (var j = 0; j < strarray.length - 1; j++) {
                            if (counttemp == 0) {
                                strtemp = strtemp + strarray[j] + "“";
                                counttemp = 1;
                            } else {
                                strtemp = strtemp + strarray[j] + "”";
                                counttemp = 0;
                            }
                        }
                        strtemp = strtemp + strarray[j];
                    } else {
                        element.focus();
                        return false;

                    }
                    v = strtemp;
                }
                if (v.indexOf("'") >= 0) {
                    counttemp = 0;
                    strtemp = "";
                    if (confirm("您输入的数据中存在[半角]单引号，您是否希望系统自动将[半角]单引号转换成中文[全角]的单引号?")) {
                        strarray = v.split("'");
                        for (var j = 0; j < strarray.length - 1; j++) {
                            if (counttemp == 0) {
                                strtemp = strtemp + strarray[j] + "‘";
                                counttemp = 1;
                            } else {
                                strtemp = strtemp + strarray[j] + "’";
                                counttemp = 0;
                            }
                        }
                        strtemp = strtemp + strarray[j];
                    } else {
                        element.focus();
                        return false;

                    }
                    v = strtemp;
                }
                if (v != "" && (v.indexOf("<") >= 0 || v.indexOf(">") >= 0)) {
                    v = v.replace(/</g, "〈");
                    v = v.replace(/>/g, "〉");
                    if (window.test_element_valid) {
                        window.test_element_valid.innerHTML = v;
                        if (window.test_element_valid.innerText != v) {
                            v = window.test_element_valid.innerText;
                            //								return false;
                        }
                    }
                }
                element.value = v;
            }
            catch (e) {

            }
        }
    }
    return true;
}
//将流程表单中无css样式的全部定义成12号字体，避免出现字体太大或者太小的情况
function initFlowCss() {
    if (!document.all) return;
    if (!document.getElementsByTagName("td"))return;
    var count = document.getElementsByTagName("td").length;
    for (var i = 0; i < count; i++) {
        var tdElement = document.getElementsByTagName("td")[i];
        if (tdElement.className == "") {
            tdElement.className = "flow_fontsize";
        }
    }
}
/**
 * 动态加入事件监听
 * @param obj 所在object
 * @param eventType 事件类型
 * @param fnHandler  时间动作
 */
function addJsEvent(obj, eventType, fnHandler) {
    if (obj)
        obj.setAttribute(eventType, document.all ? function () {
            eval(fnHandler);
        } : fnHandler);
}

function HtmlCodeOperate() {
    this.i = 0;
}

HtmlCodeOperate.prototype.getTrCount = function () {
    return this.i;
}

HtmlCodeOperate.prototype.setTrCount = function (count) {
    this.i = count;
}

HtmlCodeOperate.prototype.addRow = function (srcitem, currentRow) {
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
    var curRow = getRowTr();

    if (currentRow) {
        curRow = currentRow;
    }
    var row = curRow.parentElement.insertRow(curRow.rowIndex + 1);

    var cellcount = srcObj.cells.length;
    for (var i = 0; i < cellcount; i++) {
        var cell = row.insertCell(i);
        cell.align = srcObj.cells[i].align;
        cell.innerHTML = srcObj.cells[i].innerHTML.replace(/\{0}/g, this.i);
        cell.style.display = srcObj.cells[i].style.display;

        //增加行的默认样式
        cell.className = "td_light";
    }
    this.i++;

}

HtmlCodeOperate.prototype.addBottomRow = function (srcitem, currentRow) {
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
    var curRow = getRowTr();

    if (currentRow) {
        curRow = currentRow;
    }
    var bottom = curRow.parentElement.rows.length - 1;
//    alert("bottom="+bottom+"|this.i="+this.i)
    var row = curRow.parentElement.insertRow(bottom);

    var cellcount = srcObj.cells.length;
    for (var i = 0; i < cellcount; i++) {
        var cell = row.insertCell(i);
        cell.align = srcObj.cells[i].align;
        cell.innerHTML = srcObj.cells[i].innerHTML.replace(/\{0}/g, this.i);
        cell.style.display = srcObj.cells[i].style.display;

        //增加行的默认样式
        cell.className = "td_light";
    }
    this.i++;

}

HtmlCodeOperate.prototype.delRow = function () {
    if (confirm("确定要删除吗!")) {
        var trObj = getRowTr();
        trObj.parentElement.deleteRow(trObj.rowIndex);
    }
};

/**
 * 弹出窗口--居中
 * @param url
 * @param width
 * @param height
 * @param windowName  弹出窗口名称
 */
function openWindow(url, width, height, windowName) {
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
function closeWindow() {
    window.opener = null;
    //window.opener=top;
    window.open("", "_self");
    window.close();
}

/**
 * 数据转为千分位
 * @param num
 */
function num2Currency(num) {
    if (!typeof num == "String") {
        num = num.toString();
    } else if (num == "") {
        num = 0.0.toString();
    } else {
        num = parseFloat(num).toString();
    }
    var reg = /(\d{1,3})(?=(\d{3})+(?:$|\.))/g;
    return "￥" + num.replace(reg, "$1,");
}
/**
 * 四舍五入
 * @param num
 * @param position 小数点位数，保留2位小数应该写成"-2"
 */
function roundsUp(num, position) {
    if (typeof num == "String") {
        num = parseFloat(num);
    }
    var conductData = 1 / (Math.pow(10, position));
    return Math.round((num * conductData)) / conductData;
}

/**
 * 根据参数保留小数或者取整,保留小数四舍五入,取整不四舍五入
 * @param num
 * @param position 小数点位数
 */
function floatNum(num, position) {
    if (typeof num != "number") {
        num = parseFloat(num);
    }
    if (typeof position == "string") {
        position = parseInt(position);
    }

    return  num.toFixed(position);
}

/**
 * 查看关联的业务流程
 * @param processInstanceId
 */
function viewBizFlow(processInstanceId) {
    var url = CONTEXT_NAME + "/workflow/bpmProcessInstance/view.html?id=" + processInstanceId + "&from=opener";
    openWindow(url, 800, 600, "flow");
}
/**
 * 记录点击过的tab
 * @param code
 * @param index
 */
function recordTab(code, index) {
    $.ajax({
        url:CONTEXT_NAME + "/common/recordTab.html",
        cache:false,
        data:"code=" + code + "&index=" + index,
        success:function (ret) {
        }
    });
}
/**
 * 获得上次点击过的tab
 * @param code
 */
function getLastTab(code, eventFunc) {
    $.ajax({
        url:CONTEXT_NAME + "/common/getLastTab.html",
        cache:false,
        data:"code=" + code,
        success:function (ret) {
            var index = getElementValue(ret, "index");
            if (null != eventFunc)
                eval(eventFunc + "(" + index + ")");
        }
    });
}
/**
 *   获得图表
 * @param swf  URL of SWF file of the chart type that we intend to use
 * @param id   Id for the chart - You can give any id for the chart. Just make sure that if you're using multiple charts in the same HTML page, each chart should have a unique Id
 * @param w    Required width
 * @param h    Required height
 */
function getChart(dataUrl, chartdiv, swf, id, w, h) {
    var myChart = new FusionCharts(swf, id, w, h, "0", "0");
    myChart.setDataURL(dataUrl);
    myChart.render(chartdiv);
}
/**
 * table列向合并
 * @param tableId
 * @param colIndex
 */
function MergeTable(tableId, colIndex, startIndex) {
    var table = document.getElementById(tableId);
    var tmpRow;
    var rowCount = table.firstChild.childNodes.length; //获取表中行的总数
    var rows = table.firstChild.childNodes;//获取表中的行集合

    var startRow = rows[startIndex];
    var compareCell = null;
    //获取开始行
    while (!compareCell) {
        var startColsSpans = 0;
        for (var startRowColIndex = 0; startRowColIndex < colIndex; startRowColIndex++) {
            startColsSpans += startRow.childNodes[startRowColIndex].colSpan;
        }

        //排除单元格列超过指定合并的列 ,  当前行不含指定列，行序号+1
        if (startColsSpans > colIndex) {
            startIndex++;
            startRow = rows[startIndex];
        } else {
            break;
        }
    }
    compareCell = startRow.childNodes[colIndex];   //指定源单元格
    var rowIndex = startIndex;

    var rowMerge = 2;
    for (var i = rowIndex + 1; i < rowCount; i++) {
        tmpRow = rows[i]; //指定当前行
        var cols = tmpRow.childNodes; //获取当前行的列的集合
        var comparedCell = cols[colIndex]; //指定目标单元格
        var colsSpans = 0;
        for (var j = 0; j < colIndex; j++) {
            colsSpans += cols[j].colSpan;
        }
        //排除单元格列超过指定合并的列
        if (colsSpans > colIndex) {
            continue;
        }
        if (compareCell.innerText == comparedCell.innerText) {
            compareCell.rowspan = rowMerge++;
            tmpRow.removeChild(comparedCell);
        }
        else {
            compareCell = comparedCell;
            rowMerge = 2;
        }
    }
    document.getElementById(tableId).outerHTML = table.outerHTML;
}

function transfer2Num() {
    var elements = document.getElementsByTagName("input");
    var reg = /\d+\.\d+[Ee]\d+/g;
    for (var i = 0; i < elements.length; i++) {
        var text = elements[i].value;
        if (text.search(reg) >= 0) {
            elements[i].value = parseFloat(text);
        }
    }
}

//取得当前控件所在坐标
function getPosition(e) {
    var left = 0;
    var top = 0;

    while (e.offsetParent) {
        // alert(e.offsetParent);
        left += e.offsetLeft;
        top += e.offsetTop;
        e = e.offsetParent;
    }
    left += e.offsetLeft;
    top += e.offsetTop;
    return {x:left, y:top};
}

//刷新左边树--两层父窗口关系
function refreshLeftTree() {
    try {
        if (parent.parent.tree_frame) {
            if (parent.parent.tree_frame.lastSelectedNode) {
                parent.parent.tree_frame.updateParent(parent.parent.tree_frame.lastSelectedNode);
            }
        }
    } catch (e) {

    }
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

/********************************* 插入动态页面提示图标 begin *************************************/
if (document.attachEvent) {
    document.onreadystatechange = function () {  //支持IE
        if (document.readyState == "complete") {
            checkHelpImg();
        }
    };
} else { //兼容firefox
    document.addEventListener("DOMContentLoaded", checkHelpImg, false);
}

//判断是否需要显示帮助图标
function checkHelpImg() {
    var pageUrl = window.location + "";

    //只允许在列表、添加、查看页面加载帮助图标
    var pageCheck = false;
    var pageList = "grid,input,modify";
    var pages = pageList.split(",");
    for (var i = 0; i < pages.length; i++) {
        if (pageUrl.indexOf(pages[i] + ".html") > 0) {
            pageCheck = true;
            break;
        }
    }
    if (!pageCheck) {
        return;
    }


    var checkUrl = CONTEXT_NAME + "/system/sysHelp/getPageHint.html";
    var param = "pageUrl=" + encodeURI(pageUrl);
    if (document.getElementById("list") != null) {
        if (params != null) {
            Ext.Ajax.request({
                url:checkUrl,
                params:{ pageUrl:encodeURI(pageUrl)},
                success:function (html) {
                    showHelpImg(html.responseText);
                },
                failure:function (html) {
                    //alert("操作失败");
                }
            });
        }
    } else {
        $.ajax({
            url:checkUrl,
            cache:false,
            data:param,
            success:function (ret) {
                showHelpImg(ret);
            }
        });
    }
}
//显示帮助图标
function showHelpImg(ret) {
    var isShow = getElementValue(ret, "show");
    if (isShow == "1") {
        var link = getElementValue(ret, "url");
        var s = "<div id='pageHelpImg' style='position:absolute; right:5px; top:0px; width:32px; height:32px; z-index:1; visibility:hidden'>";
        s += "<input type='button' class='help_img' value=' ' onclick='openWindow(\"" + link + "\")' title='查看帮助'/>";
        s += "</div>";

        //$("body").append(s);   //need jquery support
        this.div = document.createElement("div");
        this.div.innerHTML = s;
        document.body.appendChild(div);
        document.getElementById("pageHelpImg").style.visibility = "visible";
    }
}
/*********************************  插入动态页面提示图标 end  *************************************/

//js精度丢失问题解决
//加法
Number.prototype.add = function(arg){
    var r1,r2,m;
    try{r1=this.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2))
    return (this*m+arg*m)/m
}

//减法
Number.prototype.sub = function (arg){
    return this.add(-arg);
}

//乘法
Number.prototype.mul = function (arg)
{
    var m=0,s1=this.toString(),s2=arg.toString();
    try{m+=s1.split(".")[1].length}catch(e){}
    try{m+=s2.split(".")[1].length}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}

//除法
Number.prototype.div = function (arg){
    var t1=0,t2=0,r1,r2;
    try{t1=this.toString().split(".")[1].length}catch(e){}
    try{t2=arg.toString().split(".")[1].length}catch(e){}
    with(Math){
        r1=Number(this.toString().replace(".",""))
        r2=Number(arg.toString().replace(".",""))
        return (r1/r2)*pow(10,t2-t1);
    }
}
/**
 * 异步获取ajax数据
 * @param objName
 * @param url
 */
var errAjaxMsg = "<div class=\"errMsg\">数据出错或服务器正忙，请稍候重新尝试！</div>";
function loadAjaxData(objName, url) {
    $.ajax({
        url:url,
        cache:false,
        data:"",
        success:function (ret) {
            if (objName != null) {
                $("#" + objName + "").html(ret);
            }
        }, error:function () {
            if (objName != null) {
                $("#" + objName + "").html(errAjaxMsg);
            }
        }
    });
}