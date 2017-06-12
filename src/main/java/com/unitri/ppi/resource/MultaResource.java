package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Multa;
import com.unitri.ppi.service.MultaService;
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
@RequestMapping("/multa")
public class MultaResource {

    @Autowired
    private MultaService multaService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Multa>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(multaService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Multa> findById(@PathVariable("id") Integer id) {
        Multa multa = multaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(multa);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Multa multa) {
        multaService.save(multa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(multa.getIdMulta()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Multa multa, @PathVariable("id") Integer id) {
        multaService.update(multa);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        multaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
