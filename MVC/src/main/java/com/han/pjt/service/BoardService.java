package com.han.pjt.service;

import java.util.List;

import com.han.pjt.vo.BoardVO;
import com.han.pjt.vo.SelectVO;

public interface BoardService {

	List<BoardVO> boardlist(SelectVO svo) throws Exception;
	int boardcount() throws Exception;
}
