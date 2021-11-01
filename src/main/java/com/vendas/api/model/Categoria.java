package com.vendas.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Entity
@Data
@ToString
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "{campo.id.obrigatorio}")
    @Column(updatable = false)
    private Long id;
    
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(nullable = false, unique = true, length = 200)
    private String nome;
    
    private void prePersistPreupdate() {
        this.nome = StringUtils.strip(this.nome);
    }
    
}
