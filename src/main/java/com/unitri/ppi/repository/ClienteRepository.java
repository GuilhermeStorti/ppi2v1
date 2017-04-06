package com.unitri.ppi.repository;

import com.unitri.ppi.domain.Avaria;
import com.unitri.ppi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilherme on 05/04/17.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
