<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<%
//세션내장객체에 저장된 "id"=값 을 가져오기 
// String id=(String)session.getAttribute("id");
// 세션값이 없으면 null => loginForm.jsp 이동
// if(id==null){
// 	response.sendRedirect("loginForm.jsp");
// }

// JSTL (JSP Standard Tag Lib)  => JSP에서 태그 처럼 사용할수 있는 표준 라이브러리
// => if , for,  조건문, 반복문, 국제화와 지역화, 날짜형식, 숫자형식 지정
// JSTL  jar 다운 받아서 설치 => pom.xml 기본적으로 설치
// 		<dependency>
// 			<groupId>javax.servlet</groupId>
// 			<artifactId>jstl</artifactId>
// 			<version>1.2</version>
// 		</dependency>
// taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<c:if test="${empty sessionScope.id}">
	<c:redirect url="/member/login"></c:redirect>
</c:if>
${sessionScope.id }님 로그인 하셨습니다.
<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath}/member/info">회원정보조회</a><br>
<a href="${pageContext.request.contextPath}/member/update">회원정보수정</a><br>
<a href="${pageContext.request.contextPath}/member/delete">회원정보삭제</a><br>

<%
//로그인 사용자 => 세션값 있음
// if(id!=null){
	// 로그인 사용자 관리자(admin) 일치 => 회원목록 보이기
// 	if(id.equals("admin")){
		%><%
// 	}
// }
%>
<c:if test="${! empty sessionScope.id }">
	<c:if test="${sessionScope.id  ==  'shghdrl'}">
		<a href="${pageContext.request.contextPath}/member/list">회원목록</a>
	</c:if>
</c:if>
</body>
</html>



