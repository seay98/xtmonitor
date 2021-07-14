<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num" value="${1}"/>
[<c:forEach var="dev" items="${sysdevices}">
<c:if test="${num > 1}">,</c:if>
{"devicename":"${dev.name}",
"ipaddr":"${dev.ip}",
"ident":"${dev.ident}",
"devicetype":"${dev.type}",
"belongto":"${dev.sysname}",
"location":"${dev.location}",
"switcher":"${dev.switcher}",
"lmtime":"${dev.lmtime}",
"savetime":"${dev.savetime}",
"state":"${dev.state}",
"statusid":"${dev.statusid}",
"status":"${dev.status}",
"alarm":"${dev.alarm}"}
<c:set var="num" value="${num+1}"/>
</c:forEach>]