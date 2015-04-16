package com.justonetech.biz.controller.android;

import com.justonetech.biz.daoservice.PollingLawService;
import com.justonetech.biz.domain.bean.android.PollingLawList;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.biz.daoservice.BpmProjectGroupService;
import com.justonetech.biz.daoservice.PollingDictService;
import com.justonetech.biz.daoservice.PollingWorkGroupService;
import com.justonetech.biz.domain.*;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeService;
import com.justonetech.system.domain.SysCode;
import com.justonetech.system.domain.SysCodeDetail;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

/**
 * 获取巡查字典和工作组数据
 * User: yujun
 * Date: 12-8-27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AndroidSysDictController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidSysDictController.class);
    @Autowired
    private SysCodeService sysCodeService;

    @Autowired
    private PollingDictService pollingDictService;

    @Autowired
    private PollingLawService pollingLawService;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    /**
     * 获取代码表数据
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String getSysCode(Model model) {
        String hql = "from SysCode where 1=1 order by id desc";
        List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
        List<SysCode> list = sysCodeService.findByQuery(hql);
        for (SysCode sysCode : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("codeId", sysCode.getId());
            map.put("code", sysCode.getCode());
            map.put("description", sysCode.getDescription());
            map.put("isLeaf", sysCode.getIsLeaf());

            map.put("isReserved", sysCode.getIsReserved());
            map.put("name", sysCode.getName());
            if (sysCode.getParent() != null)
                map.put("parent", sysCode.getParent().getId());
            else
                map.put("parent", null);
            Set<SysCodeDetail> set = sysCode.getSysCodeDetails();
            List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
            for (SysCodeDetail sysCodeDetail : set) {
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("sysDetailId", sysCodeDetail.getId());
                map1.put("code", sysCodeDetail.getCode());
                map1.put("description", sysCodeDetail.getDescription());

                map1.put("isLeaf", sysCodeDetail.getIsLeaf());
                map1.put("isReserved", sysCodeDetail.getIsReserved());
                map1.put("isValid", sysCodeDetail.getIsValid());
                map1.put("name", sysCodeDetail.getName());
                if (sysCodeDetail.getParent() != null)
                    map1.put("parent", sysCodeDetail.getParent().getId());
                else
                    map1.put("parent", null);
                map1.put("tag", sysCodeDetail.getTag());
                map1.put("treeId", sysCodeDetail.getTreeId());
                if (sysCodeDetail.getSysCode() != null)
                    map1.put("sysCodeId", sysCodeDetail.getSysCode().getId());
                else
                    map1.put("sysCodeId", null);
                list1.add(map1);
            }
            map.put("sysCodeDetails", list1);
            lista.add(map);
        }
        model.addAttribute("msg", new JSONSerializer().exclude("*.class", "sysCodeDetails.sysCodeDetails").serialize(lista));
        return "common/msg";
    }

    /**
     * 获取巡查字典数据
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String getPollingDict(Model model) {
        String hql = "from PollingDict where 1=1 order by id desc";
        List<Map> pollingDictList = new ArrayList<Map>();

        List<PollingDict> list = pollingDictService.findByQuery(hql);
        for (PollingDict pollingDict : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pollingDictId", pollingDict.getId());
            map.put("refRule", pollingDict.getRefRule());
            map.put("name", pollingDict.getName());
            if (pollingDict.getReformType() != null)
                map.put("reformType", pollingDict.getReformType().getId());
            else
                map.put("reformType", null);

            if (pollingDict.getRegisterType() != null)
                map.put("registerType", pollingDict.getRegisterType().getId());
            else
                map.put("registerType", null);

            if (pollingDict.getSafeType() != null)
                map.put("safeType", pollingDict.getSafeType().getId());
            else
                map.put("safeType", null);

            if (pollingDict.getParent() != null)
                map.put("parentId", pollingDict.getParent().getId());
            else
                map.put("parentId", null);

            map.put("isLeaf", pollingDict.getIsLeaf());
            map.put("treeId", pollingDict.getTreeId());
            map.put("isValid", pollingDict.getIsValid());
            map.put("orderNo", pollingDict.getOrderNo());
            map.put("description", pollingDict.getDescription());
            map.put("createTime", pollingDict.getCreateTime());
            map.put("updateTime", pollingDict.getUpdateTime());
            map.put("updateUser", pollingDict.getUpdateUser());
            map.put("createUser", pollingDict.getCreateUser());
            pollingDictList.add(map);
        }

        model.addAttribute("msg", new JSONSerializer().exclude("*.class").prettyPrint(true).serialize(pollingDictList));
        return "common/msg";
    }

    /**
     * 获取法律法规
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String getPollingLaw(Model model, String type, String keyName, Long rn, Integer max) throws IOException, SQLException {
        if (null == max) max = 10;
        if (null == rn) rn = 1L;
        String sql = "select A.rn,A.id,A.stddocid,A.catalog,A.tksm,A.tkbh,A.lx,A.jdfl,A.iitemno,A.type,A.shotdes,A.descriptions " +
                " from(SELECT p.*, ROWNUM RN  from Polling_Law p where 1=1 ";

        if ("质量".equals(type) || "安全".equals(type))
            sql += " and p.lx='" + type + "' ";

        if (!StringHelper.isEmpty(keyName)) {
            sql += " and (";
            if (keyName.indexOf(".") == -1) {
                sql += "p.descriptions like '%" + keyName + "%' or ";
            }
            sql += "   p.catalog like '%" + keyName + "%' " +
                    " or p.tksm like '%" + keyName + "%' " +
                    "or p.tkbh like '%" + keyName + "%' ) ";
        }
        sql += "  and ROWNUM <" + (rn + max) + " ORDER BY p.id desc) A  WHERE A.RN >=" + rn + " ";

        List list = pollingLawService.findBySql(sql);
        List<PollingLawList> pollingLawLists = new ArrayList<PollingLawList>();
        if (null != list) {
            for (Object o : list) {
                PollingLawList p = new PollingLawList();
                Object[] objects = (Object[]) o;
                if (!StringHelper.isEmpty(String.valueOf(objects[0])) && isNum(String.valueOf(objects[0]).trim()) && !"null".equals(String.valueOf(objects[0])))
                    p.setRn(Integer.parseInt(String.valueOf(objects[0]).trim()));
                if (!StringHelper.isEmpty(String.valueOf(objects[1])) && isNum(String.valueOf(objects[1]).trim()) && !"null".equals(String.valueOf(objects[1])))
                    p.setId(Long.parseLong(String.valueOf(objects[1]).trim()));
                if (!StringHelper.isEmpty(String.valueOf(objects[2])) && isNum(String.valueOf(objects[2]).trim()) && !"null".equals(String.valueOf(objects[2])))
                    p.setStddocid(Long.parseLong(String.valueOf(objects[2]).trim()));
                p.setCatalog(String.valueOf(objects[3]));
                p.setTksm(String.valueOf(objects[4]));
                p.setTkbh(String.valueOf(objects[5]));
                p.setLx(String.valueOf(objects[6]));
                p.setJdfl(String.valueOf(objects[7]));
                if (!StringHelper.isEmpty(String.valueOf(objects[8])) && isNum(String.valueOf(objects[8]).trim()) && !"null".equals(String.valueOf(objects[8])))
                    p.setType(Integer.parseInt(String.valueOf(objects[8]).trim()));
                p.setIitemno(String.valueOf(objects[9]));
                p.setShotdes(String.valueOf(objects[10]));
                p.setDescriptions(ClobToString((Clob) objects[11]));
                pollingLawLists.add(p);
            }
        }
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(pollingLawLists));
        return "common/msg";
    }

    /**
     * 判断是否为数字
     *
     * @return .
     */
    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    public String ClobToString(Clob clob) throws SQLException, IOException {

        String reString = "";
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }

    /**
     * 获取工作组
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String getWorkGroup(Model model) {

        String hql = "from PollingWorkGroup where 1=1 order by id desc";
        List<Map<String, Object>> groupList = new ArrayList<Map<String, Object>>();
        List<PollingWorkGroup> list = pollingWorkGroupService.findByQuery(hql);
        for (PollingWorkGroup pollingWorkGroup : list) {
            Map<String, Object> groupMap = new HashMap<String, Object>();
            groupMap.put("groupId", pollingWorkGroup.getId());
            groupMap.put("area", pollingWorkGroup.getArea());
            groupMap.put("chargeUserName", pollingWorkGroup.getChargeUserName());
            groupMap.put("createTime", pollingWorkGroup.getCreateTime());
            groupMap.put("createUser", pollingWorkGroup.getCreateUser());
            groupMap.put("groupUser", pollingWorkGroup.getGroupUser());
            groupMap.put("memo", pollingWorkGroup.getMemo());
            groupMap.put("name", pollingWorkGroup.getName());
            groupMap.put("updateTime", pollingWorkGroup.getUpdateTime());
            groupMap.put("updateUser", pollingWorkGroup.getUpdateUser());
            groupList.add(groupMap);
        }
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(groupList));
        return "common/msg";
    }
}
