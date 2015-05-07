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
function encodeXML(xml) {
    if ((xml == null) || (xml.length == 0)) {
        return xml;
    }
    else {
        var result = "";
        var tempChar;
        for (loop = 0; loop < xml.length; loop++) {
            tempChar = xml.substring(loop, loop + 1);

            if (tempChar.indexOf("\"") == 0) {
                tempChar = "$^";
            }
            else if (tempChar.indexOf("<") == 0) {
                tempChar = "|`";
                //      tempChar="%`";
            }
            else if (tempChar.indexOf(">") == 0) {
                //tempChar="%%`";
                tempChar = "||`";
            }
            else if (tempChar.indexOf("=") == 0) {
                //tempChar="%%%`";
                tempChar = "|||`";
            }
            else if (tempChar.indexOf("&") == 0) {
                //tempChar="%%%`";
                tempChar = "||||`";
            }
            else if (tempChar.indexOf("#") == 0) {
                //tempChar="%%%`";
                tempChar = "|||||`";
            }
            result += tempChar;
        }
        return result;
    }

}


function decodeXML(xml) {
    if ((xml == null) || (xml.length == 0)) {
        return xml;
    }
    else {
        // alert( xml);
        var start = xml.indexOf("|||||`");

        while (start >= 0) {
            xml = xml.substring(0, start) + "#" + xml.substring(start + 6, xml.length);
            start = xml.indexOf("|||||`");
        }
        var start = xml.indexOf("||||`");
        while (start >= 0) {
            xml = xml.substring(0, start) + "&" + xml.substring(start + 5, xml.length);
            start = xml.indexOf("||||`");
        }
        var start = xml.indexOf("|||`");
        while (start >= 0) {
            xml = xml.substring(0, start) + "=" + xml.substring(start + 4, xml.length);
            start = xml.indexOf("||||`");
        }
        var start = xml.indexOf("||`");
        while (start >= 0) {
            xml = xml.substring(0, start) + ">" + xml.substring(start + 3, xml.length);
            start = xml.indexOf("||`");
        }
        var start = xml.indexOf("|`");
        while (start >= 0) {
            xml = xml.substring(0, start) + "<" + xml.substring(start + 2, xml.length);
            start = xml.indexOf("|`");
        }
        var start = xml.indexOf("$^");
        while (start >= 0) {
            xml = xml.substring(0, start) + "\"" + xml.substring(start + 2, xml.length);
            start = xml.indexOf("$^");
        }


        //          alert("xml"+xml);
        return xml;
    }

}

var tagNames = new Array("select", "input", "textarea");
function getTDValue(td) {
    //  var seperate =td.getAttribute("separate");
    // var user =td.getAttribute("user");
    //var seperate =td.getAttribute("separate");
    var retValue = "";
    for (var j = 0; j < tagNames.length; j++) {
        var tagName = tagNames[j];
        //deal with each possible tagname
        if (td.getElementsByTagName(tagName.toLowerCase()).length > 0) {
            //the tag is we need
            var e = td.getElementsByTagName(tagName)[0];
            //for checkbox
            if (e.getAttribute("type") == "checkbox") {
                //modifyed by tcg
                var temp = td.getElementsByTagName(tagName);
                for (var k = 0; k < temp.length; k++) {
                    if (temp[k].checked) {
                        retValue += temp[k].value + ",";
                    }
                }
                retValue = retValue.substring(0, retValue.length - 1);
            } else if (e.getAttribute("type") == "radio") {
                var temp = td.getElementsByTagName(tagName);
                for (var k = 0; k < temp.length; k++) {
                    if (temp[k].checked) {
                        retValue = temp[k].value;
                    }
                }
            } else if (e.getAttribute("type") == "textarea") {
                retValue = e.value;
            } else {
                retValue = e.value;
            }
        }
    }

    // alert ("seperate:"+seperate+ " retValue"+retValue);
    //    var seperate = td.getAttribute("separate");
    //    var user = td.getAttribute("user");
    //		 if (seperate=="1" && retValue!="")
    //		 {
    //			 retValue="<value user=\""+ user + "\">"+retValue+"</value>";
    //	     }

    return retValue;

}


function isCDATANode(td) {
    for (var j = 0; j < tagNames.length; j++) {
        var tagName = tagNames[j];
        //deal with each possible tagname
        if (td.getElementsByTagName(tagName.toLowerCase()).length > 0) {
            //the tag is we need
            var e = td.getElementsByTagName(tagName)[0];
            if (e.tagName.toLowerCase() == "textarea" || e.getAttribute("separate") == "1") {
                return true;
            }
            else {
                return false;
            }
        }
    }

}


function setTDValue(td, value) {
    var separate = td.getAttribute("separate");
    var user = document.getElementById("user").value;
    if (separate == "1" && value != null && value != "") {
        //        user = td.getAttribute("user");
        var xmldoc = string2XML(value);
        var nodelist = xmldoc.getElementsByTagName("value");
        var flag = 0;
        for (var i = 0; i < nodelist.length && flag == 0; i++) {
            if (nodelist(i).attributes[0].value == user) {
                value = nodelist(i).text;
                flag = 1;
            }
        }
    }

    for (var j = 0; j < tagNames.length; j++) {
        var tagName = tagNames[j];
        //deal with each possible tagname
        if (td.getElementsByTagName(tagName.toLowerCase()).length > 0) {
            //the tag is we need
            var e = td.getElementsByTagName(tagName)[0];
            //for checkbox
            if (e.getAttribute("type") == "checkbox") {
                if (e.value == value || value == "on") {
                    e.checked = true;
                }
                else {
                    e.checked = false;
                }

            }
            //for radio
            else if (e.getAttribute("type") == "radio") {
                var temp = td.getElementsByTagName(tagName);

                for (var k = 0; k < temp.length; k++) {
                    temp[k].checked = false;
                    if (temp[k].value == value)
                        temp[k].checked = true;
                    //if (temp[k].checked)
                    //    return temp[k].value;
                }
                //return "";
            }
            //for other input and textarea
            else
                e.value = value;
        }
    }
}

//因为表单中的有些元素只设了name没有设id属性，在IE9前getElementById也可以当作document.getElementsByName(name)[0]来用的
function suitGetElementById(name) {
    var ele = document.getElementById(name);
    if (!ele) {
        ele = document.getElementsByName(name)[0];
    }
    return ele;
}

function getRawData() {
//    return "";//todo for test
    //    var resultarea = document.getElementById("xmlresult");
    var count = document.getElementsByTagName("td").length;
    //xmldom文档对象建立
    var xmlDoc = getXmlDoc();
    //建立根节点
    var root = xmlDoc.createElement("xml-data");
    for (var i = 0; i < count; i++) {
        var tdElement = document.getElementsByTagName("td")[i];
        var keyvalue = tdElement.getAttribute("key");
        if (keyvalue != null) {
            var tdValue = getTDValue(tdElement);
            var required = tdElement.getAttribute("required");

            if (required == "1" && (tdValue == null || tdValue == "" )) {
                //                resultarea.value = "";
                //                alert("请确保必须输入项全部填写!");
                var msg = tdElement.getAttribute("msg");
                if (msg != null && msg != "") {
                    if (msg == "已阅") {
                        tdValue = msg;
                    }
                    else {
                        alert(msg);
                        document.getElementsByName(keyvalue)[0].focus();
                        return;
                    }
                }
                else {
                    alert("请确保必须输入项全部填写!");
                    document.getElementsByName(keyvalue)[0].focus();
                    return;
                }
            }

            //添加子节点
            var itemNode = xmlDoc.createElement("data-item");

            //添加属性
            itemNode.setAttribute("key", keyvalue);

            var seperate = tdElement.getAttribute("seperate");
            var isSign = tdElement.getAttribute("isSign");
            //            var sign = tdElement.getAttribute("sign");
            if ("1" == seperate || "1" == isSign) {
                var sepNode = xmlDoc.createElement("value");

                var userName = suitGetElementById("userName").value;
                sepNode.setAttribute("user", userName);

                //add time by chenjp 20080701
                var currenttime = suitGetElementById("currenttime").value;
                sepNode.setAttribute("time", currenttime);

                if (isCDATANode(tdElement) == true) {
                    var CDATASection = xmlDoc.createCDATASection(tdValue);
                    sepNode.appendChild(CDATASection);
                }
                else {
                    sepNode.appendChild(xmlDoc.createTextNode(tdValue));
                }
                itemNode.appendChild(sepNode);
            } else {
                if (isCDATANode(tdElement) == true) {
                    var CDATASection = xmlDoc.createCDATASection(tdValue);
                    itemNode.appendChild(CDATASection);
                }
                else {
                    itemNode.appendChild(xmlDoc.createTextNode(tdValue));
                }
            }
            //添加属性
            root.appendChild(itemNode);
        }
    }
    //    alert(doc.xml);
    return XML2String(root);
}

//convert xml object to string
function XML2String(xmlObject) {
    // for IE
    if (window.ActiveXObject) {
        return xmlObject.xml;
    }
    // for other browsers
    else {
        return (new XMLSerializer()).serializeToString(xmlObject);
    }
}

function string2XML(xmlString) {
    var xmlDoc;
    try //Internet Explorer
    {
        xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
        xmlDoc.async = "false";
        xmlDoc.loadXML(xmlString);
    }
    catch (e) {
        try //Firefox, Mozilla, Opera, etc.
        {
            var parser = new DOMParser();
            xmlDoc = parser.parseFromString(xmlString, "text/xml");
        }
        catch (e) {
            alert(e.message)
        }
    }
    return xmlDoc;
}

function getXmlDoc(dname) {
    var xmlDoc;
    try //Internet Explorer
    {
        xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    }
    catch (e) {
        try //Firefox, Mozilla, Opera, etc.
        {
            xmlDoc = document.implementation.createDocument("", "", null);
        }
        catch (e) {
            alert(e.message)
        }
    }
    try {
        xmlDoc.async = false;
        return xmlDoc;
    }
    catch (e) {
        alert(e.message)
    }
    return null;
}

function initFieldsValue() {
    //xmldom文档对象建立
    var resultarea = document.getElementById("rawdata");
    var doc = string2XML(resultarea.value);
    var nodelist = doc.getElementsByTagName("data-item");

    for (var i = 0; i < nodelist.length; i++) {
        var key = "";
        var value = "";
        for (var j = 0; j < nodelist(i).attributes.length; j++) {
            //alert(nodelist(i).text);
            if (nodelist(i).attributes[j].name == "key") {
                key = nodelist(i).attributes[j].value;
            }
        }

        value = nodelist(i).text;
        var tdElement = document.getElementById(key);
        if (tdElement != null)
            setTDValue(tdElement, value);
    }
}

// add by zyl on 2008.5.23, some APIs for javascript in htmltemplate
function getValueById(id) {
    var element = document.getElementById(id);
    if (element) {
        if (element.value != '')
            return element.value * 1;
        else
            return null;
    }
    else
        return null;
}

function setValueById(id, value) {
    var element = document.getElementById(id);
    if (element)
        element.value = value;
}

function checkValid(value) {
    if (value || value == 0)
        return true;
    return false;
}

function workflowValidateInit(formName, conditions, opts) {
    conditions = conditions || [];
    for (var i = 0; i < conditions.length; i++) {
        var cond = conditions[i];
        //下面两个效果相同
        $("#" + formName + " [name=" + cond.name + "]").attr("data-validation-engine", cond.rule);
    }
    $("#" + formName).validationEngine('attach', $.extend({
        promptPosition:"bottomRight",
        isOverflown:true,
        overflownDIV:"#scrollDiv",
        beforeShowErrorMsg:function (field, promptText, type, ajaxed, options) {
            var msg = field.attr('msg');
            if (msg) {
                return msg;
            }
        }
    }, opts));
}