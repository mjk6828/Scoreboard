package com.han.pjt.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.han.pjt.service.BoardService;
import com.han.pjt.service.MemberService;
import com.han.pjt.vo.BoardVO;
import com.han.pjt.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class JsonController {
	
/*	 @Resource(name="MemberService")
	 private MemberService memberService;*/
	 @Resource(name="BoardService")
	 private BoardService boardService;
	 
	 
	@RequestMapping("/search.do")
	public MemberVO search() throws Exception {
		log.info("호출되나요");

		MemberVO vo = new MemberVO();
		vo.setName("abc");
		vo.setEmail("abc");
		vo.setPass("abc");
		log.info(vo.getName() + vo.getPass() + vo.getEmail());
		return vo;
	}
	@RequestMapping("/boardsearch.do")
	public List<BoardVO> boardsearch() throws Exception{
		
		log.info("게시판 목록 컨트롤러");
		List<BoardVO> boardlist = boardService.boardlist();
			log.info(boardlist.size());
		return boardlist;
	}

}
