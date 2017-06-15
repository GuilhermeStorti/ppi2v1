package com.ppi2.locacaoVeiculos.repository;

import com.ppi2.locacaoVeiculos.domain.Cliente;

public interface ClienteRepositoryCustom {

	Cliente findByCpf(String cpf);
}
