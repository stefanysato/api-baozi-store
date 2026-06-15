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
import br.com.baozistore.vendas.model.Produto;
import br.com.baozistore.vendas.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping
	public Produto criar(@RequestBody Produto produto) {
		return service.salvar(produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultarPorId(@PathVariable Long id) {
		Produto produto = service.consultarPorId(id);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping
	public List<Produto> listarTodos() {
		return service.listarProdutos();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return ResponseEntity.ok(service.atualizar(id, produto));
	}
	
}
