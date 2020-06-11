<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/include.jsp"%>
<title>菜单管理</title>
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
		title:'菜单管理列表',
		url:"/dictSysFunc/getDictSysFuncList.do",
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
			{field:'func_id',title:'菜单编码',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'func_name',title:'菜单名称',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'super_func_id',title:'上级菜单编码',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'func_type',title:'菜单类型',width:20,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'seq_num',title:'顺序值',width:20,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'func_url',title:'功能地址',width:100,align:'left',hidden:false, formatter: function(value,row,index){
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
				'func_name':$('#funcName').val()
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
		<td>菜单名称：</td>
		<td>
			<input name="funcName" id="funcName" class="easyui-input " />
		</td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		<td><div ><a href="#" id="btnQuery" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></div></td>
	<!-- 	<td><div ><a href="#" id="btnAdd" class="easyui-linkbutton"  data-options="iconCls:'icon-edit'">新增</a></div></td> -->
	</tr>
</table>

</div>
<!-- <div id="win" class="easyui-dialog" title="新增字典管理"  data-options="closed:true,resizable:false" style="width:450px;height:250px;">
	<form action="/dictSysFunc/doSaveDictBank.do" id="formId">
		<table  width="100%" height="center" bgcolor="#FFFFFF">
		<tr width="100%"   align="center">
		<td >
		    <span>菜单编码:</span>
			<input id="func_id" class="easyui-validatebox" name="func_id" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		    <span>菜单名称:</span>
		    
			<input id="func_name" class="easyui-validatebox" name="func_name"  style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"></input>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		</tr>
		<tr width="100%"  align="center">
		<td>
		    <span>上级菜单编码:</span>
			<input id="super_func_id" class="easyui-combobox input" name="super_func_id" style="width:250px;height:28px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr  width="100%"  align="center">
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		</tr>
		<tr width="100%"  align="center">
		<td>
		    <span>菜单类型:</span>
			<input id="func_type" class="easyui-validatebox" name="func_type" style="width:230px;height:23px;"  data-options="required:false,validType:'vname'"/>
		</td>
		</tr>
		<tr width="100%"  align="center">
		<td>
		    <span>顺序值:</span>
			<input id="seq_num" class="easyui-validatebox" name="seq_num" style="width:230px;height:23px;"  data-options="required:false,validType:'vname'"/>
		</td>
		</tr>
		<tr width="100%"  align="center">
		<td>
		    <span>功能地址:</span>
			<input id="func_url" class="easyui-validatebox" name="func_url" style="width:230px;height:23px;"  data-options="required:false,validType:'vname'"/>
		</td>
		</tr>
		
		</table>
			<div style="height:10px;"></div>
			<div   align="center">
		   			<a href="#" id="btnClose" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">关闭</a>
		   			<a href="#" id="btnSave" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">保存</a>
			</div>
	</form>
</div> -->
</body>
</html>
