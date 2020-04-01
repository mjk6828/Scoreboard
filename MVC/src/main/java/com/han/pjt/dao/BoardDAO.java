package com.han.pjt.dao;

import java.util.List;

import com.han.pjt.vo.BoardVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoardDAO")
public interface BoardDAO {

	List<BoardVO> boardlist() throws Exception;
	int boardcount() throws Exception;
}
