package com.turkcell.SpringBootRestJDBC.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;
import com.turkcell.SpringBootRestJDBC.service.DersOgrenciService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "dersogrenci")
@AllArgsConstructor
public class DersOgrenciController {
	private DersOgrenciService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<DersOgrenci> getAll() {
		ArrayList<DersOgrenci> liste = (ArrayList<DersOgrenci>) service.getAll();
		return liste;
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DersOgrenci> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getByID(id));
	}

	@PostMapping(path = "save")
	public ResponseEntity<String> save(@RequestBody DersOgrenci dersOgrenci) {
		boolean result = service.save(dersOgrenci);
		if (result) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dersOgrenci.getID() + " başarıyla kaydedildi");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dersOgrenci.getID() + " kaydedilemedi");
		}
	}
}
