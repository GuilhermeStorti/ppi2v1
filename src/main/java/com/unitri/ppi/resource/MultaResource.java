package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Multa;
import com.unitri.ppi.representation.MultaRepresentation;
import com.unitri.ppi.service.MultaService;
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
@RequestMapping("/multa")
public class MultaResource {

    @Autowired
    private MultaService multaService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<MultaRepresentation>> listAll() {
        List<Multa> multas = multaService.findAll();
        List<MultaRepresentation> representation = new ArrayList<>();
        for (Multa t : multas) {
            representation.add(new MultaRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<MultaRepresentation> findById(@PathVariable("id") Integer id) {
        Multa multa = multaService.findById(id);
        MultaRepresentation representation = new MultaRepresentation(multa);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody MultaRepresentation representation) {
        if(representation != null || representation.getIdMulta() == null){
            representation.setIdMulta(0);
        }
        Multa multa = multaService.save(MultaRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(multa.getIdMulta()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody MultaRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdMulta(id);
        multaService.update(MultaRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        multaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
