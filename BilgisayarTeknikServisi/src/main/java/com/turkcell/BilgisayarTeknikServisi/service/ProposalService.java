package com.turkcell.BilgisayarTeknikServisi.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.BilgisayarTeknikServisi.model.Proposal;
import com.turkcell.BilgisayarTeknikServisi.repository.ProposalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalService {

	private ProposalRepository proposalRepository;
	private EntityManager entityManager;

	public void refresh(Proposal proposal) {
		entityManager.refresh(proposal);
	}

	public Proposal createProposal(Proposal proposal) {
		proposal = proposalRepository.saveAndFlush(proposal);
		entityManager.clear();
		proposal = proposalRepository.findById(proposal.getId()).get();
		return proposal;
	}

	public List<Proposal> getAllProposal() {
		return proposalRepository.findAll();
	}

	public void deleteById(Long id) {
		proposalRepository.deleteById(id);
	}

	public Proposal getById(Long id) {
		return proposalRepository.findById(id).orElse(null);
	}

	public Proposal updateProposal(Long id) {
		Proposal proposal = proposalRepository.findById(id).get();
		proposal.setDurum(true);
		return proposalRepository.save(proposal);
	}

	public List<Proposal> getAllProposalByNameLike(String name) {
		return proposalRepository.findByUserNameLike(name);
	}
}
