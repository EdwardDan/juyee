<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT type="text/javascript">
    var canEdit = ${canEdit};               //编辑权限
    var icon = addIcons("default.gif");  //节点图标
    var clazz = '${clazz}';    //供上移下移使用

    $(document).ready(function () {
        //不覆盖zTree的配置，如果需要额外配置，可直接在setting里面添加
        var setting = {
            simpleOpts: {
                treeUrl: CONTEXT_NAME + "/safeProductStandard/treeData.do?icon=" + icon, //树的链接
                isOpenRoot: true, //是否打开根节点
                clickOpts: {
                    "root": CONTEXT_NAME + "/safeProductStandard/grid.do",
                    "data": ["查看安全生产标准", CONTEXT_NAME + "/safeProductStandard/view.do?id={id}"]
                },
                rightMenuOpts: function (treeNode, zTree) {
                    var menu = [];
                    if (canEdit) {
                        if (treeNode.id == 'root') {
                            menu.push(["添加", ["添加安全生产标准", CONTEXT_NAME + "/safeProductStandard/add.do?year=&parentId="]]);
                        } else if (treeNode.type == "dataParent") {
                            menu.push(["添加", ["添加安全生产标准", CONTEXT_NAME + "/safeProductStandard/add.do?year={id}&parentId="]]);
                            menu.push([]);
                            menu.push(["删除", CONTEXT_NAME + "/safeProductStandard/delete.do?id={id}", true]);
                            menu.push([]);
                            menu.push(["上移", "moveUp"]);
                            menu.push(["下移", "moveDown"]);
                        } else if (treeNode.type == "data") {
                            menu.push(["添加", ["添加安全生产标准", CONTEXT_NAME + "/safeProductStandard/add.do?parentId={id}"]]);
                            menu.push(["修改", ["修改安全生产标准", CONTEXT_NAME + "/safeProductStandard/modify.do?id={id}"]]);
                            menu.push([]);
                            menu.push(["删除", CONTEXT_NAME + "/safeProductStandard/delete.do?id={id}", true]);
                            menu.push([]);
                            menu.push(["上移", "moveUp"]);
                            menu.push(["下移", "moveDown"]);
                        }
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