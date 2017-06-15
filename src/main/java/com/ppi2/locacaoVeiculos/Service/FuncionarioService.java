package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Funcionario;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Transactional(readOnly=true)
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Funcionario findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Funcionario com o id " + id + " não existe!");
		}
		
		return funcionarioRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return funcionarioRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Funcionario save(Funcionario funcionario) {
		if (funcionario.getId() != null && exist(funcionario.getId())) {
			throw new EntityAlreadyExistException("Funcionario com o id " + funcionario.getId() + " já existe!");
		}
		
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional(readOnly=false)
	public Funcionario update(Funcionario funcionario) {
		if (!exist(funcionario.getId())) {
			throw new EntityNotFoundException("Funcionario com o id " + funcionario.getId() + " não existe!");
		}
		
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional(readOnly=false)
	public Funcionario delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Funcionario com o id " + id + " não existe!");
		}
		
		funcionarioRepository.delete(id);
		
		return funcionarioRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Funcionario delete(Funcionario funcionario) {
		if (!exist(funcionario.getId())) {
			throw new EntityNotFoundException("Funcionario com o id " + funcionario.getId() + " não existe!");
		}
		
		funcionarioRepository.delete(funcionario);
		
		return funcionarioRepository.findOne(funcionario.getId());
	}
	
}
