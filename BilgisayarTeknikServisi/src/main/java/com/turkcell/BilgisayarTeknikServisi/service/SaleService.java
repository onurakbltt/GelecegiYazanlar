package com.turkcell.BilgisayarTeknikServisi.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.BilgisayarTeknikServisi.model.Sale;
import com.turkcell.BilgisayarTeknikServisi.repository.SaleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

	private SaleRepository saleRepository;
	private EntityManager entityManager;

	public void refresh(Sale sale) {
		entityManager.refresh(sale);
	}

	public Sale createSale(Sale sale) {
		sale = saleRepository.saveAndFlush(sale);
		entityManager.clear();
		sale = saleRepository.findById(sale.getId()).get();
		return sale;
	}

	public List<Sale> getAllSale() {
		return saleRepository.findAllByIsSold(false);
	}

	public void deleteById(Long id) {
		saleRepository.deleteById(id);
	}

	public List<Sale> getByProduct(Long id) {
		return saleRepository.findAllByproductIdAndIsSold(id, false);
	}
}
