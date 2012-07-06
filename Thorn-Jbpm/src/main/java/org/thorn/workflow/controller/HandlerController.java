package org.thorn.workflow.controller;

import javax.servlet.http.HttpServletRequest;

import org.jbpm.api.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thorn.web.controller.BaseController;
import org.thorn.web.entity.Status;

/**
 * @ClassName: HandlerController
 * @Description:
 * @author chenyun
 * @date 2012-6-28 下午08:28:04
 */
@Controller
public class HandlerController extends BaseController {

	static Logger log = LoggerFactory.getLogger(HandlerController.class);

	
	/**
	 * 流程处理的入口方法
	 * @Description：
	 * @author：chenyun 	        
	 * @date：2012-6-28 下午08:40:13
	 * @param request
	 * @param taskId	任务实例ID
	 * @param titile	标题
	 * @param outcome	下一环节的线名称，多个环节需要指定
	 * @param flowInstId	流程实例ID
	 * @param flowKey		
	 * @return
	 */
	@RequestMapping("/wf/cm/handlerTask")
	@ResponseBody
	public Status handlerTask(HttpServletRequest request, String taskId,
			String titile, String outcome, String flowInstId, String flowKey) {
		Status status = new Status();

		return status;
	}

}