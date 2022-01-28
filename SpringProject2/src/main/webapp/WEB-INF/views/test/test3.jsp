<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노홍기_통합구현구현_실기시험_파일_test3.jsp</title>
<script src="${pageContext.request.contextPath}/resources/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// id="btn"
		$('#btn').click(function(){
			alert("클릭");
// 			$.getJSON('${pageContext.request.contextPath}/test/ajaxtest3',function(rdata){
// 				$.each(rdata,function(index,item){
// 	$('table').append('<tr><td>'+item.id+'</td><td>'+item.pass+'</td><td>'+item.name+'</td><td>'+item.date+'</td></tr>');
// 				});
// 			});

			$.ajax({
				url:'${pageContext.request.contextPath}/test/ajaxtest3',
				dataType:'json',
				success:function(rdata){
// 					alert("클릭");
					$.each(rdata,function(index,item){
						$('table').append('<tr><td>'+item.id+'</td><td>'+item.pass+'</td><td>'+item.name+'</td><td>'+item.date+'</td></tr>');
					});
				}
			});
			
		});
		

	});
	</script>

</head>
<body>
<h3>3번)회원목록조회버튼 클릭시 회원목록 가져와서 출력하세요</h3>
<h3>회원목록조회 버튼 클릭시 테이블에 회원목록조회 보이게 하세요</h3>

<input type="button" value="회원목록조회" id="btn">
<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>날짜</td></tr>
</table>
</body>
</html>