package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

public interface BoardService {

	// boardService.insertBoard(boardDTO); 추상메서드 정의
	public void insertBoard(BoardDTO boardDTO);

	// List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
	public List<BoardDTO> getBoardList(PageDTO pageDTO);

	// boardSercive.getBoardCount()
	public int getBoardCount();
}
