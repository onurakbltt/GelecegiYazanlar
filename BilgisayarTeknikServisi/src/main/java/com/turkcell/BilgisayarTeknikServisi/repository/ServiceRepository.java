package com.turkcell.BilgisayarTeknikServisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.BilgisayarTeknikServisi.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
