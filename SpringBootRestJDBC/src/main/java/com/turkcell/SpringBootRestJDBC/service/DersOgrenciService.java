package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;
import com.turkcell.SpringBootRestJDBC.repo.DersOgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersOgrenciService {

	private DersOgrenciRepository repo;

	public List<DersOgrenci> getAll() {
		return repo.getAll();
	}

	public DersOgrenci getByID(Long id) {
		return repo.getById(id);
	}

	public boolean save(DersOgrenci dersOgrenci) {
		try {
			return repo.save(dersOgrenci);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
