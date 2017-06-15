package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Cliente com o id " + id + " não existe!");
		}
		
		return clienteRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return clienteRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Cliente save(Cliente cliente) {
		if (cliente.getId() != null && exist(cliente.getId())) {
			throw new EntityAlreadyExistException("Cliente com o id " + cliente.getId() + " já existe!");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional(readOnly=false)
	public Cliente update(Cliente cliente) {
		if (!exist(cliente.getId())) {
			throw new EntityNotFoundException("Cliente com o id " + cliente.getId() + " não existe!");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional(readOnly=false)
	public Cliente delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Cliente com o id " + id + " não existe!");
		}
		
		clienteRepository.delete(id);
		
		return clienteRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Cliente delete(Cliente cliente) {
		if (!exist(cliente.getId())) {
			throw new EntityNotFoundException("Cliente com o id " + cliente.getId() + " não existe!");
		}
		
		clienteRepository.delete(cliente);
		
		return clienteRepository.findOne(cliente.getId());
	}
	
	@Transactional(readOnly=true)
	public Cliente findByCpf(String cpf) {
		/*if (!exist(id)) {
			throw new EntityNotFoundException("Cliente com o cpf " + cpf + " não existe!");
		}*/
		
		return clienteRepository.findByCpf(cpf);
	}
	
}
