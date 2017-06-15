package com.ppi2.locacaoVeiculos.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.domain.Locacao;

public class LocacaoRepositoryImpl implements LocacaoRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Locacao> findByMes(Long mes) {
		return entityManager.createNativeQuery("SELECT * FROM locacao WHERE MONTH(data) = :mes", Locacao.class).setParameter("mes", mes).getResultList();
	}

	@Override
	public Cliente findClienteByMes(Long mes) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT * FROM cliente WHERE id = ");
		sb.append("(SELECT cliente_id FROM locacao WHERE MONTH(data) = :mes ");
		sb.append("GROUP BY cliente_id ");
		sb.append("ORDER BY COUNT(*) DESC ");
		sb.append("LIMIT 1)");
		
		String sql = sb.toString();
		return (Cliente) entityManager.createNativeQuery(sql, Cliente.class).setParameter("mes", mes).getSingleResult();
	}

}
