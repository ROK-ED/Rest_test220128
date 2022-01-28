<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<h3>박스오피스</h3>
<div id="result"></div>
<div id="info"></div>
<script >
function movieList() {
	var url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220127";
	$.ajax({
		url : url,/*success 대신 .done 사용*/
	}).done( function(datas) { 
		//var nm = datas.boxOfficeResult.dailyBoxOfficeList[0].movieNm
		//$("#result").html(JSON.stringify(nm));
		//$("#result").html(JSON.stringify(datas));
		
		var nm = '';
		var list = datas.boxOfficeResult.dailyBoxOfficeList;
		for (i=0; i<list.length; i++){
			$("#result").append(`<a href =javascript:console.log(this); >\${i+1} \${list[i].movieNm} </a> <br>`);		
		}	
	});	
}

movieList();

function mivieInfo(cd) {
//배우 리스트 및 감독
var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+cd;
$.ajax({
	url : url,/*success 대신 .done 사용*/
}).done( function(datas) { 
	var nm = '';
	var list = datas.movieInfoResult.movieInfo.actors;
	$("#info").append("<br>");
	for (i=0; i<list.length; i++){
		$("#info").append("배우"+(i+1)+" : " +list[i].peopleNm+"<br>");		
	}	
	$("#info").append("<br>"+"감독 : "+ datas.movieInfoResult.movieInfo.directors[0].peopleNm+"<br>");
});

}
</script>
</body>
</html>