function HtmlInputElement() {
    this.Elements = document.getElementsByTagName("input");
    this.selectElements = document.getElementsByTagName("select");
    //    var elements = getElementsCategory();
    //
    //    this.textElements = elements.text;
    //    this.radioElements = elements.radio;
    //    this.hiddenElements = elements.hidden;
    //    this.passwordElements = elements.password;
    //    this.checkboxElements = elements.checkbox;
    //    this.fileElements = elements.file;
}
/**
 * 将表单元素处理成json字符串
 */
HtmlInputElement.prototype.element2JSONString = function() {
    var elements = this.Elements;
    var map = new Object();

    for (var i = 0; i < elements.length; i++) {
        var dealedElements = new Object();
        var element = elements[i];
        //如果该元素在已经被处理，则跳过
        if (dealedElements[element.name]||!element.name) {
            continue;
        }
        //处理文本录入框
        if (element.type == "text" || element.type == "password" || element.type == "hidden") {
            var textElements = document.getElementsByName(element.name);
            //处理同名
            if (textElements.length > 1) {
                var textArray = [];
                for (var j = 0; j < textElements.length; j++) {
                    textArray.push(textElements[j].value);
                }
                map[element.name] = textArray;
            } else {
                map[element.name] = element.value;
            }
        }
        //单选框处理
        else if(element.type=="radio"){
            var radioElements =  document.getElementsByName(element.name);
            for(var j=0;j<radioElements.length;j++){
                if(radioElements[j].checked)
                {
                    map[element.name] = radioElements[j].value;
                }
            }
        }
        //处理checkbox，如果有同名，则以数组保存
        else if(element.type=="checkbox"){
                var checkboxElements =  document.getElementsByName(element.name);
                if(checkboxElements.length>1){
                    var checkboxArray = [];
                    for(var j=0;j<checkboxElements.length;j++){
                        if(checkboxElements[j].checked){
                            checkboxArray.push(checkboxElements[j].value);
                        }
                    }
                    map[element.name]= checkboxArray;
                }else{
                    if(element.checked){
                        map[element.name]= element.value;
                    }
                }
            }
        dealedElements[element.name] = true;
    }
    //处理选择框
    var selectElements =this.selectElements;
    for(var k=0;k<selectElements.length;k++){
        var element = selectElements[k];
        map[element.name]= element.value;
    }
    //生成json字符串
    return obj2str(map);
};

//将input元素按类型分类（text,hidden,checkbox....）
function getElementsCategory() {
    var Elements = document.getElementsByTagName("input");
    var elements = new Object();
    var j = 0;
    for (var i = 0; i < Elements.length; i++) {
        var inputElement = Elements[i];
        if (elements[inputElement.type] && elements[inputElement.type].length > 0) {
            j = elements[inputElement.type].length;
        } else {
            j = 0;
            elements[inputElement.type] = new Array();
        }
        elements[Elements[i].type].push(Elements[i]);
    }
    return elements;
}
//json对象转为字符串
function obj2str(o) {
    var r = [];
    if (typeof o == "string") return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
    if (typeof o == "object") {
        if (!o.sort) {
            for (var i in o)
                r.push("\"" + i + "\":" + obj2str(o[i]));
            if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
                r.push("toString:" + o.toString.toString());
            }
            r = "{" + r.join() + "}"
        } else {
            for (var i = 0; i < o.length; i++)
                r.push(obj2str(o[i]))
            r = "[" + r.join() + "]"
        }
        return r;
    }
    return o.toString();
}
