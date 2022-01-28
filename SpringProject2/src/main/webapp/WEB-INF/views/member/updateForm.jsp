<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/updateForm.jsp</title>
</head>
<body>
<%
// //세션내장객체에 저장된 "id"=값 을 가져오기 
// String id=(String)session.getAttribute("id");
// //MemberDAO 객체생성
// MemberDAO memberDAO=new MemberDAO();
// //MemberDTO memberDTO =  getMember(id) 메서드 호출
// MemberDTO memberDTO=memberDAO.getMember(id);
	%>
<form action="${pageContext.request.contextPath}/member/updatePro" method="post">
아이디:<input type="text" name="id" value="${memberDTO.id }" readonly><br>
비밀번호 : <input type="password" name="pass"><br>
이름:<input type="text" name="name" value="${memberDTO.name }"><br>
<input type="submit" value="회원정보수정">
</form>	

</body>
</html>

