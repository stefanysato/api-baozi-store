
# API Baozi Store
Projeto desenvolvido como atividade prática da disciplina de Desenvolvimento Web Back End, com o objetivo de aplicar conceitos de:
-   APIs REST
-   Spring Boot
-   Spring Data JPA
-   Persistência de dados
-   Relacionamentos entre entidades
-   Arquitetura MVC
-   Operações CRUD

Análise e Desenvolvimento de Sistemas - Centro Universitário Internacional UNINTER

## Sobre
API Rest desenvolvida para o gerenciamento de clientes, produtos e pedidos da Baozi Store, uma pequena loja especializada na venda de pão chinês (Baozi).

Cada pedido registra:
- O cliente que realizou a compra;
- O produto adquirido;
- A quantidade solicitada.

O sistema foi implementado utilizando a arquitetura MVC (Model-View-Controller).

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- MySQL
- Postman (testes)

## Estrutura do projeto

```
src/main/java/br/com/baozistore/vendas  
│  
├── controller  
│   ├── ClienteController  
│   ├── ProdutoController  
│   └── PedidoController  
|  
├── model  
│   ├── Cliente  
│   ├── Produto  
│   └── Pedido  
│  
├── repository  
│   ├── ClienteRepository  
│   ├── ProdutoRepository  
│   └── PedidoRepository  
|  
├── service  
│   ├── ClienteService  
│   ├── ProdutoService  
│   └── PedidoService  
│  
└── VendasApplication  
```

## Modelo de dados

### Cliente

- id (Long)
- nome (String)
- clienteDesde (LocalDate)

### Produto

- id (Long)
- nome (String)
- preco (BigDecimal)
- estoque (Boolean)

### Pedido
- id (Long)
- cliente (Cliente)
- produto (Produto)
- quantidade (Integer)

## Relacionamentos

### Cliente -> Pedido
Um cliente pode possuir vários pedidos.

@ManyToOne  
@JoinColumn(name = "cliente_id")  
private Cliente cliente;

### Produto -> Pedido
Um produto pode estar presente em vários pedidos.

@ManyToOne  
@JoinColumn(name = "produto_id")  
private Produto produto;

## Endpoints
### Clientes
|Método HTTP|Endpoint|Descrição|
|--|--|--|
|GET|/clientes|Lista todos os clientes cadastrados|
|POST|/clientes|Cadastra novo cliente|
|PUT|/clientes/{id}|Atualiza os dados de um cliente existente|
|DELETE|/clientes/{id}|Exclui um cliente do sistema|

### Produtos
|Método HTTP|Endpoint|Descrição|
|--|--|--|
|GET|/produtos|Lista todos os produtos cadastrados|
|POST|/produtos|Cadastra novo produto|
|PUT|/produtos/{id}|Atualiza um produto existente|
|DELETE|/produtos/{id}|Exclui um produto do sistema|

### Clientes
|Método HTTP|Endpoint|Descrição|
|--|--|--|
|GET|/pedidos|Lista todos os pedidos registrados|
|POST|/pedidos|Registra novo pedido|
|PUT|/pedidos/{id}|Atualiza um pedido existente|
|DELETE|/pedidos/{id}|Exclui um pedido do sistema|

## Exemplos de Requisição (JSON)

### Cadastro de Cliente
```
{
  "nome": "Stefany",
  "clienteDesde": "15-06-2026"
}
```

### Cadastro de Produto
```
{
  "nome": "Baozi",
  "preco": 5.50,
  "estoque": true
}
```

### Registro de Pedido
```
{
  "cliente": {
    "id": 1
  },
  "produto": {
    "id": 1
  },
  "quantidade": 5
}
```

## Executando o projeto

### 1. Clonar o repositório

```
git clone https://github.com/stefanysato/api-baozi-store.git
```

### 2. Acessar o diretório

```
cd api-baozi-store
```

### 3. Configurar o banco de dados

Crie o banco de dados MySQL  
```
CREATE DATABASE baozi_store;
```

Exemplo de configuração do arquivo `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/baozi_store
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Executar a aplicação

```
mvn spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```
