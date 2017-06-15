package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Veiculo;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Transactional(readOnly=true)
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Veiculo findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Veiculo com o id " + id + " não existe!");
		}
		
		return veiculoRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return veiculoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Veiculo save(Veiculo veiculo) {
		if (veiculo.getId() != null && exist(veiculo.getId())) {
			throw new EntityAlreadyExistException("Veiculo com o id " + veiculo.getId() + " já existe!");
		}
		
		return veiculoRepository.save(veiculo);
	}
	
	@Transactional(readOnly=false)
	public Veiculo update(Veiculo veiculo) {
		if (!exist(veiculo.getId())) {
			throw new EntityNotFoundException("Veiculo com o id " + veiculo.getId() + " não existe!");
		}
		
		return veiculoRepository.save(veiculo);
	}
	
	@Transactional(readOnly=false)
	public Veiculo delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Veiculo com o id " + id + " não existe!");
		}
		
		veiculoRepository.delete(id);
		
		return veiculoRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Veiculo delete(Veiculo veiculo) {
		if (!exist(veiculo.getId())) {
			throw new EntityNotFoundException("Veiculo com o id " + veiculo.getId() + " não existe!");
		}
		
		veiculoRepository.delete(veiculo);
		
		return veiculoRepository.findOne(veiculo.getId());
	}
	
}
