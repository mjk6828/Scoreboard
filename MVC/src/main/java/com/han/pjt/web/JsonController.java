package com.han.pjt.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.han.pjt.service.BoardService;
import com.han.pjt.service.MemberService;
import com.han.pjt.vo.BoardVO;
import com.han.pjt.vo.MemberVO;
import com.han.pjt.vo.SelectVO;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class JsonController {

	@Resource(name = "MemberService")
	private MemberService memberService;

	@Resource(name = "BoardService")
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
	public HashMap<String, Object> boardsearch(SelectVO svo) throws Exception {
		log.info("게시판호출");
		log.info(svo.getCinema() + svo.getDivision() + svo.getFilm() + svo.getLocation() + svo.getTheater());
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<BoardVO> boardlist = boardService.boardlist(svo);
		int boardcount = boardService.boardcount();
		map.put("result", boardlist);
		map.put("count", boardcount);
		return map;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/excelUpload.do", method = RequestMethod.POST)
	public void excel(MultipartFile request) throws Exception {
		log.info("엑셀 컨트롤러");
		try {
			// 엑셀파일
			File convFile = new File(request.getOriginalFilename());
			request.transferTo(convFile);

			// 엑셀 파일 오픈
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(convFile));

			Cell cell = null;

			// 첫번째 sheet 내용 읽기
			for (Row row : wb.getSheetAt(0)) {
				// 셋째줄부터
				if (row.getRowNum() < 2) {
					continue;
				}
				// 두번째 셀이 비어있으면 for문을 멈춤
				if (row.getCell(1) == null) {
					break;
				}
				// 콘솔
				log.info("[row] 이름:" + row.getCell(1) + ", 나이:" + row.getCell(2) + ", 성별:" + row.getCell(3) + ", 비고:"
						+ row.getCell(4));
			}
		} catch (FileNotFoundException fe) {
			log.info("FileNotFoundException >>" + fe.toString());
		} catch (IOException e) {
			log.info("IOException >>" + e.toString());
		}
	}
	
	@RequestMapping(value = "/ExcelDown.do", method=RequestMethod.POST)
	public void excelDown() throws Exception{
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
