<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}" var="cp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>로그인</title>
<link rel="stylesheet" href="${cp}/style/default.css" />
<link rel="stylesheet" href="${cp}/style/input.css" />
</head>
<body>
	<div id="pageContainer">
		<%@ include file="../include/header.jsp"%>

		<div id="inputcontent">
			<br />
			<br />
			<div id="inputmain">
				<div class="inputsubtitle">로그인 정보</div>

				<form action="${cp}/login" method="post">
					<table>
						<tr>
							<th>아이디(id)</th>
							<td><input type="text" name="memberid" style="width: 280px" />
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="passwd"
								style="width: 280px" /></td>
						</tr>
					</table>
					<div class="buttons">
						<input type="submit" value="로그인" style="height: 25px" /> 
						<input type="button" value="취소" style="height: 25px"
							onclick="location.href='${cp}/index.jsp'" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
