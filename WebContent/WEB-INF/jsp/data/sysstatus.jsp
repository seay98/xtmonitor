<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num" value="${1}"/>
[<c:forEach var="sys" items="${syss}">
<c:if test="${num > 1}">,</c:if>
{"id":"${sys.id}",
"status":"${sys.state}",
"time":"${sys.statetime}"}
<c:set var="num" value="${num+1}"/>
</c:forEach>]