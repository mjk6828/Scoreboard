package com.han.pjt.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.han.pjt.dao.MemberDAO;
import com.han.pjt.service.MemberService;
import com.han.pjt.vo.MemberVO;
import com.han.util.ExcelRead;
import com.han.util.ExcelReadOption;

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

	@Override
	public void excelupload(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A","B","C","D","E","F");
		excelReadOption.setStartRow(2);
		
		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);
		for(Map<String, String> article: excelContent) {
			log.info(article.get("A"));
			log.info(article.get("B"));
			log.info(article.get("C"));
			log.info(article.get("D"));
			log.info(article.get("E"));
			log.info(article.get("F"));
		}
	}
}
