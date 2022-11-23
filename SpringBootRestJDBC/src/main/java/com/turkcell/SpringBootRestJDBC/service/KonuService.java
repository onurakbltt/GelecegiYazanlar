package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Konu;
import com.turkcell.SpringBootRestJDBC.repo.KonuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KonuService {
	private KonuRepository repo;

	public List<Konu> getAll() {
		return repo.getAll();
	}

	public Konu getById(Long id) {
		return repo.getById(id);
	}

	public boolean save(Konu konu) {
		try {
			return repo.save(konu);
		} catch (Exception e) {
			return false;
		}
	}
}
