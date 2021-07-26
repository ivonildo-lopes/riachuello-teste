package com.riachuello.teste.controller;


import com.riachuello.teste.DTO.response.ProdutoDTO;
import com.riachuello.teste.DTO.response.ProdutosPorLojaResponse;
import com.riachuello.teste.service.LocalidadeService;
import com.riachuello.teste.service.ProdutoService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@WebMvcTest
class ProdutoControllerTest {

    @Autowired
    private ProdutoController controller;

    @MockBean
    private ProdutoService service;

    @MockBean
    private LocalidadeService localidadeService;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(controller);
    }

    @Test
    public void deveRetornarSucesso_quandoBuscarProdutoPrecoPoLoja(){

        Mockito.when(service.findByProdutoPrecoByLoja())
                .thenReturn(getProdutosPorLojaResponses());

        RestAssuredMockMvc
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/produtos/findPrecoByLoja")
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornarSucesso_quandoBuscarProdutoPorLoja(){

        Mockito.when(this.service.findByProdutoEstoqueByLoja("TVSM0001"))
                .thenReturn(getProdutosPorLojaResponses());

        RestAssuredMockMvc
                .given()
                    .accept(ContentType.JSON)
                .when()
                .   get("/produtos/findEstoqueByLoja/{sku}","TVSM0001")
                .then()
                    .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornarNaoEncontrado_quandoBuscarProdutoPorLoja(){
        List<ProdutosPorLojaResponse> lista = new ArrayList<>();
        Mockito.when(this.service.findByProdutoEstoqueByLoja("TVSM0009"))
                .thenReturn(lista);

        RestAssuredMockMvc
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/produtos/findEstoqueByLoja/{sku}","TVSM0009")
                .then()
                    .statusCode(HttpStatus.NOT_FOUND.value());

    }

    private List<ProdutosPorLojaResponse> getProdutosPorLojaResponses() {
        List<ProdutosPorLojaResponse> lista = new ArrayList<>();

        ProdutosPorLojaResponse prod = new ProdutosPorLojaResponse();
        prod.setCodigoLoja("L100");

        List<ProdutoDTO> produtosLoja = new ArrayList<>();
        ProdutoDTO produtodto = new ProdutoDTO();
        produtodto.setCodigo(1l);
        produtodto.setSku("TVSM0001");
        produtodto.setTitulo("Tv samsung");
        produtodto.setDescricao("tv samsung 7707");
        produtodto.setDimensao("50 polegadas");
        produtodto.setEstoque(10);
        produtodto.setPreco(new BigDecimal(3099.99));
        produtosLoja.add(produtodto);

        prod.setProdutos(produtosLoja);

        lista.add(prod);
        return lista;
    }


}