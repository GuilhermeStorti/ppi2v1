package com.unitri.ppi.resource;


import com.unitri.ppi.domain.Locacao;
import com.unitri.ppi.domain.Veiculo;
import com.unitri.ppi.representation.LocacaoRepresentation;
import com.unitri.ppi.representation.VeiculoRepresentation;
import com.unitri.ppi.service.VeiculoService;
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

@CrossOrigin
@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<VeiculoRepresentation>> listAll() {
        List<Veiculo> veiculos = veiculoService.findAll();
        List<VeiculoRepresentation> representation = new ArrayList<>();
        for (Veiculo t : veiculos) {
            representation.add(new VeiculoRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<VeiculoRepresentation> findById(@PathVariable("id") Integer id) {
        Veiculo veiculo = veiculoService.findById(id);
        VeiculoRepresentation representation = new VeiculoRepresentation(veiculo);
        return ResponseEntity.ok(representation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody VeiculoRepresentation representation) {
        if(representation != null || representation.getIdVeiculo() == null){
            representation.setIdVeiculo(0);
        }
        Veiculo veiculo = veiculoService.save(VeiculoRepresentation.build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> update(@RequestBody VeiculoRepresentation representation, @PathVariable("id") Integer id) {
        representation.setIdVeiculo(id);
        veiculoService.update(VeiculoRepresentation.build(representation));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<Void> delete(@PathVariable("id") Integer id) {
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}/" +
            "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody HttpEntity<List<LocacaoRepresentation>> listLocacoesByVeiculo(@PathVariable("id") Integer id) {
        Veiculo veiculo = veiculoService.findById(id);

        List<Locacao> multas = veiculo.getLocacaoList();
        List<LocacaoRepresentation> representation = new ArrayList<>();
        for (Locacao t : multas) {
            representation.add(new LocacaoRepresentation(t));
        }
        return ResponseEntity.ok(representation);
    }

}
