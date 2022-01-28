package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	//마이바티스 객체생성
	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace="com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("BoardDAOImpl insertBoard()");
		sqlsession.insert(namespace + ".insertBoard", boardDTO);
		
	
	}

	@Override
	public Integer getMaxNum() {
		
		return sqlsession.selectOne(namespace+".getMaxNum");
	}

	@Override
	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		
		return sqlsession.selectList(namespace+".getBoardList", pageDTO);
	}

	@Override
	public int getBoardCount() {
		
		return sqlsession.selectOne(namespace+".getBoardCount");
	}
		
}

