package com.han.pjt.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.han.pjt.vo.ExcelVO;

public interface ExcelService {

	public List<ExcelVO> uploadExcelFile(MultipartFile excelFile);
}
