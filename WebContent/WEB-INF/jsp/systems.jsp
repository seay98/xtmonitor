<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>系统状态</title>
<link rel="stylesheet" href="/xtmon/resources/jqw/styles/jqx.base.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/jqw/styles/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/css/global.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/css/systems.css" type="text/css" />
<script type="text/javascript" src="/xtmon/resources/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/bootstrap.min.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxcore.js"></script>
<script type="text/javascript" src="/xtmon/resources/scripts/functions.js"></script>
<script type="text/javascript" src="/xtmon/resources/scripts/systems.js"></script>

</head>
<body>
	<!-- 导航栏 -->
    <div id="hbar" class="navbar navbar-default navbar-fixed-top">
        <ul id="myTab" class="nav nav-tabs">
            <li style="margin-left: 20px;" class="active"><a href="/xtmon/">设备状态监控</a></li>
            <li><a href="/xtmon/filestatus">报文状态监控</a></li>
            <li><a href="#fitness">设备管理</a></li>
        </ul>
    </div>
	
	<!-- 页头 -->
	<div id="header" class="jumbotron">
        <div class="container">
            <h1>卫星系统状态监控</h1>
            <h3 id="curtime"></h3>
        </div>
    </div>
            
	<!-- 页面 -->
    <div id="main">
	  <div id="docking" class="container">
    	<hr/>
	    <c:forEach var="sys" items="${syss}">
	    <div id="metro-${sys.id}" class="metro" style="background-color: rgb(160, 160, 160);">
	      <div>
	        <img id="sys-img-${sys.id}" class="metro-img" src="/xtmon/resources/images/sys_offline.png" alt="status" title="status" />
	        <div class="metro-desc">
	            <h5 class="metro-h4">${sys.name}<c:if test="${sys.alias!=''}">(${sys.alias})</c:if></h5>
	            <ul class="metro-ul">
	                <li>系统状态：<span id="sys-status-${sys.id}">未知</span></li>
	                <li>状态时间：<span id="sys-time-${sys.id}"></span></li>
	            </ul>
	            <a class="metro-link" target="_blank" href="../devices/status/${sys.id}">详情查询>></a>
	        </div>
	      </div>	      
	    </div>
	    </c:forEach>
	    
	  </div>
	</div>
	
	<!-- 页脚 -->
    <div id="footer">
        <div class="container">
            <div id="footer-text">
            <p class="copyfont text-muted">&copy; 1101 v1.0.0.0</p>
            </div>
        </div>
    </div>
</body>
</html>
