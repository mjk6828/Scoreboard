package com.han.pjt.service;

import java.io.File;
import java.util.List;

import com.han.pjt.vo.MemberVO;

public interface MemberService {

	List<MemberVO> memberlist() throws Exception;
	MemberVO memberone(MemberVO vo) throws Exception;
}
