package com.han.pjt.service;

import java.util.List;

import com.han.pjt.vo.BoardVO;

public interface BoardService {

	List<BoardVO> boardlist() throws Exception;
}
