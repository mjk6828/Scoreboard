package com.han.pjt.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public String Login(Model model, MemberVO vo) {
		
		return "member/loginForm";
	}
	
	@RequestMapping("/search.do")
	public String search() throws Exception{
		log.info("호출되나요");
		List<MemberVO> vo = memberService.memberlist();
		log.info(vo.size());
		String result = "";
		for(int i=0; i<vo.size(); i++) {
			log.info(vo.get(i).getName());
			result += vo.get(i).getName();
		}
		return result.toString();
	}
}
