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
	var bigType;
	var selectType;
	var operType;
	var activeId;
	var url = '';
	$(document).ready(function() {
		$('#bigType').combobox('setValue',$("#product_typeb").val());
		bigType = $('#bigType').combobox('getValue');
		selectType = $("#product_typeb").val();
		operType = parent.$('#operType').val();
		activeId = parent.$('#activeId').val();
		//搜索
		$('#btnSearch').bind('click', function() {
			searchMethod();
		});
		
	    document.onkeydown=function(event){
	        var e = event || window.event || arguments.callee.caller.arguments[0];
	        if(e && e.keyCode==13) {
	    		searchMethod();
	        }
	    };
		
	    resultDataGrid("/condSuccess/bestBuyList.do?bigtype="+$('#bigType').combobox('getValue')+"&searchContent=");
		
		var url = "";
		if(operType!=""&&operType=="edit") {
			url = "/bestBuy/bestBuySelectedList.do?activeId="+activeId+"&stepId="+$("#stepId").val();
			$('#btnSave_tjcp').removeAttr('style');
		}else if(operType=="view"){
			url = "/bestBuy/bestBuySelectedList.do?activeId="+activeId+"&stepId="+$("#stepId").val();
			$('#btnSave_tjcp').attr('style','display:none');
			$('#left').linkbutton('disable');
			$('#right').linkbutton('disable');
		}
		selectedDataGrid(url);
		$('#left').bind('click', function() {
			var opt = $('#left').linkbutton('options');
			var bigtype = $('#bigType').combobox('getValue');
			if(!opt.disabled) {
				var resultRows = $('#resultDataGrid').datagrid('getSelections');
				$('#selectedDataGrid').datagrid('selectAll');
			    var selectRows= $('#selectedDataGrid').datagrid('getSelections');
				if (resultRows.length == 0) {
					$.messager.alert('提示','请先勾选您要选择的产品！');
					return;
				} else{
					//比较是否已经选择过该产品
					if (selectRows.length>0) {
						var product_typeb = resultRows[0].product_type_b;
						for ( var i = 0; i < resultRows.length; i++) {
							for ( var j = 0; j < selectRows.length; j++) {
								if( product_typeb== 1 || product_typeb == 3){
									if ( resultRows[i].product_id == selectRows[j].product_id ) {
										$.messager.show({
											title:'提示',
											msg:'您已经选择过"'+selectRows[j].product_id+'['+selectRows[j].product_name+']",请重新选择！',
											timeout:2000,
											showType:'fade'
										});
							    		$('#selectedDataGrid').datagrid('unselectAll');
										return;
									}
								}else{
									if ( resultRows[i].product_id == selectRows[j].product_id && resultRows[i].product_id_exp == selectRows[j].product_id_exp) {
										$.messager.show({
											title:'提示',
											msg:'您已经选择过"'+selectRows[j].product_id+'['+selectRows[j].product_name+']",请重新选择！',
											timeout:2000,
											showType:'fade'
										});
							    		$('#selectedDataGrid').datagrid('unselectAll');
										return;
									}
								}
							}
						}
					}
					$('#selectedDataGrid').datagrid('unselectAll');
		    		for ( var i = 0; i < resultRows.length; i++) {
						$('#selectedDataGrid').datagrid('appendRow',{
							product_id: resultRows[i].product_id,
							product_name: resultRows[i].product_name,
							product_type_b: resultRows[i].product_type_b,
							product_type_bname: resultRows[i].product_type_bname,
							product_id_exp:resultRows[i].product_id_exp,
							product_id_exp1:resultRows[i].product_id_exp1,
							area_code:resultRows[i].area_code,
							area_name:resultRows[i].area_name,
							is_one_key:resultRows[i].is_one_key,
							pro_sub_type:resultRows[i].pro_sub_type
						});
					}
				}
			}
		});
		
		$('#right').bind('click', function() {
			 var opt = $('#right').linkbutton('options');
			 if(!opt.disabled) {
				 var rows = $('#selectedDataGrid').datagrid('getSelections');
				 for(var i=0;i<rows.length;i++){
					 var index = $('#selectedDataGrid').datagrid('getRowIndex', rows[i]);
					 $('#selectedDataGrid').datagrid('deleteRow', index);
				 }
			 }
		});
		$('#btnSave_tjcp').bind('click', function() {
			 var opt = $('#btnSave_tjcp').linkbutton('options');
			 if(!opt.disabled) {
				 var inserted = $('#selectedDataGrid').datagrid('getRows', "inserted");
	             var effectRow = new Object();
	             if (inserted.length) {
	            	 
	                 effectRow["inserted"] = JSON.stringify(inserted);
	             }
	             if(frameId.indexOf("markChanSTYYT") != -1 || frameId.indexOf("markChanOUTCALL") != -1 ){
	        		 if(inserted.length > 1){
	        			 $.messager.alert('提示', '最多只能选一个产品！','info');
	        			 return;
	        		 }
	    		 }
	             var productName = "";
	             for(i= 0;i<inserted.length;i++){
	            	 productName+= inserted[i].product_name+",";
	             }
	             if(productName!=null && productName!=""){
	            	 productName=productName.substring(0,productName.length-1);
	             }
	             $.post("/bestBuy/doUpdateAsFormInfo.do?activeId="+parent.$('#activeId').val()+"&stepId="+$('#stepId').val()+"&operType="+$('#operType').val(), effectRow, function(rsp) {
	                 if(rsp.success){
			                bestBuyInfo = getBestBuyInfo();
			                $.messager.alert('提示', '保存产品成功！','info',function(){
								parent.$('#'+frameId)[0].contentWindow.$('#products').val(productName);
								parent.$('#winPreview').window('close');
							}); 
	                 }else{
	                	 parent.failFade();
	                	 $('#selectedDataGrid').datagrid('clearSelections'); 
	                 }
	             }, "JSON").error(function() {
	            	 parent.failFade();   
		             $('#selectedDataGrid').datagrid('clearSelections'); 
	             });
		    }
		});
	});
	
	function searchMethod(){
		var bigtype = $('#bigType').combobox('getValue');
		var searchContent = $('#searchContent').val();
		var url = "/condSuccess/bestBuyList.do?bigtype="+bigtype+"&protype=all&searchContent="+searchContent;
		url = encodeURI(url);
		var rows = $('#selectedDataGrid').datagrid('getRows');
		if(rows.length > 0 && bigtype != selectType){
		 	$.messager.confirm('确认', '您选择的大类与之前产品大类不同，确定删除已选产品？', 
				function(r){
					if (r){
			 			$('#selectedDataGrid').datagrid('loadData', { total: 0, rows: [] }); 
			 			resultDataGrid(url);
			 			selectedDataGrid("");
						selectType = bigtype;
			 		}else{
			 			bigtype = $('#bigType').combobox("setValue",selectType);
			 		}
 				});
		 }else{
		 	resultDataGrid(url);
			selectType = bigtype;
		 }
    }
	
	function selectedDataGrid(url){
		$('#selectedDataGrid').datagrid({
		 	url:url,
		    fitColumns: false,
		    singleSelect: false,
			loadMsg:'加载中...',
			striped: true,
		    fit: true,
			rownumbers: true,
			pagination: false,
			pageNumber:1,
	   		pageList: [7],
	   		onLoadSuccess : function(data) {
				bestBuyInfo = getBestBuyInfo();
			},
			columns:[[
			          	{checkbox:true},
			          	{field:'product_id_exp',title:'活动编码',width:150,align:'center',hidden:true, formatter: function(value,row,index){
			          		return "<span title='" + value + "'>" + value + "</span>";
						}},
			          	{field:'product_id',title:'优惠编码',width:150,align:'center',hidden:false, formatter: function(value,row,index){
			          		return "<span title='" + value + "'>" + value + "</span>";
						}},
				        {field:'product_name',title:'优惠名称',width:150,align:'center',hidden:false, formatter: function(value,row,index){
				        	return "<span title='" + value + "'>" + value + "</span>";
						}},
						{field:'product_id_exp1',title:'服务编码',width:150,align:'center',hidden:true, formatter: function(value,row,index){
			          		return "<span title='" + value + "'>" + value + "</span>";
						}},
						{field:'product_type_b',title:'产品类型',width:150,align:'center',hidden:true, formatter: function(value,row,index){
							if(value == null){
								value = '-';
							}
							return "<span title='" + value + "'>" + value + "</span>";
						}},
						{field:'product_type_bname',title:'产品类型',width:150,align:'center',hidden:true, formatter: function(value,row,index){
							if(row.type == null){
								value = '-';
							}
							return "<span title='" + value + "'>" + value + "</span>";
						}},
						{field:'area_code',title:'地市编码',width:150,align:'center',hidden:true, formatter: function(value,row,index){
							if(value == null) value = '-';
							return "<span title='" + value + "'>" + value + "</span>";
						}},
						{field:'area_name',title:'地市',width:150,align:'center',hidden:true, formatter: function(value,row,index){
							if(value == null) value = '-';
							return "<span title='" + value + "'>" + value + "</span>";
						}}
				    ]]
		}); 
	}
	
	function resultDataGrid(url){
		$('#resultDataGrid').datagrid({
		 	url:url,
		    fitColumns: true,
		    singleSelect: false,
			loadMsg:'加载中...',
			striped: true,
		    fit: true,
		    doSize:true,
			rownumbers: true,
			pagination: true,
			pageNumber:1,
	   		pageList: [7],
	   		onLoadSuccess : function(data) {
				if(data==null || data==""){
					$('#resultDataGrid').datagrid("reload");
				}
			},
	   		columns:[[
	  	          	{checkbox:true},
	  	          	{field:'product_id_exp',title:'活动编码',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  	          		return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  	          	{field:'product_id_exp_name',title:'活动名称',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  	          		return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  	          	{field:'product_id',title:'优惠编码',width:150,align:'center',hidden:false, formatter: function(value,row,index){
	  	          		return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  		        {field:'product_name',title:'优惠名称',width:150,align:'center',hidden:false, formatter: function(value,row,index){
	  		        	return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  				{field:'product_id_exp1',title:'服务编码',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  	          		return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  				{field:'product_type_b',title:'产品类型',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  					return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  				{field:'product_type_bname',title:'产品类型',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  					return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  				{field:'area_code',title:'地市编码',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  					if(value == null) value = '-';
	  					return "<span title='" + value + "'>" + value + "</span>";
	  				}},
	  				{field:'area_name',title:'地市',width:150,align:'center',hidden:true, formatter: function(value,row,index){
	  					if(value == null) value = '-';
	  					return "<span title='" + value + "'>" + value + "</span>";
	  				}}
	  		    ]]
		}); 
	}
	</script>
</head>

<body >
	<div id="buttonDiv">
	<table  width="100%" height="auto" bgcolor="#FFFFFF" >
		<tr>
	  		<td height="auto"  bgcolor="#FFFFFF" align="center">
				<a href="javascript:void(0);" id="btnSave" class="easyui-linkbutton" >保存</a>
				<a href="javascript:void(0);" id="btnDel" class="easyui-linkbutton" >删除</a>
				<a href="javascript:void(0);" id="btnCopy" class="easyui-linkbutton" >复制</a>
			</td>
		</tr>
	</table>
	</div>
	<div title="<i></i>基本信息" style="padding-bottom:6px;height:auto" class="easyui-panel" data-options="collapsible:false">
		<form id="basicInfoFormId" action="/basicInfo/doSaveAsFormInfo.do" enctype="multipart/form-data" method="post" >
			<input type="hidden" id="operType" name="operType" value="${operType}"/>
			<input type="hidden" id="subactId" name="subactId" value="${subactId}"/>
			<table width="100%" border="0" align="center" bgcolor="#FFFFFF">
				<tr height="50px;">
					<td class="label">活动名称：<font id="namefont" color="red">*</font></td>
					<td>
						<input id="activename" name="activename" class="easyui-validatebox input"
							   style="width: 235px;height:23px;font-size: 13px;" data-options="required:true,validType:'vname'"
							   value="${basicInfo.activename}"></input>
					 </td>
				</tr>
				<tr>
					<td class="label">开始日期：<font color="red">*</font></td>
					<td>
					<input id="begindate" name="begindate" class="Wdate" style="width: 235px;height:28px" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',isShowClear:false,readOnly:true})" disabled="disabled" value="${basicInfo.begindate}" >
					</td>
					<td class="label">结束日期：<font color="red">*</font></td>
					<td>
					<input id="enddate" name="enddate" class="Wdate" style="width: 235px;height:28px" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',isShowClear:false,readOnly:true})" disabled="disabled" value="${basicInfo.enddate}"></input>
					</td>
				</tr>
			</table>
			<div class="div_line"></div>
			<c:if test="${operType ne 'view'}">
			<div id="div1" style="height:50px;margin-left:170px">
			<table width="100%" >
				<tr>
				<td>
				<table>
				<tr>
				<td>
					<select class="easyui-combobox" panelHeight="auto" id="bigType" name="bigType" style="width:120px;">
						<option value="1"  >优惠（套餐）</option>
						<option value="2"  >营销活动</option>
						<option value="3"  >服务</option>
						<option value="4"  >平台业务</option>
						<option value="5"  >产品变更</option>
						<option value="6"  >积分变更</option>
						<option value="7"  >换卡</option>
						<option value="8"  >宽带</option>
					</select>
					<input type="hidden" id="product_type_b" name="product_type_b" value="${product_type_b }"/>
				</td>
				<td>
				<input  class="easyui-validatebox input" type="text" id="searchContent" name="searchContent"  data-options="tipPosition:'left',required:false" style="width:200px">
				</td>
				<td>
				<a href="javascript:void(0);" id="btnSearch" name="btnSearch"  class="easyui-linkbutton" >搜索</a>
				<span><font color="#FF0000">（根据产品编码或者产品名称模糊查询）</font></span>	
				</td>
				</tr>
				</table>
				</td>
				<td  align="right">
				<div><a href="javascript:void(0);" id="btnSave_tjcp" class="easyui-linkbutton" style="display:none">保存</a>
				</div>
				</td>
				</tr>
			</table>
			</div>
			</c:if>
			
			<div id="div2" style="margin-left:50px">
			<table >
			<c:choose>
				<c:when test="${operType ne 'view'}">
			<tr>
			<td >
				<div class="easyui-panel" style="width:500px;height:255px;" data-options="title:'常用产品',border:true,fit:true">
					<table id="resultDataGrid" ></table>
				</div>
			</td>
			<td>
				<div style="width:35px;height:235px;">
					  <p align="center" style="padding-top:60px;padding-bottom:50px;">
					  <a href="javascript:void(0);" id="left" class="easyui-linkbutton" data-options="iconCls:'icon-right',plain:true"></a></p>
					  <p align="center"><a href="javascript:void(0);" id="right" class="easyui-linkbutton" <c:if test="${bestflag eq 'left'}">disabled</c:if> data-options="iconCls:'icon-left',plain:true"></a></p>
				</div>
			</td>
			<td >
				<div class="easyui-panel" style="width:500px;height:255px;" data-options="title:'已选产品',border:false,fit:true">
					<table id="selectedDataGrid" width="95%"></table>
				</div>
			</td>
			</tr>
				</c:when>
			 	<c:otherwise>
			 	<br>
			 	<br>
			 	<tr>
			<td >
				<div  class="easyui-panel" style="width:724px;height:255px;" data-options="title:'已选产品',border:false,fit:true">
					<table id="selectedDataGrid" width="95%"></table>
				</div>
			</td>
			</tr>
			 	</c:otherwise>
			</c:choose>
			</table>
		</div>
		<div class="div_line"></div>
		
		</form>
	</div>
	<div id="winCheck" class="easyui-window" data-options="closed:true,resizable:false"></div>
	<div id="dg" style="z-index: 9999; position: fixed ! important; right: 0px; top: 95%;"><a class="easyui-linkbutton" href="#buttonDiv">回到顶部</a> </div>
</body>

</html>