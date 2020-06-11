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

import com.framework.core.entity.AjaxJson;
import com.framework.mybatis.mysql.pojo.DictBank;
import com.framework.web.service.intf.systemManage.DictBankService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 银行信息管理
 * @author lenovo
 *
 */
@Controller
@RequestMapping("dictBank")
public class DictBankController {

	@Resource
    private DictBankService dictBankService;
	/**
	 * 跳转页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("dictBankIndex")
	public String cfgUserInedx(ModelMap model) throws Exception {
		return "systemmanager/dictBankIndex";
	}
	
	
	/**
	 * 银行信息管理查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDictBankList",method = RequestMethod.POST)
	@ResponseBody
	public Object getCfgUserList(HttpServletRequest request) throws Exception {
		//获取查询条件参数
		String bank_name = (String)request.getParameter("bank_name");
		String sub_branch_name = (String)request.getParameter("sub_branch_name");
		String branchName= (String)request.getParameter("branch_name");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("bankName", bank_name);
		queryMap.put("subBranchName", sub_branch_name);
		queryMap.put("branchName", branchName);
		
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=dictBankService.queryList(queryMap);
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
	@RequestMapping("doSaveDictBank")
	@ResponseBody
	public AjaxJson  doSaveCfgUser(HttpServletRequest request ){
		AjaxJson json=new AjaxJson();
		String  bankId=request.getParameter("bank_id");
		String  bankName=request.getParameter("bank_name");
		String  branchId=request.getParameter("branch_id");
		String  branchName=request.getParameter("branch_name");
		String  subBranchId=request.getParameter("sub_branch_id");
		String  subBranchName=request.getParameter("sub_branch_name");
		DictBank record=new DictBank();
		
		try {
			record.setBankId(bankId);
			record.setBankName(bankName);
			record.setBranchId(branchId);
			record.setBranchName(branchName);
			record.setSubBranchId(subBranchId);
			record.setSubBranchName(subBranchName);
			dictBankService.doSaveDictBank(record);
			json.setSuccess(true);
			json.setMsg("保存成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("保存失败："+e.getMessage());
		}
		
		return json;
	}
	

}
