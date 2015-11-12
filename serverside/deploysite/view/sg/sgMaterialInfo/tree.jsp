<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT type="text/javascript">
    var canEdit = ${canEdit};               //编辑权限
    var icon = addIcons("default.gif,biz.gif,code.gif");  //节点图标
    var clazz = '${clazz}';    //供上移下移使用

    $(document).ready(function () {
        //不覆盖zTree的配置，如果需要额外配置，可直接在setting里面添加
        var setting = {
            simpleOpts: {
                treeUrl: CONTEXT_NAME + "/sgMaterialInfo/treeData.do?icon=" + icon, //树的链接
                isOpenRoot: true, //是否打开根节点
                clickOpts: {
                    "root": CONTEXT_NAME + "/sgMaterialInfo/grid.do"
                },
                rightMenuOpts: function (treeNode, zTree) {
                    var menu = [];
                    if (canEdit) {
                        if (treeNode.type == 'root') {
                            menu.push(["添加项目类型", ["添加项目类型", CONTEXT_NAME + "/sgMaterialInfo/addProjectType.do?parentId="]]);
                        } else if (treeNode.type == 'info') {
                            menu.push(["添加材料", ["添加材料", CONTEXT_NAME + "/sgMaterialInfo/add.do?parentId={id}"]]);
                        } else if (treeNode.type == 'data') {
                            menu.push(["修改材料", ["修改材料", CONTEXT_NAME + "/sgMaterialInfo/add.do?id={id}"]]);
                        }
                        if (treeNode.id != 'root') {
                            menu.push([]);
                            menu.push(["删除", CONTEXT_NAME + "/sysDept/delete.do?id={id}", true]);
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