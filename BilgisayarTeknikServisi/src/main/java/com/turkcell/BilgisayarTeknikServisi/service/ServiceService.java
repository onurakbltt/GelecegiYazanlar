package com.turkcell.BilgisayarTeknikServisi.service;

import com.turkcell.BilgisayarTeknikServisi.model.Service;
import com.turkcell.BilgisayarTeknikServisi.repository.ServiceRepository;

import lombok.AllArgsConstructor;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceService {

	private ServiceRepository serviceRepository;

	public Service findById(Long id) {
		return serviceRepository.findById(id).get();
	}
}
