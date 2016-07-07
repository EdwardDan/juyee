package com.justonetech.proj.approval.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.alibaba.fastjson.JSON;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ConstructionPermitMaterialPortlet
 */
public class ConstructionPermitMaterialPortlet extends MVCPortlet {
 
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		 try {
			long groupId = PortalUtil.getScopeGroupId(renderRequest);
			List<ProjApproval> projApprovals=new ArrayList<ProjApproval>();
			long dictionaryId=28813L;
			if(ParamUtil.getLong(renderRequest, "what")!=0){
				dictionaryId=ParamUtil.getLong(renderRequest, "what");
			}
			renderRequest.setAttribute("what", dictionaryId);
			Dictionary dictionary=DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			String customContent=dictionary.getCustomContent();
			if(!customContent.equals("")){
				List<ProjApproval> oneProjApproval=JSON.parseArray(customContent,ProjApproval.class);
				projApprovals.addAll(oneProjApproval);
			}
//			List<Dictionary> dictionaries=DictionaryLocalServiceUtil.findByGroupIdAndParentId(groupId, DictionaryLocalServiceUtil.findByGroupIdAndCode(groupId, "ProjectType").getDictionaryId(),-1,-1);
//			for(Dictionary dictionary:dictionaries){
//				String customContent=dictionary.getCustomContent();
//				if(!customContent.equals("")){
//					List<ProjApproval> oneProjApproval=JSON.parseArray(customContent,ProjApproval.class);
//					projApprovals.addAll(oneProjApproval);
//				}
//			}
			renderRequest.setAttribute("projApprovals", projApprovals);
			renderRequest.setAttribute("projApprovalsCount", projApprovals.size());
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	public void saveProjApproval(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");
		System.out.println("之前的dictionaryId为"+dictionaryId);
		long id=ParamUtil.getLong(actionRequest, "id");
		System.out.println("之前的ID为"+id);
		//todo:要判空哦！long为空？
		Dictionary dictionary=DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		System.out.println("系统字典是"+dictionary.getCustomContent());
		long type = ParamUtil.getLong(actionRequest, "type");
		long no = ParamUtil.getLong(actionRequest, "no");
		String materialName = ParamUtil.getString(actionRequest, "materialName");
		String auditReq = ParamUtil.getString(actionRequest, "auditReq");
		String auditReqGreen = ParamUtil.getString(actionRequest, "auditReqGreen");
		long yjNum = ParamUtil.getLong(actionRequest, "yjNum");
		ProjApproval projApproval = new ProjApproval();
		projApproval.setId(CounterLocalServiceUtil.increment());
		projApproval.setDictionaryId(dictionaryId);
		projApproval.setType(type);
		projApproval.setNo(no);
		projApproval.setMaterialName(materialName);
		projApproval.setAuditReq(auditReqGreen);
		projApproval.setAuditReqGreen(auditReqGreen);
		projApproval.setYjNum(yjNum);
		System.out.println("id="+projApproval.getId());
		if(dictionary.getCustomContent().equals("")){
			List<ProjApproval> list=new ArrayList<ProjApproval>();
			list.add(projApproval);
			String jsonString = JSON.toJSONString(list);
			dictionary.setCustomContent(jsonString);
			DictionaryLocalServiceUtil.updateDictionary(dictionary);
		}else{
			String customContent=dictionary.getCustomContent();
			List<ProjApproval> projApprovals=JSON.parseArray(customContent,ProjApproval.class);
			List<ProjApproval> list=new ArrayList<ProjApproval>();
			for(ProjApproval projApprovalOld:projApprovals){
				if(projApprovalOld.getId()!=id){
					list.add(projApprovalOld);
				}
			}
			list.add(projApproval);
			String jsonString=JSON.toJSONString(list);
			dictionary.setCustomContent(jsonString);
			DictionaryLocalServiceUtil.updateDictionary(dictionary);
		}
	}
	
	public void deleteProjApproval(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {
		long id=ParamUtil.getLong(actionRequest, "id");
		long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");
		System.out.println("Id为"+id+"父节点为"+dictionaryId);
		Dictionary dictionary=DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		List<ProjApproval> projApprovals=JSON.parseArray(dictionary.getCustomContent(),ProjApproval.class);
		List<ProjApproval> list=new ArrayList<ProjApproval>();
		for(ProjApproval projApproval:projApprovals){
			if(projApproval.getId()!=id){
				list.add(projApproval);
			}
		}
		String jsonString=JSON.toJSONString(list);
		dictionary.setCustomContent(jsonString);
		DictionaryLocalServiceUtil.updateDictionary(dictionary);
	}
	
		public void editProjApproval(ActionRequest actionRequest,
				ActionResponse actionResponse) throws SystemException,
				PortalException {
			long no = ParamUtil.getLong(actionRequest, "no");
			long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");
			System.out.println("序号为"+no+"父节点为"+dictionaryId);
			Dictionary dictionary=DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			System.out.println("系统字典是"+dictionary.getCustomContent());
			List<ProjApproval> projApprovals=JSON.parseArray(dictionary.getCustomContent(),ProjApproval.class);
			for(ProjApproval projApproval:projApprovals){
				if(projApproval.getNo()==no){
					System.out.println("no:"+projApproval.getNo());
					actionRequest.setAttribute("projApproval", projApproval);
				}
			}
		
	}
	
}
