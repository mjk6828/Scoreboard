package com.han.pjt.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.han.pjt.service.MemberService;
import com.han.pjt.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {

	@Resource(name="MemberService")
	private MemberService memberService;
	
	
	@RequestMapping("/member.do")
	public String member(Model model) throws Exception{
		
		List<MemberVO> vo = memberService.memberlist();
		model.addAttribute("vo",vo);
		
		return "member/member";
	}
	
	@RequestMapping("/Main.do")
	public String Main() throws Exception{
		log.info("Main Page");
		return "Main";
	}
	@RequestMapping("/Login.do")
	public String Login(Model model, MemberVO vo, HttpSession session) {
		
		return "member/loginForm";
	}

	
	@RequestMapping(value = "/LoginForm.do", method=RequestMethod.POST)
	public String loginform(Model model, MemberVO vo, HttpSession session) throws Exception{
		log.info("로그인 페이지");
		MemberVO mvo = memberService.memberone(vo);
		if(vo.getPass().equals(mvo.getPass())) {
			log.info("로그인 성공");
			session.setAttribute("login", mvo);
			return "member/loginOK";
		}else {
			log.info("로그인 실패");
			return "member/loginErr";
		}
	}
	@RequestMapping(value = "/Logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/Main.do";
	}
}
