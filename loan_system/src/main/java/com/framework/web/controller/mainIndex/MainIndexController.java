package com.framework.web.controller.mainIndex;
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
@RequestMapping("homeMainIndex")
public class MainIndexController extends BaseController{

	private static Logger logger = Logger.getLogger(MainIndexController.class);

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/**
	 * 跳转主页面
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("mainIndex")
	public ModelAndView mainIndex(HttpServletRequest request,ModelMap model,HttpServletResponse response) throws Exception{
		try {
			//首先获取roleIds
			Set<String> roleIds = this.getSessionBean().getRoleMap().keySet();
			List<String> roles = new ArrayList<String>(roleIds);
			List<Map<String, Object>> menuList = userInfoMapper.selectMenuInfo(roles);
			List<Map<String, Object>> menuFirstList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> menusecondShowList = new ArrayList<Map<String, Object>>();
			Map<String,List<Map<String, Object>>> menusecondAllList = new HashMap<String,List<Map<String, Object>>>();
			List<Map<String, Object>> ss = null;
			String menuFirstId = null;
			String superId;
			for (Map<String, Object> menu : menuList) {
				if("0".equals(String.valueOf(menu.get("superId")))){
					menuFirstList.add(menu);
					if(menuFirstId == null){
						menuFirstId = String.valueOf(menu.get("menuId"));
					}
				}
			}
			for (Map<String, Object> menu : menuList) {
				superId = String.valueOf(menu.get("superId"));
				if(!"0".equals(superId)){
					if(!menusecondAllList.containsKey(superId)){
						ss = new ArrayList<Map<String, Object>>();
						ss.add(menu);
						menusecondAllList.put(superId, ss);
					}else{
						menusecondAllList.get(superId).add(menu);
					}
				}
			}
			menusecondShowList.addAll(menusecondAllList.get(menuFirstId));
			model.put("menuFirstList", menuFirstList);
			model.put("menusecondShowList", menusecondShowList);
			request.setAttribute("menusecondAllList", menusecondAllList);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return new ModelAndView("mainIndex/mainIndex");
	}
	
}
