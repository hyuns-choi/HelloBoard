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
<title>자료업로드</title>
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
					<div class="inputsubtitle">업로드자료정보</div>
						<table>
							<tr>
								<th>제목</th>
								<td>
									${bbs.title}
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
									${bbs.uploader}
								</td>
							</tr>
							<tr>
								<th>조회수</th>
								<td>
									${bbs.readcount}
								</td>
							</tr>
							<tr>
								<th>등록일자</th>
								<td>
									<fmt:formatDate value="${bbs.regdate}" pattern="yyyy-MM-dd" />
								</td>
							</tr>
							<tr>
								<th>첨부자료</th>
								<td>
									<c:forEach var="file" items="${files}">
										<a href="${cp}/bbs/download?bbsfileno=${file.bbsFileNo}">
										${file.userFileName}
										</a> &nbsp; ${file.downLoadCount}
									</c:forEach>
								</td>
							</tr>
							<tr>
								<th>자료설명</th>
								<td>
									${bbs.content}
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="등록" style="height:25px" />
							<input type="button" value="취소" style="height: 25px"
							onclick="location.href='${cp}/bbs/list'" />
						</div>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>
