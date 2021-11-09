package com.vendas.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.vendas.api.model.dto.CategoriaDTO;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

@Entity
@Data
@ToString
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(nullable = false, unique = true, length = 100)
    @Size(max = 100, message = "{campo.nome.length}")
    private String nome;
    
    @PrePersist
    @PreUpdate
    private void prePersistPreupdate() {
        this.nome = StringUtils.strip(this.nome);
    }

    public static Categoria create(CategoriaDTO categoriaDTO) {
        return new ModelMapper().map(categoriaDTO, Categoria.class);
    }
    
}
