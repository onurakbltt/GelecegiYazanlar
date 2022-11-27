package com.turkcell.SpringBootHibernateJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;

public interface OgretmenRepository extends JpaRepository<Ogretmen, Long> {

	public Ogretmen findByNAME(String name);

}
