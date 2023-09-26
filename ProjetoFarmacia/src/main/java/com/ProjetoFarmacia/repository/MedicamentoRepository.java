package com.ProjetoFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoFarmacia.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

}
