package com.framework.web.controller.systemManage;
import java.util.ArrayList;
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
import com.framework.mybatis.mysql.pojo.DictAgency;
import com.framework.web.service.intf.systemManage.DictAgencyInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 中介管理
 * @author ljw
 */
@Controller
@RequestMapping("dictAgencyInfo")
public class DictAgencyInfoController extends BaseController{

	@Resource
    private DictAgencyInfoService dictAgencyInfoService;
	
	@RequestMapping("dictAgencyInfoIndex")
	public String excuteTotalInedx(ModelMap model,HttpServletRequest request) throws Exception {
		String type=request.getParameter("type");
		if("".equals(type)||null==type){
			model.put("role", "1");
			model.put("i", 1);
		}else if("2".equals(type)){
			model.put("role", "2");
			model.put("i", 1);
		}
		return "systemmanager/dictAgencyInfoIndex";
	}
	
	
	
	/**
	 * 字典管理查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getdictAgencyInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Object getdictAgencyInfoList(HttpServletRequest request) throws Exception {
		//获取查询条件参数
		String agency_name = (String)request.getParameter("agency_name");//中介名称
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("agencyName", agency_name);
		
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    String type=request.getParameter("type");
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=dictAgencyInfoService.queryList(queryMap);
	    Map<String, Object> returnMap=new HashMap<String, Object>();
	    returnMap.put("total", page.getTotal());
	    returnMap.put("rows", list);
		if(!"".equals(type)&null!=type){
			returnMap.put("role", "1");
		}else{
			returnMap.put("role", "2");
		}
        return returnMap;
	
	}
	
	
	
	/**
	 * 新增保存
	 * @param request
	 * @return
	 */
	@RequestMapping("doSaveDictAgencyInfo")
	@ResponseBody
	public AjaxJson  doSaveDictAgencyInfo(HttpServletRequest request ){
		AjaxJson json=new AjaxJson();
		String  agency_id=request.getParameter("agency_id");
		String  agency_name=request.getParameter("agency_name");
		String  agency_phone=request.getParameter("agency_phone");
		String  agency_address=request.getParameter("agency_address");
		String  boss_name=request.getParameter("boss_name");
		String  boss_mphone=request.getParameter("boss_mphone");
		String  boss_lphone=request.getParameter("boss_lphone");
		String  pm_name=request.getParameter("pm_name");
		String  pm_mphone=request.getParameter("pm_mphone");
		String  pm_lphone=request.getParameter("pm_lphone");
		String  bm_name=request.getParameter("bm_name");
		String  bm_mphone=request.getParameter("bm_mphone");
		String  bm_lphone=request.getParameter("bm_lphone");
		String  account_name=request.getParameter("account_name");
		String  khh_name=request.getParameter("khh_name");
		String  account_id=request.getParameter("account_id");
		DictAgency record=new DictAgency();
		record.setAccountId(account_id);
		record.setAccountName(account_name);
		record.setAgencyAddress(agency_address);
		record.setAgencyId(agency_id);
		record.setAgencyName(agency_name);
		record.setAgencyPhone(agency_phone);
		record.setBmLphone(bm_lphone);
		record.setBmMphone(bm_mphone);
		record.setBmName(bm_name);
		record.setBossLphone(boss_lphone);
		record.setBossMphone(boss_mphone);
		record.setBossName(boss_name);
		record.setKhhName(khh_name);
		record.setPmLphone(pm_lphone);
		record.setPmMphone(pm_mphone);
		record.setPmName(pm_name);
		try {
			dictAgencyInfoService.doSaveDictAgencyInfo(record);
			json.setSuccess(true);
			json.setMsg("新增成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败："+e.getMessage());
		}
		
		return json;
	}
	
	
}
