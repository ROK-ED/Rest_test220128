<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.active {background-color: red }
</style>
</head>
<body>
<ul class="klist">
   <li data-price="500">java<button type="button" class="btnPrice">가격확인</button>
</ul>
<button type="button" id="btnAdd">추가</button>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
   let datas = [
              {name:'javascript', price:1000},
            {name:'html', price:2000},
            {name:'css', price:3000}
            ]
   $("#btnAdd").on("click",function(){
      for(data of datas) {
         //html() data() append()
         var btn = $("<button>").attr("type","button")
         						.addClass("btnPrice")
								.html("가격확인");
         
         var li = $("<li>").data("price",data.price)
                         .html(data.name)
                         .append(btn);
                         
         $(".klist").append(li);
         
      }
      
   });

   /* $("li").on("click", function(){
	  
      event.stopPropagation()//전파중지
      $(this).toggleClass("active")
      //가격을 alert
      var price = $(this).data("price");
      alert(price);
   }) */
   
    //그룹이벤트 : 동적으로 추가된 태그에 대해서 이벤트 지정하려면 부모에 이벤트를 지정
    $(".klist").on("click","li", function(){
	  
      event.stopPropagation()//전파중지
      $(this).toggleClass("active")
      //가격을 alert
      //var price = $(this).data("price");
      //alert(price);
   })
   
    $(".klist").on("click",".btnPrice", function(){
	  
      event.stopPropagation()//전파중지
      //가격을 alert
      //var price = $(this).parent().data("price");
      var price = $(this).closest("li").data("price");
      alert(price);
   })
   
  
   
   
   
   
/*   
   $(".klist").on("click",function(){
      alert("클릭")
   })
 */
</script>
</body>
</html>