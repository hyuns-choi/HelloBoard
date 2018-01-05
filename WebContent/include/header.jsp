<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<div id="header">
	<div class="title">
		<a href="${cp}">Hello Board</a>
	</div>
	<div class="links">
		<c:if test="${empty sessionScope.loginUser}">
			<a href="${cp}/account/login.jsp">로그인</a>
			<a href="${cp}/account/register.jsp">등 록</a>
		</c:if>
		<c:if test="${!empty sessionScope.loginUser}">
			${sessionScope.loginUser}님 환영합니다.
			<a href="${cp}/account/logout">로그아웃</a>
		</c:if>
	</div>
</div>
<div id="menu">
		<div>
			<ul>
				<li><a href="${cp}/bbs/list">게시판</a></li>
			</ul>
		</div>
	</div>
</div>
