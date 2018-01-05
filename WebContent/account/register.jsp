<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set value="${pageContext.request.contextPath}" var = "cp" />
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>사용자등록</title>
<link rel="stylesheet" href="${cp}/style/default.css" />
<link rel="stylesheet" href="${cp}/style/input.css" />

</head>
<body>
	<div id="pageContainer">
		<%@ include file="../include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">회원기본정보</div>
					<form id="registerform" action="${cp}/account/register" method="post">
						<table>
							<tr>
								<th>아이디(id)</th>
								<td>
									<input type="text" id="memberid" name="memberid" style="width:280px" />
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<input type="password" id="passwd" name="passwd" style="width:280px" />
								</td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td>
									<input type="password" id="confirm" name="confirm" style="width:280px" />
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>
									<input type="text" id="email" name="email" style="width:280px" />
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="등록" style="height:25px" />
							<input type="button" value="취소" style="height: 25px"
							onclick="location.href='${cp}/index.jsp'" />
						</div>
					</form>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>
