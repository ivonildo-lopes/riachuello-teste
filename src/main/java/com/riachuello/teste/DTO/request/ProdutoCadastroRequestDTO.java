package com.riachuello.teste.DTO.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoCadastroRequestDTO {

	private Long codigo;
	private String sku;
	private String titulo;
	private String descricao;
	private String dimensao;
	private Integer estoque;
	private BigDecimal preco;

	private String localidade;

}
