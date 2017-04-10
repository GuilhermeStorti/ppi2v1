package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Cliente;
import com.unitri.ppi.representation.ClienteRepresentation;
import com.unitri.ppi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by guilherme on 13/03/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<ClienteRepresentation>> listAll() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteRepresentation> representation = new ArrayList<>();
        for (Cliente t : clientes) {
            representation.add(new ClienteRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<ClienteRepresentation> findById(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.findById(id);
        ClienteRepresentation representation = new ClienteRepresentation(cliente);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody ClienteRepresentation representation) {
        if(representation != null || representation.getIdCliente() == null){
            representation.setIdCliente(0);
        }
        Cliente cliente = clienteService.save(ClienteRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody ClienteRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdCliente(id);
        clienteService.update(ClienteRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<ClienteRepresentation> findById(@PathVariable("cpf") String cpf) {
        Cliente cliente = clienteService.findByCpf(cpf);
        ClienteRepresentation representation = new ClienteRepresentation(cliente);
        return ResponseEntity.ok(representation);
    }

}
