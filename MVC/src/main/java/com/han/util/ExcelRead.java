package com.han.util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.han.pjt.vo.ExcelVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExcelRead {

	//xls 파일을 분석해 List<ExcelVO> 객체로 반환
	//@param filePath
	
	public List<ExcelVO> xlsToExcelVOList(String filePath){
		//반환할 객체 생성
		List<ExcelVO> list = new ArrayList<ExcelVO>();
		
		FileInputStream fis = null;
		HSSFWorkbook wb = null;
		
		try {
			
			fis = new FileInputStream(filePath);
			//HSSFWorkbook은 엑셀 파일 전체 내용을 담고 있는 객체
			wb = new HSSFWorkbook(fis);
			
			//탐색에 사용할 Sheet, Row, Cell 객체
			HSSFSheet sheet;
			HSSFRow row;
			HSSFCell cell;
			ExcelVO vo;
			
			//Sheet 탐색 for 문
			for(int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
				//현재 Sheet 반환
				sheet = wb.getSheetAt(sheetIndex);
				
				//row 탐색 for 문
				for(int rowIndex=0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
					//row 0은 헤더정보이기 때문에 무시
					if(rowIndex != 0) {
						//현재 row 반환
						row = sheet.getRow(rowIndex);
						vo = new ExcelVO();
						String value; 
					
						//row의 첫번째 cell값이 비어있지 않은 경우에만 cell 탐색
						if(!"".equals(row.getCell(0).getStringCellValue())) {
							
							//cell 탐색 포문
							for(int cellIndex=0; cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
								cell = row.getCell(cellIndex);
								
								if(true) {
									value = "";
									//cell 스타일이 다르더라도 String으로 반환받음
									switch(cell.getCellType()) {
									case HSSFCell.CELL_TYPE_FORMULA:
										value = cell.getCellFormula();
										break;
									case HSSFCell.CELL_TYPE_NUMERIC:
										value = cell.getNumericCellValue()+"";
										break;
									case HSSFCell.CELL_TYPE_STRING:
										value = cell.getStringCellValue()+"";
										break;
									case HSSFCell.CELL_TYPE_BLANK:
										value = cell.getBooleanCellValue()+"";
										break;
									case HSSFCell.CELL_TYPE_ERROR:
										value = cell.getErrorCellValue()+"";
										break;
									default:
										value = new String();
										break;
									}
									
									//현재 column index에 따라서 vo에 입력
									switch(cellIndex) {
									
									case 0: //아이디
										vo.setCustId(value);
										break;
									case 1: //이름
										vo.setCustName(value);
										break;
									case 2: //나이
										vo.setCustAge(value);
										break;
									case 3: //이메일
										vo.setCustEmail(value);
										break;
										
									default:
										break;
									}
								}
							}
							//cell탐색 이후 vo 추가
							list.add(vo);
					}
				}
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//사용한 자원은 finally에서 해제
				if( wb != null) wb.close();
				if( fis != null) fis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//이번엔 xlsx 파일 ^^
	public List<ExcelVO> xlsxToExcelVOList(String filePath){
		//반환 객체 생성
		List<ExcelVO> list = new ArrayList<ExcelVO>();
		
		FileInputStream fis = null;
		XSSFWorkbook wb = null;
		
		try {
			fis = new FileInputStream(filePath);
			//HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
			wb = new XSSFWorkbook(fis);
			
			// 탐색에 사용할 Sheet, Row, Cell 객체
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
