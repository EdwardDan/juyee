/***********************************************************************
**********************************************************/

$(function(){
	// 导航菜单绑定初始化
//    $("#wnav").accordion({
//        animate: false
//    });
//    addNav(_menus["basic"]); //首次加载basic 左侧菜单--3级菜单--注意将index.jsp中tree id设置为wnav
//    InitLeftMenu();    //2级菜单--注意将index.jsp中tree id设置为nav

//	tabClose();
//	tabCloseEven();

//	$('#tabs').tabs('add',{
//		title:'title',
//		content:createFrame('http://hxling.cnblogs.com')
//	}).tabs({
//        onSelect: function (title) {
//            var currTab = $('#tabs').tabs('getTab', title);
//            var iframe = $(currTab.panel('options').content);
//
//			var src = iframe.attr('src');
//			if(src)
//				$('#tabs').tabs('update', { tab: currTab, options: { content: createFrame(src)} });
//
//        }
//    });

});

//function Clearnav() {
//    var pp = $('#wnav').accordion('panels');
//
//    $.each(pp, function(i, n) {
//        if (n) {
//            var t = n.panel('options').title;
//            $('#wnav').accordion('remove', t);
//        }
//    });
//
//    pp = $('#wnav').accordion('getSelected');
//    if (pp) {
//        var title = pp.panel('options').title;
//        $('#wnav').accordion('remove', title);
//    }
//}
//function GetMenuList(data, menulist) {
//    if (data.menus == null)
//        return menulist;
//    else {
//        menulist += '<ul>';
//        $.each(data.menus, function(i, sm) {
//            if (sm.url != null) {
////                menulist += '<li ><a ref="' + sm.menuid + '" href="#" rel="'
////					+ sm.url + '" ><span class="nav">' + sm.menuname
////					+ '</span></a>'
//                menulist += '<li><div><a ref="' + sm.menuid + '" href="#" rel="' + sm.url + '" pos="' + sm.menuname + " >> " + sm.menuname + '"><span class="icon ' + sm.icon + '" >&nbsp;</span><span class="nav">' + sm.menuname + '</span></a></div></li> ';
//            }
//            else {
//                menulist += '<li state="closed"><span class="nav">' + sm.menuname + '</span>'
//            }
//            menulist = GetMenuList(sm, menulist);
//        });
//        menulist += '</ul>';
//    }
//    return menulist;
//}
//
////左侧导航加载
//function addNav(data) {
////    alert(data);
//    $.each(data, function(i, sm) {
//        var menulist1 = "";
//        //sm 常用菜单  邮件 列表
//        menulist1 = GetMenuList(sm, menulist1);
//        menulist1 = "<ul id='tt1' class='easyui-tree' animate='true' dnd='true'>" + menulist1.substring(4);
//        $('#wnav').accordion('add', {
//            title: sm.menuname,
//            content: menulist1,
//            iconCls: 'icon ' + sm.icon
//        });
//
//    });
//
//    var pp = $('#wnav').accordion('panels');
//    var t = pp[0].panel('options').title;
//    $('#wnav').accordion('select', t);
//
//}

//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({animate:false});

    $.each(_menus.basic, function(i, n) {
		var menulist ='';
		menulist +='<ul>';
        $.each(n.menus, function(j, o) {
			menulist += '<li><div style="min-width:150px"><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" pos="'+n.menuname+" >> "+o.menuname+'" targ="'+o.target+'"><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div></li> ';
        });
		menulist += '</ul>';

		$('#nav').accordion('add', {
            title: n.menuname,
            content: menulist,
            iconCls: 'icon ' + n.icon
        });

    });

    $('.easyui-accordion li div').click(
        function () {
            var a = $("a", this).get(0);
            var tabTitle = $(a).children('.nav').text();

            var url = $(a).attr("rel");
            var menuid = $(a).attr("ref");
            var pos = $(a).attr("pos");
            var targ = $(a).attr("targ");
            var icon = getIcon(menuid, icon);

            if (url == "") {
                showInfoMsg("此功能正在开发中", null);
                return;
            }
            if(url.indexOf("http://")==0){

            }else{
                url = CONTEXT_NAME + "/" + url;
            }

//		addTab(tabTitle,url,icon);
            if("_blank"==targ){
                openFullWindow(url,screen.availWidth,screen.availHeight,"WSBJ");
            }else{
                loadMainPage(url, pos);
            }

            $('.easyui-accordion li div').removeClass("selected");
            $(this).addClass("selected");
        }).hover(function () {
            $(this).addClass("hover");
        }, function () {
            $(this).removeClass("hover");
        });

    //选中第一个
    var panels = $('#nav').accordion('panels');
    if(panels != null){
        if(panels[0] != null){
            var t = panels[0].panel('options').title;
            $('#nav').accordion('select', t);
        }
    }
}
//获取左侧导航的图标
function getIcon(menuid){
	var icon = 'icon ';
	$.each(_menus.basic, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				icon += o.icon;
			}
		 })
	});

	return icon;
}

//加载main区域页面
function loadMainPage(url,location){
    loadAjaxData("mainContent",url);
    setLocation(location);
}
function setLocation(location){
    $("#mainLocationDesc").html("&nbsp;当前位置："+location);
}

//加载tab
function addTab(subtitle, url, id, opts) {
    var isFirstLoad = true;
    if (!$('#tabs').tabs('exists', subtitle)) {
        $('#tabs').tabs('add', $.extend({
            title:subtitle,
            content:createFrame('', id),
            closable:false,
            closed:true,
//			icon:icon
            onOpen:function () {
                if (isFirstLoad) {
                    isFirstLoad = false;
                } else {
                    $("#" + id).attr("src", url);
                }
            }
        }, opts));
    } else {
        $('#tabs').tabs('select', subtitle);
        $('#mm-tabupdate').click();
    }
//	tabClose();
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	});
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url)
			}
		})
	});
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	});
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			alert('已到最后');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('已到最前');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

/*****************add custom**********************/

function floatOpen(div){
//    _168();
}