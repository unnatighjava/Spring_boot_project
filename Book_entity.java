package com.bms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book_entity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int b_id;
	private String b_name;
	private int b_price;
	private String b_author;

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public Book_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book_entity(String b_name, int b_price, String b_author) {
		super();
		this.b_name = b_name;
		this.b_price = b_price;
		this.b_author = b_author;
	}

	@Override
	public String toString() {
		return "Book_entity [b_id=" + b_id + ", b_name=" + b_name + ", b_price=" + b_price + ", b_author=" + b_author
				+ "]";
	}
	private boolean status = Boolean.TRUE;
	
	
	public Seller_entity getSellEnt() {
		return sellEnt;
	}

	public void setSellEnt(Seller_entity sellEnt) {
		this.sellEnt = sellEnt;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="s_id")
	@JsonIgnoreProperties("books")
	private Seller_entity sellEnt;

	
	

}
