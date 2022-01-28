<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/content.jsp</title>
</head>
<body>
<%
// // http://localhost:8080/Study/board/content.jsp?num=1
// int num=Integer.parseInt(request.getParameter("num"));
// //BoardDAO 객체생성
// BoardDAO boardDAO=new BoardDAO();
// // 조회수 증가 update board set readcount= readcount+1 where num=1 
// // 리턴할형 없음  updateReadcount(int num)  메서드 정의
// boardDAO.updateReadcount(num);

// //리턴할형 BoardDTO  getBoard(int num) 메서드 정의
// // BoardDTO boardDTO =  .getBoard(num)  메서드 호출
// BoardDTO boardDTO =boardDAO.getBoard(num);
%>
<table border="1">
<tr><td>글번호</td><td><%//=boardDTO.getNum() %></td>
       <td>작성일</td><td><%//=boardDTO.getDate()%></td></tr>
<tr><td>글쓴이</td><td><%//=boardDTO.getName()%></td>
    <td>조회수</td><td><%//=boardDTO.getReadcount()%></td></tr>
<tr><td>글제목</td><td colspan="3"><%//=boardDTO.getSubject() %></td></tr>
<tr><td>글내용</td><td colspan="3"><%//=boardDTO.getContent() %></td></tr>
<tr><td colspan="4">
<input type="button" value="글수정" onclick="location.href='updateForm.jsp?num=<%//=boardDTO.getNum()%>'">
<input type="button" value="글삭제" onclick="location.href='deleteForm.jsp?num=<%//=boardDTO.getNum()%>'">
<input type="button" value="글목록" onclick="location.href='list.jsp'"></td></tr>
</table>
</body>
</html>