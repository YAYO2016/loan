package com.framework.web.controller.systemManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.controller.BaseController;
import com.framework.core.entity.AjaxJson;
import com.framework.mybatis.mysql.pojo.CfgUserRole;
import com.framework.web.service.intf.systemManage.CfgUserRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;



/**
 * 角色管理
 * @author ljw
 */
@Controller
@RequestMapping("cfgUserRole")
public class CfgUserRoleController extends BaseController{

	@Resource
    private CfgUserRoleService cfgUserRoleService;
	
	@RequestMapping("cfgUserRoleIndex")
	public String cfgUserInedx(ModelMap model) throws Exception {
		return "systemmanager/cfgUserRoleIndex";
	}
	
	/**
	 * 角色管理查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCfgUserRoleList",method = RequestMethod.POST)
	@ResponseBody
	public Object getCfgUserRoleList(HttpServletRequest request) throws Exception {
		//获取查询条件参数
		String roleId = (String)request.getParameter("role_id");//字典编码
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("roleId", roleId);
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=cfgUserRoleService.queryList(queryMap);
	    Map<String, Object> returnMap=new HashMap<String, Object>();
	    returnMap.put("total", page.getTotal());
	    returnMap.put("rows", list);
        return returnMap;
	}
	

	/**
	 * 新增保存
	 * @param request
	 * @return
	 */
	@RequestMapping("doSaveCfgUserRole")
	@ResponseBody
	public AjaxJson  doSaveCfgUserRole(HttpServletRequest request ){
		AjaxJson json=new AjaxJson();
		String  role_name=request.getParameter("role_name");
		String  role_id=request.getParameter("role_id");
		Map<String, Object> args=new HashMap<String, Object>();
		args.put("role_name", role_name);
		args.put("role_id", role_id);
		CfgUserRole cfgUserRole=new CfgUserRole();
		cfgUserRole.setRoleId(role_id);
		cfgUserRole.setUserId(role_name);
		try {
			cfgUserRoleService.doSaveCfgUserRole(cfgUserRole);
			json.setSuccess(true);
			json.setMsg("保存成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("保存失败："+e.getMessage());
		}
		
		return json;
	}
	
}
