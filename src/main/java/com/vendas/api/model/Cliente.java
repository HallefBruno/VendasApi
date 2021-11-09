package com.vendas.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 25, nullable = false)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    
    @Column(length = 20, nullable = false)
    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    private String telefone;
    
    @Column(nullable = false)
    private Boolean ativo;
    
    @Embedded
    private Endereco endereco;
    
    @PrePersist
    @PreUpdate
    private void prePersistPreUpdate() {
        if(this.ativo==null)this.ativo = true;
    }
}
