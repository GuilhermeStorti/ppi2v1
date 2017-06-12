package com.unitri.ppi.resource;

import com.unitri.ppi.domain.Categoria;
import com.unitri.ppi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Categoria> findById(@PathVariable("id") Integer id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable("id") Integer id) {
        categoriaService.update(categoria);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
