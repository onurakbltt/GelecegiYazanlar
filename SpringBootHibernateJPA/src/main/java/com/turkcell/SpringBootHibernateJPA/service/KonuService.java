package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.repo.KonuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KonuService {

	private KonuRepository repo;

	public List<Konu> getAll() {
		return repo.findAll();
	}

	public Konu getById(long id) {
		return repo.findById(id).orElse(null);
	}

	public boolean delete(long id) {
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Konu save(Konu konu) {
		try {
			return repo.save(konu);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Konu update(Long id, Konu yeniKonu) {
		Optional<Konu> konu = repo.findById(id);
		if (konu.isPresent()) {
			Konu varKonu = konu.get();
			varKonu.setNAME(yeniKonu.getNAME());
			return repo.save(varKonu);
		} else {
			return null;
		}
	}

	public Konu getByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByNAME(name);
	}

}
