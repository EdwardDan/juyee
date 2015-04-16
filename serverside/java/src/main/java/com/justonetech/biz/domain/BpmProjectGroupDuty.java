package com.justonetech.biz.domain;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.base.BaseBpmProjectGroupDuty;
import com.justonetech.biz.manager.workflow.ExtAttrManager;
import com.justonetech.biz.utils.jbpm.extattr.ExtAttrItems;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;


public class BpmProjectGroupDuty extends BaseBpmProjectGroupDuty {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmProjectGroupDuty () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmProjectGroupDuty (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmProjectGroupDuty (
		java.lang.Long id,
		com.justonetech.biz.domain.BpmProjectGroup projectGroup,
		java.lang.String name) {

		super (
			id,
			projectGroup,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/

  public ExtAttrItems getExtAttrItems(String extAttrName) throws JAXBException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String xml = getAttributes();
        ExtAttrItems attrItems;
        if (!StringHelper.isEmpty(xml) && !xml.trim().equals("")) {
            attrItems = extAttrManager.getExtAttrItems(xml, extAttrName);
        } else {
            attrItems = new ExtAttrItems();
        }
        //todo:you can put <extAttrName
        return attrItems;
    }

    private static ExtAttrManager extAttrManager;

    @Autowired
    private void setExtAttrManager(ExtAttrManager extAttrManager) {
        BpmProjectGroupDuty.extAttrManager = extAttrManager;
    }
}