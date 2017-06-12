package com.unitri.ppi.service;


import com.unitri.ppi.domain.Veiculo;
import com.unitri.ppi.exception.VeiculoAlreadyExistException;
import com.unitri.ppi.exception.VeiculoNotFoundException;
import com.unitri.ppi.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class VeiculoService {

        @Autowired
        private VeiculoRepository veiculoRepository;

        @Transactional(readOnly = true)
        public List<Veiculo> findAll(){
                return  veiculoRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Veiculo findById(Integer id){
                if(!exist(id)){
                        throw new VeiculoNotFoundException("Veiculo com este id não existe " + id);
                }
                return veiculoRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Veiculo save(Veiculo veiculo){
                if(exist( veiculo.getIdVeiculo() )){
                        throw new VeiculoAlreadyExistException("Veiculo com este id já existe " + veiculo.getIdVeiculo());
                }
                return veiculoRepository.save(veiculo);
        }

        @Transactional(readOnly = false)
        public Veiculo update(Veiculo veiculo){
                if(!exist( veiculo.getIdVeiculo() )){
                        throw new VeiculoNotFoundException("Veiculo com este id não existe " + veiculo.getIdVeiculo());
                }
                return veiculoRepository.save(veiculo);
        }

        @Transactional(readOnly = false)
        public void delete(Veiculo veiculo){
                if(!exist( veiculo.getIdVeiculo() )){
                        throw new VeiculoNotFoundException("Veiculo com este id não existe " + veiculo.getIdVeiculo());
                }
                veiculoRepository.delete(veiculo);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new VeiculoNotFoundException("Veiculo com este id não existe " + id);
                }
                veiculoRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return veiculoRepository.exists( id );
        }
}
