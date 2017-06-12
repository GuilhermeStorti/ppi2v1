package com.unitri.ppi.service;


import com.unitri.ppi.domain.Avaria;
import com.unitri.ppi.exception.AvariaAlreadyExistException;
import com.unitri.ppi.exception.AvariaNotFoundException;
import com.unitri.ppi.repository.AvariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class AvariaService {

        @Autowired
        private AvariaRepository avariaRepository;

        @Transactional(readOnly = true)
        public List<Avaria> findAll(){
                return  avariaRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Avaria findById(Integer id){
                if(!exist(id)){
                        throw new AvariaNotFoundException("Avaria com este id não existe " + id);
                }
                return avariaRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Avaria save(Avaria avaria){
                if(exist( avaria.getIdAvaria() )){
                        throw new AvariaAlreadyExistException("Avaria com este id já existe " + avaria.getIdAvaria());
                }
                return avariaRepository.save(avaria);
        }

        @Transactional(readOnly = false)
        public Avaria update(Avaria avaria){
                if(!exist( avaria.getIdAvaria() )){
                        throw new AvariaNotFoundException("Avaria com este id não existe " + avaria.getIdAvaria());
                }
                return avariaRepository.save(avaria);
        }

        @Transactional(readOnly = false)
        public void delete(Avaria avaria){
                if(!exist( avaria.getIdAvaria() )){
                        throw new AvariaNotFoundException("Avaria com este id não existe " + avaria.getIdAvaria());
                }
                avariaRepository.delete(avaria);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new AvariaNotFoundException("Avaria com este id não existe " + id);
                }
                avariaRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return avariaRepository.exists( id );
        }
}
