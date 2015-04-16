<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT type="text/javascript">
    var canEdit = ${canEdit};               //编辑权限
    var icon = addIcons("default.gif,doc.gif,default_disabled.gif");  //节点图标
    var clazz = '${clazz}';    //供上移下移使用

    $(document).ready(function () {
        //不覆盖zTree的配置，如果需要额外配置，可直接在setting里面添加
        var setting = {
            simpleOpts: {
                treeUrl: CONTEXT_NAME + "/reportStructure/treeData.do?icon=" + icon, //树的链接
                isOpenRoot: true, //是否打开根节点
                clickOpts: {
                    "root": CONTEXT_NAME + "/reportStructure/grid.do",
                    "ver": ["查看版本", CONTEXT_NAME + "/reportStructure/viewVer.do?versionId={id}"],
                    "data": ["查看报表", CONTEXT_NAME + "/reportStructure/view.do?id={id}"]
                },
                rightMenuOpts: function (treeNode, zTree) {
                    var menu = [];
                    if (canEdit) {
                        if (treeNode.id == 'root') {
                            menu.push(["添加报表版本", ["添加报表版本", CONTEXT_NAME + "/reportStructure/addVer.do"]]);
                        } else if(treeNode.type=="ver"){
                            menu.push(["添加报表结构", ["添加报表结构", CONTEXT_NAME + "/reportStructure/add.do?versionId={id}"]]);
                            menu.push([]);
                            menu.push(["复制版本", ["复制版本", CONTEXT_NAME + "/reportStructure/copyVer.do?versionId={id}"]]);
                            menu.push(["修改版本", ["修改版本", CONTEXT_NAME + "/reportStructure/modifyVer.do?versionId={id}"]]);
                            menu.push(["设置有效版本", CONTEXT_NAME + "/reportStructure/isValid.do?versionId={id}", true]);
                            menu.push([]);
                            menu.push(["清除版本所有节点", CONTEXT_NAME + "/reportStructure/deleteVer.do?versionId={id}", true]);

                        }else if (treeNode.type == "data") {
                            menu.push(["添加报表结构", ["添加报表结构", CONTEXT_NAME + "/reportStructure/add.do?parentId={id}"]]);
                            menu.push(["修改报表结构", ["修改报表结构", CONTEXT_NAME + "/reportStructure/modify.do?id={id}"]]);
                            menu.push([]);
                            menu.push(["删除报表结构", CONTEXT_NAME + "/reportStructure/delete.do?id={id}", true]);
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