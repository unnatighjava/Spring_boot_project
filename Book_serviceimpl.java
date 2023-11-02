package com.bms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto_model.Book_dto;
import com.bms.entity.Book_entity;
import com.bms.repository.Book_repository;
import com.bms.service.Book_service;
import com.bms.utility.Converter;

@Service
public class Book_serviceimpl implements Book_service {

	@Autowired
	Book_repository book_repository;

	@Autowired
	Converter converter;

	@Override
	public Book_dto createbook(Book_entity book_entity) {
		Book_entity bookE = book_repository.save(book_entity);

		return converter.convertTodto(bookE);
	}

	@Override
	public List<Book_dto> fetchall() {
		// TODO Auto-generated method stub
		List<Book_entity> bookEntity2 = book_repository.findAll();
		List<Book_dto> bookDto = new ArrayList<>();
		for (Book_entity bookEntity3 : bookEntity2) {
			bookDto.add(converter.convertTodto(bookEntity3));

		}
		return bookDto;
	}

	@Override
	public Book_dto fetchbyid(int id) {
		Book_entity bookEntity4 = book_repository.findById(id).get();
		return converter.convertTodto(bookEntity4);
	}

	@Override
	public String deletebyid(int id) {
		book_repository.deleteById(id);
		return "delete successfully";
	}

	@Override
	public Book_dto updatebyid(int id, Book_entity book_entity) {
		Book_entity bookEnt = book_repository.findById(id).get();
		bookEnt.setB_name(book_entity.getB_name());
		bookEnt.setB_price(book_entity.getB_price());
		bookEnt.setB_author(book_entity.getB_author());

		Book_entity bookEnt2 = book_repository.save(bookEnt);

		return converter.convertTodto(bookEnt2);
	}

//	@Override
//	public Book_entity createbook(Book_entity book_entity) {
//
//		return book_repository.save(book_entity);
//	}
//
//	@Override
//	public List<Book_entity> fetchall(Book_entity book_entity) {
//		// TODO Auto-generated method stub
//		return book_repository.findAll();
//	}
//
//	@Override
//	public Book_entity fetchbyid(int id, Book_entity book_entity) {
//		return book_repository.findById(id).get();
//	}
//
//	@Override
//	public String deletebyid(int id) {
//		book_repository.deleteById(id);
//		return "delete successfully";
//	}
//
//	@Override
//	public Book_entity updatebyid(int id, Book_entity book_entity) {
//		Book_entity bookEnt= book_repository.findById(id).get();
//		bookEnt.setB_name(book_entity.getB_name());
//		bookEnt.setB_price(book_entity.getB_price());
//		bookEnt.setB_author(book_entity.getB_author());
//		
//		Book_entity bookEnt2=book_repository.save(bookEnt);
//		
//		return bookEnt2;
//	}

}
