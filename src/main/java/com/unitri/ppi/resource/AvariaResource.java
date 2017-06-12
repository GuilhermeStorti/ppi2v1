package com.unitri.ppi.resource;

import com.unitri.ppi.domain.Avaria;
import com.unitri.ppi.service.AvariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/avaria")
public class AvariaResource {

    @Autowired
    private AvariaService avariaService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Avaria>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(avariaService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Avaria> findById(@PathVariable("id") Integer id) {
        Avaria avaria = avariaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(avaria);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Avaria avaria) {
        avariaService.save(avaria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaria.getIdAvaria()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Avaria avaria, @PathVariable("id") Integer id) {
        avariaService.update(avaria);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        avariaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
