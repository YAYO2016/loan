<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/include.jsp"%>
<title>中介管理</title>
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
	
	var role='${role}';
	if("1"!=role){
		$("#btnUse").show();
	}else{
		$("#btnUse").hide();
	}
	
	
	$('#btnAdd').bind('click', function() {
		
		$.ajax({
	    	type: "get",
            url: "/common/getSeq.do?seq_name=seq_agency_id",
            dataType: "text",
            success: function (data) {
            	var aj = $.parseJSON(data);
            	if (aj.success) {
            		var  aa=aj.attributes.nextvalue;
					$('#agency_id').val(aa);           		
            	}else{
            		$.messager.alert('提示', aj.msg,'error');
            		
            	}
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
		title:'中介管理列表',
		url:"/dictAgencyInfo/getdictAgencyInfoList.do",
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
			$('#btnUse').linkbutton('enable');
			
		},

		columns:[[
			{field:'agency_id',title:'中介编码',hidden:true,width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'agency_name',title:'中介名称',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'agency_phone',title:'中介电话',width:80,align:'left',formatter: function(value,row,index){
				if(value == null) value = '-';
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'agency_address',title:'中介地址',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'boss_name',title:'中介老板',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'boss_mphone',title:'中介老板手机',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'boss_lphone',title:'中介老板办公电话',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'pm_name',title:'权限负责人',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'pm_mphone',title:'权证负责人手机',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'pm_lphone',title:'权证负责人办公电话',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'bm_name',title:'业务接洽人',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'bm_mphone',title:'业务接洽人手机',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'bm_lphone',title:'业务接洽人办公电话',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'account_name',title:'返款结算户名',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'khh_name',title:'结算卡开户行',width:80,align:'left',hidden:false, formatter: function(value,row,index){
				if(value == null) value = "-";
				return "<span title='" + value + "'>" + value + "</span>";
			}},
			{field:'account_id',title:'账号',width:80,align:'left',hidden:false, formatter: function(value,row,index){
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
			'agency_name':$('#agency_name').val()
		});
	});
		
		$('#btnUse').bind('click', function() {
			
			var opt = $('#btnUse').linkbutton('options');
			if(!opt.disabled) {
				var resultRows = $('#dg').datagrid('getSelections');
				var  row=resultRows[0];
				parent.$("#agency_id").val(row.agency_id);
				parent.$("#agency_name").val(row.agency_name);
				parent.$("#agency_phone").val(row.agency_phone);
				parent.$("#id_type_name").val(row.id_type_name);
				parent.$("#agency_address").val(row.agency_address);
				parent.$("#boss_name").val(row.boss_name);
				parent.$("#boss_mphone").val(row.boss_mphone);
				parent.$("#boss_lphone").val(row.boss_lphone);
				parent.$("#pm_name").val(row.pm_name);
				parent.$("#pm_mphone").val(row.pm_mphone);
				parent.$("#pm_lphone").val(row.pm_lphone);
				parent.$("#bm_name").val(row.bm_name);
				parent.$("#bm_mphone").val(row.bm_mphone);
				parent.$("#bm_lphone").val(row.bm_lphone);
				parent.$("#account_name").val(row.account_name);
				parent.$("#khh_name").val(row.khh_name);
				parent.$("#account_id").val(row.account_id);
				parent.$("#agencyMsg").show();
				
				parent.$('#agencyCust').css("height","300px");
				parent.$("#win2").window("close");
			}
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
	<tr>
		<td>中介名称：</td>
		<td>
			<input name="agency_name" id="agency_name" class="easyui-input " />
			<font color="#FF0000">（根据中介名称模糊查询）</font>
		</td>
		<td>
		<div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</td>
		<td><div ><a href="javascrip:void(0)" id="btnQuery" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></div></td>
		<td><div ><a href="javascrip:void(0)" id="btnAdd" class="easyui-linkbutton"  data-options="iconCls:'icon-edit'">新增</a></div></td>
		<td><div ><a href="#" id="btnUse" class="easyui-linkbutton"  disabled data-options="iconCls:'icon-edit'">使用</a></div></td>
	</tr>
</table>

</div>
<div id="win" class="easyui-dialog" title="新增中介信息"  data-options="closed:true,resizable:false" style="width:640px;height:350px;">
	<form action="/dictAgencyInfo/doSaveDictAgencyInfo.do" id="formId">
	<table  width="100%" height="center" align="center"  bgcolor="#FFFFFF">
		<tr>
		<td width="50" align="right">  
			中介编码:
		</td >		
		<td width="100" align="left">
			<input id="agency_id" class="easyui-validatebox" readonly name="agency_id" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>中介全称:</span>
		</td >		
		<td width="250" align="left">
			<input id="agency_name" class="easyui-validatebox"  name="agency_name"  style="width:200px;height:23px"  data-options="disabled:false"></input>
		</td>
		</tr>
		 <tr >
		<td width="50" align="right">
		    <span>中介电话:</span>
		</td>		
		<td width="100" align="left">
			<input id="agency_phone" class="easyui-validatebox" name="agency_phone" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>中介地址:</span>
		 </td>		
		<td width="200" align="left">
			<input id="agency_address" class="easyui-validatebox" name="agency_address" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		<tr >
		<td width="50" align="right">
		    <span>中介老板:</span>
		</td>
		<td width="100" align="left">
			<input id="boss_name" class="easyui-validatebox" name="boss_name" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>中介老板手机:</span>
		</td>
		<td width="200" align="left">
			<input id="boss_mphone" class="easyui-validatebox"  name="boss_mphone" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		
		<tr >
		<td width="50" align="right">
		    <span>中介老板办公电话:</span>
		 </td>
		<td width="100" align="left">
			<input id="boss_lphone" class="easyui-validatebox"   name="boss_lphone" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>权限负责人:</span>
		</td>
		<td width="200" align="left">
			<input id="pm_name" class="easyui-validatebox" name="pm_name" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		
		</tr>
		<tr >
		 <td width="50" align="right">
		    <span>权证负责人手机:</span>
		 </td>
		<td width="100" align="left">
			<input id="pm_mphone" class="easyui-validatebox" name="pm_mphone" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>权证负责人办公电话:</span>
		 </td>
		<td width="200" align="left">
			<input id="pm_lphone" class="easyui-validatebox" name="pm_lphone" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		
		<tr >
		<td width="50" align="right">
		    <span>业务接洽人:</span>
		 </td>
		<td width="50" align="left">
			<input id="bm_name" class="easyui-validatebox"   name="bm_name" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>业务接洽人手机:</span>
		 </td>
		<td width="200" align="left">
			<input id="bm_mphone" class="easyui-validatebox"  name="bm_mphone" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		</tr>
		
		<tr >
		<td width="50" align="right">
		    <span>业务接洽人办公电话:</span>
		 </td>
		<td width="50" align="left">
			<input id="bm_lphone" class="easyui-validatebox"    name="bm_lphone" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>返款结算户名:</span>
		 </td>
		<td width="50" align="left">
			<input id="account_name" class="easyui-validatebox"  name="account_name" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		
		</tr>
		<tr >
		<td width="50" align="right">
		    <span>结算卡开户行:</span>
		 </td>
		<td width="200" align="left">
			<input id="khh_name" class="easyui-validatebox"   name="khh_name" style="width:120px;height:23px;"  data-options="required:true,validType:'vname'"/>
		</td>
		<td width="50" align="right">
		    <span>账号:</span>
		 </td>
		<td width="200" align="left">
			<input id="account_id" class="easyui-validatebox"  name="account_id" style="width:200px;height:23px;"  data-options="required:true,validType:'vname'"/>
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
