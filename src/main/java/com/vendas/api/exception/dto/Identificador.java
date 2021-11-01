package com.vendas.api.exception.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Identificador {
    
    @Min(value = 1, message = "{objeto.identificador.campo.id.min}")
    @NotNull(message = "{objeto.identificador.campo.id.obrigatorio}")
    private Long id;
}
