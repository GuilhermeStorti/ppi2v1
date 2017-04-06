package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Categoria;
import com.unitri.ppi.representation.CategoriaRepresentation;
import com.unitri.ppi.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<CategoriaRepresentation>> listAll() {
        List<Categoria> categorias = categoriaService.findAll();
        List<CategoriaRepresentation> representation = new ArrayList<>();
        for (Categoria t : categorias) {
            representation.add(new CategoriaRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<CategoriaRepresentation> findById(@PathVariable("id") Integer id) {
        Categoria categoria = categoriaService.findById(id);
        CategoriaRepresentation representation = new CategoriaRepresentation(categoria);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody CategoriaRepresentation representation) {
        if(representation != null || representation.getIdCategoria() == null){
            representation.setIdCategoria(0);
        }
        Categoria categoria = categoriaService.save(CategoriaRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody CategoriaRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdCategoria(id);
        categoriaService.update(CategoriaRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
