package com.turkcell.SpringBootHibernateJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootHibernateJPA.model.Ders;

public interface DersRepository extends JpaRepository<Ders, Long> {

}
