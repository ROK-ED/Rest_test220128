<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bank.jsp</title>
</head>
<body>
계좌목록

<input name="fintechUseNum">
<button type="button" id="btnBalance">잔액조회</button>
<div id="divacc" >
<!-- 	<div class="acc" data_usenum="12323232"><span>대구은행</span><span>1111222***</span></div> -->
</div>
<div id="result" ></div>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
accountList();

function accountList() {
	
	$.ajax({
		url :'account',
	}).done(function (result) {
		//console.log(result);
		/*
		var nm = '';
		var list = result.res_list;
		$("#divacc").append("<br>");
		for (i=0; i<list.length; i++){
			
			//$("#divacc").append(`<div class="acc" data_usenum="12323232"><span>대구은행</span><span>1111222***</span></div> <br>`);
			
			var div = $("<div>").addClass("acc")
						.attr("data_usenum",list[i].fintech_use_num)
						.append(`<span>\${list[i].bank_name}</span><span>\${list[i].account_num_masked}</span>`)
						//.html(list[i].account_num_masked)
						;
			
			$("#divacc").append(div);
			//$("#divacc").append("계좌아이디"+(i+1)+" : " +list[i].fintech_use_num+"<br>");	
			//$("#divacc").append("계좌"+(i+1)+" : " +list[i].account_num_masked+"<br>");
		}
		*/
		for(bank of result.res_list){
			$("<div>").addClass("acc")
					.data("usernum",bank.fintech_use_num)
					.append( $("<span>").html(bank.bank_name))
					.append( $("<span>").html(bank.account_num_masked))
					.appendTo("#divacc")
		}
	});
	
	
}
/*
function balance(num) {
	console.log(num);
	$.ajax({
		url :'balance',
		data : {fintechUseNum:num}
	}).done(function (result) {
		console.log(result);
		$("#result").empty();
		$("#result").append("잔액 : "+result.balance_amt);		
	});
}
*/
/*
$("#btnBalance").on("click", function () {
	var num = $('[name="fintechUseNum"]').val();
	$.ajax({
		url :'balance',
		data : {fintechUseNum:num}
	}).done(function (result) {
		console.log(result);
		$("#result").empty();
		$("#result").append("잔액 : "+result.balance_amt);		
	});
	
})
*/

//$("#divacc").on("click", ".span", function () {
//	var num = $(this).closest(".acc").data("usernum");
$("#divacc").on("click", ".acc", function () {
	var num = $(this).data("usernum");
	$.ajax({
		url :'balance',
		data : {fintechUseNum:num}
	}).done(function (result) {
		console.log(result);
		$("#result").empty();
		$("#result").append("잔액 : "+result.balance_amt);		
	});
	
})

</script>
</body>
</html>