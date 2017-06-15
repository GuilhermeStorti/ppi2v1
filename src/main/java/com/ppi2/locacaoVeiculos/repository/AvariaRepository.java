package com.ppi2.locacaoVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppi2.locacaoVeiculos.domain.Avaria;

@Repository
public interface AvariaRepository extends JpaRepository<Avaria, Long> {

}
