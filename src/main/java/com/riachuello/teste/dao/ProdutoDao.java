package com.riachuello.teste.dao;

import com.riachuello.teste.DTO.response.ProdutosPorLojaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riachuello.teste.entity.Produto;

import java.util.List;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Long> {

        @Query(value = "select p.* from produtos p inner join lojas l on p.codigo = l.codigo_produto " +
                " where p.sku = ?1 and l.codigo_localidade in (?2)", nativeQuery = true)
        List<Produto> findBySku(String sku, String codigoLocalidade);
}
