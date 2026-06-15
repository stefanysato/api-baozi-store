package br.com.baozistore.vendas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.baozistore.vendas.model.Pedido;
import br.com.baozistore.vendas.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;

public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido salvar(Pedido pedido) {
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
		
		updated.setClienteId(pedido.getClienteId());
		updated.setProdutoId(pedido.getProdutoId());
		updated.setQuantidade(pedido.getQuantidade());
		
		return repository.save(updated);
	}

}
