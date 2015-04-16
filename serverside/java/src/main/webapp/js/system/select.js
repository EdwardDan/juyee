/****************************************************
 select.js文件
 描述：提供各种树形结构的对话框选择树，包括单选和多选功能
 前提：要调用select.js中的函数，必须包含function.js
 ****************************************************/


/****************************************************
 描述：单选对话框：打开对话框选择树中的某一节点信息
 参数：get_doc—对应的getChildren.jsp
 inputId—对应Id的输入框
 inputName—对应名称的输入框
 check—Tree.jsp要加的脚本判断方法 可以为空 例如在人员选择中用到了check参数（要求选择人员节点）
 icons—xml格式的图标组 可以为空 例如在人员选择中用到了icons参数，改变了缺省的图标
 返回：选中节点返回<id>...</id><name>...</name>格式的字符串
 没有选择返回空字符串
 例如打开单位部门选择树选择一个单位部门，并将结果赋给单位ID的文本框和单位名称的文本框：
 参数：单位ID的文本框名称是deptId
 单位名称的文本框名称是deptName
 var get_doc="getDeptChildren.jsp";
 调用：var ret=singleSelect(get_doc,deptId,deptName)
 假定选中的单位ID是123 单位名称是ABC
 结果：ret="<id>123</id><name>ABC</name>"
 deptId.value="123"
 deptName.value="ABC"
 **注意：中文及特殊字符必须经encodeURI编码后传递，后台java接收会自动decodeURI处理
 ****************************************************/
function singleSelect(get_doc, inputId, inputName, check, icons, isFilterByProject, isPermitInput) {

    var url = CONTEXT_NAME + "/common/select/singleSelectTree.html?get_doc=" + encodeURI(get_doc) + "&check=" + encodeURI(check) + "&icons=" + icons;
    if (isPermitInput != null && isPermitInput) {
        url += "&isPermitInput=true";
    } else {
        url += "&isPermitInput=false";
    }

    //isFilterByProject如果为true或者为空则表示自动按项目过滤，如果为false则表示不按项目过滤
    if (isFilterByProject != null && !isFilterByProject) {
        url += "&isFilterByProject=false";
    } else {
        url += "&isFilterByProject=true";
    }
    var strFeatures = "dialogWidth=400px;dialogHeight=480px;center=yes;help=no;resizable:no";
    var ret;
    if (window.showModalDialog) {
        ret = showModalDialog(url, "", strFeatures);
            processSingleSelectResult(inputId, inputName, ret);
    } else {
        ret = showModalDialogAdapter(url, "", strFeatures);
        ret = window.selectDialogIframe = {};
        ret.inputId = inputId;
        ret.inputName = inputName;
    }

}

function processSingleSelectResult(inputId, inputName, ret) {
    if (ret.indexOf("cancel") > -1 || ret == "") {
        return;
    }

    if (inputId)
        inputId.value = getElementValue(ret, "id");
    if (inputName) inputName.value = getElementValue(ret, "name");
}


/****************************************************
 描述：多选对话框：打开对话框选择树中的若干节点信息
 参数：get_doc—对应的getChildren.jsp
 select—对应的列表框
 inputId—对应Id的输入框
 inputName—对应名称的输入框
 check—Tree.jsp要加的脚本判断方法 可以为空
 icons—xml格式的图标组 可以为空
 返回：选中若干节点返回<id>...</id><name>...</name>......<id>...</id><name>...</name>格式的字符串
 没有选择返回空字符串
 例如打开单位部门选择树选择两个单位部门，并将结果赋给单位ID的列表框和单位名称的列表框：
 参数：单位ID的文本框名称是deptId
 单位名称的文本框名称是deptName
 var get_doc="getDeptChildren.jsp";
 调用：var ret=singleSelect(get_doc,deptId,deptName)
 假定选中的分别是
 1-单位ID是123 单位名称是ABC
 2-单位ID是456 单位名称是EFG
 结果：ret="<id>123</id><name>ABC</name><id>456</id><name>EFG</name>"
 deptId.value="123"
 deptName.value="ABC"
 ****************************************************/
function multiSelect(get_doc, select, inputValues, inputNames, check, icons, isFilterByProject, isPermitInput) {


    var url = CONTEXT_NAME + "/common/select/multiSelectTree.html?get_doc=" + encodeURI(get_doc) + "&check=" + encodeURI(check) + "&icons=" + icons;
    if (isPermitInput != null && isPermitInput) {
        url += "&isPermitInput=true";
    } else {
        url += "&isPermitInput=false";
    }

    //isFilterByProject如果为true或者为空则表示自动按项目过滤，如果为false则表示不按项目过滤
    if (isFilterByProject != null && !isFilterByProject) {
        url += "&isFilterByProject=false";
    } else {
        url += "&isFilterByProject=true";
    }
    var strFeatures = "dialogWidth=400px;dialogHeight=480px;center=yes;help=no;resizable:no";
    var ret;
    if (window.showModalDialog) {
        ret = showModalDialog(url, "", strFeatures);
        processMultiSelectResult(select, inputValues, inputNames, ret);
    } else {
        ret = showModalDialogAdapter(url, "", strFeatures);
        ret = window.selectDialogIframe = {};
        ret.inputId = inputValues;
        ret.inputName = inputNames;
    }
}

function processMultiSelectResult(select, inputValues, inputNames, ret) {
    if (ret.indexOf("cancel") == 0 || ret == "") {
        return;
    }

    if (ret == "clear")//清除
    {
        if (select != null)
            select.length = 0;
        if (inputValues != null)
            inputValues.value = "";
        if (inputNames != null)
            inputNames.value = "";
    }

    var ids = getElementValue(ret, "id");
    //alert(ids);
    var names = getElementValue(ret, "name");
    var idArray = ids.split(",");
    var nameArray = names.split(",");

    for (var loop = 0; loop < nameArray.length; loop++) {
        var id = idArray[loop];
        if (id == "undefined" || id == null) id = "";
        var name = nameArray[loop];
        if (name != "") {
            if (select != null)
                addSelectOption(id, name, select);
        }
    }

    if (inputValues != null) {
        if (select != null) {
            inputValues.value = getSelectValues(select);
        }
        else {
            inputValues.value = ids;
        }
    }
    if (inputNames != null) {
        if (select != null) {
            inputNames.value = getSelectNames(select);
        }
        else {
            inputNames.value = names;
        }
    }
}
/***************判断是否选择了某层次的节点***************/
function select_checkNode(nodeId, nodeCode, msg) {
    if (null == nodeCode || null == msg) return true;

    if (nodeId.indexOf(nodeCode) == -1) {
//        alert(decodeURI(msg));
        return false;
    }
    return true;
}


/*******************************系统管理子系统***************************************/
//单位部门--单选
function selectUnitOrDepartment(inputId, inputName) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}
//单位--单选
function selectUnit(inputId, inputName) {
    var get_doc = "system/sysUnit/getUnitData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}
//业主单位--单选
function selectOwnerUnit(inputId, inputName) {
    var get_doc = "system/sysUnit/getOwnerUnitData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}
//单位--单选-可直接输入
function selectUnitInput(inputId, inputName) {
    var get_doc = "system/sysUnit/getUnitData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    singleSelect(get_doc, inputId, inputName, "", icons, true, true);
}
//单位--多选
function multiSelectUnit(select, inputValues, inputNames) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons);
}
//单位--多选-可直接输入
function multiSelectUnitInput(select, inputValues, inputNames) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons, true, true);
}

//部门--单选
function selectDepartment(inputId, inputName) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'dept','请选择部门')", icons);
}
//部门--单选-可直接输入
function selectDepartmentInput(inputId, inputName) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'dept','请选择部门')", icons, true, true);
}
//部门--多选
function multiSelectDepartment(select, inputValues, inputNames) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'dept','请选择部门')", icons);
}

//部门--多选(可直接输入)
function multiSelectDepartmentInput(select, inputValues, inputNames) {
    var get_doc = "system/sysUnit/treeData.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'dept','请选择部门')", icons, true, true);
}

//系统人员--单选
function selectPerson(inputId, inputName) {
    var get_doc = "system/sysPerson/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'person','请选择人员')", icons);
}

//系统人员--单选（可直接输入）
function selectPersonInput(inputId, inputName) {
    var get_doc = "system/sysPerson/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'person','请选择人员')", icons, null, true);
}

//系统人员--多选
function multiSelectPerson(select, inputValues, inputNames) {
    var get_doc = "system/sysPerson/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'person','请选择人员')", icons);
}

//系统人员--多选（可直接输入）
function multiSelectPersonInput(select, inputValues, inputNames) {
    var get_doc = "system/sysPerson/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'person','请选择人员')", icons, true, true);
}

//前序步骤--多选
function multiSelectPreStage(select, inputValues, inputNames, parameter) {
    var get_doc = "pre/preFlowCategory/treeData.html?parameter=" + parameter;
//    var get_doc = "/pre/preFlowCategory/treeData.html?typeCode=" + typeCode + "&currentPreStageId=" + currentPreStageId; //不支持多个参数
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons);
}

//系统人员--单选--通过单位或者部门过滤
function selectPersonByCo(inputId, inputName, unitId, deptId) {
    var get_doc = "system/sysPerson/treeDataByDeptForSelect.html";
    if (unitId != null && unitId != "") {
        get_doc += "?unitId=" + unitId;
    }
    if (deptId != null && deptId != "") {
        get_doc += "?deptId=" + deptId;
    }
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//系统人员--多选--通过单位或者部门过滤
function multiSelectPersonByCo(select, inputValues, inputNames, unitId, deptId) {
    var get_doc = "system/sysPerson/treeDataByDeptForSelect.html";
    if (unitId != null && unitId != "") {
        get_doc += "?unitId=" + unitId;
    }
    if (deptId != null && deptId != "") {
        get_doc += "?deptId=" + deptId;
    }
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'person','请选择人员')", icons);
}

//项目组人员--多选
function multiSelectProjectGroupPerson(select, inputValues, inputNames) {
    var get_doc = "system/sysProjectGroup/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>member_new</image3><image4>member_mobile</image4><image5>member_new_dis</image5><image6>member_mobile_dis</image6>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'person','请选择人员')", icons);
}

//系统用户--多选
function multiSelectUser(select, inputValues, inputNames) {
    var get_doc = "system/sysUser/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>user</image3><image4>user_disabled</image4>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'user','请选择用户')", icons);
}

//系统用户--单选
function selectUser(inputId, inputName) {
    var get_doc = "system/sysUser/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>unit</image1><image2>departments</image2><image3>user</image3><image4>user_disabled</image4>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'user','请选择用户')", icons);
}

//文档目录--单选
function selectFileCategory(inputId, inputName) {
    var get_doc = "file/fileCategory/treeData.html";
    var icons = "<image0>root</image0><image1>tree_doc</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//文档目录--多选
function multiSelectFileCategory(select, inputValues, inputNames) {
    var get_doc = "file/fileCategory/treeData.html";
    var icons = "<image0>root</image0><image1>tree_doc</image1>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'category','请选择文档目录')", icons);
}
//流程模板--单选(不按项目过滤)
function selectProcessTemplate(inputId, inputName)
{
    var get_doc = "workflow/bpmProcessTemplate/treeData.html";
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_pic</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'template','请选择流程模板')", icons, false);
}
//流程表单模板--多选(不按项目过滤)
function selectFormTemplate(inputId, inputName)
{
    var get_doc = "workflow/bpmFormTemplate/treeData.html";
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_form</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'template','请选择表单模板')", icons, false);
}
//流程表单模板--多选(不按项目过滤)--指定流程定义
function selectFormTemplateForDefinition(bpmProcessDefinitionId, inputId, inputName)
{
    var get_doc = "workflow/bpmFormTemplate/treeDataForDefinition.html?bpmProcessDefinitionId=" + bpmProcessDefinitionId;
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_form</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'template','请选择表单模板')", icons, false);
}
//流程表单模板--多选(不按项目过滤)
function multiSelectFormTemplate(select, inputValues, inputNames)
{
    var get_doc = "workflow/bpmFormTemplate/treeData.html";
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_form</image2>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'template','请选择表单模板')", icons, false);
}
//流程表单权限编码--多选
function multiSelectFormPrivilege(formId, select, inputValues, inputNames)
{
    var get_doc = "workflow/bpmFormTemplate/privilegeDataForSelect.html?formId=" + formId;
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_pic</image2>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons, false);
}
//流程表单key定义--单选
function selectFormKey(formId, inputId, inputName)
{
    var get_doc = "workflow/bpmFormTemplate/treeDataForSelectKey.html?formId=" + formId;
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_pic</image2>";
    singleSelect(get_doc, inputId, inputName, "", icons, false);
}
//系统权限--单选
function selectPrivilege(inputValues, inputNames) {
    //单项目平台下只能选择单项目的权限；多项目平台下可以选择所有权限
    var get_doc = "system/sysPrivilege/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>closeread</image1><image2>closereadBlue</image2>";
    singleSelect(get_doc, inputValues, inputNames, "", icons);
}

//系统权限--多选
function multiSelectPrivilege(select, inputValues, inputNames) {
    //单项目平台下只能选择单项目的权限；多项目平台下可以选择所有权限
    var get_doc = "system/sysPrivilege/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>closeread</image1><image2>closereadBlue</image2>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons);
}

function showModalDialogAdapter(url, str, featureStr) {
    featureStr = featureStr || "";
    url = url || "";
    var ele = document.getElementById("selectDialog");
    if (!ele) {
        ele = document.createElement("iframe");
        ele.name = "selectDialog";
        ele.id = "selectDialog";
        ele.style.display = "none";
        document.body.appendChild(ele);
    }
    var features = featureStr.split(";");
    var width = 300;
    var height = 300;
    for (var i = 0; i < features.length; i++) {
        var params = features[i].split("=");
        if (ele[params[0]]) {
            ele[params[0]] = params[1];
            if (/width/i.test(params[0])) {
                width = params[1];
            }
            if (/height/i.test(params[0])) {
                height = params[1];
            }
        }
    }
    var winWidth = document.body.clientWidth;
    var winHeight = document.body.clientHeight;
    var left = (winWidth - width) / 2
    var top = (winHeight - height) / 2;
    ele.style.position = "absolute";
    ele.style.left = left < 0 ? 0 : left;
    top = top < 0 ? 0 : top;
    top = top > 100 ? 100 : top;
    ele.style.top = top;
    ele.style.width = width + "px";
    ele.style.height = height + "px";
    ele.style.border = 0;
    ele.style.display = "block";
    ele.style.zIndex = 10;
    ele.src = url;
    var ret = window.frames["selectDialog"];
    ret.isClosed = false;
    return ret;
}

//标段单选
function selectBidProject(inputId, inputName) {
    var get_doc = "system/sysBidProject/treeData.html";
    var icons = "<image0>root</image0><image1>bid_work</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//标段多选
function multiSelectBidProject(select, inputValues, inputNames) {
    var get_doc = "system/sysBidProject/treeData.html";
    var icons = "<image0>root</image0><image1>bid_work</image1>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons);
}

//合同类型--单选
function selectContCategory(inputId, inputName) {
    var get_doc = "contract/contCategory/treeData.html";
    var icons = "<image0>root</image0><image1>tree_doc</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//合同类型--多选
function multiSelectContCategory(select, inputValues, inputNames) {
    var get_doc = "contract/contCategory/treeData.html";
    var icons = "<image0>root</image0><image1>tree_doc</image1>";
    multiSelect(get_doc, select, inputValues, inputNames, "", icons);
}

//合同--单选
function selectContract(inputId, inputName) {
    var get_doc = "contract/commonTreeData.html?isUnitContract=false";
    var icons = "<image0>root</image0><image1>tree_folder</image1><image2>tree_file</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'contract','请选择合同')", icons);
}

//合同--多选
function multiSelectContract(select, inputValues, inputNames) {
    var get_doc = "contract/commonTreeData.html?isUnitContract=false";
    var icons = "<image0>root</image0><image1>tree_folder</image1><image2>tree_file</image2>";
    multiSelect(get_doc, select, inputValues, inputNames, "select_checkNode(nodeId,'contract','请选择合同')", icons);
}

//付款通知单--单选
function selectRequirePayment(inputId, inputName, contractId) {
    var get_doc = "contract/contRequirePayment/treeData.html?contractId=" + contractId;
    var icons = "<image0>root</image0><image1>tree_doc</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//清单
function selectListDetailCode(listdetailcodeid, code) {
    var get_doc = "data/dataListdetailCode/treeData.html?isUnitContract=false";
    var icons = "<image0>root</image0><image1>tree_folder</image1><image2>tree_file</image2>";
    singleSelect(get_doc, listdetailcodeid, code, "", icons);
}

//合同清单的多选对话框(draw)
function multiSelectListDetailForDraw(contractid, parentid, select, inputId, inputName) {
    var get_doc = "contract/contContractDraw/treeData.html?contractId=" + contractid;
    var icons = "<image0>root</image0><image1>tree_folder</image1><image2>tree_file</image2>";
    multiSelect(get_doc, select, inputId, inputName, "", icons);
}

//采购计划——单选
function selectPlan(inputId, inputName) {
    //单项目平台下只能选择单项目的权限；多项目平台下可以选择所有权限
    var get_doc = "cost/costProcurementPlan/treeData.html";
    var icons = "<image0>root</image0><image1>closeread</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//资源的单选对话框
function selectResource(inputId, inputName) {
    var get_doc = "data/dataResource/treeData.html";
    var icons = "<image0>root</image0><image1>closeread</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons)
}

//采购项目--单选
function selectProcurementProject(inputId, inputName) {
    var get_doc = "cost/costProcurementProject/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>tz_data</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//采购项目--单选(选择关联采购项目)
function selectRelationProcurementProject(inputId, inputName) {
    var get_doc = "cost/costProcurementProject/treeDataForRelation.html";
    var icons = "<image0>root</image0><image1>tz_data</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//采购项目--多选(选择未关联采购计划的采购项目)
function multiSelectProcurementProjectForPlan(select, inputId, inputName) {
    var get_doc = "cost/costProcurementProject/treeDataForPlan.html";
    var icons = "<image0>root</image0><image1>tz_data</image1>";
    multiSelect(get_doc, select, inputId, inputName, "", icons);
}

//投资科目--单选
function selectCostCbsForProcurement(inputId, inputName, code) {
    var get_doc = "cost/costProcurementProject/treeDataCostForSelect.html?code=" + code;
    var icons = "<image0>root</image0><image1>tz_data</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//网络计划作业--单选(不包含子作业)
function selectSchActivity(inputId, inputName, planId) {
    var get_doc = "schedule/schActivity/treeDataForSelect.html?planId=" + planId;
    var icons = "<image0>root</image0><image1>sch_file</image1><image2>milestone</image2><image3>child_activity</image3>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//网络计划作业--多选(不包含子作业)
function multiSelectSchActivity(select, inputId, inputName, planId) {
    var get_doc = "schedule/schActivity/treeDataForSelect.html?planId=" + planId;
    var icons = "<image0>root</image0><image1>sch_file</image1><image2>milestone</image2><image3>child_activity</image3>";
    multiSelect(get_doc, select, inputId, inputName, "", icons);
}

//网络计划作业--多选(包含子作业)
function multiSelectSchActivityAll(select, inputId, inputName, planId) {
    var get_doc = "schedule/schActivity/treeDataForSelectAll.html?planId=" + planId;
    var icons = "<image0>root</image0><image1>sch_file</image1><image2>milestone</image2><image3>component</image3>";
    multiSelect(get_doc, select, inputId, inputName, "", icons);
}

//
//投资分解版本细目--单选
function selectCostCbs(inputId, inputName, versionId) {
    var get_doc = "cost/costCbs/selectTreeData.html?versionId=" + versionId;
    var icons = "<image0>root</image0><image1>closeread</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//质量分解结构类型--单选（选择关联质量结构类型）
function selectQuaQbsType(inputId, inputName) {
    var get_doc = "quality/quaQbsType/treeData.html";
    var icons = "<image0>root</image0><image1>tz_data</image1><image2>tz_item</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'data','请选择结构类型')", icons);
}

//质量分解结构--单选
function selectQuaQbs(inputId, inputName, levelCode) {
    var get_doc = "quality/quaQbs/treeData.html";
    var icons = "<image0>root</image0><image1>qbs_subbid1</image1><image2>qbs_subproject1</image2><image3>qbs_subsection1</image3><image4>qbs_subentry1</image4><image5>qbs_subcheck1</image5>";
    if (levelCode != null) {
        singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'" + levelCode + "','请选择正确的节点层次')", icons);
    } else {
        singleSelect(get_doc, inputId, inputName, "", icons);
    }
}
//质量分解结构--多选
function multiSelectQuaQbs(select, inputId, inputName, levelCode) {
    var get_doc = "quality/quaQbs/treeData.html";
    var icons = "<image0>root</image0><image1>qbs_subbid1</image1><image2>qbs_subproject1</image2><image3>qbs_subsection1</image3><image4>qbs_subentry1</image4><image5>qbs_subcheck1</image5>";
    if (levelCode != null) {
        multiSelect(get_doc, select, inputId, inputName, "select_checkNode(nodeId,'" + levelCode + "','请选择正确的节点层次')", icons);
    } else {
        multiSelect(get_doc, select, inputId, inputName, "", icons);
    }

}

//质量模板key定义--单选
function selectQuaTemplateKey(formId, inputId, inputName) {
    var get_doc = "quality/quaTemplate/treeDataForSelectKey.html?formId=" + formId;
    var icons = "<image0>root</image0><image1>closeread</image1><image2>template_pic</image2>";
    singleSelect(get_doc, inputId, inputName, "", icons, false);
}

//选择流程实例表单
function selectProcessInstace(inputId, inputCode, processDefinitionCode, isShowAll) {
    var url = CONTEXT_NAME + "/workflow/bpmProcessInstance/gridSelect.html";
    url += "?processDefinitionCode=" + processDefinitionCode + "&isShowAll=" + isShowAll;
    var strFeatures = "dialogWidth=800px;dialogHeight=480px;center=yes;help=no;resizable:no";
    var ret = showModalDialog(url, "", strFeatures);
    if (ret == "cancel") {
    } else if (ret == "clear") {
        if (inputId) {
            inputId.value = "";
        }
        if (inputCode) {
            inputCode.value = "";
        }
    } else if (ret != null) {
        if (inputId) {
            inputId.value = ret.id;
        }
        if (inputCode) {
            if (ret.code != null && ret.code != "") {
                inputCode.value = ret.code;
            } else {
                inputCode.value = ret.title;
            }
        }
    }
}

//构件类型--单选
function selectComponentType(inputId, inputName) {
    var get_doc = "data/dataComponentType/treeData.html";
    var icons = "<image0>root</image0><image1>tz_data</image1><image2>tz_item</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'data','请选择构件类型')", icons);
}

//工程构件--单选
function selectComponent(inputId, inputName) {
    var get_doc = "data/dataComponent/treeData.html";
    var icons = "<image0>root</image0><image1>tz_data</image1><image2>tz_item</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'data','请选择工程构件')", icons);
}

//工序包--单选
function selectActivityGroup(inputId, inputName) {
    var get_doc = "data/dataActivityGroup/treeData.html";
    var icons = "<image0>root</image0><image1>componenttype</image1><image2>activitypackage</image2><image3>activitytype</image3>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'group','请选择工序包')", icons);
}

//工序包--多选
function multiSelectActivityGroup(select, inputId, inputName) {
    var get_doc = "data/dataActivityGroup/treeData.html";
    var icons = "<image0>root</image0><image1>componenttype</image1><image2>activitypackage</image2><image3>activitytype</image3>";
    multiSelect(get_doc, select, inputId, inputName, "select_checkNode(nodeId,'group','请选择工序包')", icons);
}

//工序--单选
function selectActivityType(inputId, inputName) {
    var get_doc = "data/dataActivityGroup/treeData.html";
    var icons = "<image0>root</image0><image1>componenttype</image1><image2>activitypackage</image2><image3>activitytype</image3>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'type','请选择工序')", icons);
}

//工程构件-多选
function multiSelectComponent(select, inputId, inputName) {
    var get_doc = "data/dataComponent/treeData.html";
    var icons = "<image0>root</image0><image1>tz_data</image1>";
    multiSelect(get_doc, select, inputId, inputName, "", icons);
}

//进度计划-单选
function selectSchPlan(inputId, inputName) {
    var get_doc = "schedule/schPlan/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>closeread</image1>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}

//项目-单选
function selectProject(inputId, inputName) {
    var get_doc = "system/sysProject/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>tree_folder</image1><image2>tree_file</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'data','请选择项目')", icons);
}

//菜单-单选
function selectMenu(inputId, inputName) {
    var get_doc = "system/sysMenu/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>closeread</image1><image2>child_activity</image2><image3>file_blank</image3>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'data','请选择菜单')", icons);
}

//图纸收文--单选
function selectBlueprintReceive(inputId, inputName) {
    var get_doc = "design/desBlueprintReceive/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>public_icon</image1><image2>docView</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'data','请选择图纸')", icons);
}

//招标信息--单选
function selectCostInvitebid(inputId, inputName) {
    var get_doc = "cost/costInvitebid/treeDataForSelect.html";
    var icons = "<image0>root</image0><image1>public_icon</image1><image2>file</image2>";
    singleSelect(get_doc, inputId, inputName, "select_checkNode(nodeId,'invitebid','请选择招标信息')", icons);
}

/*******************************业务系统***************************************/
//全局科室--单选
function selectFuncRoom(year, inputId, inputName) {
    var get_doc = "biz/hospitalFuncRoom/treeDataForSelect.html?year=" + year;
    var icons = "<image0>root</image0><image1>year</image1><image2>year_dis</image2><image3>hospital_area</image3><image4>hospital_room</image4><image5>hospital_func</image5><image6>hospital_func</image6>";
    singleSelect(get_doc, inputId, inputName, "", icons);
}