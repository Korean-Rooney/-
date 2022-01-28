<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/updateForm.jsp</title>
</head>
<body>
<%
// //http://localhost:8080/Study/board/updateForm.jsp?num=1
// int num=Integer.parseInt(request.getParameter("num"));
// //BoardDAO 객체생성
// BoardDAO boardDAO=new BoardDAO();
// //BoardDTO boardDTO =  .getBoard(num)  메서드 호출
// BoardDTO boardDTO =boardDAO.getBoard(num);
%>
<form action="updatePro.jsp" method="get">
<input type="hidden" name="num" value="<%//=num%>">
	<table border="1">
		<tr><td>글쓴이</td>
		    <td><input type="text" name="name" value="<%//=boardDTO.getName()%>"></td></tr>
		<tr><td>비밀번호</td>
		    <td><input type="password" name="pass"></td></tr>
		<tr><td>제목</td>
		    <td><input type="text" name="subject" value="<%//=boardDTO.getSubject()%>"></td></tr>
		<tr><td>내용</td>
		    <td><textarea name="content" rows="10" cols="20"><%//=boardDTO.getContent()%></textarea></td></tr>
		<tr><td colspan="2"><input type="submit" value="글수정"></td></tr>
	</table>
</form>
</body>
</html>

