<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set value="${pageContext.request.contextPath}" var = "cp" />
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet" href="${cp}/style/default.css" />
</head>
<body>
	<div id="pageContainer">
		<%@ include file="../include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<h2 style="text-align:center">Welcome to oraclejava!</h2>
		</div>
		
	</div>

</body>
</html>