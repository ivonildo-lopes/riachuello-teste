package com.riachuello.teste.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.riachuello.teste.DTO.request.ProdutoCadastroRequestDTO;
import com.riachuello.teste.DTO.response.ProdutosPorLojaResponse;
import com.riachuello.teste.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riachuello.teste.entity.Produto;
import com.riachuello.teste.dao.ProdutoDao;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;

	@Autowired
	private ProdutoRepository repository;
	
	public Produto cadastrar(ProdutoCadastroRequestDTO produtoRequest) {

		List<Produto> produtos = produtoDao.findBySku(produtoRequest.getSku(),produtoRequest.getLocalidade());

		if (produtos.size() > 0) {
			// regra
			return null;
		}

		return produtoDao.save(convertProduto(produtoRequest));
	}
	private Produto convertProduto(ProdutoCadastroRequestDTO produtoRequest){
		Produto produto = new Produto();
		BeanUtils.copyProperties(produtoRequest, produto);
		produto.setLocalidades(produto.addLocalida(produtoRequest.getLocalidade()));
		return produto;
	}

	public List<ProdutosPorLojaResponse> findByProdutoByLoja(String codigoLoja) {
		return repository.findByProdutoByLoja(codigoLoja);
	}

	public List<ProdutosPorLojaResponse> findByProdutoPrecoByLoja() {
		return repository.findByProdutoPrecoByLoja();
	}

	public List<ProdutosPorLojaResponse> findByProdutoEstoqueByLoja(String sku) {
		return repository.findByProdutoEstoqueByLoja(sku);
	}

}
