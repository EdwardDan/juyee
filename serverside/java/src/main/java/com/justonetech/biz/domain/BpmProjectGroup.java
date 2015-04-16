package com.justonetech.biz.domain;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.base.BaseBpmProjectGroup;
import com.justonetech.biz.manager.workflow.ExtAttrManager;
import com.justonetech.biz.utils.jbpm.extattr.ExtAttrItems;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;


public class BpmProjectGroup extends BaseBpmProjectGroup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmProjectGroup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmProjectGroup (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmProjectGroup (
		java.lang.Long id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/

   public ExtAttrItems getExtAttrItems(String extAttrName) throws JAXBException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String xml = getAttributes();
        ExtAttrItems attrItems;
        if (!StringHelper.isEmpty(xml)&&!xml.trim().equals("")) {
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
        BpmProjectGroup.extAttrManager = extAttrManager;
    }
}