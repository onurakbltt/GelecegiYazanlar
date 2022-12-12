package com.turkcell.BilgisayarTeknikServisi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.BilgisayarTeknikServisi.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	List<Sale> findAllByIsSold(boolean isSold);

	List<Sale> findAllByproductIdAndIsSold(Long id, boolean isSold);

}
