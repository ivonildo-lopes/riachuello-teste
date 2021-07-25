package com.riachuello.teste.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long codigo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sku;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String titulo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dimensao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer estoque;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal preco;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigoLocalidade;
}
