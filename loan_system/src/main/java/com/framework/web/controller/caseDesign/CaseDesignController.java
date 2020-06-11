package com.framework.web.controller.caseDesign;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.framework.core.controller.BaseController;
import com.framework.mybatis.mysql.commapper.UserInfoMapper;

@Controller
@RequestMapping("caseDesign")
public class CaseDesignController extends BaseController{

	private static Logger logger = Logger.getLogger(CaseDesignController.class);

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/**
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("caseDesignIndex")
	public ModelAndView caseDesignIndex(HttpServletRequest request,ModelMap model,HttpServletResponse response) throws Exception{
		String operType = request.getParameter("operType");
		String caseId = request.getParameter("caseId");
		if (operType == null || "add".equals(operType)) {
			//获取活动id序列
			model.put("caseId", "");
			model.put("operType", "add");
		//基本信息修改
		}else if("edit".equals(operType)||"view".equals(operType)){
			model.put("caseId", caseId);
			model.put("operType",operType);
		}
		return new ModelAndView("caseDesign/caseDesignIndex");
	}
	
}
