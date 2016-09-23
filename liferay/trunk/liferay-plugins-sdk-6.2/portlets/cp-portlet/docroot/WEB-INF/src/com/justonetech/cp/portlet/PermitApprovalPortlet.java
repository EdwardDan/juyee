package com.justonetech.cp.portlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.itextpdf.text.DocumentException;
import com.justonetech.cp.permit.model.ApplyMaterial;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.ApplyMaterialLocalServiceUtil;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * Portlet implementation class PermitApprovalPortlet
 */
public class PermitApprovalPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}

	// 保存收件sj
	public void saveSj(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		String slbh = ParamUtil.getString(request, "slbh");
		String cltjr = ParamUtil.getString(request, "cltjr");
		String hjgsz = ParamUtil.getString(request, "hjgsz");
		String hjgsh = ParamUtil.getString(request, "hjgsh");
		String cltjrlxdh = ParamUtil.getString(request, "cltjrlxdh");
		String sqr = ParamUtil.getString(request, "sqr");
		String cltjrlxdz = ParamUtil.getString(request, "cltjrlxdz");
		String sqsx = ParamUtil.getString(request, "sqsx");
		String sjr = ParamUtil.getString(request, "sjr");
		String sqh = ParamUtil.getString(request, "sqh");
		String sjrlxdh = ParamUtil.getString(request, "sjrlxdh");
		permit.setSlbh(slbh);
		permit.setCltjr(cltjr);
		try {
			permit.setHjgsz(Integer.parseInt(hjgsz));
			permit.setHjgsh(Integer.parseInt(hjgsh));
		} catch (Exception e) {
			// TODO: handle exception
		}

		permit.setCltjrlxdh(cltjrlxdh);
		permit.setSqr(sqr);
		permit.setCltjrlxdz(cltjrlxdz);
		permit.setSqsx(sqsx);
		permit.setSjr(sjr);
		permit.setSqh(sqh);
		permit.setSjrlxdh(sjrlxdh);
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response);
	}

	// 保存初审cs和sl
	public void saveCs(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] csyjs = ParamUtil.getParameterValues(request, "csyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setCsyj(csyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
		redirect(request, response);
	}

	// 保存复核fh和sh
	public void saveFh(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] fhyjs = ParamUtil.getParameterValues(request, "fhyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setFhyj(fhyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
		redirect(request, response);
	}

	// 保存审核sh和sp
	public void saveSh(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] shyjs = ParamUtil.getParameterValues(request, "shyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setShyj(shyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
		redirect(request, response);
	}

	public void redirect(ActionRequest request, ActionResponse response) throws IOException {
		String redirect = ParamUtil.getString(request, "redirectURL");
		String permitId = ParamUtil.getString(request, "permitId");
		redirect += "&" + response.getNamespace() + "permitId=" + permitId;
		response.sendRedirect(redirect);
	}

	// 施工许可
	public void sgxk(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException, DocumentException,
			com.lowagie.text.DocumentException {
		long permitId = ParamUtil.getLong(request, "permitId");
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29087);
		String newPDFPath = "F://jtjs//" + xmlx + "施工许可证书.pdf";
		Map<String, String> map = getMap(permitId, xmlx);
		fillTemplate(request, response, fileEntry, newPDFPath, map);
	}

	// 施工许可(绿色)
	public void sgxkls(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException, DocumentException,
			com.lowagie.text.DocumentException {
		long permitId = ParamUtil.getLong(request, "permitId");
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29017);
		String newPDFPath = "F://jtjs//" + xmlx + "施工许可证书(绿色通道).pdf";
		Map<String, String> map = getMap(permitId, xmlx);
		fillTemplate(request, response, fileEntry, newPDFPath, map);
	}

	// 生成许可证pdf
	public void fillTemplate(ActionRequest request, ActionResponse response, DLFileEntry fileEntry, String newPDFPath, Map<String, String> map)
			throws IOException, DocumentException, PortalException, SystemException, com.lowagie.text.DocumentException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();//
		PdfReader pdfReader = new PdfReader(fileEntry.getContentStream());
		File file = new File(newPDFPath);
		file.delete();
		FileOutputStream outputStream = new FileOutputStream(file);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfStamper pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
		AcroFields acroFields = pdfStamper.getAcroFields();
		int i = 0;
		Iterator<String> iterator = acroFields.getFields().keySet().iterator();
		while (iterator.hasNext()) {
			String data = iterator.next().toString();
			System.out.println("====================" + data);
			acroFields.setField(data, map.get(data));
			i++;
		}
		pdfStamper.setFormFlattening(true);
		pdfStamper.close();
		Document document = new Document();
		PdfCopy pdfCopy = new PdfCopy(document, outputStream);
		document.open();
		PdfImportedPage importedPage = pdfCopy.getImportedPage(new PdfReader(byteArrayOutputStream.toByteArray()), 1);
		pdfCopy.addPage(importedPage);
		document.close();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setIndexingEnabled(true);
		DLAppLocalServiceUtil.addFileEntry(20199, 20195, 28426, file.getName(), "application/pdf", CounterLocalServiceUtil.increment() + "", null,
				null, file, serviceContext);
	}

	public Map<String, String> getMap(long permitId, String xmlx) throws PortalException, SystemException {
		Map<String, String> map = new HashMap<String, String>();
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String title = "上海市(" + xmlx + ")工程施工许可证";
		String bh = permit.getYwbh();
		String gj = "";
		if (xmlx.equals("港口")) {
			gj = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		} else if (xmlx.equals("公路")) {
			gj = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		} else {
			gj = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		}
		String jsdw = projectProfile.getJsdwmc();
		String gcmc = projectProfile.getGcmc();
		String gcwz = projectProfile.getJsdd();
		String gcnr = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工";
		String xmtzgs = projectProfile.getXmtzgs() + "(万元)";
		String htjg = projectProfile.getHtjg() + "(万元)";
		String sjdw = "";
		String sgdw = "";
		String jldw = "";

		List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (ParticipationUnit participationUnit : participationUnits) {
			if (participationUnit.getDwlx().equals("设计单位")) {
				sjdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("施工单位")) {
				sgdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("监理单位")) {
				jldw = participationUnit.getDwmc();
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String jhkg = sdf.format(projectProfile.getJhkg());
		String jhjg = sdf.format(projectProfile.getJhjg());
		String jhkgrq = jhkg.substring(0, 4) + "年" + jhkg.substring(4, 6) + "月" + jhkg.substring(6, 8) + "日";
		String jhjgrq = jhjg.substring(0, 4) + "年" + jhjg.substring(4, 6) + "月" + jhjg.substring(6, 8) + "日";
		String bz = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		map.put("xmtzgs", xmtzgs);
		map.put("htjg", htjg);
		map.put("gcwz", gcwz);
		map.put("gcnr", gcnr);
		map.put("jsdw", jsdw);
		map.put("gcmc", gcmc);
		map.put("bh", bh);
		map.put("gj", gj);
		map.put("title", title);
		map.put("jhkgrq", jhkgrq);
		map.put("jhjgrq", jhjgrq);
		map.put("sgdw", sgdw);
		map.put("jldw", jldw);
		map.put("sjdw", sjdw);
		map.put("bz", bz);
		return map;
	}
	
	public static void provideSgxkzbh(long permitId) throws PortalException, SystemException{
		String ywbh = "JT";//JT
		Permit permit1 = PermitLocalServiceUtil.getPermit(permitId);
		ywbh = ywbh + permit1.getBjbh() + permit1.getBdh();//报建编号+标段号
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4);
		ywbh = ywbh + currentDateStr;//两位年份
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		ywbh = ywbh + xmlx.getCode();//类别
		
		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		int num = 1;
		for(Permit permit2:permits){
			String bjbh = permit2.getSgxkzbh().substring(2, 12);
			if(bjbh.equals(permit1.getBjbh())){
				num++;
			}
		}
		if (num / 10 < 1) {
			ywbh = ywbh + "00" + num;
		} else if (num / 100 < 1) {
			ywbh = ywbh + "0" + num;
		} else if (num / 1000 < 1) {
			ywbh = ywbh + num;
		}
	}
}
