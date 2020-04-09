package com.han.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExcelRead {

	public static List<Map<String, String>> read(ExcelReadOption excelReadOption){
		//엑셀 파일 자체 엑셀 파일을 읽어들임
		//FileType.getWorkbook() <- 파일의 확장자에 따라 적절하게 가져옴
		Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());
		
		//엑셀 파일에서 첫번째 시트를 가져옴
		Sheet sheet = wb.getSheetAt(0);
		log.info("Sheet 이름:"+wb.getSheetName(0));
		log.info("데이터가 있는 Sheet의 수:"+wb.getNumberOfSheets());
		
		//sheet에서 유효한(데이터가 있는) 행의 개수를 가져옴
		
		int numOfRows = sheet.getPhysicalNumberOfRows();
		int numOfCells = 0;
		
		Row row = null;
		Cell cell = null;
		
		String cellName = "";
		
		/*각 row 마다의 값을 저장할 맵 객체
		저장되는 형식은
		put("A","이름");
		put("B", "게임명");*/
		
		Map<String, String> map = null;
		 /*
         * 각 Row를 리스트에 담는다.
         * 하나의 Row를 하나의 Map으로 표현되며
         * List에는 모든 Row가 포함될 것이다.
         */
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		//각 Row 만큼 반복을 한다.
		
		for(int rowIndex = excelReadOption.getStartRow() - 1; rowIndex < numOfRows; rowIndex++) {
			
			/*워크북에서 가져온 시트에서 rowIndex에 해당하는 Row를 가져온다.
			하나의 Row는 여러개의 Cell을 가진다.*/
			
			row = sheet.getRow(rowIndex);
			
			if(row != null) {
				//가져온 Row Cell의 개수를 구함
				
				numOfCells = row.getLastCellNum();
				//데이터를 담을 맵 객체 초기화
				map = new HashMap<String, String>();
				//cell의 수만큼 반복
				for(int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
					//Row에서 CellIndex에 해당하는 Cell을 가져옴
					cell = row.getCell(cellIndex);
					
					//현재 Cell의 이름을 가져온다
					
					cellName = ExcelCellRef.getName(cell, cellIndex);
					//추출 대상 컬럼인지 확인, 추출 대상 컬럼이 아니라면 for로 다시 올라감
					if( !excelReadOption.getOutputColumns().contains(cellName)) {
						continue;
					}
					//map 객체에 Cell의 이름을 키(key)로 데이터를 담는다.
					map.put(cellName, ExcelCellRef.getValue(cell));
				}
				//만들어진 Map 객체를 List로 넣는다.
				result.add(map);
			}
		}
		return result;
	}
}
