# Teste Java


## Sobre

  O teste consiste em construir a camada de serviço de um pseudo ecommerce de games mobile utilizando Java.

  Essa versão disponibiliza os seguintes recursos: ```Product```:  aonde será disponibilizado todos os produtos cadastros, ```Client```: são os usuários que serão os clientes do ecommerce , ```ItemCart```: previsualização das compras do usuario, subtotal do carrinho e o mesmo poderá remover ou adicionar um novo produto e ```Cart```: que ficará o recurso do checkout (finalizar) das compras do cliente.


## Tecnologias Utilizadas 

  O projeto foi  desenvolvido utilizando as seguintes tecnologias.

- [Spring Boot](https://spring.io/)
- [Apache Tomcat](http://tomcat.apache.org/)
- [Maven](https://maven.apache.org/)
- [Insomnia](https://insomnia.rest/download)
- [H2](https://www.h2database.com/html/main.html)

  A escolha do springboot foi definida a praticidade e velocidade nas configurações do projeto pois já vem integrado com o servidor web apache tomcat e o gerenciador maven. Foi escolhido o SGBD H2 por causa de sua velocidade e pouco espaço em armazenamento, porém ele é um banco em memória, ou seja, os dados não são persistido no banco. E o Insomnia pois já acredito que seja mais leve e rápido na requisição.

## Requisições Json

<h4>Product</h4>
<h5>GET</h5>

```
localhost:8080/Products
localhost:8080/ProductsByScore
localhost:8080/Product/3
localhost:8080/ProductsByName
```
<h5>POST</h5>

```
localhost:8080/Product/
```
<h5>PUT</h5>

```
localhost:8080/Product/1
```

<h5>DELETE</h5>

```
localhost:8080/Product/1
```



<h4>Client</h4>
<h5>GET</h5>

```
localhost:8080/Clients/
```
<h5>POST</h5>

```
localhost:8080/Client/
```



<h4>ItemCart  </h4>
<h5>GET</h5>

```
localhost:8080/CartItem/
```
<h5>POST</h5>

```
localhost:8080/CartItem/
```
<h5>DELETE</h5>

```
localhost:8080/CartItem/7
```


<h4>Cart </h4>
<h5>GET</h5>

```
localhost:8080/Carts/
localhost:8080/Cart/1
```
<h5>POST</h5>

```
localhost:8080/Cart/
```




## Estrutura das Entidades

Conceitualmente o projeto é formado pelas entidades Client, Product, ItemCart e Cart sendo estruturadas como exemplos abaixo:


### Client

```json
{
    "id": long,
    "name": String,
    "cpf": String
   
}

```

### Product

```json
{
    "id": long,
    "name": String,
    "price": BigDecimal,
    "score": short,
    "Image": String
   
}
```

### ItemCart

```json
{
    "id": long,
    "id_client": Long,
    "id_product": Long,
    "qtdProduct": Integer
   
}
```

### Cart

```json
{
    "id": long,
    "id_client": Long,
    "id_product": Long,
    "total": Integer,
    "freight": Integer,

}
```
 

##  Como baixar o projeto
```bash
# Clonar o repositório
$ git clone git@github.com:yurihallan/ps-java-ecommerce.git
# Entrar no diretório
$ cd ps-java-ecommerce
# Importar projeto através do VSCODE (ou IDE de sua preferência)
# Se precisar importar as dependências antes de executar o projeto, rode
$ mvn clean install
# Iniciar o projeto execute 
$ mvn spring-boot:run
# Podendo rodar a aplicação com a extensão do Extension Pack for Java v0.18.5 no VSCODE, outras IDE tem um botão para executar a aplicação java.
```