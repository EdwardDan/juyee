package com.justonetech.cp.quartz;

import java.util.Date;
import java.util.List;

import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;
import com.justonetech.cp.util.ProjectSync;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

public class PermitProjectSync implements MessageListener {
	private static Log _log = LogFactoryUtil.getLog(PermitProjectSync.class
			.getName());
	@Override
	public void receive(Message message) {
		_log.info(new Date() + "ProjectSync定时器任务已启动");
		try {
			List<Project> projectList=ProjectLocalServiceUtil.getProjects(0,10);
			for(Project project:projectList ){
				ProjectSync.projectSync(project.getBjbh());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
