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
import br.com.baozistore.vendas.model.Pedido;
import br.com.baozistore.vendas.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@PostMapping
	public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {		
		return ResponseEntity.ok(service.salvar(pedido));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> consultarPorId(@PathVariable Long id) {
		Pedido pedido = service.consultarPorId(id);
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping
	public List<Pedido> listarTodos() {
		return service.listarPedidos();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
		return ResponseEntity.ok(service.atualizar(id, pedido));
	}
	
}
