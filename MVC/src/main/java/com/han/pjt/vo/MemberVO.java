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
	/*public MemberVO(@JsonProperty("num") int num, @JsonProperty("id") String id, @JsonProperty("pass") String pass,
								@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("phone") int phone) {
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public int getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getPhone() {
		return phone;
	}*/
	
	
	
}
