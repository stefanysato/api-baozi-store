package br.com.baozistore.vendas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baozistore.vendas.model.Cliente;
import br.com.baozistore.vendas.model.Pedido;
import br.com.baozistore.vendas.model.Produto;
import br.com.baozistore.vendas.repository.ClienteRepository;
import br.com.baozistore.vendas.repository.PedidoRepository;
import br.com.baozistore.vendas.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Pedido salvar(Pedido pedido) {
		
		Cliente cliente = clienteRepository
				.findById(pedido.getCliente().getId())
				.orElseThrow();
		
		Produto produto = produtoRepository
				.findById(pedido.getProduto().getId())
				.orElseThrow();
		
		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		
		return repository.save(pedido);
	}
	
	public Pedido consultarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado."));
	}
	
	public List<Pedido> listarPedidos() {
		return repository.findAll();
	}
	
	public void apagar(Long id) {
		Pedido pedido = consultarPorId(id);
		repository.delete(pedido);
	}
	
	public Pedido atualizar(Long id, Pedido pedido) {
		Pedido updated = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		updated.setCliente(pedido.getCliente());
		updated.setProduto(pedido.getProduto());
		updated.setQuantidade(pedido.getQuantidade());
		
		return repository.save(updated);
	}

}
