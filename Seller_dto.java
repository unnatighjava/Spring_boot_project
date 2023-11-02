package com.bms.dto_model;

import jakarta.persistence.Column;

public class Seller_dto {
	
	private int s_id;
	private String s_name;
	private String s_Gmail;
	private long s_phone_number;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_Gmail() {
		return s_Gmail;
	}
	public void setS_Gmail(String s_Gmail) {
		this.s_Gmail = s_Gmail;
	}
	public long getS_phone_number() {
		return s_phone_number;
	}
	public void setS_phone_number(long s_phone_number) {
		this.s_phone_number = s_phone_number;
	}

}
