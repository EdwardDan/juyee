<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<SCRIPT type="text/javascript">
    var icon = addIcons("default.gif,video_on.gif,video_off.gif");  //节点图标
    var lastSelNode;

    $(document).ready(function () {
        //不覆盖zTree的配置，如果需要额外配置，可直接在setting里面添加
        var setting = {
            simpleOpts:{
                treeUrl:CONTEXT_NAME + "/gdMonitor/treeData.do?icon=" + icon, //树的链接
                isOpenRoot:true, //是否打开根节点
                clickOpts:function (treeId, treeNode) {
                    var type = treeNode.type || "all";
                    if (type == "monitor") {
                        var parentNode = treeNode.getParentNode();
                        var icons = icon.split(",");
                        if (lastSelNode) {
                            lastSelNode.icon = lastSelNode.icon.substring(0, lastSelNode.icon.lastIndexOf("/") + 1) + icons[3];
                            global_zTree.updateNode(lastSelNode);
                        }
                        gotoplay(treeNode.id);
                        lastSelNode = treeNode;
                        $.getJSON("${ctx}/gdMonitor/getProjectInfo.do?gdCode=" + parentNode.id, function (projInfo) {
                            if (projInfo) {
                                if (projInfo.data) {
                                    $("#projectName").text(projInfo.data.projectName);
                                    $("#buildUnitName").text(projInfo.data.buildUnitName);
                                }
                                $("#belongArea").text(projInfo.belongArea);
                                $("#property").text(projInfo.property);
                                $("#sgTotalUnitName").text(projInfo.sgTotalUnitName);
                            }
                        });
                    }
                    return {};
                }
            }
        };
        $.get(setting.simpleOpts.treeUrl, function (zNodes) {
            initTree($("#treeId"), setting, $.parseJSON(zNodes));
        });
    })
</SCRIPT>
<ul id="treeId" class="ztree"></ul>