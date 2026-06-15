package br.com.baozistore.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.baozistore.vendas.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
