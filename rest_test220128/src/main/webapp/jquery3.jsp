<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<input name="kor"><input name="eng">
<button id="btnAdd" type="button">추가</button>

<button id="btnScore" type="button">국어성적합계</button>
<table>
   <thead>
      <tr>
         <td>국어</td>
         <td>영어</td>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>40</td>
         <td>60</td>
      </tr>
      <tr>
         <!-- <td id="kor">80</td> -->
         <td>80</td>
         <td>100</td>
      </tr>
      <tr>
         <td>60</td>
         <td>60</td>
      </tr>
   </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	//국어성적합께 버튼을 클릭하면 국어성적의 합계를 계산해서 alert로 출력
	$("#btnScore").on("click", function () {
		console.log($("tbody").find("tr").find("td:nth-child(1)"));
		var list = $("tbody").find("tr").find("td:nth-child(1)");
		var sum = 0;
		for(score of list){
			//console.log(score.innerHTML);
			sum += parseInt(score.innerHTML);
		}
		alert(sum);		
	});
	//추가 버튼을 클릭하면 input 태그의 값으로 <tr> 생성해서 테이블 추가
	$("#btnAdd").on("click", function () {
		//debugger
		console.log($('[name="kor"]').val());
		console.log($('[name="eng"]').val());
		var tr = $("<tr>");
		var kor = $("<td>").html($('[name="kor"]').val());
		tr.append(kor);
		var eng = $("<td>").html($('[name="eng"]').val());
		tr.append(eng);
		
		$("tbody").append(tr);
		
	});
</script>
</body>
</html>