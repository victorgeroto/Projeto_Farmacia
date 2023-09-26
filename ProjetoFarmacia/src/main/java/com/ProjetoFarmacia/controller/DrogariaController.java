package com.ProjetoFarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoFarmacia.entities.Drogaria;
import com.ProjetoFarmacia.service.DrogariaService;

@RestController
@RequestMapping("/drogaria")
public class DrogariaController {

	private final DrogariaService drogariaService;

	@Autowired
	public DrogariaController(DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Drogaria> getDrogariaById(@PathVariable Long id) {
		Drogaria drogaria = drogariaService.getDrogariaById(id);
		if (drogaria != null) {
			return ResponseEntity.ok(drogaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Drogaria>> getAllDrogaria() {
		List<Drogaria> drogaria = drogariaService.getAllDrogaria();
		return ResponseEntity.ok(drogaria);
	}
	@PostMapping("/")
	public ResponseEntity<Drogaria> criarDrogaria(@RequestBody Drogaria drogaria) {
		Drogaria criarDrogaria = drogariaService.salvarDrogaria(drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarDrogaria);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Drogaria> updateDrogaria(@PathVariable Long id, @RequestBody Drogaria drogaria) {
		Drogaria updatedDrogaria = drogariaService.updateDrogaria(id, drogaria);
		if (updatedDrogaria != null) {
			return ResponseEntity.ok(updatedDrogaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDrogaria(@PathVariable Long id) {
		boolean deleted = drogariaService.deleteDrogaria(id);
		if (deleted) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

