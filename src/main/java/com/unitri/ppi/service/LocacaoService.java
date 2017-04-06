package com.unitri.ppi.service;


import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.exception.LocacaoAlreadyExistException;
import com.unitri.ppi.exception.LocacaoNotFoundException;
import com.unitri.ppi.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class LocacaoService {

        @Autowired
        private LocacaoRepository locacaoRepository;

        @Transactional(readOnly = true)
        public List<Locacao> findAll(){
                return  locacaoRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Locacao findById(Integer id){
                if(!exist(id)){
                        throw new LocacaoNotFoundException("Locacao com este id não existe " + id);
                }
                return locacaoRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Locacao save(Locacao locacao){
                if(locacao.getIdLocacao() == null && exist( locacao.getIdLocacao() )){
                        throw new LocacaoAlreadyExistException("Locacao com este id já existe " + locacao.getIdLocacao());
                }
                return locacaoRepository.save(locacao);
        }

        @Transactional(readOnly = false)
        public Locacao update(Locacao locacao){
                if(locacao.getIdLocacao() == null && !exist( locacao.getIdLocacao() )){
                        throw new LocacaoNotFoundException("Locacao com este id não existe " + locacao.getIdLocacao());
                }
                return locacaoRepository.save(locacao);
        }

        @Transactional(readOnly = false)
        public void delete(Locacao locacao){
                if(!exist( locacao.getIdLocacao() )){
                        throw new LocacaoNotFoundException("Locacao com este id não existe " + locacao.getIdLocacao());
                }
                locacaoRepository.delete(locacao);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new LocacaoNotFoundException("Locacao com este id não existe " + id);
                }
                locacaoRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return locacaoRepository.exists( id );
        }
}
