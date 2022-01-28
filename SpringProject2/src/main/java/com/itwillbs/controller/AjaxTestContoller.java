package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxTestContoller {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value ="test/ajaxtest1", method = RequestMethod.GET)
	public ResponseEntity<String> ajaxtest1(HttpServletRequest request) {
		// id 파라미터 가져오기
		String id = request.getParameter("id");
		//id 중복 조회
		String result="";
		
		MemberDTO memberDTO = memberService.getMember(id);
		
		if(memberDTO==null) {
			// 아이디 사용가능
			result="idOk";
		}else {
			// 아이디 중복
			result="idDup";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(result,HttpStatus.OK);
		
		return entity;
		
	}
	@RequestMapping(value ="test/ajaxtest2", method = RequestMethod.GET)
	public ResponseEntity<String> ajaxtest2(HttpServletRequest request) {
		// id 파라미터 가져오기
		String email = request.getParameter("email");
		//id 중복 조회
		String result="";
		
		MemberDTO memberDTO = memberService.getMember(email);
		
		if(memberDTO==null) {
			// 아이디 사용가능
			result="mailOk";
		}else {
			// 아이디 중복
			result="mailDup";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(result,HttpStatus.OK);
		
		return entity;
		
	}
	@RequestMapping(value = "/test/ajaxtest3", method = RequestMethod.GET)
	public ResponseEntity<List<MemberDTO>> ajaxtest3() {
		System.out.println("안녕");
		List<MemberDTO> memberList = memberService.getMemberList();
		
ResponseEntity<List<MemberDTO>> entity=new ResponseEntity<List<MemberDTO>>(memberList,HttpStatus.OK);
		return entity;
	}
	
}
