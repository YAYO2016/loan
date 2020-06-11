package com.loan.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.service.DataAnalysisService;
import com.loan.web.common.JsonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @author liujianwen
 * 
 */
@RestController
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {

    @Autowired
    private DataAnalysisService dataAnalysisService;
    
    /**
     * 公司业务分析
     * @param period
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("companyAnalysis")
    public JsonData list(@RequestParam(value = "period") String period,
                         @RequestParam(value = "startTime") String startTime,
                         @RequestParam(value = "endTime") String endTime,
                         @RequestParam(value = "org_id") String org_id,
                         @RequestParam(value = "user_id") String user_id) {
    	
    	Map<String, Object>  params=new HashMap<String, Object>();
    	if (!StringUtils.isEmpty(org_id)) params.put("org_id", org_id);
    	if (!StringUtils.isEmpty(user_id)) params.put("user_id", user_id);
    	
    	List<Map<String, Object>>  list=null;
    	if("day".equals(period)){
	    	  params.put("startTime", startTime);
	          params.put("endTime", endTime);
    		  list=dataAnalysisService.getCompanyDay(params);
    		
    	}else if("month".equals(period)){
    		params.put("startTime", startTime+"-01");
        	params.put("endTime", endTime+"-30");
    		list=dataAnalysisService.getCompanyMonth(params);
    	}
    	
        return JsonData.getSucceed(list);
    }


    /**
     * 案子分析
     * @param period
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("dateAnalysisByType")
    public JsonData dateAnalysisByType(@RequestParam(value = "period") String period,
                         @RequestParam(value = "startTime") String startTime,
                         @RequestParam(value = "endTime") String endTime,
                         @RequestParam(value = "org_id") String org_id) {
    	
    	Map<String, Object>  params=new HashMap<String, Object>();
    	params.put("startTime", startTime);
        params.put("endTime", endTime);
        if (!StringUtils.isEmpty(org_id)) params.put("org_id", org_id);
    	
        List<Map<String, Object>>  list=null;
    	if("1".equals(period)){
    		  list=dataAnalysisService.getcaseNumByType(params);
    	}else if("2".equals(period)){
    		list=dataAnalysisService.getcaseNumByCaseType(params);
    	}else if("3".equals(period)){
    		list=dataAnalysisService.getcaseNumByOrgId(params);
    	}else if("4".equals(period)){
    		list=dataAnalysisService.getUserCaseNumByOrgId(params);
    	}
    	
        return JsonData.getSucceed(list);
    }
    
    /**
     * 获取公司基本信息
     * @param period
     * @return
     */
    @GetMapping("companyInfo")
    public JsonData companyInfo() {
    	
    	Map<String, Object>  params=new HashMap<String, Object>();
    	List<Map<String, Object>>  list=dataAnalysisService.getCompanyCount(params);
        return JsonData.getSucceed(list);
    }

   
    /**
     * 部门下拉框
     * @param 
     * @return
     */
    @GetMapping("orgInfo")
    public JsonData orgInfo() {
    	
    	Map<String, Object>  params=new HashMap<String, Object>();
    	List<Map<String, Object>>  list=dataAnalysisService.orgInfo(params);
        return JsonData.getSucceed(list);
    }

    
    
    /**
     * 根据部门获取人员
     * @param org_id
     * @return
     */
    @GetMapping("orgInfoByOrgId")
    public JsonData orgInfoByOrgId(@RequestParam(value = "org_id") String org_id) {
    	Map<String, Object>  params=new HashMap<String, Object>();
    	params.put("org_id", org_id);
    	List<Map<String, Object>>  list=dataAnalysisService.orgInfoByOrgId(params);
        return JsonData.getSucceed(list);
    }
    


    /**
     * 根据部门获取人员
     * @param org_id
     * @return
     */
    @GetMapping("getUserPageList")
    public JsonData getUserPageList(@RequestParam(value = "month") String month
    							    ,@RequestParam(value = "org_id") String org_id
    								,@RequestParam(value = "user_id") String user_id
    								,@RequestParam(value = "pageNum") Integer pageNum
    		                        ,@RequestParam(value = "pageSize") Integer pageSize) {
    	
    	LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
    	Map<String, Object>  params=new HashMap<String, Object>();
    	
    	if (!StringUtils.isEmpty(month)) params.put("month", month+"-01");
    	if (!StringUtils.isEmpty(org_id)&&!"0".equals(org_id)) params.put("org_id", org_id);
    	if (!StringUtils.isEmpty(user_id)&&!"0".equals(user_id)) params.put("user_id", user_id);
    	
    	LoanPageList<Map<String, Object>>  list=dataAnalysisService.getUserPageList(params,pageAttr);
        return JsonData.getSucceed(list.getDatas(), list.getPageInfo());
    }
    
    /**
     * 获取部门的信息头
     * @param org_id
     * @return
     */
    @GetMapping("getCompanyInfoByOrgId")
    public JsonData getCompanyInfoByOrgId(@RequestParam(value = "org_id") String org_id) {
    	Map<String, Object>  params=new HashMap<String, Object>();
    	params.put("org_id", org_id);
    	List<Map<String, Object>>  list=dataAnalysisService.getCompanyInfoByOrgId(params);
        return JsonData.getSucceed(list);
    }
    
    /**
     * 获取个人的信息头
     * @param org_id
     * @return
     */
    @GetMapping("getUserInfoByOrgId")
    public JsonData getUserInfoByOrgId(@RequestParam(value = "user_id") String user_id) {
    	Map<String, Object>  params=new HashMap<String, Object>();
    	params.put("user_id", user_id);
    	List<Map<String, Object>>  list=dataAnalysisService.getUserInfoByOrgId(params);
        return JsonData.getSucceed(list);
    }
}
