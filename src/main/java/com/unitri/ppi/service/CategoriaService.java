package com.unitri.ppi.service;


import com.unitri.ppi.domain.Categoria;
import com.unitri.ppi.exception.CategoriaAlreadyExistException;
import com.unitri.ppi.exception.CategoriaNotFoundException;
import com.unitri.ppi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class CategoriaService {

        @Autowired
        private CategoriaRepository categoriaRepository;

        @Transactional(readOnly = true)
        public List<Categoria> findAll(){
                return  categoriaRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Categoria findById(Integer id){
                if(!exist(id)){
                        throw new CategoriaNotFoundException("Categoria com este id não existe " + id);
                }
                return categoriaRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Categoria save(Categoria categoria){
                if(exist( categoria.getIdCategoria() )){
                        throw new CategoriaAlreadyExistException("Categoria com este id já existe " + categoria.getIdCategoria());
                }
                return categoriaRepository.save(categoria);
        }

        @Transactional(readOnly = false)
        public Categoria update(Categoria categoria){
                if(!exist( categoria.getIdCategoria() )){
                        throw new CategoriaNotFoundException("Categoria com este id não existe " + categoria.getIdCategoria());
                }
                return categoriaRepository.save(categoria);
        }

        @Transactional(readOnly = false)
        public void delete(Categoria categoria){
                if(!exist( categoria.getIdCategoria() )){
                        throw new CategoriaNotFoundException("Categoria com este id não existe " + categoria.getIdCategoria());
                }
                categoriaRepository.delete(categoria);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new CategoriaNotFoundException("Categoria com este id não existe " + id);
                }
                categoriaRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return categoriaRepository.exists( id );
        }
}
