package com.han.pjt.vo;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class MemberVO {
	private int num;
	private String id;
	private String pass;
	private String name;
	private String email;
	private int phone;
	
	
	
}
