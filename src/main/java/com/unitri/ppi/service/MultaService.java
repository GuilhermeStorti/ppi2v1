package com.unitri.ppi.service;


import com.unitri.ppi.domain.Multa;
import com.unitri.ppi.exception.MultaAlreadyExistException;
import com.unitri.ppi.exception.MultaNotFoundException;
import com.unitri.ppi.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class MultaService {

        @Autowired
        private MultaRepository multaRepository;

        @Transactional(readOnly = true)
        public List<Multa> findAll(){
                return  multaRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Multa findById(Integer id){
                if(!exist(id)){
                        throw new MultaNotFoundException("Multa com este id não existe " + id);
                }
                return multaRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Multa save(Multa multa){
                if(multa.getIdMulta() == null && exist( multa.getIdMulta() )){
                        throw new MultaAlreadyExistException("Multa com este id já existe " + multa.getIdMulta());
                }
                return multaRepository.save(multa);
        }

        @Transactional(readOnly = false)
        public Multa update(Multa multa){
                if(multa.getIdMulta() == null && !exist( multa.getIdMulta() )){
                        throw new MultaNotFoundException("Multa com este id não existe " + multa.getIdMulta());
                }
                return multaRepository.save(multa);
        }

        @Transactional(readOnly = false)
        public void delete(Multa multa){
                if(!exist( multa.getIdMulta() )){
                        throw new MultaNotFoundException("Multa com este id não existe " + multa.getIdMulta());
                }
                multaRepository.delete(multa);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new MultaNotFoundException("Multa com este id não existe " + id);
                }
                multaRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return multaRepository.exists( id );
        }
}
