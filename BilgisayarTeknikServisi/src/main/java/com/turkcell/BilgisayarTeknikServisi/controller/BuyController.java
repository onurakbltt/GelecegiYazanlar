package com.turkcell.BilgisayarTeknikServisi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.BilgisayarTeknikServisi.model.SaleLOG;
import com.turkcell.BilgisayarTeknikServisi.service.SaleLogService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "buy")
@AllArgsConstructor
public class BuyController {

	private SaleLogService saleLogService;

	@PostMapping(path = "save")
	public ResponseEntity<SaleLOG> save(@RequestBody SaleLOG log) {
		return ResponseEntity.status(HttpStatus.CREATED).body(saleLogService.create(log));
	}
}
