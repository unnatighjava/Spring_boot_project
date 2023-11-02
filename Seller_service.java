package com.bms.service;

import java.util.List;

import com.bms.dto_model.Seller_dto;
import com.bms.entity.Seller_entity;

public interface Seller_service {
	Seller_dto registerSeller(Seller_entity seller_entity);

	String assignBooktoSeller(int S_id, int b_id);

	List<Seller_dto> fetchall();

	Seller_dto fetchbyid(int id);

	String deletebyid(int id);

	Seller_dto updatebyid(int id, Seller_entity seller_entity);

}
