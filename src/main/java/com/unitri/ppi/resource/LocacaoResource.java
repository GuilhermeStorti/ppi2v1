package com.unitri.ppi.resource;

import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.service.LocacaoService;
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
@RequestMapping("/locacao")
public class LocacaoResource {

    @Autowired
    private LocacaoService locacaoService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Locacao>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Locacao> findById(@PathVariable("id") Integer id) {
        Locacao locacao = locacaoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(locacao);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Locacao locacao) {
        locacaoService.save(locacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(locacao.getIdLocacao()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Locacao locacao, @PathVariable("id") Integer id) {
        locacaoService.update(locacao);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        locacaoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
