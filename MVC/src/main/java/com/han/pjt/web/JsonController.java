package com.han.pjt.web;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.han.pjt.service.MemberService;
import com.han.pjt.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class JsonController {

	@Resource(name="MemberService")
	private MemberService memberService;
	
	@RequestMapping(value = "/search.do", method=RequestMethod.POST)
	public List<MemberVO> search() throws Exception{
		log.info("호출되나요");
		return memberService.memberlist();
	}
}
