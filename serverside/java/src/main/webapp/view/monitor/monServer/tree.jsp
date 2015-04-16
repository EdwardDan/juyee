<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT type="text/javascript">
    var canEdit = ${canEdit};               //编辑权限
    var icon = addIcons("default.gif");  //节点图标
    var clazz = '${clazz}';    //供上移下移使用
    var clazzCamera = '${clazzCamera}';

    $(document).ready(function () {
        //不覆盖zTree的配置，如果需要额外配置，可直接在setting里面添加
        var setting = {
            simpleOpts:{
                treeUrl:CONTEXT_NAME + "/monServer/treeData.do?icon=" + icon, //树的链接
                isOpenRoot:true, //是否打开根节点
                clickOpts:{
                    "root":CONTEXT_NAME + "/monCamera/grid.do",
                    "data":CONTEXT_NAME + "/monServer/grid.do?id={id}",
                    "camera":["查看视频探头", CONTEXT_NAME + "/monCamera/view.do?id={id}"]
                },
                rightMenuOpts:function (treeNode, zTree) {
                    var menu = [];
                    if (canEdit) {
                        if (treeNode.id == 'root') {
                            menu.push(["添加视频服务器", ["添加视频服务器", CONTEXT_NAME + "/monServer/add.do?parentId={id}"]]);    //有问题
                        }

                        else if (treeNode.type == 'data') {
                            menu.push(["添加视频探头", ["添加视频探头", CONTEXT_NAME + "/monCamera/add.do?monServerId={id}"]]);    //改
                            menu.push([]);
                            menu.push(["修改视频服务器", ["修改视频服务器", CONTEXT_NAME + "/monServer/modify.do?id={id}"]]);
                            menu.push([]);
                            menu.push(["删除视频服务器", CONTEXT_NAME + "/monServer/delete.do?id={id}", true]);
                            menu.push([]);
                            menu.push(["查看视频服务器", ["查看视频服务器", CONTEXT_NAME + "/monServer/view.do?id={id}"]]);
                            menu.push([]);
                            menu.push(["上移", "moveUp"]);
                            menu.push(["下移", "moveDown"]);
                        }
                        else {
                            menu.push(["修改视频探头", ["修改视频探头", CONTEXT_NAME + "/monCamera/modify.do?id={id}"]]);
                            menu.push([]);
                            menu.push(["删除视频探头", CONTEXT_NAME + "/monCamera/delete.do?id={id}", true]);
                            menu.push([]);
                            menu.push(["上移", function(treeNode, zTree) {
                                treeActions.moveUp(treeNode, zTree, clazzCamera,"mon_server_id="+treeNode.getParentNode().id);
                            }]);
                            menu.push(["下移", function(treeNode, zTree) {
                                treeActions.moveDown(treeNode, zTree, clazzCamera,"mon_server_id="+treeNode.getParentNode().id);
                            }]);
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