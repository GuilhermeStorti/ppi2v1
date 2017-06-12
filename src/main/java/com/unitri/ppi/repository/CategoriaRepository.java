package com.unitri.ppi.repository;

import com.unitri.ppi.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilherme on 05/04/17.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
