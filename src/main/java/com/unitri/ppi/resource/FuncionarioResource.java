package com.unitri.ppi.resource;

import com.unitri.ppi.domain.Funcionario;
import com.unitri.ppi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Funcionario>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Funcionario> findById(@PathVariable("id") Integer id) {
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Funcionario funcionario) {
        funcionarioService.save(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getIdfuncionario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Funcionario funcionario, @PathVariable("id") Integer id) {
        funcionarioService.update(funcionario);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
