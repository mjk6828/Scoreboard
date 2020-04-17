package com.han.pjt.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.han.pjt.service.ExcelService;
import com.han.pjt.vo.ExcelVO;

@Service("ExcelService")
public class ExcelServiceImpl implements ExcelService{

	@Override
	public List<ExcelVO> uploadExcelFile(MultipartFile excelFile) {
		List<ExcelVO> list = new ArrayList<ExcelVO>();
		
		try {
			OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
			XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
			//첫번째시트
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for(int i=0; i<sheet.getLastRowNum() +1; i++) {
				ExcelVO vo = new ExcelVO();
				XSSFRow row = sheet.getRow(i);
				
				//행이 존재하지 않으면 패스
				if(null == row) {
					continue;
				}
				//행의 1번째 열
				XSSFCell cell = row.getCell(0);
				
				if(null != cell)
					vo.setCustId(cell.getStringCellValue());
				//행의 2번째 열
				cell = row.getCell(1);
				if(null != cell)
					vo.setCustName(cell.getStringCellValue());
				//행의 3번째 열
				cell = row.getCell(2);
				if(null != cell)
					vo.setCustAge(cell.getStringCellValue());
				//행의 4번째 열
				cell = row.getCell(3);
				if(null != cell)
					vo.setCustEmail(cell.getStringCellValue());
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
