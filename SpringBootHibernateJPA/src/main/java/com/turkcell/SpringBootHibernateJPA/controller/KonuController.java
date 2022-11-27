package com.turkcell.SpringBootHibernateJPA.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.service.KonuService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "konu")
public class KonuController {

	private KonuService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Konu> getAll() {
		return service.getAll();
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getByIdEntity(@PathVariable Long id) {
		Konu konu = service.getById(id);
		if (konu != null) {
			return ResponseEntity.status(HttpStatus.OK).body(konu);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping(path = "getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getByNameEntity(@PathVariable String name) {
		Konu konu = service.getByName(name);
		if (konu != null) {
			return ResponseEntity.status(HttpStatus.OK).body(konu);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		if (service.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi !!!");
		}
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Konu konu) {
		// localhost:8080/konu/save
		// {"name" : "kerem"}
		konu = service.save(konu);
		return ResponseEntity.status(HttpStatus.CREATED).body(konu.toString()
				+ " başarıyla kaydedildi<br>Ulaşmak için: http://localhost:8080/konu/getById/" + konu.getID());
	}

	@PutMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Konu update(@PathVariable Long id, @RequestBody Konu yeniKonu) {
		return service.update(id, yeniKonu);
	}

}
