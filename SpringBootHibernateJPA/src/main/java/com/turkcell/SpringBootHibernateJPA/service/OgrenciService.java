package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ogrenci;
import com.turkcell.SpringBootHibernateJPA.repo.OgrenciRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgrenciService {

	private OgrenciRepository repo;

	public List<Ogrenci> getAll() {
		return repo.findAll();
	}

	public Ogrenci getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public boolean delete(long id) {
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Ogrenci save(Ogrenci ogrenci) {
		try {
			return repo.save(ogrenci);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Ogrenci update(Long id, Ogrenci yeniOgrenci) {
		Optional<Ogrenci> ogrenci = repo.findById(id);
		if (ogrenci.isPresent()) {
			Ogrenci varOgrn = ogrenci.get();
			varOgrn.setNAME(yeniOgrenci.getNAME());
			varOgrn.setOGRNUMBER(yeniOgrenci.getOGRNUMBER());
			varOgrn.setYEAR(yeniOgrenci.getYEAR());
			return repo.save(varOgrn);
		} else {
			return null;
		}
	}

	public Ogrenci getByName(String name) {
		return repo.findByNAME(name);
	}

	public Ogrenci getByYear(Long year) {
		return repo.findByYEAR(year);
	}
}
