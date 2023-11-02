package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto_model.Book_dto;
import com.bms.dto_model.Seller_dto;
import com.bms.entity.Book_entity;
import com.bms.entity.Seller_entity;
import com.bms.service.Seller_service;
import com.bms.utility.Converter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Seller_controller {

	@Autowired
	private Seller_service seller_service;

	@Autowired
	private Converter converter;

	@PostMapping("/createseller")
	ResponseEntity<Seller_dto> createBook(@Valid @RequestBody Seller_dto seller_dto) {
		final Seller_entity seller_entity = converter.ConverToSellerEntity(seller_dto);
		return new ResponseEntity<Seller_dto>(seller_service.registerSeller(seller_entity), HttpStatus.CREATED);

	}

	@PostMapping("/assign/{s_id}/{b_id}")
	public String assignBooktoSeller(@PathVariable("s_id") int s_id, @PathVariable("b_id") int b_id) {
		return seller_service.assignBooktoSeller(s_id, b_id);

	}

	@GetMapping("/getallseller")
	List<Seller_dto> fetchalldata() {
		return seller_service.fetchall();

	}

	@GetMapping("/getbyidseller/{s_id}")
	Seller_dto fetch_byid(@PathVariable("s_id") int id) {
		return seller_service.fetchbyid(id);

	}

	@DeleteMapping("/deletebyidseller/{s_id}")
	String delete_byid(@PathVariable("s_id") int id) {
		return seller_service.deletebyid(id);

	}
	
	@PutMapping("/updatebysellerid/{s_id}")
	Seller_dto update_byid(@PathVariable("s_id") int id, @RequestBody Seller_dto seller_dto) {
		Seller_entity seller_entity  = converter.ConverToSellerEntity(seller_dto);
		return seller_service.updatebyid(id, seller_entity );

}
}
