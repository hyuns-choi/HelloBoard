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
	$(document).ready(function(){
		$.ajax({
			type: "get",
			//data:{"command", "select"},
			dataType: "json",
			url: '${cp}/GetMembers',
			success: function(data){
				//alert(data.length);
				$.each(data, function(){
					var trElement = $("table .header").clone().removeClass().empty(); //<tr></tr> 상태
					$("table tbody").append(trElement.addClass("content"));
					trElement.append("<td>" + this.memberid + "</td>");
					trElement.append("<td>" + this.passwd + "</td>");
					trElement.append("<td>" + this.email + "</td>");
					trElement.append("<td>" + this.usertype + "</td>");
					trElement.append("<td>" + this.active + "</td>");
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
					<th>사용자아이디</th><th>비번</th><th>이메일</th><th>사용자type</th><th>active</th><th>등록일</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>