package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.DersOgrenci;
import com.turkcell.SpringBootHibernateJPA.repo.DersOgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersOgrenciService {

	private DersOgrenciRepository repo;

	public List<DersOgrenci> getAll() {
		return repo.findAll();
	}

	public DersOgrenci getById(long id) {
		return repo.findById(id).orElse(null);
	}

	public boolean delete(long id) {
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public DersOgrenci save(DersOgrenci dO) {
		try {
			return repo.save(dO);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
