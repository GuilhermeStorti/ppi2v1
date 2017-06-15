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

import com.ppi2.locacaoVeiculos.Service.ClienteService;
import com.ppi2.locacaoVeiculos.domain.Cliente;
import com.ppi2.locacaoVeiculos.representation.ClienteRepresentation;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<ClienteRepresentation>> listAll() {
		
		List<Cliente> clientes = clienteService.findAll();
		List<ClienteRepresentation> representations = new ArrayList<>();
		
		clientes.forEach(cliente -> {
			representations.add(new ClienteRepresentation(cliente));
		});
		
		return ResponseEntity.ok(representations);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ClienteRepresentation> findById(@PathVariable("id") Long id) {
				
		Cliente cliente = clienteService.findById(id);
		ClienteRepresentation representation = new ClienteRepresentation(cliente);
		
		return ResponseEntity.ok(representation);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody ClienteRepresentation representation) {
		
		Cliente cliente = clienteService.save(ClienteRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody ClienteRepresentation representation, @PathVariable("id") Long id) {
		
		representation.setIdentifier(id);
		clienteService.update(ClienteRepresentation.build(representation));
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<ClienteRepresentation> delete(@PathVariable("id") Long id) {
		
		Cliente cliente = clienteService.findById(id);
		ClienteRepresentation representation = new ClienteRepresentation(cliente);
		clienteService.delete(cliente);
		
		return ResponseEntity.ok(representation);
		
	}
	
	/*
	 * Cliente -> CPF
	 */
	
	@RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ClienteRepresentation> findByCpf(@PathVariable("cpf") String cpf) {
				
		Cliente cliente = clienteService.findByCpf(cpf);
		ClienteRepresentation representation = new ClienteRepresentation(cliente);
		
		return ResponseEntity.ok(representation);
	}
}
