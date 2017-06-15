package com.ppi2.locacaoVeiculos.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ppi2.locacaoVeiculos.Service.MultaService;
import com.ppi2.locacaoVeiculos.domain.Multa;
import com.ppi2.locacaoVeiculos.representation.MultaRepresentation;

@CrossOrigin
@RestController
@RequestMapping("/multas")
public class MultaResource {

	@Autowired
	private MultaService multaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<MultaRepresentation>> listAll() {
		
		List<Multa> multas = multaService.findAll();
		List<MultaRepresentation> representations = new ArrayList<>();
		
		multas.forEach(multa -> {
			representations.add(new MultaRepresentation(multa));
		});
		
		return ResponseEntity.ok(representations);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<MultaRepresentation> findById(@PathVariable("id") Long id) {
				
		Multa multa = multaService.findById(id);
		MultaRepresentation representation = new MultaRepresentation(multa);
		
		return ResponseEntity.ok(representation);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody MultaRepresentation representation) {
		
		Multa multa = multaService.save(MultaRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(multa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody MultaRepresentation representation, @PathVariable("id") Long id) {
		
		representation.setIdentifier(id);
		multaService.update(MultaRepresentation.build(representation));
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<MultaRepresentation> delete(@PathVariable("id") Long id) {
		
		Multa multa = multaService.findById(id);
		MultaRepresentation representation = new MultaRepresentation(multa);
		multaService.delete(multa);
		
		return ResponseEntity.ok(representation);
		
	}
	
}
