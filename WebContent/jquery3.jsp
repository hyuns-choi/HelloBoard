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
		$("#hideIt").click(function(){
			//$("#img1").hide();
			//$("#img1").hide('fast');
			//$("#img1").hide(10000);
			/*
			$("#img1").hide(1000, function(){
				alert("이미지가 사라졌습니다.");
			});
			*/
			
			$("#img1").fadeOut(1000, function(){
				alert("이미지가 사라졌습니다.");
			});
			
		});
		
		$("#showIt").click(function(){
			//$("#img1").show();
			//$("#img1").show('slow');
			//$("#img1").show(5000);
			/*
			$("#img1").show(5000, function(){
				alert("이미지가 나타났습니다.");
			});
			*/
			
			$("#img1").fadeIn(1000, function(){
				alert("이미지가 나타났습니다.");
			});
		});
		
		$("#toggle").click(function(){
			//$("#img1").toggle();
			/*
			$("#img1").toggle(1000, function(){
				alert("이미지가 토글되었습니다.");
			});
			*/
			$("#img1").fadeToggle(1000, function(){
				alert("이미지가 토글되었습니다.");
			});
		});
		
		
		$("#slideDown").click(function(){
			$("#img1").slideDown();
			//$("#img1").show('slow');
			//$("#img1").show(5000);
			
		});
		
		$("#slideUp").click(function(){
			$("#img1").slideUp();
		});
		
		$("#slideToggle").click(function(){
			$("#img1").slideToggle();
		});
		
		$("#aniMate").click(function(){
			// 화면의 반으로 키워라
			$("#img1").animate({width:"50%", opacity:0.3},5000);
		});
		
		
	});
</script>
</head>
<body>
	<div id="Header">
		<img id="img1" src="v30.png">
	</div>
	
	<div>
		<button id="hideIt">Hide</button>
		<button id="showIt">Show</button>
		<button id="toggle">Hide/Show</button>	
		<button id="slideDown">SlideDown</button>
		<button id="slideUp">SlideUp</button>
		<button id="slideToggle">SlideToggle</button>
		<button id="aniMate">Animate</button>
		
	</div>
</body>
</html>