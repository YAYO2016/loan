<%@page import="com.framework.core.utils.CommonUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.framework.core.utils.GlobalConst"%>
<%@ page import="com.framework.core.entity.SessionBean"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%
	SessionBean sessionBean = (SessionBean)request.getSession().getAttribute(GlobalConst.SESSION_KEY);
	String userid = sessionBean.getUserId();
	String areaid = sessionBean.getAreaId();
	Map<String,String> authMap = sessionBean.getRoleMap();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<%@include file="/include.jsp"%>
	<style rel="stylesheet" type="text/css">
		.panel-title {
			    font-weight: bold;
			    color: #494949;
			    height: 30px;
			    line-height: 30px;
			    padding-left: 10px;
			    font-size:16px;
			}
		.panel-title i {
		    width: 5px;
		    height: 20px;
		    display: inline-block;
		    background-color: #f8a73d;
		    margin-right: 10px;
		    margin-top: 5px;
		    float: left;
		}
		td{
			font-family: "Microsoft YaHei" !important;
			font-size: 13px;
		}
		span{
			font-family: "Microsoft YaHei" !important;
		}
		.datagrid-cell span {
			font-family: "Microsoft YaHei" !important;
			font-size: 14px;
		}
		.datagrid-toolbar td {
			font-size: 13px;
		}
		.datagrid-toolbar {
		    height: auto;
		    background: none repeat scroll 0% 0% rgb(239, 239, 239);
		    padding: 1px 2px;
		    border-bottom: 1px solid rgb(204, 204, 204);
		}
		.panel datagrid {
		    border:1px;
		}
		.pagination .pagination-num{
			width: 45px;
			text-align: center;
		}
		a.l-btn span.l-btn-left{
			padding: 0px 8px;
		}
		a.l-btn-plain{
			width: 30px;
		}
	</style>
	<script type="text/javascript">
	//记录哪些环节保存过了
	var map = new Map();
	//流程类型
	var flowType = "";
	//当前处理环节
	var nowHandle = "";
	
	//#bcb0b0
	function buttonCss(clickNow){
		$("#btn_"+clickNow).css('background-color','06395a');
		var url = "";
		if(clickNow == 0){
			url = "";
		}
		$("iframe")[0].src = url;
		for(var i = 0; i< 8; i++){
			if(i == clickNow){
				continue;
			}
			if(!map.containsKey(i)){
				$("a").eq(i).css("backgroundColor","#bcb0b0");
			}else{
				$("a").eq(i).css("backgroundColor","#52a7e0");
			}
		}
		nowHandle = clickNow;
	}
	
	$(document).ready(function() {
		//如果operType是edit or view 去后台查询根据caseId
		if("add" == "${operType}"){
			
		}else{
			
		}
		if(map.isEmpty()){
			$("img").slice(0,7).css("display","none");
			$("a").slice(1,8).css("display","none");
			buttonCss(0);
			//下一步按钮置灰
			$('#btnNext').linkbutton('disable');
		}else{
			
		}
		
		//保存按钮
		$('#btnSave').bind('click', function() {
			//调用子界面的保存校验方法
			map.put(nowHandle, "1");
			
//			$("iframe")[0].contentWindow.$("")
// 			$('#formId').form('submit',{
// 				success:function(data) {
// 					var obj = jQuery.parseJSON(data);
// 					if (obj.success) {
// 						parent.fade();
// 						targeInfo = getTargetFromInfo();
// 					}
// 				}
// 			});
			//根据界面填写的信息，判断流程类型
			if(nowHandle == 0){//只有基本信息保存需要判断
				flowType = "1";
				//显示剩余步骤
				if(flowType == "1"){//全显示
					$("img").slice(0,7).css("display","block");
					$("a").slice(1,8).css("display","block");
				}else if(flowType == "2"){//
					
				}
				$("#dad").panel("setTitle","<i></i>案子流程信息【二手房】");
			}
			if("add" == "${operType}"){
				$('#btnNext').linkbutton('enable');
			}
			
		});
				
		//下一步按钮
		$('#btnNext').bind('click', function() {
			var opt = $('#btnNext').linkbutton('options');
		    if(!opt.disabled) {
		    	buttonCss(nowHandle+1);
			}
		});
		$("#btn_0").bind('click', function() {
			buttonCss(0);
		});
		$("#btn_1").bind('click', function() {
			buttonCss(1);
		});
		$("#btn_2").bind('click', function() {
			buttonCss(2);
		});
		$("#btn_3").bind('click', function() {
			buttonCss(3);
		});
		$("#btn_4").bind('click', function() {
			buttonCss(4);
		});
		$("#btn_5").bind('click', function() {
			buttonCss(5);
		});
		$("#btn_6").bind('click', function() {
			buttonCss(6);
		});
		$("#btn_7").bind('click', function() {
			buttonCss(7);
		});
		
	});
	
	</script>
</head>

<body >
	<div id="dad" title="<i></i>案子流程信息" style="padding-bottom:6px;height:auto" class="easyui-panel" data-options="collapsible:false">
		<form id="formId" enctype="multipart/form-data" method="post" >
		<div id="div1" style="height:45px;margin-left:30px;margin-right:30px;margin-top:8px;">
			<table width="100%" >
				<tr>
				<td width="5%" align="center">
					<a href="javascript:void(0);" id="btn_0"  class="easyui-linkbutton">基本信息</a>
				</td>
				<td id="td1" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td2" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_1"  class="easyui-linkbutton">贷款信息</a>
				</td>
				<td id="td3" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td4" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_2"  class="easyui-linkbutton">交易房产信息</a>
				</td>
				<td id="td5" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td6" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_3"  class="easyui-linkbutton">主贷人信息</a>
				</td>
				<td id="td7" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td8" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_4"  class="easyui-linkbutton">卖方信息</a>
				</td>
				<td id="td9" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td10" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_5"  class="easyui-linkbutton">中介信息</a>
				</td>
				<td id="td11" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td12" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_6"  class="easyui-linkbutton">材料信息</a>
				</td>
				<td id="td13" width="5%"  align="center">
					<img src="/images/u82.png">
				</td>
				<td id="td14" width="5%" align="center">
					<a href="javascript:void(0);" id="btn_7"  class="easyui-linkbutton">费用结算</a>
				</td>
				</tr>
			</table>
		</div>
		<div class="div_line"></div>
		<div style="height:40px;margin-top:5px;text-align:center">
			<a href="javascript:void(0);" id="btnDel" class="easyui-linkbutton" >重置</a>
			<a href="javascript:void(0);" id="btnSave" class="easyui-linkbutton" >保存</a>
			<a href="javascript:void(0);" id="btnNext" class="easyui-linkbutton" >下一步</a>
			<font id="namefont" color="red">点击下一步前先点击保存按钮</font>
		</div>
		<div>
			<iframe scrolling="auto" frameborder="0" src="/MainIndex/mainIndex.do" style="width:100%;height:100%;overflow-x:hidden;overflow:auto;"></iframe>
		</div>
		</form>
	</div>
	<div id="winCheck" class="easyui-window" data-options="closed:true,resizable:false"></div>
</body>

</html>