/**
 * 选择日历 -- 新插件(同松江系统)，可以兼容之前的程序代码
 * @param objName 元素ID，比如'startDate'
 * @param dateType -- 日期类型，默认不传为YYYY-MM-DD，可选datetime或all
 * @param pattern  -- 日期格式化，保留，兼容之前的代码
 */
var id_ext = 0;
function calendar(objName, dateType, pattern) {
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
        //如果传过来的为object则取name，兼容之前的代码，如calendar(document.getElementById('actStartDate'));
        if(objName instanceof Object || typeof(objName)=='object'){
            if(!objName.name|| null==objName.name){
                alert("无法选择日期，未设置元素标识");
                return;
            }
            if(!objName.id|| null==objName.id){
                id_ext ++;   //针对增减行的需求，name都相同，设置一个唯一的id
                objName.setAttribute("id","id_"+id_ext);
                objName = "id_"+id_ext;

            }else{
                objName = objName.name;
            }
        }
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

//+---------------------------------------------------
//| 日期计算
//+---------------------------------------------------
Date.prototype.dateAdd = function(strInterval, Number) {
    var dtTmp = this;
    switch (strInterval) {
        case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
    }
}

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern = function(fmt) {
    var o = {
        "M+" : this.getMonth() + 1, //月份
        "d+" : this.getDate(), //日
        "h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "H+" : this.getHours(), //小时
        "m+" : this.getMinutes(), //分
        "s+" : this.getSeconds(), //秒
        "q+" : Math.floor((this.getMonth() + 3) / 3), //季度
        "S" : this.getMilliseconds() //毫秒
    };
    var week = {
        "0" : "\u65e5",
        "1" : "\u4e00",
        "2" : "\u4e8c",
        "3" : "\u4e09",
        "4" : "\u56db",
        "5" : "\u4e94",
        "6" : "\u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}