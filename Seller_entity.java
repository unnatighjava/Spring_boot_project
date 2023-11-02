package com.bms.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Seller_entity {
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Book_entity> getBooks() {
		return books;
	}
	public void setBooks(List<Book_entity> books) {
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	@Column(length = 35)
	private String s_name;
	@Column(length = 35)
	private String s_Gmail;
	@Column(length = 12)
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
	public Seller_entity(int s_id, String s_name, String s_Gmail, long s_phone_number) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_Gmail = s_Gmail;
		this.s_phone_number = s_phone_number;
	}
	public Seller_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Seller_entity [s_id=" + s_id + ", s_name=" + s_name + ", s_Gmail=" + s_Gmail + ", s_phone_number="
				+ s_phone_number + "]";
	}
	
	private boolean status=Boolean.TRUE;
	
	@OneToMany(mappedBy = "sellEnt",cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties("sellEnt")
	List<Book_entity> books;
	
}
