package com.turkcell.BilgisayarTeknikServisi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.BilgisayarTeknikServisi.model.Sale;
import com.turkcell.BilgisayarTeknikServisi.service.SaleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "sale")
@AllArgsConstructor
public class SaleController {

	private SaleService saleService;

	@GetMapping(path = "/getAll")
	public List<Sale> getAllSale() {
		return saleService.getAllSale();
	}

	@GetMapping(path = "/getByProduct/{id}")
	public List<Sale> getByProduct(@PathVariable(name = "id") Long id) {
		return saleService.getByProduct(id);
	}

	@PostMapping(path = "/save")
	public Sale createSale(@RequestBody Sale sale) {
		return saleService.createSale(sale);
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
		saleService.deleteById(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}
}
