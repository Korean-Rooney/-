package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {

	// 스프링 객체 생성(의존관계주입DI) :부모 인터페인터페이스 멤버변수 xml에서 객체생성해서 set 메서드 통해서 생성 값 전달 
	@Inject
	private BoardService boardService;
	
	// http://localhost:8080/myweb/board/write
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String insert() {
		// /WEB-INF/views/member/writeForm.jsp
		return "board/writeForm";
	}
	
	// http://localhost:8080/myweb/board/write
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String insertPro(BoardDTO boardDTO) {
		System.out.println("BoardController /board/writePro");
		// 디비 insert => BoardServiceImpl => BoardDAOImpl
		boardService.insertBoard(boardDTO);
		
		// 가상주소 /board/list
		return "redirect:/board/list";
	}
	
	// http://localhost:8080/myweb/board/write
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		PageDTO pageDTO = new PageDTO();
		// 한 페이지에 보여줄 글 개수
		pageDTO.setPageSize(3);
		
		// 현페이지 가져오기
		if(request.getParameter("pageNum")==null) {
			pageDTO.setPageNum("1");
		} else {
			pageDTO.setPageNum(request.getParameter("pageNum"));
		}
//		List<BoardDTO> boardList = boardDAO.getBoardList(startRow,pageSize);
		List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
		
		// int count=boardDAO.getBoardCount(); => page관련 값 계산
		pageDTO.setCount(boardService.getBoardCount());
		
		
		// model 담아서 list.jsp 전달
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		// /WEB-INF/views/member/list.jsp
		return "board/list";
	}
}
