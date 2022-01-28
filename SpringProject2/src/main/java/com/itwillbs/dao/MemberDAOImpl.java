package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	//마이바티스 자동으로 객체생성
	@Inject
	private SqlSession sqlSession;
	
	//sql구문 들어있는 파일 이름 변수 정의
	private static final String namespace="com.itwillbs.mapper.MemberMapper";

//	//멤버변수
////	private DataSource dataSource;
//	private SimpleJdbcTemplate template;
//	
//	//set메서드 
//	@Inject
//	public void setDataSource(DataSource dataSource) {
////		this.dataSource = dataSource;
//		template=new SimpleJdbcTemplate(dataSource);
//	}

//	String insertMember="insert into member(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		// 디비작업 => 필요한 프로그램 JDBC프로그램 , 스프링 JDBC 프로그램 
		// =>메이븐 사이트에 모든 프로그램 저장 => 메이븐 코드 pom.xml=>메이븐 사이트 자동 다운
//		template.update(insertMember, memberDTO.getId(),memberDTO.getPass(),memberDTO.getName(),memberDTO.getDate());
		// (xml sql구문  이름, ?들어갈 memberDTO 멤버변수 값)
		sqlSession.insert(namespace+".insertMember", memberDTO);
		
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
	}

	@Override
	public MemberDTO getMember(String id) {
		return sqlSession.selectOne(namespace+".getMember", id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		sqlSession.update(namespace+".updateMember", memberDTO);
	}

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		sqlSession.delete(namespace+".deleteMember", memberDTO);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		System.out.println("DAO");
		return sqlSession.selectList(namespace+".getMemberList");
	}

}
