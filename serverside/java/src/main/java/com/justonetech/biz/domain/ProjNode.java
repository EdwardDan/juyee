package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseProjNode;
import com.justonetech.core.utils.StringHelper;

import java.util.Set;


public class ProjNode extends BaseProjNode {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public ProjNode() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public ProjNode(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 获取第1层节点
     *
     * @return .
     */
    public ProjNode getFirstNode() {
        ProjNode parent = getParent();
        if (parent != null) {
            ProjNode parent1 = parent.getParent();
            if (parent1 != null) {
                return parent1;
            } else {
                return parent;
            }
        }
        return this;
    }

    /**
     * 获取第1层节点ID
     *
     * @return .
     */
    public Long getFirstNodeId() {
        return getFirstNode().getId();
    }

    /**
     * 获取叶子节点中第1个节点--用于问题的显示
     *
     * @return .
     */
    public Long getChildFirstLeafId() {
        Set<ProjNode> projNodes = getProjNodes();
        if (projNodes.size() > 0) {
            ProjNode child = projNodes.iterator().next();
            Set<ProjNode> children = child.getProjNodes();
            if (children.size() > 0) {
                return children.iterator().next().getId();
            } else {
                return child.getId();
            }
        }
        return getId();
    }

    /**
     * 获取本节点所在层次的所有层次数
     *
     * @return .
     */
    public int getTotalLevel() {
        ProjNode firstNode = getFirstNode();
        Set<ProjNode> childs = firstNode.getProjNodes();
        if (childs.size() > 0) {
            for (ProjNode child : childs) {
                if (child.getProjNodes().size() > 0) {
                    return 3;
                }
            }
            return 2;
        }
        return 1;
    }

    /**
     * 获取当前节点所在层次
     *
     * @return .
     */
    public int getCurrentLevel() {
        return StringHelper.stringToStringArray(getTreeId(), ".").length;
    }

    /**
     * 获取当前节点下所有叶子节点的总数
     *
     * @return .
     */
    public int getTotalChildCount() {
        int count = 0;
        Set<ProjNode> childs = getProjNodes();
        if (childs.size() > 0) {
            for (ProjNode child : childs) {
                count += child.getProjNodes().size();
            }
        }
        if (count == 0) {
            count = childs.size();
        }
        return count;
    }
}