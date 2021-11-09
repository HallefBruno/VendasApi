package com.vendas.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Embeddable
@Data
@ToString
public class Endereco implements Serializable {
    
    @Column(nullable = false, length = 30)
    @NotEmpty(message = "{campo.logradouro.obrigatorio}")
    private String logradouro;
    
    @Column(nullable = false)
    @NotEmpty(message = "{campo.numero.obrigatorio}")
    private Integer numero;
    
    @Column(nullable = false, length = 30)
    @NotEmpty(message = "{campo.bairro.obrigatorio}")
    private String bairro;
    
    @Column(nullable = false, length = 30)
    @NotEmpty(message = "{campo.cep.obrigatorio}")
    private String cep;
    
    @Column(nullable = false, length = 30)
    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;
    
    @Column(nullable = false, length = 30)
    @NotEmpty(message = "{campo.estado.obrigatorio}")
    private String estado;
    
    @PrePersist
    @PreUpdate
    private void prePersistPreUpdate() {
        this.logradouro = StringUtils.strip(this.logradouro);
        this.bairro = StringUtils.strip(this.bairro);
        this.cep = StringUtils.strip(this.cep);
        this.cidade = StringUtils.strip(this.cidade);
        this.estado = StringUtils.strip(this.estado);
    }
}
