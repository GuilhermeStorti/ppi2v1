package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Avaria;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.AvariaRepository;

@Service
public class AvariaService {

	@Autowired
	private AvariaRepository avariaRepository;
	
	@Transactional(readOnly=true)
	public List<Avaria> findAll() {
		return avariaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Avaria findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Avaria com o id " + id + " não existe!");
		}
		
		return avariaRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return avariaRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Avaria save(Avaria avaria) {
		if (avaria.getId() != null && exist(avaria.getId())) {
			throw new EntityAlreadyExistException("Avaria com o id " + avaria.getId() + " já existe!");
		}
		
		return avariaRepository.save(avaria);
	}
	
	@Transactional(readOnly=false)
	public Avaria update(Avaria avaria) {
		if (!exist(avaria.getId())) {
			throw new EntityNotFoundException("Avaria com o id " + avaria.getId() + " não existe!");
		}
		
		return avariaRepository.save(avaria);
	}
	
	@Transactional(readOnly=false)
	public Avaria delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Avaria com o id " + id + " não existe!");
		}
		
		avariaRepository.delete(id);
		
		return avariaRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Avaria delete(Avaria avaria) {
		if (!exist(avaria.getId())) {
			throw new EntityNotFoundException("Avaria com o id " + avaria.getId() + " não existe!");
		}
		
		avariaRepository.delete(avaria);
		
		return avariaRepository.findOne(avaria.getId());
	}
	
}
