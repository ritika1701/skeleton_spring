package com.spring.codes.controller;

import com.spring.codes.entity.ExchangeProduct;
import com.spring.codes.entity.ExchangeResponse;
import com.spring.codes.entity.ProductList;
import com.spring.codes.service.EndPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EndPoint {

	@Autowired
	private EndPointService endPointService;
	
		@GetMapping("/getProductList")
	public ResponseEntity<?> getList() {

		List<ProductList> products = endPointService.getProductList();

		return ResponseEntity.ok(products);
	}

	@PostMapping(path="/exchange",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> applyExchange(@RequestBody ExchangeProduct product) {

		ExchangeResponse response = endPointService.processExchange(product);

		return ResponseEntity.ok(response);

	}
	
}
