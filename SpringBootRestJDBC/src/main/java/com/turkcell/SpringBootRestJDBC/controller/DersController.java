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

import com.turkcell.SpringBootRestJDBC.model.Ders;
import com.turkcell.SpringBootRestJDBC.service.DersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "ders")
@AllArgsConstructor
public class DersController {

	private DersService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Ders> getAll() {
		ArrayList<Ders> liste = (ArrayList<Ders>) service.getAll();
		return liste;
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ders> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
	}

	@PostMapping(path = "save")
	public ResponseEntity<String> save(@RequestBody Ders ders) {
		boolean result = service.save(ders);
		if (result) {
			return ResponseEntity.status(HttpStatus.CREATED).body(ders.getID() + " ders başarıyla kaydedildi");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ders.getID() + " ders kaydedilemedi");
		}
	}

}
