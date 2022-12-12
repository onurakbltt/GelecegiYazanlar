package com.turkcell.BilgisayarTeknikServisi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.BilgisayarTeknikServisi.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

	public List<Proposal> findByUserNameLike(String name);
}
