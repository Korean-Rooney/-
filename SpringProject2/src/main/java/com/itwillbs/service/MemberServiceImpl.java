package com.itwillbs.service;

import com.itwillbs.dao.MemberDAOImpl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	// 멤버변수 => 객체생성
//	MemberDAO memberDAO=new MemberDAOImpl();
	@Inject
	private MemberDAO memberDAO;
	
	//set메서드
//	@Inject
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		
//		//1. 3곳 수정
//		// MemberDAOImpl 객체생성 => 기억장소 할당
//		MemberDAOImpl memberDAO=new MemberDAOImpl();
//		//insertMember() 메서드 호출
//		memberDAO.insertMember(memberDTO);
		
//		//2. 1곳 수정  부모인터페이스 틀 만들고 => 상속받은 클래스 객체생성
//		//부모인터페이스 MemberDAO =  MemberDAOImpl 객체생성 => 기억장소 할당
//		MemberDAO memberDAO=new MemberDAOImpl();
//		//insertMember() 메서드 호출
//		memberDAO.insertMember(memberDTO);
		
		//3. 0곳 수정  부모인터페이스memberDAO  틀 만들고 
		//  => 스프링파일 root-context.xml에서  상속받은 클래스 memberDAOImpl 객체생성
		//  => xml에서 MemberServiceImpl set호출,생성자를 호출해서 객체생성 전달
		
		//insertMember() 메서드 호출
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		memberDAO.insertMember(memberDTO);
		
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		return memberDAO.userCheck(memberDTO);
	}

	@Override
	public MemberDTO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		memberDAO.updateMember(memberDTO);
	}

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		memberDAO.deleteMember(memberDTO);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		System.out.println("서비스");
		return memberDAO.getMemberList();
	}
	

}
