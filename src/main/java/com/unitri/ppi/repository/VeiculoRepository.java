package com.unitri.ppi.repository;

import com.unitri.ppi.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilherme on 05/04/17.
 */
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
