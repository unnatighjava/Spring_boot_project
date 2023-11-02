package com.bms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto_model.Seller_dto;
import com.bms.entity.Book_entity;
import com.bms.entity.Seller_entity;
import com.bms.exception.ResourseNotFondException;
import com.bms.repository.Book_repository;
import com.bms.repository.Seller_repository;
import com.bms.service.Seller_service;
import com.bms.utility.Converter;

@Service
public class Seller_serviceimpl implements Seller_service {
	@Autowired
	private Seller_repository seller_repository;

	@Autowired
	private Book_repository book_repository;

	@Autowired
	private Converter converter;

	@Override
	public Seller_dto registerSeller(Seller_entity seller_entity) {

		return converter.convertToSellerdto(seller_repository.save(seller_entity));
	}

	@Override
	public String assignBooktoSeller(int s_id, int b_id) {
		Book_entity booEntity = book_repository.findById(b_id)
				.orElseThrow(() -> new ResourseNotFondException("book ", " b_id ", b_id));

		Seller_entity sellerEntity = seller_repository.findById(s_id)
				.orElseThrow(() -> new ResourseNotFondException("seller ", " s_id ", s_id));

		List<Book_entity> books = new ArrayList<>();
		books.add(booEntity);

		sellerEntity.setBooks(books);
		booEntity.setSellEnt(sellerEntity);

		seller_repository.save(sellerEntity);
		return "student assign to a techer successfullyss";
	}

	@Override
	public List<Seller_dto> fetchall() {
		// TODO Auto-generated method stub
		List<Seller_entity> sellEntities = seller_repository.findAll();
		List<Seller_dto> sellDtos = new ArrayList<>();
		for (Seller_entity sellEntity : sellEntities) {
			sellDtos.add(converter.convertToSellerdto(sellEntity));

		}
		return sellDtos;
	}

	@Override
	public Seller_dto fetchbyid(int id) {
		Seller_entity sellEntity = seller_repository.findById(id).get();
		return converter.convertToSellerdto(sellEntity);
	}

	@Override
	public String deletebyid(int id) {
		seller_repository.deleteById(id);
		return "delete successfully id:- "+id;
	}

	@Override
	public Seller_dto updatebyid(int id, Seller_entity seller_entity) {
	   Seller_entity sellEntity = seller_repository.findById(id).get();
	   sellEntity .setS_name(seller_entity.getS_name());
	   sellEntity .setS_Gmail(seller_entity.getS_Gmail());
	   sellEntity .setS_phone_number(seller_entity.getS_phone_number());

		Seller_entity selEntity = seller_repository.save(sellEntity);

		return converter.convertToSellerdto(selEntity);
	}

}
