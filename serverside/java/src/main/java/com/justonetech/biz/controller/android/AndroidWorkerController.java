package com.justonetech.biz.controller.android;

import com.justonetech.biz.controller.query.ProjectQueryController;
import com.justonetech.biz.daoservice.WorkerInspectRecordService;
import com.justonetech.biz.daoservice.WorkerStopFormService;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.domain.WorkerInspectRecord;
import com.justonetech.biz.domain.WorkerStopForm;
import com.justonetech.biz.domain.bean.android.AndriodProjectInfoBjbh;
import com.justonetech.biz.domain.bean.android.AndroidCommonMsg;
import com.justonetech.biz.domain.bean.android.AndroidWorkerInspectRecord;
import com.justonetech.biz.domain.bean.android.AndroidWorkerStopForm;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * note:执法监督管理
 * User: Shaxj
 * Date: 14-12-24
 * Time: 下午2:04
 */
@Controller
public class AndroidWorkerController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidWorkerController.class);

    @Autowired
    private WorkerInspectRecordService workerInspectRecordService;

    @Autowired
    private WorkerStopFormService workerStopFormService;

    @Autowired
    private ProjectManager projectManager;

    /**
     * 保存现场检查记录
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveWorkerInspectRecord(@RequestBody AndroidWorkerInspectRecord result, Model model) throws Exception {
        WorkerInspectRecord target = new WorkerInspectRecord();

        Field[] fields = AndroidWorkerInspectRecord.class.getDeclaredFields();
        String msgs = "保存成功";
        try {
            for (Field field : fields) {
                PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), AndroidWorkerInspectRecord.class);
                //获得get方法
                Method readMethod = descriptor.getReadMethod();
                //执行get方法返回一个Object
                Object bean = readMethod.invoke(result);

                PropertyDescriptor pw = new PropertyDescriptor(field.getName(), WorkerInspectRecord.class);
                Method writeMethod = pw.getWriteMethod();
                // 反射写入数据
                writeMethod.invoke(target, bean);
            }

            workerInspectRecordService.save(target);
        } catch (Exception e) {
            msgs = "保存失败！";
        }

        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg(msgs);
        msg.setId(target.getId());
        msg.setType("workerInspectRecord");
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }

    /**
     * 保存执法管理停工单
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveWorkerStopForm(@RequestBody AndroidWorkerStopForm result, Model model) throws Exception {
        WorkerStopForm target = new WorkerStopForm();

        Field[] fields = AndroidWorkerStopForm.class.getDeclaredFields();
        String msgs = "保存成功";
        try {
            for (Field field : fields) {
                PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), AndroidWorkerStopForm.class);
                //获得get方法
                Method readMethod = descriptor.getReadMethod();
                //执行get方法返回一个Object
                Object bean = readMethod.invoke(result);

                PropertyDescriptor pw = new PropertyDescriptor(field.getName(), WorkerStopForm.class);
                Method writeMethod = pw.getWriteMethod();
                // 反射写入数据
                writeMethod.invoke(target, bean);
            }

            workerStopFormService.save(target);
        } catch (Exception e) {
            msgs = "保存失败！";
        }

        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg(msgs);
        msg.setId(target.getId());
        msg.setType("WorkerStopForm");
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }

    /**
     * 通过bjbh编号获取工程信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getProjectInfoByBjbh(String bjbh, Model model) {

        AndriodProjectInfoBjbh andriodProjectInfoBjbh = new AndriodProjectInfoBjbh();
        try {
            Map<String, Object> map = projectManager.getProjectInfo(bjbh);
            ShareProTobuild shareProTobuild = (ShareProTobuild) map.get("data");
            andriodProjectInfoBjbh.setSuccess(true);
            andriodProjectInfoBjbh.setBjbh(shareProTobuild.getBjbh());
            andriodProjectInfoBjbh.setFaren(shareProTobuild.getBuildUnitLegal());
            andriodProjectInfoBjbh.setTel(shareProTobuild.getBuildUnitTel());
        } catch (Exception e) {
            andriodProjectInfoBjbh.setSuccess(false);
        }

        model.addAttribute("msg", JSONArray.fromObject(andriodProjectInfoBjbh).toString());
        return "common/androidMsg";

    }

}
