package com.vendas.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vendas.api.model.Categoria;
import org.modelmapper.ModelMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel("CategoriaDTO")
@JsonPropertyOrder({"id","nome"})
public class CategoriaDTO {

    @ApiModelProperty("Id")
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty("Nome")
    @JsonProperty("nome")
    private String nome;

    public static CategoriaDTO create(Categoria categoria) {
        return new ModelMapper().map(categoria, CategoriaDTO.class);
    }
}