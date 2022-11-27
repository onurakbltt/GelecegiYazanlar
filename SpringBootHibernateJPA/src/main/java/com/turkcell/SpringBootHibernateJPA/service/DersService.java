package com.turkcell.SpringBootHibernateJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootHibernateJPA.model.Ders;
import com.turkcell.SpringBootHibernateJPA.model.Konu;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repo.DersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DersService {

	private DersRepository repo;
	private KonuService kService;
	private OgretmenService oService;

	public List<Ders> getAll() {
		return repo.findAll();
	}

	public Ders getById(long id) {
		return repo.findById(id).orElse(null);
	}

	public boolean delete(long id) {
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}

	public Ders create(Ders ders) {
		try {
			return repo.save(ders);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Ders update(Long id, Ders yeniDers) {
		Optional<Ders> ders = repo.findById(id);
		Konu konu = kService.getById(id);
		Ogretmen ogretmen = oService.getById(id);
		if (ders.isPresent()) {
			Ders varDers = ders.get();
			varDers.setKonu(konu);
			varDers.setOgretmen(ogretmen);
			return repo.save(varDers);
		} else {
			return null;
		}

	}

}
