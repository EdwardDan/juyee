package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.ProjBidAreaService;
import com.justonetech.biz.daoservice.ProjBidService;
import com.justonetech.biz.daoservice.ProjInfoAreaService;
import com.justonetech.biz.domain.ProjBid;
import com.justonetech.biz.domain.ProjBidArea;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.domain.ProjInfoArea;
import com.justonetech.biz.utils.enums.ProjBidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * description: 项目基本信息的业务类
 */
@Service
public class ProjInfoManager {

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjBidAreaService projBidAreaService;

    @Autowired
    private ProjInfoAreaService projInfoAreaService;

    /**
     * 初始化形象进度标段，自动创建一个标段
     *
     * @param projInfo .
     */
    public void initScheduleBid(ProjInfo projInfo) {
        //添加和修改项目时判断如果下面没有标段则自动创建一个形象进度标段，并且默认标段的所属区县与项目一致
        Set<ProjBid> projBids = projInfo.getProjBids();
        Boolean noTypeNode = true;//默认没有形象进度
        if (projBids != null && projBids.size() > 0) {
            for (ProjBid projBid : projBids) {
                String typeNode = projBid.getTypeCode();
                if (ProjBidType.TYPE_NODE.getCode().equals(typeNode)) {
                    noTypeNode = false;
                    break;
                }
            }
        }
        if (noTypeNode) {
            ProjBid projBid = new ProjBid();
            projBid.setTypeCode(ProjBidType.TYPE_NODE.getCode());
            projBid.setName(projInfo.getName());
            projBid.setCode("1");
            projBid.setProject(projInfo);
            projBidService.save(projBid);

            List<ProjInfoArea> areas = projInfoAreaService.findByQuery("from ProjInfoArea where project.id=?", projInfo.getId());
            for (ProjInfoArea area : areas) {
                ProjBidArea projBidArea = new ProjBidArea();
                projBidArea.setBelongArea(area.getBelongArea());
                projBidArea.setBid(projBid);
                projBidAreaService.save(projBidArea);
            }
        }
    }
}
