package br.com.baozistore.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baozistore.vendas.model.Cliente;
import br.com.baozistore.vendas.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente consultarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
	}
	
	public List<Cliente> listarClientes() {
		return repository.findAll();
	}
	
	public void apagar(Long id) {
		Cliente cliente = consultarPorId(id);
		
		repository.delete(cliente);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente updated = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		updated.setNome(cliente.getNome());
		updated.setClienteDesde(cliente.getClienteDesde());
		
		return repository.save(updated);
	}
}
