<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>设备状态</title>
<link rel="stylesheet" href="/xtmon/resources/jqw/styles/jqx.base.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/jqw/styles/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/css/global.css" type="text/css" />
<link rel="stylesheet" href="/xtmon/resources/css/devices.css" type="text/css" />

<script type="text/javascript" src="/xtmon/resources/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/bootstrap.min.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxcore.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxdata.js"></script> 
<script type="text/javascript" src="/xtmon/resources/jqw/jqxbuttons.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxscrollbar.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxlistbox.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxdropdownlist.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxmenu.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.sort.js"></script> 
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.columnsresize.js"></script>
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.selection.js"></script> 
<script type="text/javascript" src="/xtmon/resources/jqw/jqxgrid.edit.js"></script> 

<script type="text/javascript" src="/xtmon/resources/scripts/functions.js"></script>
<script type="text/javascript" src="/xtmon/resources/scripts/devices.js"></script>
</head>
<body>
	<input type="hidden" name="sysid" id="sysid" value="${sysid}"></input>
	<!-- 导航栏 -->
    <div id="hbar" class="navbar navbar-default navbar-fixed-top">
        <ul id="myTab" class="nav nav-tabs">
            <li style="margin-left: 20px;" class="active"><a href="/xtmon/">设备状态监控</a></li>
            <li><a href="/xtmon/filestatus">报文状态监控</a></li>
            <li><a href="#fitness">设备管理</a></li>
        </ul>
    </div>

	<!-- 页面 -->
    <div id="main" class="container">
		<div id="devicelist"></div>
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