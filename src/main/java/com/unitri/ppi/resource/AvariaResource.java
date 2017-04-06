package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Avaria;
import com.unitri.ppi.representation.AvariaRepresentation;
import com.unitri.ppi.service.AvariaService;
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
@RequestMapping("/avarias")
public class AvariaResource {

    @Autowired
    private AvariaService avariaService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<AvariaRepresentation>> listAll() {
        List<Avaria> avarias = avariaService.findAll();
        List<AvariaRepresentation> representation = new ArrayList<>();
        for (Avaria t : avarias) {
            representation.add(new AvariaRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<AvariaRepresentation> findById(@PathVariable("id") Integer id) {
        Avaria avaria = avariaService.findById(id);
        AvariaRepresentation representation = new AvariaRepresentation(avaria);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody AvariaRepresentation representation) {
        if(representation != null || representation.getIdAvaria() == null){
            representation.setIdAvaria(0);
        }
        Avaria avaria = avariaService.save(AvariaRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaria.getIdAvaria()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody AvariaRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdAvaria(id);
        avariaService.update(AvariaRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        avariaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
