package com.bms.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bms.dto_model.Book_dto;
import com.bms.dto_model.Seller_dto;
import com.bms.entity.Book_entity;
import com.bms.entity.Seller_entity;

@Component
public class Converter {

	public Book_entity convertToEntity(Book_dto book_dto) {

		Book_entity book_entity = new Book_entity();
		if (book_dto != null) {
			BeanUtils.copyProperties(book_dto, book_entity);
		}
		return book_entity;

	}

	public Book_dto convertTodto(Book_entity book_entity) {

		Book_dto book_dto = new Book_dto();
		if (book_entity != null) {
			BeanUtils.copyProperties(book_entity, book_dto);
		}
		return book_dto;

	}
	
	
	
	public Seller_entity ConverToSellerEntity(Seller_dto seller_dto) {

		Seller_entity seller_entity = new Seller_entity();
		if (seller_dto != null) {
			BeanUtils.copyProperties(seller_dto, seller_entity);
		}
		return seller_entity;
	}
	
	public Seller_dto convertToSellerdto(Seller_entity seller_entity) {

		Seller_dto seller_dto = new Seller_dto();
		if (seller_entity != null) {
			BeanUtils.copyProperties(seller_entity, seller_dto);
		}
		return seller_dto;
	}
}
