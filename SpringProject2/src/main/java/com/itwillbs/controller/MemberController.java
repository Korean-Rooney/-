package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@Controller
public class MemberController{
	
	// 멤버변수 =>xml에서 객체생성해서 set메서드 통해서 전달 => 스프링객체생성 방식 
	// 스프링객체생성 => 의존관계주입(DI:Dependency Injection)
//	MemberService memberService=new MemberServiceImpl();
	@Inject
	private MemberService memberService;
	
//	//생성자
//	@Inject
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	
//	//set메서드 
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	// http://localhost:8080/myweb/member/board/write
	
	
	// http://localhost:8080/myweb/member/insert
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// /WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
	}
	// http://localhost:8080/myweb/member/insertPro
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		// insertForm.jsp name="id", MemberDTO의 멤버변수 private String id; 일치=> 자동동작
		//회원가입처리
		System.out.println("/member/insertPro");
//		MemberDTO memberDTO=new MemberDTO();
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setPass(request.getParameter("pass"));
//		memberDTO.setName(request.getParameter("name"));
		
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		//Controller =>   처리작업파일  =>   디비작업파일 
		
		//MemberController => MemberServiceImpl => MemberDAOImpl 
		
		// 파일 만들기  패키지 com.itwillbs.controller  파일 MemberController
		// 파일 만들기  패키지 com.itwillbs.service  인터페이스 파일 MemberService
		//                                       클래스 파일 MemberServiceImpl
		// 파일 만들기  패키지 com.itwillbs.dao  인터페이스  파일 MemberDAO
		//                                    클래스 파일 MemberDAOImpl
		
//		// 1. 3곳 수정
//		// MemberServiceImpl 객체생성 => 기억장소 할당
//		MemberServiceImpl memberService=new MemberServiceImpl();
//		//insertMember() 메서드 호출
//		memberService.insertMember(memberDTO);
		
//		//2. 1곳 수정  부모인터페이스 틀 만들고 => 상속받은 클래스 객체생성
//		//부모인터페이스 MemberService =  MemberServiceImpl 객체생성 => 기억장소 할당
//		MemberService memberService=new MemberServiceImpl();
//		//insertMember() 메서드 호출
//		memberService.insertMember(memberDTO);
		
		//3. 0곳 수정  부모인터페이스MemberService  틀 만들고 
		//  => 스프링파일 root-context.xml에서  상속받은 클래스 MemberServiceImpl 객체생성
		//  => xml에서 MemberController set호출,생성자를 호출해서 객체생성 전달
		
		//insertMember() 메서드 호출
		memberService.insertMember(memberDTO);
		
		
		// response.sendRedirect() /member/login
		return "redirect:/member/login";
	}
	
	//http://localhost:8080/myweb/member/login
	// /WEB-INF/views/member/loginForm.jsp
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		// /WEB-INF/views/member/loginForm.jsp
		return "member/loginForm";
	}
	
	// http://localhost:8080/myweb/member/loginPro
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		//로그인처리
		System.out.println("/member/loginPro");
		// 리턴할형 MemberDTO  userCheck(MemberDTO memberDTO) 메서드 정의 
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			//세션 값 생성
			session.setAttribute("id", memberDTO.getId());
			// response.sendRedirect() /member/main
			return "redirect:/member/main";
		}else {
			//null이면 아이디 비밀번호 틀림 뒤로이동
			return "member/msg";
		}
	}
	
	
		//http://localhost:8080/myweb/member/main
		// /WEB-INF/views/member/main.jsp
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		// /WEB-INF/views/member/main.jsp
		return "member/main";
	}
	
	//http://localhost:8080/myweb/member/logout
@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
public String logout(HttpSession session) {
	//로그아웃  세션값 초기화
	session.invalidate();
	
	return "redirect:/member/main";
}
	
	
	//http://localhost:8080/myweb/member/info
	// /WEB-INF/views/member/info.jsp
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {
		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		// 디비에 세션값에 대한 정보 조회 가져오기
		MemberDTO memberDTO=memberService.getMember(id);
		// 조회해서 가져온 정보 저장해서 info.jsp로 들고감
		model.addAttribute("memberDTO",memberDTO);
		// /WEB-INF/views/member/info.jsp
		return "member/info";
	}
	
	
	//http://localhost:8080/myweb/member/update
	// /WEB-INF/views/member/updateForm.jsp
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		// 디비에 세션값에 대한 정보 조회 가져오기
		MemberDTO memberDTO=memberService.getMember(id);
		// 조회해서 가져온 정보 저장해서 info.jsp로 들고감
		model.addAttribute("memberDTO",memberDTO);
		// /WEB-INF/views/member/updateForm.jsp
		return "member/updateForm";
	}
	
	// http://localhost:8080/myweb/member/updatePro
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		//수정처리
		System.out.println("/member/updatePro");
		// 리턴할형 MemberDTO  userCheck(memberDTO) 메서드 호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			//수정작업 메서드 호출
			memberService.updateMember(memberDTO);
			// response.sendRedirect() /member/main
			return "redirect:/member/main";
		}else {
			//입력하신 정보 틀림
			//null이면 아이디 비밀번호 틀림 뒤로이동
			return "member/msg";
		}
	}
	
	
	//http://localhost:8080/myweb/member/delete
	// /WEB-INF/views/member/deleteForm.jsp
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		// /WEB-INF/views/member/deleteForm.jsp
		return "member/deleteForm";
	}
	
	// http://localhost:8080/myweb/member/deletePro
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO,HttpSession session) {
		//삭제처리
		System.out.println("/member/deletePro");
		// 리턴할형 MemberDTO  userCheck(memberDTO) 메서드 호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			//삭제작업 메서드 호출
			memberService.deleteMember(memberDTO);
			//세션값 초기화
			session.invalidate();
			// response.sendRedirect() /member/main
			return "redirect:/member/main";
		}else {
			//입력하신 정보 틀림
			//null이면 아이디 비밀번호 틀림 뒤로이동
			return "member/msg";
		}
	}
	
	//http://localhost:8080/myweb/member/list
	// /WEB-INF/views/member/list.jsp
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		// member정보 조회
		List<MemberDTO> memberList = memberService.getMemberList();
		// model 담아서 list.jsp 가지고 감
		model.addAttribute("memberList",memberList);
		// /WEB-INF/views/member/list.jsp
		return "member/list";
	}
	
	@RequestMapping(value = "/test/test1", method = RequestMethod.GET)
	public String test1() {
		// /WEB-INF/views/member/insertForm.jsp
		return "test/test1";
	}
	
	@RequestMapping(value = "/test/test2", method = RequestMethod.GET)
	public String test2() {
		// /WEB-INF/views/member/insertForm.jsp
		return "test/test2";
	} 
	
	@RequestMapping(value = "/test/test3", method = RequestMethod.GET)
	public String test3() {
		// /WEB-INF/views/member/insertForm.jsp
		return "test/test3";
	}
	
}
