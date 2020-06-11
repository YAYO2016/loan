package com.framework.web.controller.systemManage;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.controller.BaseController;
import com.framework.core.entity.AjaxJson;
import com.framework.mybatis.mysql.pojo.CfgDict;
import com.framework.web.service.intf.systemManage.CfgDictInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 字典管理
 * @author ljw
 */
@Controller
@RequestMapping("cfgDictInfo")
public class CfgDictInfoController extends BaseController{

	@Resource
    private CfgDictInfoService cfgDictInfoService;
	
	@RequestMapping("cfgCustInfoIndex")
	public String excuteTotalInedx(ModelMap model) throws Exception {
		return "systemmanager/cfgDictInfoIndex";
	}
	
	/**
	 * 字典管理查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getcfgDictInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Object getcfgDictInfoList(HttpServletRequest request) throws Exception {
		//获取查询条件参数
		String dict_id = (String)request.getParameter("dict_id");//字典编码
		String dict_name = (String)request.getParameter("dict_name");//字典名称
		String super_dict_id = (String)request.getParameter("super_dict_id");//上级字典编码
		
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("dictId", dict_id);
		queryMap.put("dictName", dict_name);
		queryMap.put("superDictId", super_dict_id);
		
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=cfgDictInfoService.queryList(queryMap);
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
	@RequestMapping("doSaveCfgCustInfoManage")
	@ResponseBody
	public AjaxJson  doSaveCntRecomManage(HttpServletRequest request ){
		AjaxJson json=new AjaxJson();
		String  dict_id=request.getParameter("dict_id");
		String  dict_name=request.getParameter("dict_name");
		String  super_dict_id=request.getParameter("super_dict_id");
		String  is_valid=request.getParameter("is_valid");
		String  dict_tab_name=request.getParameter("dict_tab_name");
		CfgDict cfgDict=new CfgDict();
		cfgDict.setDictId(dict_id);
		cfgDict.setDictName(dict_name);
		cfgDict.setDictTabName(dict_tab_name);
		cfgDict.setIsValid(is_valid);
		cfgDict.setSuperDictId(super_dict_id);
		try {
			cfgDictInfoService.doSaveCfgDict(cfgDict);
			json.setSuccess(true);
			json.setMsg("新增成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败："+e.getMessage());
		}
		return json;
	}
	
}
