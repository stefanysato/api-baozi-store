package br.com.baozistore.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.baozistore.vendas.model.Produto;
import br.com.baozistore.vendas.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto consultarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));
	}
	
	public List<Produto> listarProdutos() {
		return repository.findAll();
	}
	
	public void apagar(Long id) {
		Produto produto = consultarPorId(id);
		repository.delete(produto);
	}
	
	public Produto atualizar(Long id, Produto produto) {
		Produto updated = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		updated.setNome(produto.getNome());
		updated.setPreco(produto.getPreco());
		updated.setEstoque(produto.getEstoque());
		
		return repository.save(updated);
	}
	
}
