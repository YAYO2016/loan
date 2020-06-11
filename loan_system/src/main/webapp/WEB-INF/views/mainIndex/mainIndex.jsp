<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible"content="IE=edge,chrome=1">
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ page isELIgnored="false" %>
	<%@ page language="java" pageEncoding="UTF-8"%>
	<%@ page import="com.framework.core.entity.SessionBean"%>
	<%@ page import="com.framework.core.utils.GlobalConst"%>
	<%@ page import="java.util.*"%>
	<%@ page import="java.util.Map.Entry"%>
	<%
		SessionBean sessionBean = (SessionBean)request.getSession().getAttribute(GlobalConst.SESSION_KEY);
		Map<String,String> pmp = sessionBean.getRoleMap();
		String userName = sessionBean.getUserName();
		String path = request.getContextPath();
		Map<String,List<Map<String, Object>>> menusecondAllList = 
		(Map<String,List<Map<String, Object>>>)request.getAttribute("menusecondAllList");
		
	%>
	<title>CDI信贷系统</title>
	<link href="/css/stylenew.css" type="text/css" rel="stylesheet">
    <link href="/css/iconfont.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="/js/easyui/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/js/map.js"></script>
<script>
	var map = new Map();
	<%
	StringBuffer sb = new StringBuffer();
	boolean over = false;
	for (Entry<String, List<Map<String, Object>>> entry : menusecondAllList.entrySet()) {
		over = false;
		sb.setLength(0);
		for (Map<String, Object> mm : entry.getValue()) {
			if(!over){
				sb.append("<li id='"+String.valueOf(mm.get("menuId"))+"' lang='"+String.valueOf(mm.get("url"))+"' class='selected'>" +
						"<span class='menu-name'>"+String.valueOf(mm.get("menuName"))+"</span></li>");
				over = true;
			}else{
				sb.append("<li id='"+String.valueOf(mm.get("menuId"))+"' lang='"+String.valueOf(mm.get("url"))+"'>" +
						"<span class='menu-name'>"+String.valueOf(mm.get("menuName"))+"</span></li>");
			}
		}%>
		map.put("<%=entry.getKey() %>", "<%=sb.toString() %>");
		<%
	}%>
	
	$(document).ready(function() {
		<c:forEach var="list" items="${menusecondShowList}" varStatus="status">
       		<c:if test="${status.index eq 0}">
       			$("iframe")[0].src = "${list.url }";
       		</c:if>
       	</c:forEach>
		/*一级菜单绑定click事件*/
		firstMenuClick();
		/*二级菜单click事件*/
		secondMenuClick();
	});
	
	/*一级菜单绑定click事件*/
	function firstMenuClick(){
		$('ul.menu-list').children().click(function(){
			$(this).addClass("selected");
			$(this).siblings().removeClass("selected");
			$('ul.menu-ul').empty().append(map.get($(this)[0].id));
			secondMenuClick();
			//二级菜单选中节点触发iframe刷新
			$("iframe")[0].src = $('ul.menu-ul').children(".selected")[0].lang;
		});
	}
	
	/*二级菜单click事件*/
	function secondMenuClick(){
		$('ul.menu-ul').children().click(function(){
			$(this).addClass("selected");
			$(this).siblings().removeClass("selected");
			$("iframe")[0].src = $(this)[0].lang;
		});
	}
	
</script> 
</head>
<body>
<!--html壳子-->
<div class="html-wrap">
    <div class="menu-bar">
        <img class="menu-logo" src="/images/logo.png"><span class="logo-name">信贷系统</span>
        <!--菜单-->
        <ul class="menu-list">
        	<c:forEach var="list" items="${menuFirstList}">
        		<c:if test="${list.orderBy eq 1}">
        			<li id="${list.menuId }" class="selected">
        		</c:if>
        		<c:if test="${list.orderBy ne 1}">
        			<li id="${list.menuId }" >
        		</c:if>
        			<img src="${list.menuPictureId }">
	                <span class="menu-list-text">${list.menuName }</span>
            	</li>
        	</c:forEach>
        </ul>
        <!--登录区-->
        <div class="login-wrap">
            <div class="login-tools">
                <a class="toos-wrap">
                    <img src="/images/tixing.png ">
                    <span class="new-message">2</span>
                </a>
                <a class="toos-wrap">
                    <img src="/images/xiaoxi.png">
                    <span class="new-message">8</span>
                </a>
            </div>
            <div class="login-box">
                <span class="login-name">你好，<%=userName %></span>
                <img src="/images/dengchu.png ">
            </div>
        </div>
    </div>
    <!--侧边菜单-->
    <!--右侧内容区域-->
    <section class="content-wrap">
        <div class="fill-area">
            <!--登录条-->
            <section class="sidebar-wrap">
                <!--菜单列表-->
                <ul class="menu-ul">
                	<c:forEach var="list" items="${menusecondShowList}" varStatus="status">
		        		<c:if test="${status.index eq 0}">
		        			<li id="${list.menuId }" lang="${list.url }" class="selected">
		        		</c:if>
		        		<c:if test="${status.index ne 0}">
		        			<li id="${list.menuId }" lang="${list.url }" >
		        		</c:if>
			                <span class="menu-name">${list.menuName }</span>
                    </li>
		        	</c:forEach>
                </ul>
            </section>
            <!--内容区域-->
            <div class="content-page">
				<iframe scrolling="auto" frameborder="0" src="" style="width:100%;height:100%;overflow-x:hidden;overflow:auto;"></iframe>
            </div>
        </div>
    </section>
</div>
</body>
</html>
