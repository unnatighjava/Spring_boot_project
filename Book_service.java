package com.bms.service;

import java.util.List;

import com.bms.dto_model.Book_dto;
import com.bms.entity.Book_entity;

public interface Book_service {

	Book_dto createbook(Book_entity book_entity);

	List<Book_dto> fetchall();

	Book_dto fetchbyid(int id);

	String deletebyid(int id);

	Book_dto updatebyid(int id, Book_entity book_entity);

//	Book_entity createbook(Book_entity book_entity);
//	
//	List<Book_entity> fetchall(Book_entity book_entity);
//	
//	Book_entity fetchbyid(int id, Book_entity book_entity);
//	
//	String deletebyid(int id);
//	
//	Book_entity updatebyid(int id,Book_entity book_entity);
//	

}
