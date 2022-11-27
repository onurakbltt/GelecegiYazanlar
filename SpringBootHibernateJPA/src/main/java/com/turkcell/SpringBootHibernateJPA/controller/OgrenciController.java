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

import com.turkcell.SpringBootHibernateJPA.model.Ogrenci;
import com.turkcell.SpringBootHibernateJPA.service.OgrenciService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "ogrenci")
public class OgrenciController {

	private OgrenciService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ogrenci> getAll() {
		return service.getAll();
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getByIdEntity(@PathVariable Long id) {
		Ogrenci ogrn = service.getById(id);
		if (ogrn != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ogrn);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping(path = "getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getByNameEntity(@PathVariable String name) {
		Ogrenci ogrenci = service.getByName(name);
		if (ogrenci != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ogrenci);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping(path = "getByYear/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getByYearEntity(@PathVariable Long year) {
		Ogrenci ogrenci = service.getByYear(year);
		if (ogrenci != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ogrenci);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		// localhost:8080/ogrenci/deleteById/1
		if (service.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi !!!");
		}
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogrenci ogrn) {
		ogrn = service.save(ogrn);
		return ResponseEntity.status(HttpStatus.CREATED).body(ogrn.toString()
				+ " başarıyla kaydedildi<br>Ulaşmak için: http://localhost:8080/ogrenci/getById/" + ogrn.getID());
	}

	@PutMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ogrenci update(@PathVariable Long id, @RequestBody Ogrenci yeniOgrenci) {
		return service.update(id, yeniOgrenci);
	}
}
