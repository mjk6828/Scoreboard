package com.han.pjt.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class BoardVO {

	private int num;
	private String writer;
	private String email;
	private String subject;
	private String pass;
	private int readcount;
	private int ref;
	private int step;
	private int depth;
	private Date regdate;
	private String content;
	private String b_type;
	
	
}
