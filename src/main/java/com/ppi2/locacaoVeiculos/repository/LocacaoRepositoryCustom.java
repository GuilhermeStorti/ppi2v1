package com.ppi2.locacaoVeiculos.repository;

import java.util.List;

import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.domain.Locacao;

public interface LocacaoRepositoryCustom {

	List<Locacao> findByMes(Long mes);
	
	Cliente findClienteByMes(Long mes);
	
}
