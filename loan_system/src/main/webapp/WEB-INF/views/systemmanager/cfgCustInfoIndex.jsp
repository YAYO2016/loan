<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/include.jsp"%>
<title>客户信息管理</title>
<style>
	.datagrid-toolbar {
	height: auto;
	background: none repeat scroll 0% 0% rgb(239, 239, 239);
	padding: 1px 2px;
	border-bottom: 1px solid rgb(204, 204, 204);
	}
</style>
</head>
<script type="text/javascript">
$(document).ready(function() {
	
	
	var role='${role}';
	if("1"!=role){
		$("#btnUse").show();
	}else{
		$("#btnUse").hide();
	}
	
	
	$('#btnEdit').bind('click', function() {
		
		$.ajax({
	    	type: "get",
            url: "/common/getSeq.do?seq_name=seq_stakeholder_id",
            dataType: "text",
            success: function (data) {
            	var aj = $.parseJSON(data);
            	if (aj.success) {
            		var  aa=aj.attributes.nextvalue;
					$('#cust_id').val(aa);           		
            	}else{
            		$.messager.alert('提示', aj.msg,'error');
            		
            	}
            	
            }
		});
		
		
		/*证件类型 */
		$('#id_type').combobox({
			url : '/common/getDictByType.do?type=7',
			valueField : 'value',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			method : 'get',
			required : true,
			onLoadSuccess : function() { 
				comboboxLoadFirst(this, "value");
			}
		});
		
		/*收入来源 */
		$('#income_source').combobox({
			url : '/common/getDictByType.do?type=9',
			valueField : 'value',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			method : 'get',
			required : true,
			onLoadSuccess : function() { 
				comboboxLoadFirst(this, "value");
			}
		});
		
		/*职业性质 */
		$('#occup_type').combobox({
			url : '/common/getDictByType.do?type=8',
			valueField : 'value',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			method : 'get',
			required : true,
			onLoadSuccess : function() { 
				comboboxLoadFirst(this, "value");
			}
		});
		/*是否真实单位 */
		$('#is_true').combobox({
			url : '/common/getDictByType.do?type=10',
			valueField : 'value',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			method : 'get',
			required : true,
			onLoadSuccess : function() { 
				comboboxLoadFirst(this, "value");
			}
		});
		
		
		
		
		/*单位性质 */
		$('#co_type').combobox({
			url : '/common/getDictByType.do?type=13',
			valueField : 'value',
			textField : 'name',
			panelHeight : 'auto',
			editable : false,
			method : 'get',
			required : true,
			onLoadSuccess : function() { 
				comboboxLoadFirst(this, "value");
			}
		});
		
		
		
		$("#win").window("open");
		$("#win").window("center");
	});


	function comboboxLoadFirst(obj, valueField) {
		var val = $(obj).combobox("getData");
		for ( var item in val[0]) {
			if (item == valueField) {
				$(obj).combobox("select", val[0][item]);
			}
		}
	}
	
	function comboboxLoadFirst2(obj, valueField) {
		var val = parent.$(obj).combobox("getData");
		for ( var item in val[0]) {
			if (item == valueField) {
				parent.$(obj).combobox("select", val[0][item]);
			}
		}
	}
	
	

	$('#dg').datagrid({
		title:'客户信息管理列表',
		url:"/cfgCustInfo/getcfgCustInfoList.do",
		toolbar: '#tb',
		fit: true,
		fitColumns: true,
		singleSelect: true,
		loadMsg:'加载中...',
		pagination: true,
		pageNumber:1,
		pageSize:15,
		pageList:[15,30],
		striped: true,
		rownumbers: true,
		onLoadError: function(data) {
			var content = '<iframe scrolling="auto" frameborder="0" src="/frameSysmgmt/showError.action?funcId=020201" style="width:100%;height:100%;overflow-x:hidden;overflow:auto;"></iframe>';
			top.$('#winErr').window({
				content: content
			});
			top.$('#winErr').window('center');
			top.$('#winErr').window('open');
		},
		onLoadSuccess : function(data) {
			
			if(data.rows.length == 0){
				var body = $(this).data().datagrid.dc.body2;
				body.find('table tbody').append('<tr><td width = "'+body.width()+'" style = "height:25px;text-align:center;">当前没有相关信息！</td></tr>');
			}
		},
		onClickRow:function(rowIndex, rowData) {
			var resultRows = $('#dg').datagrid('getSelections');
			 $('#btnUse').linkbutton('enable');
			
			
		},

		columns:[[
			{field:'cust_id',title:'cust_name',hidden:true,width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'cust_name',title:'人员名称',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'id_type_name',title:'证件类型',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'id_type',title:'证件类型',hidden:true,width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'id_number',title:'证件号',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'land_phone',title:'手机号码',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'occup_type_name',title:'职业性质',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'occup_type',title:'职业性质',width:80,align:'left',hidden:true, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}}/* ,
			{field:'is_true',title:'是否真实单位',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				if(value == "1") value = "是";
				if(value == "0") value = "否";
				return "<span title='" + value + "'>" + value + "</span>";
			}} */,
			{field:'income_source_name',title:'收入来源',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'income_source',title:'收入来源',width:80,align:'left',hidden:true, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'amount_value',title:'收入金额',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}}
			/* ,
			{field:'is_stream',title:'流水有无',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				if(value == "1") value = "有";
				if(value == "0") value = "无";
				return "<span title='" + value + "'>" + value + "</span>";
			}}
			,
			{field:'is_true_stream',title:'流水是否真实',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				if(value == "1") value = "是";
				if(value == "0") value = "否";
				return "<span title='" + value + "'>" + value + "</span>";
			}} */
			,
			{field:'co_type_name',title:'单位性质',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},{field:'co_type',title:'单位性质',width:80,align:'left',hidden:true, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'co_name',title:'工作单位',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'co_phone',title:'单位电话',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'co_address',title:'单位地址',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'account_name',title:'账户名',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'khh_name',title:'开户行',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'account_id',title:'账号',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}}
		]]
	});

	/* $('#dg').datagrid('load', {
		'channeltype':$('#channeltype').combobox('getValue')
	}); */
	
	
	$('#btnClose').bind('click', function() {
		$("#win").window("close");
	});
	
	
	//查询
	$('#btnQuery').bind('click', function() {
		$('#dg').datagrid('load', {
			'serchMsg':$('#serchMsg').val()
		});
	});
		
	
	$('#btnSave').bind('click', function() {
		
		var opt = $('#btnSave').linkbutton('options');
		if(!opt.disabled) {
			$('#formId').form('submit',{
				success:function(data) {
					var aj = $.parseJSON(data);
					if (aj.success) {
						$("#win").window("close");
						$.messager.alert('提示', '保存成功！');
						 $('#dg').datagrid('reload');
					}else{
						 $.messager.alert('提示', aj.msg);
						 $('#dg').datagrid('reload');
					}
			    }
			});
		}
    });

	if("2"==role){
		$('#btnUse').bind('click', function() {
			
			var opt = $('#btnUse').linkbutton('options');
			if(!opt.disabled) {
				var resultRows = $('#dg').datagrid('getSelections');
				var  row=resultRows[0];
				parent.$("#cust_id").val(row.cust_id);
				parent.$("#cust_name").val(row.cust_name);
				parent.$("#id_type").val(row.id_type);
				parent.$("#id_type_name").val(row.id_type_name);
				parent.$("#id_number").val(row.id_number);
				parent.$("#custMsg").show();
				parent.$('#mainCust').css("height","175px");
				
				
				parent.$("#win2").window("close");
			}
	    });
		
		
		
	}else if("3"==role){
		$('#btnUse').bind('click', function() {
			var opt = $('#btnUse').linkbutton('options');
			if(!opt.disabled) {
				var table=add(${i});
				parent.$("#custAdd").append(table);
		        var tagobj = parent.$('#custAdd');
		        $.parser.parse(tagobj);
				var i=${i};
				i=i+1;
				var heightS= parent.$("#height").val();
				if(heightS==""||null==heightS){
					heightS=0;
				}
				var height=parseInt(heightS);
				height=165+height;
				var newHeight=height+"px";
				parent.$('#shareCust').css("height",newHeight);
				
				/*是否真实单位 */
				parent.$('#is_true_'+${i}).combobox({
					url : '/common/getDictByType.do?type=10',
					valueField : 'value',
					textField : 'name',
					panelHeight : 'auto',
					editable : false,
					method : 'get',
					required : true,
					onLoadSuccess : function() { 
						/* comboboxLoadFirst2(this, "value"); */
					}
				});
				
				/*流水有无 */
				parent.$('#is_stream_'+${i}).combobox({
					url : '/common/getIsTrue.do?type=1',
					valueField : 'value',
					textField : 'name',
					panelHeight : 'auto',
					editable : false,
					method : 'get',
					required : true,
					onLoadSuccess : function() { 
						/* comboboxLoadFirst2(this, "value"); */
					}
				});
				
				/*流水有无 */
				parent.$('#is_true_stream_'+${i}).combobox({
					url : '/common/getIsTrue.do?type=2',
					valueField : 'value',
					textField : 'name',
					panelHeight : 'auto',
					editable : false,
					method : 'get',
					required : true,
					onLoadSuccess : function() { 
						/* comboboxLoadFirst2(this, "value"); */
					}
				});
				
				
				
				var resultRows = $('#dg').datagrid('getSelections');
				var  row=resultRows[0];
				parent.$("#cust_id_"+${i}).val(row.cust_id);
				parent.$("#cust_name_"+${i}).val(row.cust_name);
				parent.$("#id_type_"+${i}).val(row.id_type);
				parent.$("#id_type_name_"+${i}).val(row.id_type_name);
				parent.$("#id_number_"+${i}).val(row.id_number);
				parent.$("#custMsg_"+${i}).show();
				parent.$("#i").val(i);
				parent.$("#height").val(height);
				
				
				parent.$("#win2").window("close");
			}
	    });
		
	}
	
	

});

function  add(i){
	var  tables=  ' <div  id="custMsg'+i+'"> '    
	+'	<input id="cust_id_'+i+'" type="hidden" class="easyui-validatebox" value="${cust_id}" name="cust_id_'+i+'" style="width:230px;height:23px;" readonly data-options="required:true,validType:\'vname\'"/>    '    
	+'	 <input id="id_type_'+i+'" type="hidden" class="easyui-validatebox" value="${id_type}" name="id_type_'+i+'"  style="width:230px;height:28px" readonly ></input>                                                                                                                                                                                                         '    
	+'	<table  width="100%" height="center" bgcolor="#FFFFFF">                                                                                                                                                  '    
	+'	<tr >                                                                                                                                                                        '    
	+'	<td width="60" align="right">                                                                                                                                                                                                     '    
	+'	    <span>共还姓名:</span></td><td  align="left" width="300"> '
	+'		<input id="cust_name_'+i+'" class="easyui-validatebox" value="${cust_name}" name="cust_name_'+i+'" style="width:230px;height:23px;" readonly data-options="required:true,validType:\'vname\'"/>        '    
	+'	</td>                                                                                                                                                                                                    '    
	+'	<td width="60" align="right">                                                                                                                                                                                     '    
	+'	    <span>证件类型:</span></td><td  align="left" width="300">                                                                                                                                                                               '    
	+'		<input id="id_type_name_'+i+'"  class="easyui-validatebox" disabled  value="${id_type}" name="id_type_name_'+i+'"  style="width:230px;height:23px" readonly ></input>                                        '    
	+'	</td>                                                                                                                                                                                                    '    
	+'	 <td width="60" align="right">                                                                                                                                                                                       '    
	+'	    	<span>证件号:</span></td><td  align="left" width="300">                                                                                                                                                                             '    
	+'	   	 	<input id="id_number_'+i+'" class="easyui-validatebox" value="${id_number}" name="id_number_'+i+'" readonly style="width:230px;height:23px"  data-options="disabled:false"></input>              '    
	+'		</td>                                                                                                                                                                                                '    
	+'	</tr>                                                                                                                                                                                                    '    
	+'	                                                                                                                                                                                                         '    
	+'	<tr>                                                                                                                                                                        '    
	+'	<td width="60" align="right">                                                                                                                                                                                      '    
	+'	    <span>真实单位:</span></td><td  align="left" width="300">                                                                                                                                                                               '    
	+'	    <input id="is_true_'+i+'" class="easyui-combobox input" value="${is_true}" name="is_true_'+i+'" readonly style="width:230px;height:28px;"  data-options="required:true,validType:\'vname\'"/>          '    
	+'	</td>                                                                                                                                                                                                    '    
	+'	<td  width="60" align="right">                                                                                                                                                                                       '    
	+'	    <span>流水有无:</span></td><td  align="left" width="300">                                                                                                                                                                               '    
	+'	    <input id="is_stream_'+i+'" class="easyui-combobox input" value="${is_stream}" name="is_stream_'+i+'" readonly style="width:230px;height:28px;"  data-options="required:true,validType:\'vname\'"/>    '    
	+'	</td>                                                                                                                                                                                                    '    
	+'	<td width="60" align="right">                                                                                                                                                                                        '    
	+'	    <span>流水是否真实:</span></td><td  align="left" width="300">                                                                                                                                                                          '   
	+'	    <input id="is_true_stream_'+i+'" class="easyui-combobox input" value="${is_true_stream}" name="is_true_stream_'+i+'" readonly style="width:230px;height:28px;"  data-options="required:true,validType:\'vname\'"/> ' 
	+'	</td>                                                                                                                                                                                                       ' 
	+'	</tr>                                                                                                                                                                                                       ' 
	+'	<tr width="100%"  align="center">                                                                                                                                                                           ' 
	+'	                                                                                                                                                                                                            ' 
	+'	<td width="60" align="right">                                                                                                                                                                                         ' 
	+'	    <span>补充流水:</span></td><td  align="left" width="300">                                                                                                                                                                            ' 
	+'		<input id="stream_value_'+i+'" class="easyui-validatebox" value="${stream_value}" name="stream_value_'+i+'"  style="width:230px;height:23px;"  data-options="required:true,validType:\'vname\'"/>         '           
	+'	</td>                                                                                                                                                                                                       ' 
	+'	 <tr height="20"></tr>                                                                                                                                                                                                            '
	+'	</table>	                                                                                                                                                                                                 '
	+'</div>                                                                                                                                                                                                      '
	return tables;
	
}


</script>
<body>
<table id="dg"></table>
<div id="tb">
<table>
 	<input type="hidden" id="delsql" name="delsql" value=""/>
	<tr>
		<td>个人信息：</td>
		<td>
			<input name="serchMsg" id="serchMsg" class="easyui-input " />
			<font color="#FF0000">（根据姓名模糊查询）</font>
		</td>
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		<td><div ><a href="#" id="btnQuery" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></div></td>
		<td><div ><a href="#" id="btnEdit" class="easyui-linkbutton"  data-options="iconCls:'icon-edit'">新增</a></div></td>
		<td><div ><a href="#" id="btnUse" class="easyui-linkbutton"  disabled data-options="iconCls:'icon-edit'">使用</a></div></td>
	</tr>
</table>

</div>
<div id="win" class="easyui-dialog" title="新增客户信息"  data-options="closed:true,resizable:false" style="width:700px;height:370px;">
	<form action="/cfgCustInfo/doSaveCfgCustInfoManage.do" id="formId">
	 <table>
	  <tr>
	    <td >
		    <span>贷款人id:</span>
			<input id="cust_id" class="easyui-validatebox" name="cust_id" style="width:230px;height:23px;" readonly data-options="required:true,validType:'vname'"/>
		</td>
		<td>
		    <span>贷款人姓名:</span>
			<input id="cust_name" class="easyui-validatebox" name="cust_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
	  </tr>
	  <tr>
	  <td>
		    <span>移动电话:</span>
			<input id="mobile_phone" class="easyui-validatebox" name="mobile_phone" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td >
		    <span>&nbsp;&nbsp;&nbsp;家庭电话:</span>
			<input id="land_phone" class="easyui-validatebox" name="land_phone" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
	  </tr>
	  <tr>
	   <td>
		    <span>证件类型:</span>
			<input id="id_type" class="easyui-combobox input" name="id_type"  style="width:230px;height:28px"  ></input>
		</td>
		<td >
		    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;证件号:</span>
		    <input id="id_number" class="easyui-validatebox" name="id_number"  style="width:230px;height:23px"  data-options="disabled:false"></input>
		</td>
	  </tr>
	  <tr>
		  <td >
			    <span>收入来源:</span>
				<input id="income_source" class="easyui-combobox input" name="income_source" style="width:230px;height:28px;" />
		  </td>
		  <td>
			    <span>&nbsp;&nbsp;&nbsp;收入金额:</span>
				<input id="amount_value" class="easyui-validatebox" name="amount_value" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		  </td>
	  </tr>
	  <tr>
	   <td>
		    <span>单位性质:</span>
			<input id="co_type" class="easyui-combobox input"  name="co_type"  style="width:230px;height:28px"  ></input>
		</td>
		<td>
		    <span>&nbsp;&nbsp;&nbsp;工作单位:</span>
			<input id="co_name" class="easyui-validatebox" name="co_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
	  </tr>
	  <tr>
	    <td>
		    <span>单位电话:</span>
			<input id="co_phone" class="easyui-validatebox" name="co_phone" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td>
		    <span>&nbsp;&nbsp;&nbsp;单位地址:</span>
			<input id="co_address" class="easyui-validatebox" name="co_address" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
	  </tr>
	  <tr>
	  <td>
		    <span>&nbsp;&nbsp;&nbsp;&nbsp;账户名:</span>
			<input id="account_name" class="easyui-validatebox" name="account_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td >
		    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开户行:</span>
			<input id="khh_name" class="easyui-validatebox" name="khh_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
	  </tr>
	  <tr>
	    <td>
		    <span>职业性质:</span>
			<input id="occup_type" class="easyui-combobox input" name="occup_type" style="width:230px;height:28px;"  data-options="required:true,validType:'vname'"/>
		</td>
	    <td >
		    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号:</span>
			<input id="account_id" class="easyui-validatebox" name="account_id" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
	  </tr>
	 </table>
	 <div style="height:10px;"></div>
	<div   align="center">
   			<a href="#" id="btnClose" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">关闭</a>
   			<a href="#" id="btnSave" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">保存</a>
	</div>
	
	
	
	
		
		<!-- <td align="left">
		    <span>是否真实单位:</span>
		    <input id="is_true" class="easyui-combobox input" name="is_true" style="width:230px;height:28px;"  data-options="required:true,validType:'vname'"/>
		</td> -->
		</tr>
		
	<!-- 	<tr width="100%"  align="center">
		<td>
		    <span>流水有无:</span>
			<select id="is_stream" name="is_stream" class="easyui-validatebox" style="width:230px;height:28px;" >
		    	<option value="1">有</option>
		    	<option value="0">无</option>
		    </select>
		</td>
		<td align="left">
		    <span>流水是否真实:</span>
		    <select id="is_true_stream" name="is_true_stream" class="easyui-validatebox" style="width:230px;height:28px;" >
		    	<option value="1">是</option>
		    	<option value="0">否</option>
		    </select>
		</td>
		</tr> -->
		
			
	</form>
</div>
</body>
</html>
