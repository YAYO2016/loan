package com.framework.web.controller.systemManage;

import java.net.URLDecoder;
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
import com.framework.mybatis.mysql.pojo.CfgCustInfo;
import com.framework.web.service.intf.systemManage.CfgCustInfoService;
import com.framework.web.service.intf.systemManage.CommService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 干系人关系表/客户信息管理
 * @author ljw
 */
@Controller
@RequestMapping("cfgCustInfo")
public class CfgCustInfoController extends BaseController{

	@Resource
    private CfgCustInfoService cfgCustInfoService;
	
	@Resource
	private CommService  commService;
	
	@RequestMapping("cfgCustInfoIndex")
	public String excuteTotalInedx(ModelMap model,HttpServletRequest request) throws Exception {
		String type=request.getParameter("type");
		
		if("".equals(type)||null==type){
			model.put("role", "1");
			model.put("i", 1);
		}else if("2".equals(type)){
			model.put("role", "2");
			model.put("i", 1);
		}else if("3".equals(type)){
			String i=request.getParameter("i");
			model.put("i", i);
			model.put("role", "3");
		}
		
		return "systemmanager/cfgCustInfoIndex";
	}
	
	
	
	/**
	 * 客户信息管理配置查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getcfgCustInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Object getcfgCustInfoList(HttpServletRequest request) throws Exception {

		//获取查询条件参数
		String serchMsg = (String)request.getParameter("serchMsg");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("serchMsg", serchMsg);
		
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=cfgCustInfoService.queryList(queryMap);
	    Map<String, Object> returnMap=new HashMap<String, Object>();
	    returnMap.put("total", page.getTotal());
	    returnMap.put("rows", list);
	    String type=request.getParameter("type");
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
	@RequestMapping("doSaveCfgCustInfoManage")
	@ResponseBody
	public AjaxJson  doSaveCntRecomManage(HttpServletRequest request ){
		AjaxJson json=new AjaxJson();
		String  cust_id=request.getParameter("cust_id");
		String  cust_name=request.getParameter("cust_name");
		String  id_type=request.getParameter("id_type");
		String  id_number=request.getParameter("id_number");
		String  mobile_phone=request.getParameter("mobile_phone");
		String  land_phone=request.getParameter("land_phone");
		String  occup_type=request.getParameter("occup_type");
		String  income_source=request.getParameter("income_source");
		String  amount_value=request.getParameter("amount_value");
		String  co_type=request.getParameter("co_type");
		String  co_name=request.getParameter("co_name");
		String  co_phone=request.getParameter("co_phone");
		String  co_address=request.getParameter("co_address");
		String  account_name=request.getParameter("account_name");
		String  khh_name=request.getParameter("khh_name");
		String  account_id=request.getParameter("account_id");
		String stream_value=request.getParameter("stream_value");
		
		CfgCustInfo  cfgCustInfo=new CfgCustInfo();
		cfgCustInfo.setAccountId(account_id);
		cfgCustInfo.setAccountName(account_name);
		cfgCustInfo.setAmountValue(Double.parseDouble(amount_value));
		cfgCustInfo.setCoAddress(co_address);
		cfgCustInfo.setCoName(co_name);
		cfgCustInfo.setCoPhone(co_phone);
		cfgCustInfo.setCoType(co_type);
		cfgCustInfo.setCustId(cust_id);
		cfgCustInfo.setCustName(cust_name);
		cfgCustInfo.setIdNumber(id_number);
		cfgCustInfo.setIdType(id_type);
		cfgCustInfo.setIncomeSource(income_source);
		cfgCustInfo.setKhhName(khh_name);
		cfgCustInfo.setLandPhone(land_phone);
		cfgCustInfo.setMobilePhone(mobile_phone);
		cfgCustInfo.setOccupType(occup_type);
		cfgCustInfo.setStreamValue(stream_value);
		
		try {
			cfgCustInfoService.doSaveCfgCustInfoManage(cfgCustInfo);
			json.setSuccess(true);
			json.setMsg("保存成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("保存失败！");
		}
		return json;
	}
	
	
}
