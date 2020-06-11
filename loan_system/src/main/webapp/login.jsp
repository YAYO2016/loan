<%@page language="java" contentType="text/html; charset=utf-8"%>
<% String path = request.getContextPath(); %>
<%@ page import="com.framework.core.utils.GlobalConst"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>CDI信贷系统</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/js/easyui/themes/cupertino/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/js/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/js/easyui/themes/cupertino/tooltip.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css" />
<script type="text/javascript" src="<%=path%>/js/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	function login(){
		var params = {
			'userId':$('#userId').val(),
			'password':$('#passwd').val()
		}
		$.ajax({
			type: 'post',
			url: '/login/login.do',
			datatype:'text',
			data: params,
			success:function(data, textStatus) {
				var obj = jQuery.parseJSON(data);
				if(obj.success) {
					window.location="/homeMainIndex/mainIndex.do";
				} else {
					top.$.messager.alert('提示', obj.msg);
				}
			}
		})
	}
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	    if(e && e.keyCode==13) {
	    	login();
	    }
	};
	
	
	function loadTopWindow(){
	    if (window.top!=null && window.top.document.URL!=document.URL){
	        window.top.location= document.URL;
	       }
	 }
	
   </script>

</head>

<body  onload="loadTopWindow()">
<div class="bg1">
    <div class="title">公司-系统名称</div>
    
     <div class="login_div">
        <div class="login-word"><span>用户登录</span><span class="nth-2">User Login</span></div>
        <div class="login_input_area">
            <input class="input1" id="userId" value="" placeholder="用户名" onfocus="javascript:if(this.value=='用户名')this.value='';">
            <input class="input1" type="password" id="passwd" value="" placeholder="密码" onfocus="javascript:if(this.value=='密码')this.value='';">
            <a onclick='login()' class="login_bt"><span class="login_span">Login</span></a>
        </div>
    </div>
    <div class="login_div2" style="text-align: center;line-height: 150px;">
     <a onclick='ExampleQuery()' ><span class="companyDesc"  style="font-size:30px;" >案子查询</span></a>
    </div>
    
    <div class="login_div3" style="text-align: center;line-height: 150px;">
     <a onclick='companyDesc()'><span class="companyDesc" style="font-size:30px;">公司简介</span></a>
    </div>
   
	<div class="copyright" style="text-align: center;line-height: 70px;">
		<span class="copyrightInformation">版权信息</span>
	</div>    
</div>

</body>
</html>
