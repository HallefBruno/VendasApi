package com.vendas.api.repository;

import java.util.List;
import java.util.Optional;
import com.vendas.api.model.Produto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    List<Produto> findByCategoriaId(Long idCategoria);

    @EntityGraph(type = EntityGraphType.FETCH,attributePaths = {"categoria"})
    Optional<Produto> findByIdAndCategoriaId(Long produtoId, Long categoriaId);
}
