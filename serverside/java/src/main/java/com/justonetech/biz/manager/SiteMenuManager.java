package com.justonetech.biz.manager;

import com.justonetech.biz.utils.UrlParser;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.mismenu.MisMenu;
import com.justonetech.system.utils.FormatUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户网站菜单
 */
@Service
public class SiteMenuManager {
    private static List<MisMenu> MIS_MENUS = null;
    private static Map<String, String[]> menuMap = null;

    //菜单定义
    private static String[] menu_XMXXHZ = new String[]{"xmxxhz", "项目信息汇总", "projectQueryStage/grid.do"};

    private static String[] menu_QYZZ = new String[]{"qyzzgl", "企业资质管理", "unitQualify/grid.do"};
    private static String[] menu_ZCRY = new String[]{"zcryzz", "注册人员资质", "personQualify/grid.do"};
    private static String[] menu_SLRY = new String[]{"slryzg", "三类人员资格", "slryQualify/grid.do"};


    private static String[] menu_SEWXM = new String[]{"sewxm", "项目信息填报", "projExtend/grid.do?flag=&xmsx=sewxm"};
    private static String[] menu_SEWWT = new String[]{"sewwtqd", "问题清单", "projExtendQuestion/grid.do?flag=&qdType=question"};
    private static String[] menu_SEWZR = new String[]{"sewzrqd", "责任清单", "projExtendQuestion/grid.do?flag=&qdType=duty"};

    private static String[] menu_QQDJ1012 = new String[]{"qqdj1012", "项目信息填报", "projExtend/grid.do?flag=qqdj&msg=1012&xmsx=qqdj1"};
    private static String[] menu_WTQD1012 = new String[]{"wtqd1012", "问题清单", "projExtendQuestion/grid.do?flag=qqdj&msg=1012&qdType=question"};
    private static String[] menu_ZRQD1012 = new String[]{"zrqd1012", "责任清单", "projExtendQuestion/grid.do?flag=qqdj&msg=1012&qdType=duty"};

    private static String[] menu_QQDJ1517 = new String[]{"qqdj1517", "项目信息填报", "projExtend/grid.do?flag=qqdj&msg=1517&xmsx=qqdj2"};
    private static String[] menu_WTQD1517 = new String[]{"wtqd1517", "问题清单", "projExtendQuestion/grid.do?flag=qqdj&msg=1517&qdType=question"};
    private static String[] menu_ZRQD1517 = new String[]{"zrqd1517", "责任清单", "projExtendQuestion/grid.do?flag=qqdj&msg=1517&qdType=duty"};

    private static String[] menu_JBXX = new String[]{"xmjbxxtb", "项目基本信息填报", "projInfo/grid.do"};
    private static String[] menu_BZBD = new String[]{"xmbzbdgl", "项目办证标段管理", "projBid/grid.do?typeCode=certStage"};
    private static String[] menu_XXBD = new String[]{"xxjdbdgl", "形象进度标段管理", "projBid/grid.do?typeCode=scheduleNode"};
    private static String[] menu_JSDW = new String[]{"jsdwgl", "建设单位管理", "projRelateDept/grid.do"};

    private static String[] menu_SDHZ = new String[]{"sdhz", "送达回证", "serviceReturn/grid.do"};

    private static String[] menu_YJGL = new String[]{"yjgl", "邮件管理", "oaMail/init.do"};

    private static String[] menu_XXFB = new String[]{"xxfb", "信息发布", "oaPublicInfo/grid.do?isZc="};
    private static String[] menu_DXPT = new String[]{"dxpt", "短信平台", "msgMessage/grid.do"};
    private static String[] menu_WCHYGL = new String[]{"wchygl", "外出会议管理", "oaMeetingOuter/grid.do"};
    private static String[] menu_NBHYGL = new String[]{"nbhygl", "内部会议管理", "oaMeeting/init.do"};
    private static String[] menu_CLSQ = new String[]{"clsq", "车辆申请", "oaCar/grid.do"};
    private static String[] menu_BGYPK = new String[]{"bgypk", "办公用品库", "oaThings/grid.do"};
    private static String[] menu_BGYPSQ = new String[]{"bgypsq", "办公用品申请", "oaThingsApply/grid.do"};
    private static String[] menu_LDYZGZAP = new String[]{"ldyzgzap", "领导一周工作安排", "oaWeekArrange/init.do"};
    private static String[] menu_XFGL = new String[]{"xfgl", "信访管理", "oaPetition/grid.do"};
    private static String[] menu_KSYZGZ = new String[]{"ksyzgz", "科室一周工作", "oaWorkPlan/grid.do"};
    private static String[] menu_GZDB = new String[]{"gzdb", "工作督办", "oaWorkWatch/init.do"};
    private static String[] menu_FWGL = new String[]{"fwgl", "发文管理", "oaSendFile/grid.do"};
    private static String[] menu_SWLCPZ = new String[]{"swlcpz", "收文流程配置", "oaReceiveStep/grid.do"};
    private static String[] menu_SWDJD = new String[]{"swdjd", "收文登记单", "oaReceive/grid.do"};

    private static String[] menu_ZZJGGL = new String[]{"zzjggl", "组织机构管理", "sysDept/init.do"};
    private static String[] menu_RSGL = new String[]{"rsgl", "人事管理", "sysPerson/grid.do"};
    private static String[] menu_ZHGL = new String[]{"zhgl", "账户管理", "sysUser/grid.do"};
    private static String[] menu_ZXYH = new String[]{"zxyh", "在线用户", "sysOnlineUser/grid.do"};
    private static String[] menu_CZRZ = new String[]{"czrz", "操作日志", "sysLog/grid.do"};

    private static String[] menu_SGXK = new String[]{"sgxkjb", "施工许可（旧版）", "sgPermit/grid.do"};
    private static String[] menu_QXSGXK = new String[]{"qxsgxkjb", "区县施工许可（旧版）", "areaSgPermit/grid.do"};

    private static void init() {
        if (menuMap == null) {
            menuMap = new HashMap<String, String[]>();
            menuMap.put(menu_XMXXHZ[0], menu_XMXXHZ);

            menuMap.put(menu_QYZZ[0], menu_QYZZ);
            menuMap.put(menu_ZCRY[0], menu_ZCRY);
            menuMap.put(menu_SLRY[0], menu_SLRY);

            menuMap.put(menu_SEWXM[0], menu_SEWXM);
            menuMap.put(menu_SEWWT[0], menu_SEWWT);
            menuMap.put(menu_SEWZR[0], menu_SEWZR);

            menuMap.put(menu_QQDJ1012[0], menu_QQDJ1012);
            menuMap.put(menu_WTQD1012[0], menu_WTQD1012);
            menuMap.put(menu_ZRQD1012[0], menu_ZRQD1012);

            menuMap.put(menu_QQDJ1517[0], menu_QQDJ1517);
            menuMap.put(menu_WTQD1517[0], menu_WTQD1517);
            menuMap.put(menu_ZRQD1517[0], menu_ZRQD1517);

            menuMap.put(menu_JBXX[0], menu_JBXX);
            menuMap.put(menu_BZBD[0], menu_BZBD);
            menuMap.put(menu_XXBD[0], menu_XXBD);
            menuMap.put(menu_JSDW[0], menu_JSDW);

            menuMap.put(menu_SDHZ[0], menu_SDHZ);

            menuMap.put(menu_YJGL[0], menu_YJGL);

            menuMap.put(menu_XXFB[0], menu_XXFB);
            menuMap.put(menu_DXPT[0], menu_DXPT);
            menuMap.put(menu_WCHYGL[0], menu_WCHYGL);
            menuMap.put(menu_NBHYGL[0], menu_NBHYGL);
            menuMap.put(menu_CLSQ[0], menu_CLSQ);
            menuMap.put(menu_BGYPK[0], menu_BGYPK);
            menuMap.put(menu_BGYPSQ[0], menu_BGYPSQ);
            menuMap.put(menu_LDYZGZAP[0], menu_LDYZGZAP);
            menuMap.put(menu_XFGL[0], menu_XFGL);
            menuMap.put(menu_KSYZGZ[0], menu_KSYZGZ);
            menuMap.put(menu_GZDB[0], menu_GZDB);
            menuMap.put(menu_FWGL[0], menu_FWGL);
            menuMap.put(menu_SWLCPZ[0], menu_SWLCPZ);
            menuMap.put(menu_SWDJD[0], menu_SWDJD);

            menuMap.put(menu_ZZJGGL[0], menu_ZZJGGL);
            menuMap.put(menu_RSGL[0], menu_RSGL);
            menuMap.put(menu_ZHGL[0], menu_ZHGL);
            menuMap.put(menu_ZXYH[0], menu_ZXYH);
            menuMap.put(menu_CZRZ[0], menu_CZRZ);

            menuMap.put(menu_SGXK[0], menu_SGXK);
            menuMap.put(menu_QXSGXK[0], menu_QXSGXK);
        }
    }

    /**
     * 获取左侧菜单
     *
     * @param request .
     * @return .
     */
    public static List<MisMenu> getMisMenus(HttpServletRequest request) {
        if (MIS_MENUS == null) {
            MIS_MENUS = new ArrayList<MisMenu>();
            String basePath = UrlParser.getFrontUrl(request);
            String url = basePath + "platform/jump.do?code={0}";

            MIS_MENUS.add(getMisMenu(menu_QYZZ, url));
            MIS_MENUS.add(getMisMenu(menu_ZCRY, url));
            MIS_MENUS.add(getMisMenu(menu_SLRY, url));

        }
        return MIS_MENUS;
    }

    private static MisMenu getMisMenu(String[] define, String url) {
        return new MisMenu(define[0], define[1], FormatUtil.format(url, define[0]));
    }

    /**
     * 获取菜单真实跳转链接
     *
     * @param menuCode .
     * @param account  .
     * @param name     .
     * @param type     .
     * @return .
     */
    public static String getActualLink(String menuCode, String account, String name, String type) {
        init();
        String[] menu = menuMap.get(menuCode);
        if (menu != null) {
            String link = menu[2];
            if (!link.contains("?")) {
                link += "?";
            } else {
                link += "&";
            }
            if (StringHelper.isEmpty(name)) {
                name = menu[1];
            }
            return link + "account=" + account + "&name=" + name + "&type=" + type;
        }
        return null;
    }
}
