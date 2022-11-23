package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Ders;
import com.turkcell.SpringBootRestJDBC.repo.DersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersService {
	private DersRepository repo;

	public List<Ders> getAll() {
		return repo.getAll();
	}

	public Ders getById(Long id) {
		return repo.getById(id);
	}

	public boolean save(Ders ders) {
		try {
			return repo.save(ders);
		} catch (Exception e) {
			return false;
		}
	}
}
