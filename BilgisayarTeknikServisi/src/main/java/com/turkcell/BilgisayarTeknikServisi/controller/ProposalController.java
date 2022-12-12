package com.turkcell.BilgisayarTeknikServisi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.BilgisayarTeknikServisi.model.Proposal;
import com.turkcell.BilgisayarTeknikServisi.service.ProposalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "proposal")
public class ProposalController {

	private ProposalService proposalService;

	@GetMapping(path = "/getAll")
	public List<Proposal> getAllProposal() {
		return proposalService.getAllProposal();
	}

	@GetMapping(path = "/getById/{id}")
	public Proposal getById(@PathVariable(name = "id") Long id) {
		return proposalService.getById(id);
	}

	@GetMapping(path = "/getAllProposal")
	public List<Proposal> getAllProposalByNameLike(@RequestParam(name = "name") String name) {
		return proposalService.getAllProposalByNameLike(name);
	}

	@PostMapping(path = "/save")
	public Proposal createProposal(@RequestBody Proposal proposal) {
		return proposalService.createProposal(proposal);
	}

	@PostMapping(path = "/update/{id}")
	public Proposal updateProposal(@PathVariable(name = "id") Long id) {
		return proposalService.updateProposal(id);
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
		proposalService.deleteById(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}
}
