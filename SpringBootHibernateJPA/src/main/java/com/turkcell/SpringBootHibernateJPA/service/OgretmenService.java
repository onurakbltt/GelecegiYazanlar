package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repo.OgretmenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgretmenService {

	private OgretmenRepository repo;

	public List<Ogretmen> getAll() {
		return repo.findAll();
	}

	public Ogretmen getById(long id) {
		return repo.findById(id).orElse(null);
	}

	public boolean delete(long id) {
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Ogretmen save(Ogretmen ogretmen) {
		try {
			return repo.save(ogretmen);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Ogretmen update(Long id, Ogretmen yeniOgretmen) {
		Optional<Ogretmen> ogretmen = repo.findById(id);
		if (ogretmen.isPresent()) {
			Ogretmen varOgrt = ogretmen.get();
			varOgrt.setNAME(yeniOgretmen.getNAME());
			varOgrt.setISGICIK(yeniOgretmen.isISGICIK());
			return repo.save(varOgrt);
		} else {
			return null;
		}
	}

	public Ogretmen getByName(String name) {
		return repo.findByNAME(name);
	}
}
