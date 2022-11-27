package com.turkcell.SpringBootHibernateJPA.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootHibernateJPA.model.DersOgrenci;
import com.turkcell.SpringBootHibernateJPA.service.DersOgrenciService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "dersogrenci")
public class DersOgrenciController {

	private DersOgrenciService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DersOgrenci> getAll() {
		return service.getAll();
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DersOgrenci> getByIdEntity(@PathVariable Long id) {
		DersOgrenci dO = service.getById(id);
		if (dO != null) {
			return ResponseEntity.status(HttpStatus.OK).body(dO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		// localhost:8080/dersogrenci/deleteById/1
		if (service.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi !!!");
		}
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody DersOgrenci dO) {
		// localhost:8080/dersogrenci/save
		dO = service.save(dO);
		return ResponseEntity.status(HttpStatus.CREATED).body(dO.toString()
				+ " başarıyla kaydedildi<br>Ulaşmak için: http://localhost:8080/dersogrenci/getById/" + dO.getID());
	}
}
