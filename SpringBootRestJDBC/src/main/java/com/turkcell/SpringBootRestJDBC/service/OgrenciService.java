package com.turkcell.SpringBootRestJDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Ogrenci;
import com.turkcell.SpringBootRestJDBC.repo.OgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgrenciService {

	private OgrenciRepository repo;

	public List<Ogrenci> getAll() {
		return repo.getAll();
	}

	public Ogrenci getByID(Long id) {
		return repo.getById(id);
	}

	public boolean save(Ogrenci ogrenci) {
		try {
			return repo.save(ogrenci);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
