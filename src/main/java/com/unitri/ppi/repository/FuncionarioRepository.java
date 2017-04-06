package com.unitri.ppi.repository;

import com.unitri.ppi.domain.Categoria;
import com.unitri.ppi.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilherme on 05/04/17.
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
