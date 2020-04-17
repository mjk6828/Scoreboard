package com.han.pjt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.han.pjt.dao.MemberDAO;
import com.han.pjt.service.MemberService;
import com.han.pjt.vo.MemberVO;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service("MemberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="MemberDAO")
	private MemberDAO memberDAO;
	
	
	@Override
	public List<MemberVO> memberlist() throws Exception {
	
		return memberDAO.memberlist();
	}


	@Override
	public MemberVO memberone(MemberVO vo) throws Exception {
		return memberDAO.memberone(vo);
	}
}
