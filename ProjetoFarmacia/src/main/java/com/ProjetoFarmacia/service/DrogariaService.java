package com.ProjetoFarmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoFarmacia.entities.Drogaria;
import com.ProjetoFarmacia.repository.DrogariaRepository;

@Service
public class DrogariaService {
	private final DrogariaRepository drogariaRepository;
	
	@Autowired
    public DrogariaService(DrogariaRepository drogariaRepository) {
        this.drogariaRepository = drogariaRepository;
    }
	  public List<Drogaria> getAllDrogaria() {
	        return drogariaRepository.findAll();
	    }

	    public Drogaria getDrogariaById(Long id) {
	        Optional<Drogaria> drogaria = drogariaRepository.findById(id);
	        return drogaria.orElse(null);
	    }

	    public Drogaria salvarDrogaria(Drogaria drogaria) {
	        return drogariaRepository.save(drogaria);
	    }

	    public Drogaria updateDrogaria(Long id, Drogaria updatedDrogaria) {
	        Optional<Drogaria> existingDrogaria = drogariaRepository.findById(id);
	        if (existingDrogaria.isPresent()) {
	            updatedDrogaria.setId(id);
	            return drogariaRepository.save(updatedDrogaria);
	        }
	        return null;
	    }

	    public boolean deleteDrogaria(Long id) {
	        Optional<Drogaria> existingDrogaria = drogariaRepository.findById(id);
	        if (existingDrogaria.isPresent()) {
	        	drogariaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}

