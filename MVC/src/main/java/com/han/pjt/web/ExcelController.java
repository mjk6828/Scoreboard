package com.han.pjt.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.han.pjt.service.ExcelService;
import com.han.util.ExcelRead;
import com.han.util.ExcelReadOption;

import lombok.extern.log4j.Log4j2;
@SuppressWarnings("unused")
@Controller
@Log4j2
@ResponseBody
public class ExcelController {

	@Resource(name="ExcelService")
	private ExcelService excelService;
	
	

	@RequestMapping(value = "/ExcelUpload.do", method = RequestMethod.POST)
	public List<Map<String, String>> excelupload(MultipartHttpServletRequest request) throws Exception {

		MultipartFile excelFile = request.getFile("excelFile");
		//엑셀파일 업로드
		if(excelFile == null || excelFile.isEmpty()) {
			throw new RuntimeException("엑셀파일 선택좀;");
		}
		File destFile = new File("D:\\excel\\"+excelFile.getOriginalFilename());
		try {
			excelFile.transferTo(destFile);
		}catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
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
		//excelService.uploadExcelFile(destFile);
		return excelContent;
	}
	
	@RequestMapping(value = "/ExcelDown.do", method=RequestMethod.POST)
	public void excelDownload() throws Exception{
		//임의의 VO가 되어주는 Map 객체
		Map<String,Object> map = null;
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		ArrayList<String> columnList = new ArrayList<String>();
		
		for(int i=0; i<10; i++) {
			map = new HashMap<String,Object>();
			map.put("seq", i+1);
			map.put("title", "제목"+i);
			map.put("content", "내용"+i);
			list.add(map);
		}
	}
}
