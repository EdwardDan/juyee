<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT type="text/javascript">
    var canEdit = ${canEdit};               //编辑权限
    var icon = addIcons("default.gif,default_disabled.gif");
    var clazz = '${clazz}';    //供上移下移使用
    $(document).ready(function () {
        //不覆盖zTree的配置，如果需要额外配置，可直接在setting里面添加
        var setting = {
            simpleOpts:{
                treeUrl:CONTEXT_NAME + "/bpmProcessDefinition/treeData.do?icon=" + icon, //树的链接
                isOpenRoot:true, //是否打开根节点
                clickOpts:{
                    "root":CONTEXT_NAME + "/bpmProcessDefinition/grid.do",
                    "data":["查看业务流程定义", CONTEXT_NAME + "/bpmProcessDefinition/view.do?id={id}", {
                        isRefreshGrid:false, width:800, height:500
                    }]
                },
                menuParams:{
                    destory:true,
                    beforeShow:function (ele) {
                        $(ele).width(130);
                    }
                },
                rightMenuOpts:function (treeNode, zTree) {
                    var menu = [];
                    if (canEdit) {
                        if (treeNode.type == 'root') {

                        } else if (treeNode.type == 'category') {
                            menu.push(["添加", function (treeNode, zTree) {
                                openWindow("添加业务流程定义", CONTEXT_NAME + "/bpmProcessDefinition/input.do?categoryId="+treeNode.id, true, 1000, 500);
                            }]);
//                            menu.push(["导入流程定义", ["导入流程定义", CONTEXT_NAME + "/bpmProcessDefinition/input.do"]]);
                        }else if (treeNode.type == 'data') {
                            menu.push(["编辑", function (treeNode, zTree) {
                                loadAjaxData("treeRight", CONTEXT_NAME + "/bpmProcessDefinition/tabs.do?act=edit&id=" + treeNode.id);
                                $("#treeRight").height($("#mainContent").height() - 50);
//                                openWindow("编辑业务流程定义", CONTEXT_NAME + "/bpmProcessDefinition/tabs.do?act=edit&id=" + treeNode.id, true, 1000, 500);
                            }]);
                            menu.push([]);
                            menu.push(["删除", CONTEXT_NAME + "/bpmProcessDefinition/delete.do?id={id}", true]);
                            menu.push(["删除流程所有实例", CONTEXT_NAME + "/bpmProcessDefinition/deleteInstanceByDefinition.do?id={id}", true]);
                            menu.push([]);
                            menu.push(["上移", "moveUp"]);
                            menu.push(["下移", "moveDown"]);
                        }
                        menu.push([]);
                    }
                    menu.push(["刷新", "refreshNode"]);
                    return menu;
                }
            }
        };
        initTree($("#treeId"), setting);
    })
</SCRIPT>
<ul id="treeId" class="ztree"></ul>