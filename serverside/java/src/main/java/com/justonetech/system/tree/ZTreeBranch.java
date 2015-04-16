package com.justonetech.system.tree;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 12-2-7
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
public class ZTreeBranch {
    List<Node> treeNodeList;
    String[] icons;

    public List<Node> getTreeNodeList() {
        if(treeNodeList == null){
            treeNodeList = new ArrayList<Node>();
        }
        return treeNodeList;
    }

    public void setTreeNodeList(List<Node> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }

    public void addTreeNode(Node treeNode){
        getTreeNodeList().add(treeNode);
    }

    public String[] getIcons() {
        return icons;
    }

    public void setIcons(String[] icons) {
        this.icons = icons;
    }

    /**
     *
     * @param hasCheckBox 是否要添加checkbox 多选框
     * @return
     */
    public String toJsonString(boolean hasCheckBox) {
        List<Node> list = getTreeNodeList();
        for (Node node : list) {
            processNode(node);
        }
        JsonConfig jsonConfig = new JsonConfig();
        if (!hasCheckBox) {
            jsonConfig.setExcludes(new String[]{"checked"});
        }
        JSONArray tranfer = JSONArray.fromObject(list, jsonConfig);
        return tranfer.toString();
    }

    public Node processNode(Node node) {
        ZTreeNode treeNode = (ZTreeNode) node;
        if (treeNode.getIcon() == null) {
            treeNode.setIcon(getIconPath(getIcons(), Integer.parseInt(treeNode.getIcon())));
        } else {
            treeNode.setIcon(getIconPath(getIcons(), Integer.parseInt(treeNode.getIcon())));
        }
        //建设controller设置代码，如业务复杂可以开放uid应用
        String uid = treeNode.getType() + "|<id>" + treeNode.getId() + "</id>";
        if (treeNode.getUid() == null) {
            treeNode.setUid(uid);
        }
        treeNode.setText(treeNode.getName());
        treeNode.setOpen(false);
        treeNode.setIsParent(!treeNode.getIsLeaf());
        return treeNode;
    }

    /**
     * 获取根节点
     * @return
     */
    public ZTreeNode getRootNode(String name){
        ZTreeNode treeNode = new ZTreeNode();
        treeNode.setId("root");
        treeNode.setIsParent(true);
        treeNode.setIsLeaf(false);
        treeNode.setOpen(true);
//            treeNode.setHasChildren(true);
        treeNode.setName(name);
        treeNode.setText(name);
        treeNode.setUid("root");
        treeNode.setIcon("0");
        treeNode.setType("root");
        return treeNode;
    }

    /**
     * 获取图片路径
     * @param icons
     * @param no
     * @return
     */
    public String getIconPath(String[] icons,int no){
        String iconPath = "default.gif";
         if(icons != null){
             if(icons.length>no){
                 iconPath = icons[no];
             }
         }
        return "../skin/default/jquery/zTreeStyle/img/icons/"+iconPath;
    }
}
