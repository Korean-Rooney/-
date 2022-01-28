package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

public interface BoardDAO {
	
	// boardDAO.insertBoard(boarDTO); 추상메서드
	public void insertBoard(BoardDTO boardDTO);

	// getMaxNum
	public Integer getMaxNum();
	
	//List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
	public List<BoardDTO> getBoardList(PageDTO pageDTO);

	// boardSercive.getBoardCount()
	public int getBoardCount();
}
