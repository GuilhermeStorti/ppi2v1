package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Multa;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.MultaRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository multaRepository;
	
	@Transactional(readOnly=true)
	public List<Multa> findAll() {
		return multaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Multa findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Multa com o id " + id + " não existe!");
		}
		
		return multaRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return multaRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Multa save(Multa multa) {
		if (multa.getId() != null && exist(multa.getId())) {
			throw new EntityAlreadyExistException("Multa com o id " + multa.getId() + " já existe!");
		}
		
		return multaRepository.save(multa);
	}
	
	@Transactional(readOnly=false)
	public Multa update(Multa multa) {
		if (!exist(multa.getId())) {
			throw new EntityNotFoundException("Multa com o id " + multa.getId() + " não existe!");
		}
		
		return multaRepository.save(multa);
	}
	
	@Transactional(readOnly=false)
	public Multa delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Multa com o id " + id + " não existe!");
		}
		
		multaRepository.delete(id);
		
		return multaRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Multa delete(Multa multa) {
		if (!exist(multa.getId())) {
			throw new EntityNotFoundException("Multa com o id " + multa.getId() + " não existe!");
		}
		
		multaRepository.delete(multa);
		
		return multaRepository.findOne(multa.getId());
	}

}
