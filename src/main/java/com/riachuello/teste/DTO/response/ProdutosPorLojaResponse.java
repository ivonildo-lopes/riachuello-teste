package com.riachuello.teste.DTO.response;

import lombok.Data;

import java.util.List;


@Data
public class ProdutosPorLojaResponse {

    private String codigoLoja;
    private List<ProdutoDTO> produtos;

}
