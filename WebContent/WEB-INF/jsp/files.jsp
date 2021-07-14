<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>报文监控</title>
<link rel="stylesheet" href="/xtmon/resources/jqw/styles/jqx.base.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/jqw/styles/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/css/global.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/css/files.css" type="text/css" />
<script type="text/javascript" src="/xtmon/resources/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/bootstrap.min.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxcore.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxdraw.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxchart.core.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxdata.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxscrollbar.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.columnsresize.js"></script>
    <script type="text/javascript" src="/xtmon/resources/jqw/jqxbuttons.js"></script>
    <script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.selection.js"></script>

<script type="text/javascript" src="/xtmon/resources/scripts/functions.js"></script>
<script type="text/javascript" src="/xtmon/resources/scripts/files.js"></script>
</head>
<body>
	<!-- 导航栏 -->
    <div id="hbar" class="navbar navbar-default navbar-fixed-top">
        <ul id="myTab" class="nav nav-tabs">
            <li style="margin-left: 20px;"><a href="/xtmon/">设备状态监控</a></li>
            <li class="active"><a href="/xtmon/files/status">报文状态监控</a></li>
            <li><a href="#fitness">设备管理</a></li>
        </ul>
    </div>
    
	<!-- 页头 -->
	<div id="header" class="jumbotron">
        <div class="container">
            <h1>报文传输状态监控</h1>
            <h3 id="curtime"></h3>
        </div>
    </div>
    
    <!-- 页面 -->
    <div id="main" class="container">
        <div id="fileschart" class="metro-border"></div>
        <div id="filesgrid" class="metro-border"></div>
        <div id="filesline" class="metro-border"></div>
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