package com.han.pjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.han.pjt.dao.BoardDAO;
import com.han.pjt.service.BoardService;
import com.han.pjt.vo.BoardVO;
import com.han.pjt.vo.SelectVO;
import com.han.util.ExcelReadOption;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service("BoardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name="BoardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> boardlist(SelectVO svo) throws Exception {
		log.info("게시판 목록 조회");
		return boardDAO.boardlist(svo);
	}

	@Override
	public int boardcount() throws Exception {
		
		return boardDAO.boardcount();
	}



}
