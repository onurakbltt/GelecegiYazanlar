package com.turkcell.SpringBootRestJDBC.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.Konu;
import com.turkcell.SpringBootRestJDBC.service.KonuService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "konu")
public class KonuController {

	private KonuService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Konu> getAll() {
		return service.getAll();
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Konu konu) {
		boolean result = service.save(konu);
		if (result) {
			return ResponseEntity.status(HttpStatus.CREATED).body(konu.getNAME() + " isimli konu başarıyla kaydedildi");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(konu.getNAME() + " isimli konu kaydedilemedi");
		}
	}
}
