package com.han.pjt.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.han.pjt.vo.ExcelVO;

public interface ExcelService {

	void uploadExcelFile(File destFile) throws Exception;
}
