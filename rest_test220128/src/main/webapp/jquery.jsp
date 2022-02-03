<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery연습</title>
<style>
	.active {background-color: red }
</style>
</head>
<body>
<ul class="klist">
	<!-- <li class="active dd aaa">java -->
	<li data-price="500" data-pub="영진">java
	<li data-price="300">jsp
	<li data-price="400">spring
</ul>
<button type="button" id="btnCount">선택확인</button>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$("li").on("click",function(){
		//$(event.target) 또는 $(this) ~둘다 상관없음
		//$(event.target).css("backgroundColor","yellowgreen"); 
		/*
		if( $(this).hasClass("active")){
			$(this).removeClass("active");		
		} else {
			$(this).addClass("active");
		}
		*/
		$(this).toggleClass("active");
		//console.log($(this).data("price"));
		alert($(this).data("price"));
	});
	
	$("#btnCount").on("click", function(){
		//클래스가 active 태그 찾아서 갯수 출력
		//alert( $(".active").length + "가 선택됨" );
		
		//선택된 태그의 내용을 콘솔에 출력
		var list = $(".active");
		console.log(list);
		
		for (i=0; i<list.length; i++){
			//입력 멈춤 디버그 상태가됨
			//debugger
			//console.log(list[i].childNodes[0].textContent);
			console.log( $(list[i]).html() );
		}
		
		 for (temp of list) {
			console.log( $(temp).html());
		}
		
		$.each(list, function(i, item){
			console.log( $(item).html());
		}); 
		
	});
	
	
</script>
</body>
</html>