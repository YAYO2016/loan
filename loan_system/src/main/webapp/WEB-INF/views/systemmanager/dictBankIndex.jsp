<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/include.jsp"%>
<title>银行字典管理</title>
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

function comboboxLoadFirst(obj, valueField) {
	var val = $(obj).combobox("getData");
	for ( var item in val[0]) {
		if (item == valueField) {
			$(obj).combobox("select", val[0][item]);
		}
	}
}

$(document).ready(function() {
	
	$('#btnAdd').bind('click', function() {
		
		$('#super_dict_id').combobox({
			url : '/cfgDictInfo/getSuperDictId.do',
			valueField : 'value',
			textField : 'name',
			panelHeight : '260',
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


	$('#dg').datagrid({
		title:'银行字典列表',
		url:"/dictBank/getDictBankList.do",
		toolbar: '#tb',
		fit: true,
		fitColumns: true,
		singleSelect: false,
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
			
		},

		columns:[[
			{field:'bank_id',title:'银行编码',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'bank_name',title:'银行名称',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'branch_id',title:'分行编码',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'branch_name',title:'分行名称',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'sub_branch_id',title:'支行编码',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'sub_branch_name',title:'支行名称',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}}
		]]
	});
	
	$('#btnClose').bind('click', function() {
		$("#win").window("close");
	});
	
	
	//查询
	$('#btnQuery').bind('click', function() {
			$('#dg').datagrid('load', {
				'bank_name':$('#bankName').val(),
				'sub_branch_name':$('#subBranchName').val(),
				'branch_name':$('#branchName').val()
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
});


</script>
<body>
<table id="dg"></table>
<div id="tb">
<table>
 	<input type="hidden" id="delsql" name="delsql" value=""/>
	<tr>
		<td>银行名称：</td>
		<td>
			<input name="bankName" id="bankName" class="easyui-input " />
		</td>
		<td>分行名称：</td>
		<td>
			<input name="branchName" id="branchName" class="easyui-input " />
		</td>
		<td>支行名称：</td>
		<td>
			<input name="subBranchName" id="subBranchName" class="easyui-input " />
		</td>
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		<td><div ><a href="#" id="btnQuery" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></div></td>
		<td><div ><a href="#" id="btnAdd" class="easyui-linkbutton"  data-options="iconCls:'icon-edit'">新增</a></div></td>
	</tr>
</table>
</div>

<div id="win" class="easyui-dialog" title="新增银行字典"  data-options="closed:true,resizable:false" style="width:400px;height:375px;">
		
		<form action="/dictBank/doSaveDictBank.do" id="formId">
		<table  width="100%" height="center" bgcolor="#FFFFFF">
		<tr height="24"></tr>
		<tr width="100%"   align="center">
		<td >
		    <span>银行编码:</span>
			<input id="bank_id" class="easyui-validatebox" name="bank_id" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		<tr height="4"></tr>
		</td>
		</tr>
		<tr width="100%"   align="center">
		<td >
		    <span>银行名称:</span>
			<input id="bank_name" class="easyui-validatebox" name="bank_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		<tr height="4"></tr>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		    <span>分行编码:</span>
		    
			<input id="branch_id" class="easyui-validatebox" name="branch_id"  style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"></input>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		</td>
		</tr>
		<tr height="4"></tr>
		<tr width="100%"   align="center">
		<td >
		    <span>分行名称:</span>
			<input id="branch_name" class="easyui-validatebox" name="branch_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr height="4"></tr>
		<tr width="100%"   align="center">
		<td >
		    <span>支行编码:</span>
			<input id="sub_branch_id" class="easyui-validatebox" name="sub_branch_id" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr height="4"></tr>
		<tr width="100%"   align="center">
		<td >
		    <span>支行名称:</span>
			<input id="sub_branch_name" class="easyui-validatebox" name="sub_branch_name" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr height="4"></tr>
		<tr  width="100%"  align="center">
		<td>
		</td>
		</tr>
		</table>
			<div style="height:10px;"></div>
			<div   align="center">
		   			<a href="#" id="btnClose" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">关闭</a>
		   			<a href="#" id="btnSave" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">保存</a>
			</div>
	</form>
</div>
</body>
</html>
