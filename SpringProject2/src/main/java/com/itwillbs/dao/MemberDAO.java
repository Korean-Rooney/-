package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {
	//추상메서드 틀
	public void insertMember(MemberDTO memberDTO);
	
	// 리턴할형 MemberDTO  userCheck(MemberDTO memberDTO) 메서드 정의
	public MemberDTO userCheck(MemberDTO memberDTO);
	
	// MemberDTO memberDTO=memberService.getMember(id);
	public MemberDTO getMember(String id);
	
//	memberService.updateMember(memberDTO);
	public void updateMember(MemberDTO memberDTO);
	
//	memberService.deleteMember(memberDTO);
	public void deleteMember(MemberDTO memberDTO);
	
	// List<MemberDTO> memberList = memberService.getMemberList();
	public List<MemberDTO> getMemberList();
	
}
