function showQueryDialog(options){
	var opts = options || {};
	var dlg = $('#dlg-query');
	if (!dlg.length){
		dlg = $('<div id="dlg-query"></div>').appendTo('body');
		dlg.dialog({
			title:opts.title||'高级查询',
			width:opts.width||400,
			height:opts.height||300,
			closed:true,
			modal:true,
			href:opts.form,
			buttons:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
					dlg.dialog('close');
					var param = {};
					dlg.find('.query').each(function(){
						var name = $(this).attr('name');
						var val = $(this).val();
						if ($(this).hasClass('datebox-f')){
							name = $(this).attr('comboname');
							val = $(this).datebox('getValue');
						} else if ($(this).hasClass('combogrid-f')){
							name = $(this).attr('comboname');
							val = $(this).combogrid('getValue');
						} else if ($(this).hasClass('combobox-f')){
							name = $(this).attr('comboname');
							val = $(this).combobox('getValue');
						}
						param[name] = val;
					});
					opts.callback(param);
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){dlg.dialog('close');}
			}]
		});
	}
	dlg.dialog('open');
}

/**
 * 取得系统时间
 */
function getDate(divId){
    //获取系统时间
    var date=new Date();
    var month=date.getMonth()+1; //month默认0-11，所以要加1
    var minutes=date.getMinutes(),Min;
    var seconds=date.getSeconds(),updateTime;
    updateTime=60-seconds;
    minutes<=9 ? Min="0"+minutes : Min=minutes;
    var week=date.getDay(),day;

    switch(week){
        case 0 : day="星期日";break;
        case 1 : day="星期一";break;
        case 2 : day="星期二";break;
        case 3 : day="星期三";break;
        case 4 : day="星期四";break;
        case 5 : day="星期五";break;
        case 6 : day="星期六";break;
    }

    var time=date.getFullYear()+"年"+month+"月"+date.getDate()+"日 "+date.getHours()+":"+Min+ ":" + seconds + " " + day;

    // alert(time);

    // debugger;

    $("#" + divId).text(time); //jquery
    //var container=document.getElementById("updateTime");
    //container.innerText=time; //javascript;
    setTimeout("getDate('" + divId + "')", 1000);  //定时请求时间
}

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
function InputNumber(decimal, nega) {
    var rng = document.selection.createRange().text;
    if (rng != "" && rng != ".") {
        this.event.returnValue = true;
        return;
    }
    var input_value = new String();
    input_value = this.event.srcElement.value;
    if ((this.event.keyCode < 45 )
        || (this.event.keyCode > 57 )
        || (this.event.keyCode == 47 )
        || (this.event.keyCode == 45 && (typeof(nega) == "undefined" || !nega))) {
        this.event.returnValue = false;
        return;
    }
    var maxlength;
    if (isNaN(parseInt(this.event.srcElement.maxLength)))
        maxlength = 8;
    else
        maxlength = parseInt(this.event.srcElement.maxLength);
    if (input_value.length == 0) {
        //第一个字符不能为小数点
        if (this.event.keyCode == 46) {
            this.event.returnValue = false;
            return;
        }
    }

    var first_pos = input_value.indexOf(".");
    var last_pos = input_value.lastIndexOf(".");
    //alert(first_pos);
    if (first_pos == -1) {
        if (null != maxlength) {
            if ((input_value.length + 1) > maxlength) {
                if (this.event.keyCode != 46) {
                    this.event.returnValue = false;
                    return;
                }
            }
        }
    }
    else {


        if (last_pos == first_pos) {
            //不能出现第二个小数点
            if (this.event.keyCode == 46) {
                this.event.returnValue = false;
                return;
            }

            if ((null != decimal && !isNaN(decimal))) {
                //alert( (input_value.length > maxlength) ||( (input_value.length-first_pos)>decimal))
                if ((input_value.length > maxlength) || ( (input_value.length - first_pos) > decimal)) {
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

    if ((null != decimal && !isNaN(decimal))) {
        if (decimal == 0 && this.event.keyCode == 46) {
            this.event.returnValue = false;
            return;
        }
    }
}

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
function InputInteger() {
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
function InputNumberNoChina(obj) {
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
function InputIntegerNoChina(obj) {
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d]/g, "");

    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");
}


