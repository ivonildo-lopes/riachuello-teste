##Teste Riachuello

###Tecnologias:

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

###Acesso ao Banco de Dados

para acessa-lo basta apenas acessar a seguinte URL: http://localhost:8080/h2-console

###Acesso ao Swagger
URL: http://localhost:8080/swagger-ui.html

###___________________________________________________________________


##Cadastro de Produto

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

##consulta todos os produtos com estoque de uma loja

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


##consulta todos os produtos que tem preço vigente por loja

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

## listar todos os estoques do produto, saber em qual loja aquele produto está disponível

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




