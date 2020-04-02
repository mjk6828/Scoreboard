package com.han.pjt.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.han.pjt.service.BoardService;
import com.han.pjt.vo.BoardVO;
import com.han.pjt.vo.MemberVO;
import com.han.pjt.vo.SelectVO;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class JsonController {
/*
	@Resource(name="MemberService")
	private MemberService memberService;
	*/
	@Resource(name="BoardService")
	private BoardService boardService;
	
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
	@RequestMapping("/boardsearch.do")
	public HashMap<String, Object> boardsearch(SelectVO svo) throws Exception{
		log.info("게시판호출");
		log.info(svo.getCinema()+svo.getDivision()+svo.getFilm()+svo.getLocation()+svo.getTheater());
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<BoardVO> boardlist = boardService.boardlist(svo);
		int boardcount = boardService.boardcount();
		map.put("result", boardlist);
		map.put("count", boardcount);
		return map;
	}
	
}
