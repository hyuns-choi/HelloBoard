<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var = "cp" />
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery.js"></script>
<!--  <script src="https://code.jquery.com/jquery-3.2.1.js"></script> -->
<script>
// ajax 테스트

	$(document).ready(function(){
		$.ajax({
			type: "get",
			//data:{"command", "select"},
			dataType: "json",
			url: '${cp}/GetBbs',
			success: function(data){
				//alert(data.length);
				$.each(data, function(){
					var trElement = $("table .header").clone().removeClass().empty(); //<tr></tr> 상태
					$("table tbody").append(trElement.addClass("content"));
					trElement.append("<td>" + this.bbsno + "</td>");
					trElement.append("<td>" + this.title + "</td>");
					trElement.append("<td>" + this.uploader + "</td>");
					trElement.append("<td>" + this.readcount + "</td>");
					trElement.append("<td>" + this.regdate + "</td>");
					
					
				});
			},
			error: function(request, status){
				alert(status);
			}
		});
	});
</script>
<style>
	table {
		width: 500;
		border: 1px solid gray;
		font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
		font-size: 12px;
	}
	
	td {
		border: 1px solid gray;
		text-align: center;		
	}
	
	tr.header * {
		background-color: #666666;
		color: white;
	}
</style>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr class="header">
					<th>게시판번호</th><th>제목</th><th>올린이</th><th>조회수</th><th>등록일</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>