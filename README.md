# API Ecommerce

API desenvolvida durante o treinamento **If Black, then Code (IBM & Gama Academy)**, durante as aulas sobre Spring Boot do Prof. Isidro Massetto. A publicação da documentação com *Postman* pode ser visualizada **<a href="https://documenter.getpostman.com/view/21287524/VUr1GXw9">aqui<a/>**.

## Endpoints

## `GET` `/departamentos`
Rota utilizada para listar todos os departamentos cadastrados no sistema.

  
  #### **Exemplo de requisição**
  ```curl
  curl --location --request GET 'localhost:8080/departamentos'
  ```
  
  #### **Exemplo de resposta**
  ```json
  [
    {
        "codigo": 1,
        "nome": "Informática",
        "descricao": "Acessorios, utilitários e eletrônicos"
    },
    {
        "codigo": 2,
        "nome": "Vestuário",
        "descricao": "Moda feminina, masculina e infantil"
    }
]
  ```


## `POST` `/departamentos`
Rota utilizada para cadastrar novos departamentos no sistema.

- **Requisição**
  - nome
  - descricao

#### Exemplo de requisição
```
curl --location --request POST 'localhost:8080/departamentos' \
--data-raw '{
        "nome": "Vestuário",
        "descricao": "Moda feminina, masculina e infantil"
    }'
```

#### Exemplo de resposta
`HTTP Status 200`
```json
{
    "codigo": 2,
    "nome": "Vestuário",
    "descricao": "Moda feminina, masculina e infantil"
}
```


## `PUT` `/departamentos`
Rota utilizada para atualizar registros de departamentos já existentes no sistema.

- **Requisição**
  - id
  - nome
  - descricao
  
#### Exemplo de requisição
```curl
curl --location --request PUT 'localhost:8080/departamentos' \
--data-raw '{
    "codigo": 1,
    "nome": "Informática",
    "descricao": "Acessorios, utilitários e eletrônicos"
}'
```

#### Exemplo de resposta
`HTTP Status 200`
```json 
{
    "codigo": 1,
    "nome": "Informática",
    "descricao": "Utilitários, acessórios e eletrônicos"
}
```

## `DELETE` `/departamentos/{id}`
Rota utilizada para excluir registros de departamentos.

#### Exemplo de requisição
```curl
curl --location --request DELETE 'localhost:8080/departamentos/3'
```


## `GET` `/departamentos/{id}`
Rota para buscar departamento por ID.

#### Exemplo de requisição
```curl
curl --location --request GET 'localhost:8080/departamentos/3'
```

#### Exemplo de resposta 
`HTTP Status 200`
```json
{
    "codigo": 2,
    "nome": "Vestuário",
    "descricao": "Moda feminina, masculina e infantil"
}
```

## `GET` `/produtos`
Rota para listar todos os produtos registrados no sistema.

#### Exemplo de requisição
```curl
curl --location --request GET 'localhost:8080/produtos'
```

#### Exemplo de resposta
`HTTP Status 200`
```json
[
    {
        "codigo": 1,
        "nome": "Computaodr i9 32Gb Ram 1TbHD, Placa GTX1090",
        "descricao": "Computador Ultima Geração",
        "preco": 4000,
        "estoque": 3,
        "linkFoto": "computador.jpg",
        "departamento": {
            "codigo": 1,
            "nome": "Informática",
            "descricao": "Utilitários, acessórios e eletrônicos"
        }
    },
    {
        "codigo": 2,
        "nome": "Notebook i7 16 Gb Ram 500Gb HD SSD",
        "descricao": "Notebook Ultima Geração",
        "preco": 3850,
        "estoque": 5,
        "linkFoto": "notebook.jpg",
        "departamento": {
            "codigo": 1,
            "nome": "Informática",
            "descricao": "Utilitários, acessórios e eletrônicos"
        }
    }
]
```

## `POST` `/produtos`
Rota para salvar novo produto no sistema.

- **Requisição**
  - nome
  - descricao
  - preco
  - estoque
  - linkFoto
  - departamento
  
#### Exemplo de requisição
```curl
curl --location --request POST 'localhost:8080/produtos' \
--data-raw '{ 
    "nome": "Cabo HDMI",
    "descricao": "Cabo para monitores, TVs e computadores",
    "preco": 50.0,
    "estoque": 10,
    "linkFoto": "caboHDMI.png",
    "departamento": {
        "codigo": 1
    }
}'
```

#### Exemplo de resposta
`HTTP Status 200`
```json
{
    "codigo": 8,
    "nome": "Cabo HDMI",
    "descricao": "Cabo para monitores, TVs e computadores",
    "preco": 50.0,
    "estoque": 10,
    "linkFoto": "caboHDMI.png",
    "departamento": {
        "codigo": 1,
        "nome": null,
        "descricao": null
    }
}
```

## `GET` `/produtos/{id}`
Rota para buscar produto por id.

#### Exemplo de requisição
```curl
curl --location --request GET 'localhost:8080/produtos/3'
```

#### Exemplo de resposta
`HTTP Status 200`
```json
{
    "codigo": 3,
    "nome": "Cabo HDMI",
    "descricao": "Cabo para monitores, TVs e computadores",
    "preco": 50.0,
    "estoque": 10,
    "linkFoto": "caboHDMI.png",
    "departamento": {
        "codigo": 1,
        "nome": null,
        "descricao": null
    }
}
```

## `POST` `/pedidos`
Rota para registrar novo pedido no sistema.

- **Requisição**
   - nome
   - descricao
   - preco
   - estoque
   - linkFoto
   - departamento

#### Exemplo de requisição
```curl
curl --location --request POST 'localhost:8080/pedidos' \
--data-raw '{
    "cliente": {
        "id": 3
    },
    "valorBruto": 2400.00,
    "desconto": 100.0,
    "valorFinal": 2300.0,
    "data" : "2022-08-16",
    "status": "N",
    "itens": [
        {
            "produto": {
                "codigo": 6
            },
            "valorUnitario": 1200.0,
            "quantidade": 2,
            "valorTotal": 2400
        }
    ]
}'
```

#### Exemplo de resposta
`HTTP Status 200`
```json
{
    "numero": 19,
    "data": "2022-08-16",
    "valorBruto": 2400.0,
    "desconto": 100.0,
    "valorFinal": 2300.0,
    "status": "N",
    "cliente": {
        "id": 3,
        "nome": null,
        "email": null,
        "senha": null,
        "registroGeral": null,
        "cpf": null
    },
    "itens": [
        {
            "numSeq": 19,
            "quantidade": 2,
            "valorUnitario": 1200.0,
            "valorTotal": 2400.0,
            "produto": {
                "codigo": 6,
                "nome": null,
                "descricao": null,
                "preco": null,
                "estoque": null,
                "linkFoto": null,
                "departamento": null
            }
        }
    ]
}
```

## `GET` `/pedidos/{id}`
Rota para buscar pedido por ID.

#### Exemplo de requisição
```curl
curl --location --request GET 'localhost:8080/pedidos/3'
```

#### Exemplo de resposta
```json
{
    "numero": 3,
    "data": "2021-03-10",
    "valorBruto": 3850.0,
    "desconto": 0.0,
    "valorFinal": 3850.0,
    "status": "F",
    "cliente": {
        "id": 3,
        "nome": "Regina Brito",
        "email": "reginabrito@mail.com",
        "senha": "010203",
        "registroGeral": "83.235.645-90",
        "cpf": "123.456.789-00"
    },
    "itens": [
        {
            "numSeq": 3,
            "quantidade": 1,
            "valorUnitario": 3850.0,
            "valorTotal": 3850.0,
            "produto": {
                "codigo": 2,
                "nome": "Notebook i7 16 Gb Ram 500Gb HD SSD",
                "descricao": "Notebook Ultima Geração",
                "preco": 3850.0,
                "estoque": 5,
                "linkFoto": "notebook.jpg",
                "departamento": {
                    "codigo": 1,
                    "nome": "Informática",
                    "descricao": "Utilitários, acessórios e eletrônicos"
                }
            }
        }
    ]
}
```

## `GET` `/pedidos`
Rota para listar todos os pedidos existentes no banco de dados da aplicação.

#### Exemplo de requisição
```curl
curl --location --request GET 'localhost:8080/pedidos'
```

#### Exemplo de resposta
```json
[
    {
        "numero": 1,
        "data": "2021-01-10",
        "valorBruto": 4000.0,
        "desconto": 0.0,
        "valorFinal": 4000.0,
        "status": "F",
        "cliente": {
            "id": 1,
            "nome": "Jose Alberto Neves",
            "email": "josealberto@mail.com",
            "senha": "123456",
            "registroGeral": "98.876.123-99",
            "cpf": "987.654.321-00"
        },
        "itens": [
            {
                "numSeq": 1,
                "quantidade": 1,
                "valorUnitario": 4000.0,
                "valorTotal": 4000.0,
                "produto": {
                    "codigo": 1,
                    "nome": "Computaodr i9 32Gb Ram 1TbHD, Placa GTX1090",
                    "descricao": "Computador Ultima Geração",
                    "preco": 4000.0,
                    "estoque": 3,
                    "linkFoto": "computador.jpg",
                    "departamento": {
                        "codigo": 1,
                        "nome": "Informática",
                        "descricao": "Utilitários, acessórios e eletrônicos"
                    }
                }
            }
        ]
    },
    {
        "numero": 2,
        "data": "2021-02-01",
        "valorBruto": 70.0,
        "desconto": 0.0,
        "valorFinal": 70.0,
        "status": "F",
        "cliente": {
            "id": 2,
            "nome": "Antonio Oliveira",
            "email": "antoniooli@mail.com",
            "senha": "987654",
            "registroGeral": "12.983.256-72",
            "cpf": "765.432.987.10"
        },
        "itens": [
            {
                "numSeq": 2,
                "quantidade": 2,
                "valorUnitario": 35.0,
                "valorTotal": 70.0,
                "produto": {
                    "codigo": 4,
                    "nome": "Conector USB para recarga em tomada 3A",
                    "descricao": "Conector USB",
                    "preco": 35.0,
                    "estoque": 15,
                    "linkFoto": "conector.jpg",
                    "departamento": {
                        "codigo": 1,
                        "nome": "Informática",
                        "descricao": "Utilitários, acessórios e eletrônicos"
                    }
                }
            }
        ]
    }
 ]
```

## Tecnologias e ferramentas utilizadas

* Java
* Maven
* JPA/Hibernate
* Spring framework (Spring Boot, Spring Data JPA)
* MySQL
* Postman
* Eclipse


## Authors

* **Cristhiane da Cruz** - [barroscruzc](https://github.com/barroscruzc)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
