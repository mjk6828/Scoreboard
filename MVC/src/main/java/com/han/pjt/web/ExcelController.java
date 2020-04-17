package com.han.pjt.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.log4j.Log4j2;

@Controller@Log4j2
public class ExcelController {

	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/excelUpload.do", method = RequestMethod.POST)
	public String excelupload(MultipartHttpServletRequest request, Model model, HttpServletResponse response) throws Exception {
		log.info("엑셀 컨트롤러");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter pw = response.getWriter();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
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
