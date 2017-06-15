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

import com.ppi2.locacaoVeiculos.Service.LocacaoService;
import com.ppi2.locacaoVeiculos.Service.MultaService;
import com.ppi2.locacaoVeiculos.domain.Avaria;
import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.domain.Locacao;
import com.ppi2.locacaoVeiculos.domain.Multa;
import com.ppi2.locacaoVeiculos.representation.AvariaRepresentation;
import com.ppi2.locacaoVeiculos.representation.ClienteRepresentation;
import com.ppi2.locacaoVeiculos.representation.LocacaoRepresentation;
import com.ppi2.locacaoVeiculos.representation.MultaRepresentation;

@CrossOrigin
@RestController
@RequestMapping("/locacoes")
public class LocacaoResource {

	@Autowired
	private LocacaoService locacaoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> listAll() {
		
		List<Locacao> locacoes = locacaoService.findAll();
		List<LocacaoRepresentation> representations = new ArrayList<>();
		
		locacoes.forEach(locacao -> {
			representations.add(new LocacaoRepresentation(locacao));
		});
		
		return ResponseEntity.ok(representations);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<LocacaoRepresentation> findById(@PathVariable("id") Long id) {
				
		Locacao locacao = locacaoService.findById(id);
		LocacaoRepresentation representation = new LocacaoRepresentation(locacao);
		
		return ResponseEntity.ok(representation);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody LocacaoRepresentation representation) {
		
		Locacao locacao = locacaoService.save(LocacaoRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(locacao.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody LocacaoRepresentation representation, @PathVariable("id") Long id) {
		
		representation.setIdentifier(id);
		locacaoService.update(LocacaoRepresentation.build(representation));
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<LocacaoRepresentation> delete(@PathVariable("id") Long id) {
		
		Locacao locacao = locacaoService.findById(id);
		LocacaoRepresentation representation = new LocacaoRepresentation(locacao);
		locacaoService.delete(locacao);
		
		return ResponseEntity.ok(representation);
		
	}
	
	/*
	 * Multas -> Locação
	 */
	
	@RequestMapping(value = "/{id}/multas", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<MultaRepresentation>> findMultasByIdLocacao(@PathVariable("id") Long id) {
				
		/*Locacao locacao = locacaoService.findById(id);
		List<Multa> multas = locacao.getMultas();
		List<MultaRepresentation> representations = new ArrayList<>();
		multas.forEach(multa -> {
			representations.add(new MultaRepresentation(multa));
		});*/
		
		List<Multa> multas = locacaoService.findMultas(id);
		List<MultaRepresentation> representations = new ArrayList<>();
		multas.forEach(multa -> representations.add(new MultaRepresentation(multa)));
		
		return ResponseEntity.ok(representations);
	}
	
	/*
	 * Avarias -> Locação
	 */
	
	@RequestMapping(value = "/{id}/avarias", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<AvariaRepresentation>> findAvariasByIdLocacao(@PathVariable("id") Long id) {
		
		List<Avaria> avarias = locacaoService.findAvarias(id);
		List<AvariaRepresentation> representations = new ArrayList<>();
		avarias.forEach(avaria -> {
			representations.add(new AvariaRepresentation(avaria));
		});
		
		return ResponseEntity.ok(representations);
	}
	
	/*
	 * Locação -> Mês
	 */
	
	@RequestMapping(value = "/mes/{mes}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> findLocacoesByIdVeiculo(@PathVariable("mes") Long mes) {
				
		List<Locacao> locacoes = locacaoService.findByMes(mes);
		List<LocacaoRepresentation> representations = new ArrayList<>();
		locacoes.forEach(locacao -> {
			representations.add(new LocacaoRepresentation(locacao));
		});
		
		return ResponseEntity.ok(representations);
	}
	
	/*
	 * Cliente -> Locação
	 */
	
	@RequestMapping(value = "/mes/{mes}/cliente", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ClienteRepresentation> findClienteByMes(@PathVariable("mes") Long mes) {
				
		Cliente cliente = locacaoService.findClienteByMes(mes);
		
		ClienteRepresentation representation = new ClienteRepresentation(cliente);
		
		return ResponseEntity.ok(representation);
	}
	
	@RequestMapping(value = "/{id}/multas/{id2}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> updateLoc(@RequestBody LocacaoRepresentation representation, @PathVariable("id") Long id, @PathVariable("id2") Long id2) {
		
		representation.setIdentifier(id);
		Locacao locacao = locacaoService.findById(id);
		MultaService multaService = new MultaService();
		Multa multa = multaService.findById(id2);
		
		locacao.getMultas().add(multa);
		
		locacaoService.update(LocacaoRepresentation.build(representation));
		
		return ResponseEntity.noContent().build();
		
	}
}
