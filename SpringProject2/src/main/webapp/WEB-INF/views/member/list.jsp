<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
</head>
<body>
<%
// // 세션값 가져오기
// String id=(String)session.getAttribute("id");
// // 세션값이 없으면  loginForm.jsp 이동
// if(id==null){
// 	response.sendRedirect("loginForm.jsp");
// }else{
// 	//세션값이 있으면 "admin" 아니면 => main.jsp 이동 
// 	if(!(id.equals("admin"))){
// 		response.sendRedirect("main.jsp");
// 	}
// }

// //MemberDAO 객체생성
// MemberDAO memberDAO=new MemberDAO();
// //리턴할형 List  getMemberList() 메서드 정의
// //List memberList =  getMemberList() 메서드 호출
// // List memberList=memberDAO.getMemberList();
// List<MemberDTO> memberList=memberDAO.getMemberList();

%>
<c:choose>
	<c:when test="${empty sessionScope.id}">
		<c:redirect url="/member/login"></c:redirect>
	</c:when>
	
	<c:otherwise>
		<c:if test="${sessionScope.id ne 'shghdrl'}">
			<c:redirect url="/member/main"></c:redirect>
		</c:if>
	</c:otherwise>
</c:choose>

<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
<%
// for(int i=0;i<memberList.size();i++){
// 	MemberDTO memberDTO=(MemberDTO)memberList.get(i);
// 	MemberDTO memberDTO=memberList.get(i);
	%><tr><td><%//=memberDTO.getId() %></td><td><%//=memberDTO.getPass() %></td>
	      <td><%//=memberDTO.getName() %></td><td><%//=memberDTO.getDate() %></td></tr><%
// }
%>
<c:forEach var="memberDTO" items="${memberList }">
	<tr><td>${memberDTO.id }</td><td>${memberDTO.pass }</td>
		<td>${memberDTO.name }</td><td>${memberDTO.date }</td></tr>
</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/member/main">메인으로 이동</a>
</body>
</html>

