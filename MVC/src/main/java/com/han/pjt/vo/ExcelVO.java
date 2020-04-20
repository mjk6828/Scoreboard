package com.han.pjt.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class ExcelVO {

	private String name;
	private CommonsMultipartFile fileData;
}
