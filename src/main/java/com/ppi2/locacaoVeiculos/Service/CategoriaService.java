package com.ppi2.locacaoVeiculos.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.locacaoVeiculos.domain.Categoria;
import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Categoria findById(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Categoria com o id " + id + " não existe!");
		}
		
		return categoriaRepository.findOne(id);
	}

	@Transactional(readOnly=true)
	private boolean exist(Long id) {
		return categoriaRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Categoria save(Categoria categoria) {
		if (categoria.getId() != null && exist(categoria.getId())) {
			throw new EntityAlreadyExistException("Categoria com o id " + categoria.getId() + " já existe!");
		}
		
		return categoriaRepository.save(categoria);
	}
	
	@Transactional(readOnly=false)
	public Categoria update(Categoria categoria) {
		if (!exist(categoria.getId())) {
			throw new EntityNotFoundException("Categoria com o id " + categoria.getId() + " não existe!");
		}
		
		return categoriaRepository.save(categoria);
	}
	
	@Transactional(readOnly=false)
	public Categoria delete(Long id) {
		if (!exist(id)) {
			throw new EntityNotFoundException("Categoria com o id " + id + " não existe!");
		}
		
		categoriaRepository.delete(id);
		
		return categoriaRepository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public Categoria delete(Categoria categoria) {
		if (!exist(categoria.getId())) {
			throw new EntityNotFoundException("Categoria com o id " + categoria.getId() + " não existe!");
		}
		
		categoriaRepository.delete(categoria);
		
		return categoriaRepository.findOne(categoria.getId());
	}
	
}
