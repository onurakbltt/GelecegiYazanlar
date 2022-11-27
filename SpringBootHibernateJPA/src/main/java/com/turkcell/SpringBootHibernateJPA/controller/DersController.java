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

import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.service.DersService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "ders")
public class DersController {

	private DersService service;

	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ders> getAll() {
		return service.getAll();
	}

	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ders> getByIdEntity(@PathVariable Long id) {
		Ders ders = service.getById(id);
		if (ders != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ders);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping(path = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		// localhost:8080/ders/deleteById/1
		if (service.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silindi");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Başarı ile silinemedi !!!");
		}
	}

	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody Ders ders) {
		// localhost:8080/ders/save
		ders = service.create(ders);
		return ResponseEntity.status(HttpStatus.CREATED).body(ders.toString()
				+ " başarıyla kaydedildi<br>Ulaşmak için: http://localhost:8080/ders/getById/" + ders.getID());
	}

	@PutMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ders update(@PathVariable Long id, @RequestBody Ders yeniDers) {
		return service.update(id, yeniDers);
	}

}
