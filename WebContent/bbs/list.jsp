<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}" var = "cp" />
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="${cp}/style/default.css" />
</head>
<body>
	<div id="pageContainer">
		<%@ include file="../include/header.jsp" %>
		
		<div style="padding-top:25px;text-align:center">
			[<a href="${cp}/bbs/write">자료등록</a>]
			<br/><br/>
			
			<table border="1" style="width:600px" align="center">
				<tr style="background-color:orange;height:30px">
					<th style="width:50px">번호</th>
					<th style="width:400px">제목</th>
					<th style="width:150px;text-align:center">작성일</th>
				</tr>
				<c:forEach var="bbs" items="${bbslist}">
				<tr style="height:30px">
					<td>${bbs.bbsno}</td>
					<td style="text-align:left;padding-left:10px">
						<a href="${cp}/bbs/detail?bbsno=${bbs.bbsno}">${bbs.title}</a>
					</td>
					<td>
						<fmt:formatDate value="${bbs.regdate}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				</c:forEach>
					
			</table>
			
		</div>
		
	</div>

</body>
</html>