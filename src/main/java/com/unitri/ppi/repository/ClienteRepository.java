package com.unitri.ppi.repository;

import com.unitri.ppi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by guilherme on 05/04/17.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Cliente findByCpf(@Param("cpf") String cpf);
}
