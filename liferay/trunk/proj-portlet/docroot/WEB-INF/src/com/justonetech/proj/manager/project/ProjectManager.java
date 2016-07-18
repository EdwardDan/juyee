package com.justonetech.proj.manager.project;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
	// 区县
	public static List<String> getCountys() {

		List<String> list = new ArrayList<String>();
		list.add("浦东");
		list.add("崇明");
		list.add("杨浦");
		list.add("虹口");
		list.add("静安");
		list.add("徐汇");
		list.add("宝山");
		list.add("青浦");
		list.add("黄埔");
		list.add("闸北");
		list.add("嘉定");
		list.add("普陀");
		list.add("长宁");
		list.add("闵行");
		list.add("奉贤");
		list.add("金山");
		list.add("松江");

		return list;
	}

	/**
	 * 项目状态
	 * 
	 * @return
	 */
	public static List<String> getProjStatus() {

		List<String> list = new ArrayList<String>();
		list.add("在建");
		list.add("未开工");
		list.add("已完工");

		return list;
	}

	/**
	 * 业态类别
	 * 
	 * @return
	 */
	public static List<String> getIndustryCategory() {

		List<String> list = new ArrayList<String>();
		list.add("请选择");
		list.add("公路");
		list.add("城市道路");
		list.add("公交基础设施");
		list.add("轨道");
		list.add("内河");
		list.add("港口");
		list.add("机场");
		list.add("铁路");

		return list;
	}

	// 管理属性
	public static List<String> getManageAttr() {

		List<String> list = new ArrayList<String>();
		list.add("市属");
		list.add("区属");

		return list;
	}

	// 项目来源
	public static List<String> getProjSource() {

		List<String> list = new ArrayList<String>();
		list.add("原有项目");
		list.add("30号文内项目");
		list.add("调整项目");
		list.add("新增项目");

		return list;
	}

	// 项目属性
	public static List<String> getProjAttr() {

		List<String> list = new ArrayList<String>();
		list.add("十二五项目");
		list.add("2010-2012区区对接");
		list.add("2015-2017区区对接");
		list.add("新增项目");
		list.add("储备项目");

		return list;
	}

	// 道路等级
	public static List<String> getRoadLevel() {

		List<String> list = new ArrayList<String>();
		list.add("国道");
		list.add("省道");
		list.add("县道");
		list.add("乡道");

		return list;
	}

	// 道路技术等级
	public static List<String> getRoadTechLevel() {

		List<String> list = new ArrayList<String>();
		list.add("高速");
		list.add("快速");
		list.add("一级");
		list.add("二级");
		list.add("三级");
		list.add("四级");

		return list;
	}
	
	public static List<String> getCompanys() {

		List<String> list = new ArrayList<String>();
		list.add("建设公司");
		list.add("勘察单位");
		list.add("设计单位");
		list.add("施工单位");
		list.add("监理单位");

		return list;
	}
}
