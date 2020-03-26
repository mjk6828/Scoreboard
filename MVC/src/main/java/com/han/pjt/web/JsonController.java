package com.han.pjt.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.han.pjt.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class JsonController {
/*
	@Resource(name="MemberService")
	private MemberService memberService;
	*/
	@RequestMapping("/search.do")
	public MemberVO search() throws Exception{
		log.info("호출되나요");
		
		MemberVO vo = new MemberVO();
		vo.setName("abc");
		vo.setEmail("abc");
		vo.setPass("abc");
		log.info(vo.getName()+vo.getPass()+vo.getEmail());
		return vo;
	}
	
	@RequestMapping(value="/search2.do")
	public ResponseEntity<Map<Integer, MemberVO>> searchmap(){
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		for(int i=0; i <= 5; i++) {
			MemberVO vo = new MemberVO();
			vo.setName("abc"+i);
			vo.setNum(i);
			vo.setPhone(9+i);
			map.put(i, vo);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
