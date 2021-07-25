package com.riachuello.teste.repository;

import com.riachuello.teste.DTO.response.ProdutosPorLojaResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProdutoRepository {

    private final transient SqlSession sqlSession;

    @Autowired
    public ProdutoRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<ProdutosPorLojaResponse> findByProdutoByLoja(String codigoLoja){
        return this.sqlSession.selectList("ProdutoRepository.findByProdutoByLoja",codigoLoja);
    }

    public List<ProdutosPorLojaResponse> findByProdutoPrecoByLoja(){
        return this.sqlSession.selectList("ProdutoRepository.findByProdutoPrecoByLoja");
    }

    public List<ProdutosPorLojaResponse> findByProdutoEstoqueByLoja(String sku){
        Map<String,Object> filter = new HashMap<>();
        filter.put("sku",sku);
        return this.sqlSession.selectList("ProdutoRepository.findByProdutoEstoqueByLoja",filter);
    }
}
