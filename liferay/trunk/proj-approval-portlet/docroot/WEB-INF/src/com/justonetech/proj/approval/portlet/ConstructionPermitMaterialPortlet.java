package com.justonetech.proj.approval.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.alibaba.fastjson.JSON;
import com.justonetech.proj.approval.vo.ConstructionPermitMaterial;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ConstructionPermitMaterialPortlet
 */
public class ConstructionPermitMaterialPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			int pageSize = ParamUtil.getInteger(renderRequest, "delta", 5);
			int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = (pageNumber - 1) * pageSize;
			int end = pageNumber * pageSize;
			System.out.println("start1=" + start + "&end1=" + end);
			long groupId = PortalUtil.getScopeGroupId(renderRequest);
			Dictionary projectType = DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ProjectType");
			long dictionaryId = 0L;
			if (null != projectType) {
				List<Dictionary> dictionaries = DictionaryLocalServiceUtil.findByGroupIdAndParentId(groupId,
						projectType.getDictionaryId(), -1, -1);
				dictionaryId = dictionaries.get(0).getDictionaryId();
			}
			List<ConstructionPermitMaterial> constructionPermitMaterials = new ArrayList<ConstructionPermitMaterial>();
			if (ParamUtil.getLong(renderRequest, "type") != 0) {
				dictionaryId = ParamUtil.getLong(renderRequest, "type");
			}
			renderRequest.setAttribute("type", dictionaryId);
			Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			String customContent = dictionary.getCustomContent();
			if (!customContent.equals("")) {
				List<ConstructionPermitMaterial> oneConstructionPermitMaterial = JSON.parseArray(customContent, ConstructionPermitMaterial.class);
				constructionPermitMaterials.addAll(oneConstructionPermitMaterial);
			}
			 Collections.sort(constructionPermitMaterials, new Comparator<ConstructionPermitMaterial>(){  
		            /*  
		             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
		             * 返回负数表示：o1 小于o2，  
		             * 返回0 表示：o1和o2相等，  
		             * 返回正数表示：o1大于o2。  
		             */  
		            public int compare(ConstructionPermitMaterial o1, ConstructionPermitMaterial o2) {  
		              
		                //按照序号进行升序排列  
		                if(o1.getSortNo() > o2.getSortNo()){  
		                    return 1;  
		                }  
		                if(o1.getSortNo() == o2.getSortNo()){  
		                    return 0;  
		                }  
		                return -1;  
		            }  
		        });   
				if (end > constructionPermitMaterials.size()) {
					end = constructionPermitMaterials.size();
				}
				System.out.println("end="+end);
			renderRequest.setAttribute("constructionPermitMaterials", constructionPermitMaterials.subList(start, end));
			renderRequest.setAttribute("constructionPermitMaterialsCount", constructionPermitMaterials.size());
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	public void saveConstructionPermitMaterial(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		
		long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");
		long id = ParamUtil.getLong(actionRequest, "id");
		// todo:要判空哦！long为空？
		Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		long type = ParamUtil.getLong(actionRequest, "type");
		int sortNo = ParamUtil.getInteger(actionRequest, "sortNo");
		String materialName = ParamUtil.getString(actionRequest, "materialName");
		String auditReq = ParamUtil.getString(actionRequest, "auditReq");
		String auditReqGreen = ParamUtil.getString(actionRequest, "auditReqGreen");
		int yjNum = ParamUtil.getInteger(actionRequest, "yjNum");
		ConstructionPermitMaterial constructionPermitMaterial = new ConstructionPermitMaterial();
		constructionPermitMaterial.setId(CounterLocalServiceUtil.increment());
		constructionPermitMaterial.setType(type);
		constructionPermitMaterial.setSortNo(sortNo);
		constructionPermitMaterial.setDictionaryId(dictionaryId);
		constructionPermitMaterial.setMaterialName(materialName);
		constructionPermitMaterial.setAuditReq(auditReq);
		constructionPermitMaterial.setAuditReqGreen(auditReqGreen);
		constructionPermitMaterial.setYjNum(yjNum);
		if (dictionary.getCustomContent().equals("")) {
			List<ConstructionPermitMaterial> list = new ArrayList<ConstructionPermitMaterial>();
			list.add(constructionPermitMaterial);
			String jsonString = JSON.toJSONString(list);
			dictionary.setCustomContent(jsonString);
			DictionaryLocalServiceUtil.updateDictionary(dictionary);
		} else {
			String customContent = dictionary.getCustomContent();
			List<ConstructionPermitMaterial> constructionPermitMaterials = JSON.parseArray(customContent, ConstructionPermitMaterial.class);
			List<ConstructionPermitMaterial> list = new ArrayList<ConstructionPermitMaterial>();
			for (ConstructionPermitMaterial constructionPermitMaterialOld : constructionPermitMaterials) {
				if (constructionPermitMaterialOld.getId() != id) {
					list.add(constructionPermitMaterialOld);
				}
			}
			list.add(constructionPermitMaterial);
			String jsonString = JSON.toJSONString(list);
			dictionary.setCustomContent(jsonString);
			DictionaryLocalServiceUtil.updateDictionary(dictionary);
		}
	}

	public void deleteConstructionPermitMaterial(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException,
			PortalException {
		long id = ParamUtil.getLong(actionRequest, "id");
		long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");
		Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		List<ConstructionPermitMaterial> constructionPermitMaterials = JSON.parseArray(dictionary.getCustomContent(), ConstructionPermitMaterial.class);
		List<ConstructionPermitMaterial> list = new ArrayList<ConstructionPermitMaterial>();
		for (ConstructionPermitMaterial constructionPermitMaterial : constructionPermitMaterials) {
			if (constructionPermitMaterial.getId() != id) {
				list.add(constructionPermitMaterial);
			}
		}
		String jsonString = JSON.toJSONString(list);
		dictionary.setCustomContent(jsonString);
		DictionaryLocalServiceUtil.updateDictionary(dictionary);
	}

	public void editConstructionPermitMaterial(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException,
			PortalException {
		long sortNo = ParamUtil.getLong(actionRequest, "sortNo");
		long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");
		Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		List<ConstructionPermitMaterial> constructionPermitMaterials = JSON.parseArray(dictionary.getCustomContent(), ConstructionPermitMaterial.class);
		for (ConstructionPermitMaterial constructionPermitMaterial : constructionPermitMaterials) {
			if (constructionPermitMaterial.getSortNo() == sortNo) {
				actionRequest.setAttribute("constructionPermitMaterial", constructionPermitMaterial);
			}
		}

	}
	
}
