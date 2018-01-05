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
<link rel="stylesheet" href="${cp}/style/input2.css" />

</head>
<body>
	<div id="pageContainer">
		<%@ include file="../include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">자료등록정보</div>
					<form id="registerform" action="${cp}/bbs/write" method="post"
						enctype="multipart/form-data">
						<table>
							<tr>
								<th>제목</th>
								<td>
									<input type="text" id="title" name="title" style="width:580px" />
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
									<input type="hidden" name="uploader" value="${sessionScope.loginUser}" />
									${sessionScope.loginUser}
								</td>
							</tr>
							<tr>
								<th>첨부자료</th>
								<td>
									<input type="file" name="attach" style="width:580px;height:20px" />
								</td>
							</tr>
							<tr>
								<th>자료설명</th>
								<td>
									<textarea name="content" style="width:580px" rows="15"></textarea>
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="등록" style="height:25px" />
							<input type="button" value="취소" style="height: 25px"
							onclick="location.href='${cp}/bbs/list	'" />
						</div>
					</form>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>
