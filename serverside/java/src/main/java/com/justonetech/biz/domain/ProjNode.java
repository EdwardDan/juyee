package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseProjNode;



public class ProjNode extends BaseProjNode {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ProjNode () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ProjNode (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 获取第1层父节点
     * @return .
     */
    public Long getFirstNodeId(){
        ProjNode parent = getParent();
        if(parent != null){
            ProjNode parent1 = parent.getParent();
            if(parent1 != null){
                 return parent1.getId();
            }else{
                return parent.getId();
            }
        }
        return getId();
    }
}