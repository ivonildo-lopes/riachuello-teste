package com.riachuello.teste.controller;

import java.io.Serializable;
import java.util.List;

import com.riachuello.teste.DTO.request.ProdutoCadastroRequestDTO;
import com.riachuello.teste.DTO.response.ProdutosPorLojaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riachuello.teste.entity.Produto;
import com.riachuello.teste.service.ProdutoService;

@RestController
@RequestMapping(value = "produtos")
@Api("API REST PRODUTOS")
@CrossOrigin(origins = "*")
public class ProdutoController implements Serializable {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping(path = "/save")
	@ApiOperation("Cadastro de produto")
	public Produto cadastrar(@RequestBody ProdutoCadastroRequestDTO produtoRequest) {
		return produtoService.cadastrar(produtoRequest);
	}
	
	@GetMapping(path = "/findByLoja/{codigoLoja}")
	@ApiOperation("consulta todos os produtos com estoque de uma loja.")
	public List<ProdutosPorLojaResponse> findByLoja(@PathVariable String codigoLoja) {
		return produtoService.findByProdutoByLoja(codigoLoja);
	}

	@GetMapping(path = "/findPrecoByLoja")
	@ApiOperation("consulta todos os produtos que tem preço vigente por loja.")
	public List<ProdutosPorLojaResponse> findPrecoByLoja() {
		return produtoService.findByProdutoPrecoByLoja();
	}

	@GetMapping(path = "/findEstoqueByLoja/{sku}")
	@ApiOperation("listar todos os estoques do produto, saber em qual loja aquele produto está disponível.")
	public ResponseEntity<List<ProdutosPorLojaResponse>> findEstoqueByLoja(@PathVariable String sku) {

		List<ProdutosPorLojaResponse> lista = produtoService.findByProdutoEstoqueByLoja(sku);

		if(lista.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(lista);
	}
}
