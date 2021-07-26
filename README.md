<h1> Teste Riachuello </h1>

<h2>Tecnologias:</h2>

<li>Java 11</li>
<li>Spring-boot</li>
<li>Hibernate</li>
<li>Mybatis</li>
<li>H2</li>
<li>Swagger</li>
<li>Lombok</li>

APLICAÇÃO REST usando padrão MVC

[OBS.:]
Para esse case usei o Java 11 e escolhi o banco de dados H2, pela facilidade e a agilidade que ele proporciona (* podendo ser alterado facilmente por outro bando de dados dado que não usei nenhuma particularidade de banco).

<h2>Acesso ao Banco de Dados </h2>

para acessa-lo basta apenas acessar a seguinte URL: http://localhost:8080/h2-console

<h2>Acesso ao Swagger </h2>
URL: http://localhost:8080/swagger-ui.html

<h2>___________________________________________________________________ </h2>


<h2>Cadastro de Produto </h2>

POST - http://localhost:8080/produtos/save

payload:
```
{
    "sku":"TVSM002",
    "titulo":"TV samsung",
    "descricao":"tv samsung rh 6066",
    "dimensao":"42 polegadas",
    "estoque":1,
    "localidade": "L200",
    "preco":3000.0
}
```
o cadastro de produto é feito de forma individual ou seja cada loja deverá realizar o cadastro do produto, passando o código da localidade.
o sku é o código que identifica o produto.

<h2>consulta todos os produtos com estoque de uma loja </h2>

GET - http://localhost:8080/produtos/findByLoja/L200

```
[
    {
        "codigoLoja": "L200",
        "produtos": [
            {
                "codigo": 38,
                "sku": "TVSM001",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 6066",
                "dimensao": "42 polegadas",
                "estoque": 1,
                "preco": 3000
            },
            {
                "codigo": 39,
                "sku": "TVSM002",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 6066",
                "dimensao": "42 polegadas",
                "estoque": 1,
                "preco": 3000
            }
        ]
    }
]
```

Exibe todos os produtos de uma determinada loja


<h2>consulta todos os produtos que tem preço vigente por loja </h2>

GET - http://localhost:8080/produtos/findPrecoByLoja

```
[
    {
        "codigoLoja": "L100",
        "produtos": [
            {
                "codigo": 36,
                "sku": "TVSM002",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 7000",
                "dimensao": "50 polegadas",
                "estoque": 15,
                "preco": 100.1
            }
        ]
    },
    {
        "codigoLoja": "L200",
        "produtos": [
            {
                "codigo": 38,
                "sku": "TVSM001",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 6066",
                "dimensao": "42 polegadas",
                "estoque": 1,
                "preco": 3000
            },
            {
                "codigo": 39,
                "sku": "TVSM002",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 6066",
                "dimensao": "42 polegadas",
                "estoque": 1,
                "preco": 3000
            }
        ]
    },
    {
        "codigoLoja": "L300",
        "produtos": [
            {
                "codigo": 35,
                "sku": "TVSM002",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 7000",
                "dimensao": "50 polegadas",
                "estoque": 25,
                "preco": 6000
            }
        ]
    }
]
```

Exibe todos os produtos com preço maior que ZERO por loja

<h2> listar todos os estoques do produto, saber em qual loja aquele produto está disponível </h2>

GET - http://localhost:8080/produtos/findEstoqueByLoja/TVSM001

```
[
    {
        "codigoLoja": "L200",
        "produtos": [
            {
                "codigo": 38,
                "sku": "TVSM001",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 6066",
                "dimensao": "42 polegadas",
                "estoque": 1,
                "preco": 3000
            }
        ]
    },
    {
        "codigoLoja": "L300",
        "produtos": [
            {
                "codigo": 34,
                "sku": "TVSM001",
                "titulo": "TV samsung",
                "descricao": "tv samsung rh 6066",
                "dimensao": "42 polegadas",
                "estoque": 10
            }
        ]
    }
]
```




