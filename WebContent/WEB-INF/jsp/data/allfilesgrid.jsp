<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num" value="${1}"/>
[<c:forEach var="files" items="${filestoday}">
<c:if test="${num > 1}">,</c:if>
{"system":"<c:choose><c:when test="${files.sysalias!=''}">${files.sysalias}(${files.sysname})</c:when><c:otherwise>${files.sysname}</c:otherwise></c:choose>",
"count":"${files.count}",
"lmtime":"${files.ltime}",
"span":"${files.span}"}
<c:set var="num" value="${num+1}"/>
</c:forEach>]