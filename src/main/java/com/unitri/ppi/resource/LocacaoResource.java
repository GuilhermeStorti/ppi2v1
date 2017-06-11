package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Avaria;
import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.domain.Multa;
import com.unitri.ppi.representation.AvariaRepresentation;
import com.unitri.ppi.representation.LocacaoRepresentation;
import com.unitri.ppi.representation.MultaRepresentation;
import com.unitri.ppi.service.LocacaoService;
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
@RequestMapping("/locacao")
public class LocacaoResource {

    @Autowired
    private LocacaoService locacaoService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<LocacaoRepresentation>> listAll() {
        List<Locacao> locacaos = locacaoService.findAll();
        List<LocacaoRepresentation> representation = new ArrayList<>();
        for (Locacao t : locacaos) {
            representation.add(new LocacaoRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<LocacaoRepresentation> findById(@PathVariable("id") Integer id) {
        Locacao locacao = locacaoService.findById(id);
        LocacaoRepresentation representation = new LocacaoRepresentation(locacao);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody LocacaoRepresentation representation) {
        if(representation != null || representation.getIdLocacao() == null){
            representation.setIdLocacao(0);
        }
        Locacao locacao = locacaoService.save(LocacaoRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(locacao.getIdLocacao()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody LocacaoRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdLocacao(id);
        locacaoService.update(LocacaoRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        locacaoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}/avarias", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<AvariaRepresentation>> listAvariasByLocacaoll(@PathVariable("id") Integer id) {
        Locacao locacao = locacaoService.findById(id);

        List<Avaria> avarias = locacao.getAvariaList();
        List<AvariaRepresentation> representation = new ArrayList<>();
        for (Avaria t : avarias) {
            representation.add(new AvariaRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}/multas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<MultaRepresentation>> listMultasByLocacao(@PathVariable("id") Integer id) {
        Locacao locacao = locacaoService.findById(id);

        List<Multa> multas = locacao.getMultaList();
        List<MultaRepresentation> representation = new ArrayList<>();
        for (Multa t : multas) {
            representation.add(new MultaRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

}
