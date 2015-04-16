package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.core.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * description:项目审批业务类
 * User: Chenjp
 * Date: 14-6-23 下午1:43
 */
@Service
public class NetAcceptManager {
    private Logger logger = LoggerFactory.getLogger(NetAcceptManager.class);

    @Autowired
    private NetOpLogService netOpLogService;

    @Autowired
    private NetApplyFbTypeService netApplyFbTypeService;

    @Autowired
    private NetAcceptStatusService netAcceptStatusService;

    @Autowired
    private NetApplyService netApplyService;

    @Autowired
    private NetCfbService netCfbService;

    @Autowired
    private NetContractService netContractService;

    @Autowired
    private NetMonitorService netMonitorService;

    @Autowired
    private NetSgpermitService netSgpermitService;

    @Autowired
    private NetAcceptStepService netAcceptStepService;

    /**
     * 获取第1步状态
     *
     * @param matterCode 事项编码，在NetMatterDefine中定义
     * @return .
     */
    public NetAcceptStatus getFirstStatus(String matterCode) {
        return netAcceptStatusService.findUnique("from NetAcceptStatus where acceptStep.matterCode=? and isStart=1", matterCode);
    }

    /**
     * 获取步骤列表
     * @param matterCode 事项编码，在NetMatterDefine中定义
     * @return .
     */
    public List<NetAcceptStep> getSteps(String matterCode){
        return  netAcceptStepService.findByQuery("from NetAcceptStep where matterCode=? order by no,id asc",matterCode);
    }

    /**
     * 获取项目信息
     *
     * @param bjbh .
     * @return .
     */
    public NetApply getProject(String bjbh) {
        return netApplyService.findUnique("from NetApply where bjbh=? and isImportant=1", bjbh);
    }

    /**
     * 获取项目信息(非重大项目也能获取项目信息)
     *
     * @param bjbh .
     * @return .
     */
    public NetApply getProjectUnLimit(String bjbh) {
        return netApplyService.findUnique("from NetApply where bjbh=?", bjbh);
    }

    /**
     * 获取承发包记录并按分类整理
     *
     * @param bjbh .
     * @return .
     */
    public Map<String,List<NetCfb>> getCfbRecordByBjbh(String bjbh) {
        Map<String,List<NetCfb>> map = new HashMap<String, List<NetCfb>>();
        List<NetCfb> list = netCfbService.findByQuery("from NetCfb where apply.bjbh =? order by fbType.id asc,netDate asc,createTime asc",bjbh);
        for (NetCfb netCfb : list) {
            //bidMethod：发包方式（public公开招标，direct直接发包）
            //fbTypeCode：节点类型（施工sg、监理jl、勘察kc、设计sj）
            String key = netCfb.getBidMethodCode()+"_"+netCfb.getFbType().getCode();
            List<NetCfb> netCfbs = map.get(key);
            if(netCfbs==null) netCfbs = new ArrayList<NetCfb>();
            netCfbs.add(netCfb);
            map.put(key,netCfbs);
        }
        return map;
    }

    /**
     * 获取备案记录并按分类整理
     *
     * @param bjbh .
     * @return .
     */
    public Map<String,List<NetContract>> getContractRecordByBjbh(String bjbh) {
        Map<String,List<NetContract>> map = new HashMap<String, List<NetContract>>();
        List<NetContract> list = netContractService.findByQuery("from NetContract where apply.bjbh =? order by contractType.id asc,netDate asc,createTime asc",bjbh);
        for (NetContract data : list) {
            //fbTypeCode：节点类型（施工sg、监理jl、勘察kc、设计sj）
            String key = data.getContractType().getCode();
            List<NetContract> netContracts = map.get(key);
            if(netContracts==null) netContracts = new ArrayList<NetContract>();
            netContracts.add(data);
            map.put(key,netContracts);
        }
        return map;
    }

    /**
     * 获取操作日志
     * @param bizClass .
     * @param bizId .
     * @return .
     */
    public List<NetOpLog> getNetOpLogs(String bizClass,Long bizId) {
        return netOpLogService.findByQuery("from NetOpLog where bizClass=? and bizId=? order by acceptStatus.acceptStep.no asc,acceptStatus.no asc", bizClass, bizId);
    }

    /**
     * 移除操作日志
     * @param bizClass .
     * @param bizId  .
     */
    private void removeNetOpLogs(String bizClass,Long bizId) {
        List<NetOpLog> netOpLogs = getNetOpLogs(bizClass, bizId);
        for (NetOpLog netOpLog : netOpLogs) {
            netOpLogService.delete(netOpLog);
        }
    }

    /**
     * 根据受理编号获取日期
     *
     * @param str .
     * @return sqlDate
     */
    public java.sql.Date getDateFromCode(String str) {
        java.sql.Date ret = null;
        str = str.trim();
        if (!StringHelper.isEmpty(str) && str.length() > 8) {
            String dt = str.substring(1, 9);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date date = null;
            try {
                date = format.parse(dt.toString());
            } catch (ParseException e) {
            }
            ret = new java.sql.Date(date.getTime());
        }
        return ret;
    }

    /**
     * 删除报建所有相关记录
     * @param id .
     * @throws Exception
     */
    public void deleteAll(Long id) throws Exception {
        NetApply netApply = netApplyService.get(id);

        //承发包类型
        Set<NetApplyFbType> netApplyFbTypes = netApply.getNetApplyFbTypes();
        for (NetApplyFbType netApplyFbType : netApplyFbTypes) {
            netApplyFbTypeService.delete(netApplyFbType);
        }

        //承发包
        Set<NetCfb> netCfbs = netApply.getNetCfbs();
        for (NetCfb netCfb : netCfbs) {
            removeNetOpLogs(NetCfb.class.getSimpleName(),netCfb.getId());
            netCfbService.delete(netCfb);
        }

        //合同备案
        Set<NetContract> netContracts = netApply.getNetContracts();
        for (NetContract netContract : netContracts) {
            removeNetOpLogs(NetContract.class.getSimpleName(),netContract.getId());
            netContractService.delete(netContract);
        }

        //项目报监
        Set<NetMonitor> netMonitors = netApply.getNetMonitors();
        for (NetMonitor netMonitor : netMonitors) {
            removeNetOpLogs(NetMonitor.class.getSimpleName(),netMonitor.getId());
            netMonitorService.delete(netMonitor);
        }

        //施工许可
        Set<NetSgpermit> netSgpermits = netApply.getNetSgpermits();
        for (NetSgpermit netSgpermit : netSgpermits) {
            removeNetOpLogs(NetSgpermit.class.getSimpleName(),netSgpermit.getId());
            netSgpermitService.delete(netSgpermit);
        }

        //删除申报日志记录
        removeNetOpLogs(NetApply.class.getSimpleName(),netApply.getId());

        //删除主记录
        netApplyService.delete(netApply);
    }
}
