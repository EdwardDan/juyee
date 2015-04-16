package com.justonetech.biz.controller.syn;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.biz.domain.ExcelJdTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * description
 * User: WangFei
 * Date: 13-7-22 下午2:56
 */

@Controller
public class ExcelJdTasksPositionController extends BaseCRUDActionController {
    @Autowired
    ExcelJdTasksService excelJdTasksService;



    @RequestMapping
    public String map(Model model, Long id, String level) {
        model.addAttribute("id", id);
        model.addAttribute("level", !StringHelper.isEmpty(level)?level:"14");
        String pos = "";
        ExcelJdTasks excelJdTasks = excelJdTasksService.get(id) ;
        model.addAttribute("bjbh",excelJdTasks.getBjbh());
        if (excelJdTasks.getX() != null) {
            pos = "{'xmmc':'" + excelJdTasks.getProjectName() + "','bjbh':'" + excelJdTasks.getBjbh() + "','x':'" + excelJdTasks.getX() + "','y':'" + excelJdTasks.getY() + "'}";
        }
        model.addAttribute("pos", pos);

        return "view/syn/excelJdTasksPosition/map";
    }


    @RequestMapping
    public void markCheck(Long id,HttpServletResponse response){
       ExcelJdTasks excelJdTasks = excelJdTasksService.get(id);
        if(excelJdTasks.getX() == null){
            sendJSON(response,"未标注");
        }else {
            sendJSON(response,"已标注");
        }
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param id    .
     * @param x        .
     * @param y        .
     * @return .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, Long id, Double x, Double y) throws Exception {
        try {
            if (id!=null && x > 0 && y > 0) {
                ExcelJdTasks excelJdTasks = excelJdTasksService.get(id) ;
                excelJdTasks.setX(x);
                excelJdTasks.setY(y);
                excelJdTasksService.save(excelJdTasks);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "项目标注成功");
    }


}
