package com.unitri.ppi.resource;

import com.unitri.ppi.domain.Cliente;
import com.unitri.ppi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
        clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}
