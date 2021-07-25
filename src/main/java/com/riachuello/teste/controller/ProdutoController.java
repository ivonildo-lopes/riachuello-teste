package com.riachuello.teste.controller;

import java.io.Serializable;
import java.util.List;

import com.riachuello.teste.DTO.request.ProdutoCadastroRequestDTO;
import com.riachuello.teste.DTO.response.ProdutosPorLojaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.riachuello.teste.entity.Produto;
import com.riachuello.teste.service.ProdutoService;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController implements Serializable {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping(path = "/save")
	public Produto cadastrar(@RequestBody ProdutoCadastroRequestDTO produtoRequest) {
		return produtoService.cadastrar(produtoRequest);
	}
	
	@GetMapping(path = "/findByLoja/{codigoLoja}")
	public List<ProdutosPorLojaResponse> findByLoja(@PathVariable String codigoLoja) {
		return produtoService.findByProdutoByLoja(codigoLoja);
	}

	@GetMapping(path = "/findPrecoByLoja")
	public List<ProdutosPorLojaResponse> findPrecoByLoja() {
		return produtoService.findByProdutoPrecoByLoja();
	}

	@GetMapping(path = "/findEstoqueByLoja/{sku}")
	public List<ProdutosPorLojaResponse> findEstoqueByLoja(@PathVariable String sku) {
		return produtoService.findByProdutoEstoqueByLoja(sku);
	}
}
