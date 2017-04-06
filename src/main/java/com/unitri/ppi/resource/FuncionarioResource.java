package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Funcionario;
import com.unitri.ppi.representation.FuncionarioRepresentation;
import com.unitri.ppi.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<FuncionarioRepresentation>> listAll() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        List<FuncionarioRepresentation> representation = new ArrayList<>();
        for (Funcionario t : funcionarios) {
            representation.add(new FuncionarioRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<FuncionarioRepresentation> findById(@PathVariable("id") Integer id) {
        Funcionario funcionario = funcionarioService.findById(id);
        FuncionarioRepresentation representation = new FuncionarioRepresentation(funcionario);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody FuncionarioRepresentation representation) {
        if(representation != null || representation.getIdFuncionario() == null){
            representation.setIdFuncionario(0);
        }
        Funcionario funcionario = funcionarioService.save(FuncionarioRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getIdfuncionario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody FuncionarioRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdFuncionario(id);
        funcionarioService.update(FuncionarioRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
