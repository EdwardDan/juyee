var color_input_name = "inputcolor"; //input name
var color_div_name = "colorpane";    //div name

var ColorHex = new Array('00', '33', '66', '99', 'CC', 'FF');
var SpColorHex = new Array('FF0000', '00FF00', '0000FF', 'FFFF00', '00FFFF', 'FF00FF');
var current = null;
function initcolor(evt) {
    var colorTable = '';
    for (var i = 0; i < 2; i++) {
        for (var j = 0; j < 6; j++) {
            colorTable = colorTable + '<tr height=15>';
            colorTable = colorTable + '<td width=15 style="background-color:#000000">';
            if (i == 0) {
                colorTable = colorTable + '<td width=15 style="cursor:pointer;background-color:#' + ColorHex[j] + ColorHex[j] + ColorHex[j] + '" onclick="doclick(this)">';
            }else {
                colorTable = colorTable + '<td width=15 style="cursor:pointer;background-color:#' + SpColorHex[j] + '" onclick="doclick(this)">';
            }
            colorTable = colorTable + '<td width=15 style="background-color:#000000">';
            for (var k = 0; k < 3; k++) {
                for (var l = 0; l < 6; l++) {
                    colorTable = colorTable + '<td width=15 style="cursor:pointer;background-color:#' + ColorHex[k + i * 3] + ColorHex[l] + ColorHex[j] + '" onclick="doclick(this)">';
                }
            }
        }
    }
    colorTable = '<table border="1" cellspacing="0" cellpadding="0" style="text-align:center;cursor:pointer;border-collapse:collapse" bordercolor="#000000" bgcolor="#FFFFFF">'
        + '<tr><td colspan="21"><span style="float:right;margin-right:5px;cursor:pointer;" onclick="colorclose()">×关闭</span><span style="float:right;margin-right:5px;cursor:pointer;" onclick="defaultColor()">默认颜色</span></td></tr>'
        + colorTable + '</table>';
    document.getElementById(color_div_name).innerHTML = colorTable;
    var current_x = document.getElementById(color_input_name).offsetLeft;
    var current_y = document.getElementById(color_input_name).offsetTop;
    document.getElementById(color_div_name).style.left = current_x + "px";
    document.getElementById(color_div_name).style.top = current_y + "px";
}
function doclick(obj) {
    document.getElementById(color_input_name).value = getHexBackgroundColor(obj).toUpperCase();
    document.getElementById(color_div_name).style.display = "none";
}
function colorclose() {
    document.getElementById(color_div_name).style.display = "none";
}
function coloropen() {
    document.getElementById(color_div_name).style.display = "";
}
function getHexBackgroundColor(obj) {
    var rgb = obj.style.backgroundColor+"";
    if(rgb.indexOf("#")==-1){    //firefox下得到的rgb必须转换为hex
//        rgb = rgb.match(/^rgb((d+),s*(d+),s*(d+))$/);
//        return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
        var r = getElementValueByTag(rgb,"(",")");
        var ss = r.split(",");
        return "#" + hex(ss[0]) + hex(ss[1]) + hex(ss[2]);
    }else{
        return rgb;
    }
}
function hex(x) {return ("0" + parseInt(x).toString(16)).slice(-2);}

function getElementValueByTag(doc, startTag, endTag) {
    var pStart = doc.indexOf(startTag);
    var pEnd = doc.indexOf(endTag);
    var ret = "";
    if (pStart >= 0 && pEnd > pStart) {
        ret = doc.substring(pStart + startTag.length, pEnd);
    }
    return ret;
}

window.onload = initcolor;
