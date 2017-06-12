package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Veiculo;
import com.unitri.ppi.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Veiculo>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Veiculo> findById(@PathVariable("id") Integer id) {
        Veiculo veiculo = veiculoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(veiculo);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Veiculo veiculo) {
        veiculoService.save(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Veiculo veiculo, @PathVariable("id") Integer id) {
        veiculoService.update(veiculo);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
