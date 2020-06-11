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
import com.framework.web.service.intf.systemManage.CommService;

/**
 * 公共Controller
 * @author ljw
 *
 */
@Controller
@RequestMapping("common")
public class CommController extends BaseController{
	
	@Resource
	private CommService commService;
	
	@RequestMapping("getSeq")
	@ResponseBody
	public Object getSeq(HttpServletRequest request){
		AjaxJson json=new AjaxJson();
		Map<String, Object> args=new HashMap<String, Object>();
		String seq_name=request.getParameter("seq_name");
		
		if("".equals(seq_name)||null==seq_name){
			json.setSuccess(false);
			json.setMsg("序列名称为空！");
			return json;
		}
		args.put("seqName", seq_name);
		
		try {
			Map<String, Object> seqMap=commService.getSeq(args);
			json.setAttributes(seqMap);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	
	/**
	 * 获取下拉框信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="getDictByType", method = RequestMethod.GET)
	@ResponseBody
	public Object getLoanYears(HttpServletRequest request,
			HttpServletResponse response, 
			ModelMap model) throws Exception {
		String  type=request.getParameter("type");
		Map<String, Object>  queryMap=new HashMap<String, Object>();
		queryMap.put("superDictId", type);
		List<Map<String,Object>> resultList= new ArrayList<Map<String,Object>>();
		List<Map<String, Object>>  list=(List<Map<String, Object>>) commService.queryList(queryMap);
		
		Map<String, Object> resMap = null;
		for(Map<String, Object> map:list){
			resMap=new HashMap<String, Object>();
			resMap.put("name", map.get("dict_name"));
			resMap.put("value", map.get("dict_id"));
			resultList.add(resMap);
		}
		return resultList;
	}
	
	
	
	
	
}
