/**
 * 查看项目信息
 * @param bjbh
 * @param gdCode
 * @param flowCode
 * @param isParentWindow
 * @param isOpenNewWindow
 */
function viewProjectInfo(title, bjbh, gdCode, jdTaskCode, isParentWindow, isOpenNewWindow) {
    var url = CONTEXT_NAME + "/projectQuery/view.do?bjbh=" + bjbh + "&gdCode=" + gdCode + "&jdTaskCode=" + jdTaskCode;
    var windowId = isOpenNewWindow ? "newWinId" : null;
    if (isParentWindow) {
        parent.openNewWindow(windowId, title, url, false, 900, 525);
    } else {
        openNewWindow(windowId, title, url, false, 900, 525);
    }
}

/********************* 任务管理部分 begin ************************/
/**
 * 执行和查看任务
 * @param id -- oaTaskDeal.id
 * @param url -- task url
 * @param isWorkflow -- 是否流程任务
 * @param isView -- 是否查看
 * @param isNeedCheck -- 是否需要判断表单存在
 */
function viewTask(id, url, isWorkflow, isView, isNeedCheck) {
    url = CONTEXT_NAME + "/" + url + "&from=task&oaTaskDealId=" + id;
    if (isNeedCheck) {
        var ret = $.ajax({
            url: url,
            async: false,
            cache: false
        }).responseText;
        if (ret.indexOf("出现了异常") >= 0) {
            showErrorMsg("表单已不存在，无法查看");
        } else {
            openTaskCallback(id, url, isWorkflow, isView);
        }
    } else {
        openTaskCallback(id, url, isWorkflow, isView);
    }
}
function openTaskCallback(id, url, isWorkflow, isView) {
    //只有流程需要单独弹出页面，其余使用div，查看页面也使用div
    if ("true" == isWorkflow && !isView) {
        if("sgPermit".indexOf(url)){
            parent.openNewWindow("newWinId", "查看施工许可证", url, false, 900, 550);
        } else {
            parent.openFullWindow(url, 900, 550);
        }
    } else {
        if (url.indexOf("sgPermit/frame")) {
            parent.openNewWindow("newWinId", "查看施工许可证", url, false, 900, 550);
        }else{
            parent.openWindow("查看任务", url, true, 900, 550);
        }
    }

    //设置为已读状态
    if (!isView) {
        loadAjaxDataCallback(null, CONTEXT_NAME + "/oaTask/setStatus.do?id=" + id + "&status=", refreshThisGrid);
    }
}
function refreshThisGrid() {
    refreshGrid(null);
}

//首页任务提醒
function showTaskPop(count) {
    //右下角弹出提示框
    $.messager.show({
        title: '系统提示',
        msg: '您有' + count + '条任务等待处理！<a href="javascript:viewMoreTask();">查看</a>',
        timeout: 5000
    });
}

//查看更多任务
function viewMoreTask() {
    loadMainPage(CONTEXT_NAME + "/oaTask/init.do", "系统首页>>任务处理");
}
/********************* 任务管理部分 end ************************/

//判断是否已启用视频插件
function checkVideoObj() {
    var player = document.getElementById("player");
    if (player) {
        return (player.tagName == 'OBJECT');
    }
    return false;
}

//获取监督记录相关的工程信息 todo 以后不再使用该方法
function getJdProjectInfo(btn) {
    var v = $("#jdTaskCode").val();
    if (v == "") {
        showInfoMsg("请输入监督任务书编号!");
        return;
    }
    btn.value = "请稍候";
    btn.disabled = true;
    $.ajax({
        url: CONTEXT_NAME + "/jdRecord/getProjectInfo.do?jdTaskCode=" + v,
        cache: false,
        data: "",
        success: function (ret) {
            if (ret.indexOf("{") >= 0) {
                var json = eval("(" + ret + ")");
                var data = json[0];
                if (data.projectName != "") {
                    for (var key in data) {
                        $('#' + key).val(data[key]);
                    }
                }
            } else {
                showErrorMsg("未获取到有效工程信息");
            }
            btn.value = "获取";
            btn.disabled = false;
        }, error: function () {
            btn.value = "获取";
            btn.disabled = false;
        }
    });
}

/**
 *根据报建编号或监督任务书编号获取工程信息
 * @param btn 点击按钮
 * @param bjbh 报建编号
 * @param jdTaskCode 监督任务书编号
 * @param isNeedAlert 是否需要提示，否为静默方式，查看页面调用时设置为否
 * @param isInnerHtml 是否直接显示在span中，不显示在文本框中
 */
function loadProjectInfoByCode(btn, bjbh, jdTaskCode, isNeedAlert, isInnerHtml) {
    var alertMsg = "请输入报建编号!";
    var url = CONTEXT_NAME + "/projectInfo/getProjectInfoByBjbh.do?bjbh=" + bjbh;
    if (jdTaskCode != null && jdTaskCode != "") {
        alertMsg = "请输入监督任务书编号!";
        url = CONTEXT_NAME + "/projectInfo/getProjectInfoByJdTaskCode.do?jdTaskCode=" + jdTaskCode;
    }
    if (bjbh != null && bjbh.length < 3) {
        if (isNeedAlert) {
            showInfoMsg(alertMsg);
        }
        return;
    }
    if (btn != null) {
        btn.value = "请稍候";
        btn.disabled = true;
    }
    $.ajax({
        url: url,
        cache: false,
        data: "",
        success: function (ret) {
            console.log(ret);
            if (ret.indexOf("{") >= 0) {
                var json = eval("(" + ret + ")");
                var data = json[0];
                if (data.projectName != "") {
                    for (var key in data) {
                        if ($('#' + key).length > 0) {
                            if (isInnerHtml) {
                                if (document.getElementById(key).nodeName == "INPUT")
                                    $('#' + key).val(data[key]);     //text方式
                                else
                                    $('#' + key).html(data[key]);  //span方式
                            } else {
                                $('#' + key).val(data[key]);     //text方式
                            }
                        }
                    }
                } else if (isNeedAlert) {
                    showErrorMsg("未获取到有效工程信息");
                }
            } else if (isNeedAlert) {
                showErrorMsg("未获取到有效工程信息");
            }
            if (btn != null) {
                btn.value = "获取";
                btn.disabled = false;
            }
        }, error: function () {
            if (btn != null) {
                btn.value = "获取";
                btn.disabled = false;
            }
        }
    });
}