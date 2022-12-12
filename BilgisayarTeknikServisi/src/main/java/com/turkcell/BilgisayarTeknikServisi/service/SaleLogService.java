package com.turkcell.BilgisayarTeknikServisi.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.BilgisayarTeknikServisi.model.SaleLOG;
import com.turkcell.BilgisayarTeknikServisi.repository.SaleLogRepository;
import com.turkcell.BilgisayarTeknikServisi.repository.SaleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleLogService {

	private SaleLogRepository saleLogRepository;
	private SaleRepository saleRepository;
	private EntityManager em;

	public SaleLOG create(SaleLOG log) {
		log = saleLogRepository.save(log);
		saleLogRepository.flush();
		em.clear();
		log = saleLogRepository.findById(log.getId()).get();
		log.getSale().setSold(true);
		saleRepository.save(log.getSale());
		return log;
	}

}
