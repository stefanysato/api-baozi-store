package br.com.baozistore.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.baozistore.vendas.model.Cliente;
import br.com.baozistore.vendas.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public Cliente criar(@RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> consultarPorId(@PathVariable Long id) {
		Cliente cliente = service.consultarPorId(id);
		
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping
	public List<Cliente> listarTodos() {
		return service.listarClientes();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(service.atualizar(id, cliente));
	}
}
