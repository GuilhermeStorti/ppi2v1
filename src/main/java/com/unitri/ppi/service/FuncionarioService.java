package com.unitri.ppi.service;


import com.unitri.ppi.domain.Funcionario;
import com.unitri.ppi.exception.FuncionarioAlreadyExistException;
import com.unitri.ppi.exception.FuncionarioNotFoundException;
import com.unitri.ppi.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class FuncionarioService {

        @Autowired
        private FuncionarioRepository funcionarioRepository;

        @Transactional(readOnly = true)
        public List<Funcionario> findAll(){
                return  funcionarioRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Funcionario findById(Integer id){
                if(!exist(id)){
                        throw new FuncionarioNotFoundException("Funcionario com este id não existe " + id);
                }
                return funcionarioRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Funcionario save(Funcionario funcionario){
                if(exist( funcionario.getIdfuncionario() )){
                        throw new FuncionarioAlreadyExistException("Funcionario com este id já existe " + funcionario.getIdfuncionario());
                }
                return funcionarioRepository.save(funcionario);
        }

        @Transactional(readOnly = false)
        public Funcionario update(Funcionario funcionario){
                if(!exist( funcionario.getIdfuncionario() )){
                        throw new FuncionarioNotFoundException("Funcionario com este id não existe " + funcionario.getIdfuncionario());
                }
                return funcionarioRepository.save(funcionario);
        }

        @Transactional(readOnly = false)
        public void delete(Funcionario funcionario){
                if(!exist( funcionario.getIdfuncionario() )){
                        throw new FuncionarioNotFoundException("Funcionario com este id não existe " + funcionario.getIdfuncionario());
                }
                funcionarioRepository.delete(funcionario);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new FuncionarioNotFoundException("Funcionario com este id não existe " + id);
                }
                funcionarioRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return funcionarioRepository.exists( id );
        }
}
