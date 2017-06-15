package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Avaria;
import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.domain.Locacao;
import com.ppi2.locacaoVeiculos.domain.Multa;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Transactional(readOnly=true)
	public List<Locacao> findAll() {
		return locacaoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Locacao findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Locacao com o id " + id + " não existe!");
		}
		
		return locacaoRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return locacaoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Locacao save(Locacao Locacao) {
		if (Locacao.getId() != null && exist(Locacao.getId())) {
			throw new EntityAlreadyExistException("Locacao com o id " + Locacao.getId() + " já existe!");
		}
		
		return locacaoRepository.save(Locacao);
	}
	
	@Transactional(readOnly=false)
	public Locacao update(Locacao Locacao) {
		if (!exist(Locacao.getId())) {
			throw new EntityNotFoundException("Locacao com o id " + Locacao.getId() + " não existe!");
		}
		
		return locacaoRepository.save(Locacao);
	}
	
	@Transactional(readOnly=false)
	public Locacao delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Locacao com o id " + id + " não existe!");
		}
		
		locacaoRepository.delete(id);
		
		return locacaoRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Locacao delete(Locacao Locacao) {
		if (!exist(Locacao.getId())) {
			throw new EntityNotFoundException("Locacao com o id " + Locacao.getId() + " não existe!");
		}
		
		locacaoRepository.delete(Locacao);
		
		return locacaoRepository.findOne(Locacao.getId());
	}
	
	/*
	 * Multas -> Locação
	 */
	
	@Transactional(readOnly=true)
	public List<Multa> findMultas(Long id) {
		return locacaoRepository.findOne(id).getMultas();
	}
	
	/*
	 * Avarias -> Locação
	 */
	
	@Transactional(readOnly=true)
	public List<Avaria> findAvarias(Long id) {
		return locacaoRepository.findOne(id).getAvarias();
	}
	
	/*
	 * Locação -> Mês
	 */
	
	@Transactional(readOnly=true)
	public List<Locacao> findByMes(Long mes) {
		return locacaoRepository.findByMes(mes);
	}
	
	/*
	 * Cliente -> Locação
	 */

	@Transactional(readOnly=true)
	public Cliente findClienteByMes(Long mes) {
		return locacaoRepository.findClienteByMes(mes);
	}
}
