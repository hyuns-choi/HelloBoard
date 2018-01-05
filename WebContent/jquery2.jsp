<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery.js"></script>
<!--  <script src="https://code.jquery.com/jquery-3.2.1.js"></script> -->
<script>
	$(document).ready(function(){
		$("li").css("border", "#ff0000 1px solid"); // or
		//$("ul > li").css("border", "#ff0000 1px solid");
		$("li.optimus").css("border", "#0000ff 1px solid"); // or
		
		//$("#img1").attr("title","----변경가능303030");
		//$("#img1").attr({"title":"변경가능303030", "alt":"010-111-3111"});
		//$("#img1").attr({"title":"변경가능303030"});
		
		$("#img1").attr("title", function(){
			return $("#img1").attr("src");
		});
		
		
		var title = $("#img1").attr("title");
		alert(title);
	});
</script>
</head>
<body>
	<ul>
		<li>갤럭시</li>
		<li class="optimus">
			<img id="img1" src="v30.png" title="v30입니다.">옵티머스
		</li>
		<li>아이폰</li>		
	</ul>
</body>
</html>