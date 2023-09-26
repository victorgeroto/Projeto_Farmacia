package com.ProjetoFarmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoFarmacia.entities.Medicamento;
import com.ProjetoFarmacia.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
	private final MedicamentoRepository medicamentoRepository;
	
	@Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }
	
	public List<Medicamento> getAllMedicamento() {
        return medicamentoRepository.findAll();
    }

    public Medicamento getMedicamentoById(Long id) {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
        return medicamento.orElse(null);
    }

    public Medicamento salvarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento updateMedicamento(Long id, Medicamento updatedMedicamento) {
        Optional<Medicamento> existingMedicamento = medicamentoRepository.findById(id);
        if (existingMedicamento.isPresent()) {
            updatedMedicamento.setId(id);
            return medicamentoRepository.save(updatedMedicamento);
        }
        return null;
    }

    public boolean deleteMedicamento(Long id) {
        Optional<Medicamento> existingMedicamento = medicamentoRepository.findById(id);
        if (existingMedicamento.isPresent()) {
        	medicamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

