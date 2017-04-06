package com.unitri.ppi.service;


import com.unitri.ppi.domain.Cliente;
import com.unitri.ppi.exception.ClienteAlreadyExistException;
import com.unitri.ppi.exception.ClienteNotFoundException;
import com.unitri.ppi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@Service
public class ClienteService {

        @Autowired
        private ClienteRepository clienteRepository;

        @Transactional(readOnly = true)
        public List<Cliente> findAll(){
                return  clienteRepository.findAll();
        }

        @Transactional(readOnly = true)
        public Cliente findById(Integer id){
                if(!exist(id)){
                        throw new ClienteNotFoundException("Cliente com este id não existe " + id);
                }
                return clienteRepository.findOne( id );
        }


        @Transactional(readOnly = false)
        public Cliente save(Cliente cliente){
                if(cliente.getIdCliente() == null && exist( cliente.getIdCliente() )){
                        throw new ClienteAlreadyExistException("Cliente com este id já existe " + cliente.getIdCliente());
                }
                return clienteRepository.save(cliente);
        }

        @Transactional(readOnly = false)
        public Cliente update(Cliente cliente){
                if(cliente.getIdCliente() == null && !exist( cliente.getIdCliente() )){
                        throw new ClienteNotFoundException("Cliente com este id não existe " + cliente.getIdCliente());
                }
                return clienteRepository.save(cliente);
        }

        @Transactional(readOnly = false)
        public void delete(Cliente cliente){
                if(!exist( cliente.getIdCliente() )){
                        throw new ClienteNotFoundException("Cliente com este id não existe " + cliente.getIdCliente());
                }
                clienteRepository.delete(cliente);
        }

        @Transactional(readOnly = false)
        public void delete(Integer id){
                if(!exist( id )){
                        throw new ClienteNotFoundException("Cliente com este id não existe " + id);
                }
                clienteRepository.delete(id);
        }

        private boolean exist( Integer id ) {
                return clienteRepository.exists( id );
        }
}
