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
import com.framework.web.service.intf.systemManage.DictSysFuncService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 菜单字典表
 * @author ljw
 */
@Controller
@RequestMapping("dictSysFunc")
public class DictSysFuncController extends BaseController{

	@Resource
    private DictSysFuncService dictSysFuncService;
	
	@RequestMapping("dictSysFuncIndex")
	public String dictSysFuncIndex(ModelMap model) throws Exception {
		return "systemmanager/dictSysFuncIndex";
	}
	
	/**
	 * 菜单字典查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDictSysFuncList",method = RequestMethod.POST)
	@ResponseBody
	public Object getDictSysFuncList(HttpServletRequest request) throws Exception {
		//获取查询条件参数
		String funcName = (String)request.getParameter("func_name");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("funcName", funcName);
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=dictSysFuncService.queryList(queryMap);
	    Map<String, Object> returnMap=new HashMap<String, Object>();
	    returnMap.put("total", page.getTotal());
	    returnMap.put("rows", list);
        return returnMap;
	}
}
