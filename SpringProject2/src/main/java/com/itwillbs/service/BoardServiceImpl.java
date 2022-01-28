package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("BoardServiceImpl insertBoard()");
		// name pass subject content 폼에서 가져옴
		// num readcount date 구하기 => boardDTO 저장
		boardDTO.setReadcount(0);
		boardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		// max(num)+1
		if(boardDAO.getMaxNum()==null) {
			// 게시판 글 없는 경우
			boardDTO.setNum(1);
		} else {
			// 게시판 글 있는 경우
			boardDTO.setNum(boardDAO.getMaxNum()+1);
		}
	 
	
		boardDAO.insertBoard(boardDTO);
	}

	@Override
	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("BoardServiceImpl getBoardList()");
		// pageSize pageNum 가지고 감
		// currentPage startRow endRow 구하기
		pageDTO.setCurrentPage(Integer.parseInt(pageDTO.getPageNum()));
		pageDTO.setStartRow((pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1);
		pageDTO.setEndRow(pageDTO.getStartRow()+pageDTO.getPageSize()-1);
		
		// 디비에서 #{startRow}-1
		pageDTO.setStartRow(pageDTO.getStartRow()-1);
		
		return boardDAO.getBoardList(pageDTO);
		
		
	}

	@Override
	public int getBoardCount() {
		
		return boardDAO.getBoardCount();
	}

}
