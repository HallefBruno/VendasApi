package com.vendas.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(nullable = false, unique = true, length = 200)
    private String descricao;
    
    @Min(value = 1, message = "{campo.quantidade.min}")
    @NotNull(message = "{campo.quantidade.obrigatorio}")
    private Integer quantidade;
    
    @Min(value = 1, message = "{campo.precoCusto.min}")
    @NotNull(message = "{campo.precoCusto.obrigatorio}")
    @Column(name = "preco_custo", nullable = false)
    private BigDecimal precoCusto;
    
    @Min(value = 1, message = "{campo.precoVenda.min}")
    @NotNull(message = "{campo.precoVenda.obrigatorio}")
    @Column(name = "preco_venda", nullable = false)
    private BigDecimal precoVenda;
    
    @Column(length = 200)
    private String observacao;
    
    @NotNull(message = "{campo.categoria.obrigatoria}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false, referencedColumnName = "id")
    private Categoria categoria;
}
