<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/include.jsp"%>
<title>员工信息管理</title>
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
		title:'员工信息列表',
		url:"/cfgUser/getCfgUserList.do",
		toolbar: '#tb',
		fit: true,
		fitColumns: true,
		singleSelect: false,
		loadMsg:'加载中...',
		pagination: true,
		pageNumber:1,
		pageSize:15,
		pageList:[10,20,30],
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
			var role=data.role;
			if(data.rows.length == 0){
				var body = $(this).data().datagrid.dc.body2;
				body.find('table tbody').append('<tr><td width = "'+body.width()+'" style = "height:25px;text-align:center;">当前没有相关信息！</td></tr>');
			}
		},
		onClickRow:function(rowIndex, rowData) {
			var resultRows = $('#dg').datagrid('getSelections');
			
		},
		columns:[[
			{field:'user_id',title:'用户编码',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'user_name',title:'用户名称',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'user_pw',title:'系统密码',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'org_id',title:'归属组织机构',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'innet_date',title:'入司日期',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'m_phone',title:'移动电话',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'l_phone',title:'办公电话',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'email_address',title:'电子邮件',width:80,align:'left',hidden:false, formatter: function(value,row,index){
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
			'userId':$('#userId').val(),
			'userName':$('#userName').val()
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
		<td>用户编码：</td>
		<td>
			<input name="userId" id="userId" class="easyui-input " />
		</td>
		<td>用户名称：</td>
		<td>
			<input name="userName" id="userName" class="easyui-input " />
		</td>
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		<td><div ><a href="#" id="btnQuery" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></div></td>
		<td><div ><a href="#" id="btnAdd" class="easyui-linkbutton"  data-options="iconCls:'icon-edit'">新增</a></div></td>
	</tr>
</table>

</div>
<div id="win" class="easyui-dialog" title="新增用户"  data-options="closed:true,resizable:false" style="width:650px;height:200px;">
<form action="/cfgUser/doSaveCfgUser.do" id="formId">
		<table  bgcolor="#FFFFFF">
			<tr>
			<td>
		    	<span>用户编码:</span>
				<input id="user_id" class="easyui-validatebox" name="user_id" style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"/>
			</td>
			<td>
			    <span>用户名称:</span>
				<input id="user_name" class="easyui-validatebox" name="user_name"  style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"></input>
		   </td>
		   </tr>
		   <tr>
			<td>
			    <span>系统密码:</span>
				<input id="user_pw" class="easyui-validatebox" name="user_pw"  style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"></input>
			</td>
			<td>
			    <span>归属组织机构:</span>
				<input id="org_id" class="easyui-combobox input" name="org_id" style="width:250px;height:28px;"  data-options="required:true,validType:'vname'"/>
			</td>
		   </tr>
		    <tr>
			<td>
		    <span>入司日期:</span>
			<input id="innet_date" class="easyui-validatebox" name="innet_date"  style="width:230px;height:23px;"  data-options="required:true,validType:'vname'"></input>
			</td>
			<td>
		    <span>移动电话:</span>
			<input id="m_phone" class="easyui-validatebox" name="m_phone" style="width:230px;height:23px;"  data-options="required:false,validType:'vname'"/>
		   </td>
		   </tr>
		    <tr>
			<td>
		    <span>办公电话:</span>
			<input id="l_phone" class="easyui-validatebox" name="l_phone" style="width:230px;height:23px;"  data-options="required:false,validType:'vname'"/>
		 	</td>
			<td>
		    <span>电子邮件:</span>
			<input id="email_address" class="easyui-validatebox" name="email_address" style="width:230px;height:23px;"  data-options="required:false,validType:'vname'"/>
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
