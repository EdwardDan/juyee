/**
 * 设置各输入的必输项及其它判断
 * 底层判断仍旧采用DOM及Validator
 * todo:对于Number及Integer 自动加入onKeyPress事件
 * 备注：无需再input里定义maxlength，统一在条件中判断
 * @param conditions
 */
function setObjCondition(conditions)
{
    if (conditions == "undefined" || !conditions) return;

    for (var i = 0; i < conditions.length; i++) {
        var condition = conditions[i];
        if (condition == null || condition == "") continue;
        //       alert(condition.length)
        var obj = eval("document.all." + condition[0]);
        if (obj == "undefined" || !obj) {
            obj = eval("document.getElementById('" + condition[0] + "')");
        }
        if (obj == "undefined" || !obj) {
            continue;
        }
        //1、set attribute dataType
        if (condition[1] != "") {
            //           obj.setAttribute("dataType",condition[1]);
            var requires = condition[1].split(",");
            var firstDataType = "";
            for (var j = 0; j < requires.length; j++) {
                if (requires[j] == null || requires[j] == "") continue;
                if (j == 0) {
                    obj.setAttribute("dataType", requires[j]);
                    firstDataType = requires[j];
                } else {
                    var requires_others = requires[j].split(":");
                    if (requires_others[0] != "" && requires_others[1] != "") {
                        obj.setAttribute(requires_others[0], requires_others[1]);
                    }
                }

            }
            showErrMsg(obj, "*");
        }

        //2、set attribute maxlength(input & textarea)
        if (condition[2] != ""){
            if("textarea"==obj.type){
               obj.setAttribute("maxlength", condition[2]);
            }else{
               obj.setAttribute("maxLength", condition[2]);
            }
        }

        //3、set attribute msg
        if (condition[3] != "") obj.setAttribute("msg", condition[3]);

        //4、add JsEvcent
        if (condition.length == 5) {
            if (condition[4] != "") {
                var events_arry = condition[4].split(";");
                for(var a=0;a<events_arry.length;a++) {
                    var events_string = events_arry[a];
                    if(events_string != ""){
                        var events = events_string.split(":");
                        if (events[0] != "") {
                            addJsEvent(obj, events[0], events[1]);
                        }
                    }
                }
            }
        }
    }
}

/**
 * 显示错误提示信息
 * @param obj
 * @param errMsg
 */
function showErrMsg(obj, errMsg)
{
    Validator.ClearState(obj);
    var span = document.createElement("SPAN");
    span.id = "__ErrorMessagePanel";
    span.style.color = "red";
    obj.parentNode.appendChild(span);
    span.innerHTML = errMsg.replace(/\d+:/, "*");
}

/**
 * *****表单提交验证必输项并且显示加载页面*****
 * 注意：此方法是表单提交判断的唯一方法
 * 方法1：提交按钮采用submit方式，则必须在form里增加 "onsubmit='return check_form(this)'"
 * 方法2：提交按钮采用button方式，则提交按钮里必须写入onClick方法，并且在onClick方法里最后调用"if(!check_form(document.dataForm,false)) return;document.dataForm.submit();"
 * @param form 表单对象
 * @param isNeedLoading 是否显示加载页面
 */
function check_form(form, isNeedLoading)
{
    if (!Validator.Validate(form))  return false;
    if (isNeedLoading == null) isNeedLoading = true;

    if (isNeedLoading)
    {
        //显示加载页面
        loading();
        //当document中innerHTML后，form object已经发生的改变，必须重新获取，否则submit失败
        eval("document." + form.name).submit();
    }
    else
    {
        form.submit();
    }
    return false;
}

/**
 * 验证必输项
 */
Validator = {
    Require : /.+/,
    Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
    Phone : /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/,
//    Mobile : /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/,
    Mobile : /^((\(\d{2,3}\))|(\d{3}\-))?1(3|4|5|8)\d{9}$/, //支持以13，15，18开头的手机号码
    Url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
    IdCard : "this.IsIdCard(value)",
    Currency : /^\d+(\.\d+)?$/,
    Number : /^\d+$/,
    Zip : /^[1-9]\d{5}$/,
    QQ : /^[1-9]\d{4,8}$/,
    Integer : /^[-\+]?\d+$/,
    Double : /^[-\+]?\d+(\.\d+)?$/,
    English : /^[A-Za-z]+$/,
    Chinese :  /^[\u0391-\uFFE5]+$/,
    Username : /^[a-z]\w{3,}$/i,
    UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
    IsSafe : function(str) {
        return !this.UnSafe.test(str);
    },
    SafeString : "this.IsSafe(value)",
    Filter : "this.DoFilter(value, getAttribute('accept'))",
    Limit : "this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
    LimitB : "this.limit(this.LenB(value), getAttribute('min'), getAttribute('max'))",
    Date : "this.IsDate(value, getAttribute('min'), getAttribute('format'))",
    Repeat : "value == document.getElementsByName(getAttribute('to'))[0].value",
    Range : "getAttribute('min') < (value|0) && (value|0) < getAttribute('max')",
    Compare : "this.compare(value,getAttribute('operator'),getAttribute('to'))",
    Custom : "this.Exec(value, getAttribute('regexp'))",
    Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",
    ErrorItem : [document.forms[0]],
    ErrorMessage : ["以下原因导致提交失败：\t\t\t\t"],
    Validate : function(theForm, mode) {


        var obj = theForm || event.srcElement;
        var count = obj.elements.length;
        this.ErrorMessage.length = 1;
        this.ErrorItem.length = 1;
        this.ErrorItem[0] = obj;
        for (var i = 0; i < count; i++) {
            with (obj.elements[i]) {

                //判断输入内容是否超过设定长度
                var element = obj.elements[i];
                if (element.type == 'textarea') {
                    if (element.maxlength) {
                        if (element.maxlength > 0) {
                            if (element.value != "") {
                                if (element.value.length > element.maxlength)
                                {
                                    alert("输入内容长度不能超过" + element.maxlength + "个字！");
                                    element.focus();
                                    return false;
                                }
                            }
                        }
                    }
                }

                var _dataType = getAttribute("dataType");
                if (typeof(_dataType) == "object" || typeof(this[_dataType]) == "undefined")  continue;


                this.ClearState(obj.elements[i]);
                if (getAttribute("require") == "false" && value == "") continue;
                switch (_dataType) {
                    case "IdCard" :
                    case "Date" :
                    case "Repeat" :
                    case "Range" :
                    case "Compare" :
                    case "Custom" :
                    case "Group" :
                    case "Limit" :
                    case "LimitB" :
                    case "SafeString" :
                    case "Filter" :
                        if (!eval(this[_dataType])) {
                            this.AddError(i, getAttribute("msg"));
                        }
                        break;
                    default :
                        if (!this[_dataType].test(value)) {
                            this.AddError(i, getAttribute("msg"));
                        }
                        break;
                }
            }
        }
        if (this.ErrorMessage.length > 1) {
            mode = mode || 3;
            var errCount = this.ErrorItem.length;
            switch (mode) {
                case 2 :
                    for (var i = 1; i < errCount; i++)
                        this.ErrorItem[i].style.color = "red";
                case 1 :
                    alert(this.ErrorMessage.join("\n"));
                    this.ErrorItem[1].focus();
                    break;
                case 3 :
                    for (var i = 1; i < errCount; i++) {
                        try {
                            var span = document.createElement("SPAN");
                            span.id = "__ErrorMessagePanel";
                            span.style.color = "red";
                            this.ErrorItem[i].style.borderColor = "#FF6666";
                            this.ErrorItem[i].parentNode.appendChild(span);
                            span.innerHTML = this.ErrorMessage[i].replace(/\d+:/, "*");
                        }
                        catch(e) {
                            alert(e.description);
                        }
                    }
                    this.ErrorItem[1].focus();
                    break;
                default :
                    alert(this.ErrorMessage.join("\n"));
                    break;
            }
            return false;
        }
        return true;
    },
    limit : function(len, min, max) {
        min = min || 0;
        max = max || Number.MAX_VALUE;
        return min <= len && len <= max;
    },
    LenB : function(str) {
        return str.replace(/[^\x00-\xff]/g, "**").length;
    },
    ClearState : function(elem) {
        with (elem) {
            if (style.color == "red")
                style.color = "";
            //            elem.style.borderColor = "#b9d9f6";
            var lastNode = parentNode.childNodes[parentNode.childNodes.length - 1];
            if (lastNode.id == "__ErrorMessagePanel")
                parentNode.removeChild(lastNode);
        }
    },
    AddError : function(index, str) {
        this.ErrorItem[this.ErrorItem.length] = this.ErrorItem[0].elements[index];
        this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
    },
    Exec : function(op, reg) {
        return new RegExp(reg, "g").test(op);
    },
    compare : function(op1, operator, op2) {
        switch (operator) {
            case "NotEqual":
                return (op1 != op2);
            case "GreaterThan":
                return (op1 > op2);
            case "GreaterThanEqual":
                return (op1 >= op2);
            case "LessThan":
                return (op1 < op2);
            case "LessThanEqual":
                return (op1 <= op2);
            default:
                return (op1 == op2);
        }
    },
    MustChecked : function(name, min, max) {
        var groups = document.getElementsByName(name);
        var hasChecked = 0;
        min = min || 1;
        max = max || groups.length;
        for (var i = groups.length - 1; i >= 0; i--)
            if (groups[i].checked) hasChecked++;
        return min <= hasChecked && hasChecked <= max;
    },
    DoFilter : function(input, filter) {
        return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
    },
    IsIdCard : function(number) {
        var date, Ai;
        var verify = "10x98765432";
        var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
        var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
        var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/i);
        if (re == null) return false;
        if (re[1] >= area.length || area[re[1]] == "") return false;
        if (re[2].length == 12) {
            Ai = number.substr(0, 17);
            date = [re[9], re[10], re[11]].join("-");
        }
        else {
            Ai = number.substr(0, 6) + "19" + number.substr(6);
            date = ["19" + re[4], re[5], re[6]].join("-");
        }
        if (!this.IsDate(date, "ymd")) return false;
        var sum = 0;
        for (var i = 0; i <= 16; i++) {
            sum += Ai.charAt(i) * Wi[i];
        }
        Ai += verify.charAt(sum % 11);
        return (number.length == 15 || number.length == 18 && number == Ai);
    },
    IsDate : function(op, formatString) {
        formatString = formatString || "ymd";
        var m, year, month, day;
        switch (formatString) {
            case "ymd" :
                m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
                if (m == null) return false;
                day = m[6];
                month = m[5] * 1;
                year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
                break;
            case "dmy" :
                m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
                if (m == null) return false;
                day = m[1];
                month = m[3] * 1;
                year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
                break;
            default :
                break;
        }
        if (!parseInt(month)) return false;
        month = month == 0 ? 12 : month;
        var date = new Date(year, month - 1, day);
        return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth() + 1) && day == date.getDate());
        function GetFullYear(y) {
            return ((y < 30 ? "20" : "19") + y) | 0;
        }
    }
}

function InputNumber(decimal, nega)
    /**************************************************************
     *函数名称：InputNumber()
     *入口参数：decimal,小数点位置后的位数
     *
     *函数功能：输入数字，可以输入小数点,小数点只能输入一次，但第一个输入的不能是小数点
     *存在bug:可以通过copy 和paste的方法向文本框中输入其他字符,在小数点后输入的位数小于
     *       len2时，小数点前可以输入任意长度的数字
     *使用方法：首先引用该脚本文件
     *在输入框加入下面脚本onKeypress ="InputNumber()" 即可生效
     *例子
     *<INPUT TYPE="text" NAME="test" onKeypress ="InputNumber()">
     *作者：赵永标
     *时间：2002-10-30
     ***************************************************************/
{
    var rng = document.selection.createRange().text
    if (rng != "" && rng != ".")
    {
        this.event.returnValue = true
        return;
    }
    var input_value = new String
    input_value = this.event.srcElement.value
    if ((this.event.keyCode < 45 )
            || (this.event.keyCode > 57 )
            || (this.event.keyCode == 47 )
            || (this.event.keyCode == 45 && (typeof(nega) == "undefined" || !nega)))
    {
        this.event.returnValue = false
        return;
    }
    var maxlength;
    if (isNaN(parseInt(this.event.srcElement.maxLength)))
        maxlength = 8;
    else
        maxlength = parseInt(this.event.srcElement.maxLength);
    if (input_value.length == 0)
    {
        //第一个字符不能为小数点
        if (this.event.keyCode == 46)
        {
            this.event.returnValue = false
            return;
        }
    }

    var first_pos = input_value.indexOf(".");
    var last_pos = input_value.lastIndexOf(".");
    //alert(first_pos);
    if (first_pos == -1)
    {
        if (null != maxlength)
        {
            if ((input_value.length + 1) > maxlength)
            {
                if (this.event.keyCode != 46)
                {
                    this.event.returnValue = false;
                    return;
                }
            }
        }
    }
    else
    {


        if (last_pos == first_pos)
        {
            //不能出现第二个小数点
            if (this.event.keyCode == 46)
            {
                this.event.returnValue = false;
                return;
            }

            if ((null != decimal && ! isNaN(decimal)))
            {
                //alert( (input_value.length > maxlength) ||( (input_value.length-first_pos)>decimal))
                if ((input_value.length > maxlength) || ( (input_value.length - first_pos) > decimal))
                {
                    this.event.returnValue = false;
                    return;
                }
            }
        }
    }

    //
    if (first_pos == -1 && (this.event.keyCode != 46 )) {
        if (input_value.length >= (maxlength - decimal)) {
            this.event.returnValue = false;
            return;
        }
    }

    if ((null != decimal && ! isNaN(decimal)))
    {
        if (decimal == 0 && this.event.keyCode == 46) {
            this.event.returnValue = false;
            return;
        }
    }
}

function InputInteger()
    /**************************************************************
     *函数名称：InputInteger()
     *入口参数：无
     *函数功能：输入整数，不能输入小数点（句号，点号）
     *存在bug:可以通过copy 和paste的方法向文本框中输入其他字符
     *使用方法：首先引用该脚本文件
     *在输入框加入下面脚本onKeypress ="InputInteger()" 即可生效
     *例子
     *<INPUT TYPE="text" NAME="test"  onKeypress ="InputInteger()">
     ***************************************************************/
    /**
     *ai 2003-01-07修改增加退格键-- && (this.event.keyCode <> 8)
     *ai 2003-01-08增加小键盘数字键--96-105
     */
{
    /*if (((this.event.keyCode < 48) && (this.event.keyCode != 8)) || (this.event.keyCode > 57))
     this.event.returnValue = false*/

    var code = this.event.keyCode;
    /*
     if ((8 == code) || ((48 <= code)&&(57 >= code)) || ((96 <= code)&&(105 >= code)))
     this.event.returnValue = true;
     */
    if (code > 47 && code < 58)
        this.event.returnValue = true;
    else
        this.event.returnValue = false;
}

//可输入整数和小数
//调用方法onkeyup="InputNumberNoChina(this)"
function InputNumberNoChina(obj)
{
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d.]/g, "");

    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");

    //保证只有出现一个.而没有多个.
    obj.value = obj.value.replace(/\.{2,}/g, ".");

    //保证.只出现一次，而不能出现两次以上
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}

//只能输入整数，不能输入小数
function InputIntegerNoChina(obj)
{
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d]/g, "");

    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");
}

function validateAll(value, reg, message) {
    if (value != "") {
        if (value.match(reg) == null) {
            alert("输入的"+message+"格式不对，请重新输入！");
            return false;
        }
    }
    return true;
}