# Projeto de Gestão de Produtos

## 1. Introdução

Um cliente requisitou o desenvolvimento de uma aplicação Java focada na gestão eficiente de produtos. O objetivo principal é criar uma solução robusta que permita a criação, listagem e busca de produtos, com a particularidade de que cada produto deve possuir um nome único. Essa especificação visa atender à demanda do cliente por um sistema que garanta a exclusividade e a fácil identificação de produtos em seu inventário.

## 2. Objetivos da Aplicação

- **Criação de Produtos**: Permitir que o usuário adicione novos produtos ao sistema, com cada produto tendo um identificador único, nome, preço em centavos e quantidade em estoque.
- **Preço deve ser positivo**: Ao fazer a criação de um produto, deve validar se o preço enviado é um valor positivo ou não.
- **Listagem de Produtos**: Facilitar a visualização de todos os produtos disponíveis no sistema.
- **Busca de Preço do Produtos por Código de Barras**: Oferecer uma funcionalidade de busca para localizar rapidamente o preço do produto pelo código de barras.

## 3. Estrutura Proposta

A aplicação será estruturada em várias partes, cada uma com sua responsabilidade específica:

1. **Modelo de Produto (`ProductModel`)**: Definirá a estrutura de dados para os produtos.
2. **Controlador de Produtos (`ProductController`)**: Gerenciará as operações de criação, leitura e busca de produtos.
3. **Exceções Personalizadas**: Incluirá exceções customizadas para tratar situações específicas como preço negativo e produtos não encontrados.

## 4. Especificações das Exceções Personalizadas:

Nessa aplicação teremos duas exceções personalizadas, sendo elas **`NotFoundException`** e **`NegativePriceException`**. Ambas devem herdar de `Exception` ou `RuntimeException`.

1. **`NotFoundException`**: Deve conter dois construtores (overloading), sendo um que não recebe parâmetro e define a mensagem de erro como "**Not found.**" e um que recebe a mensagem de erro por parâmetro.
2. **`NegativePriceException`**: Deve conter dois construtores (overloading), sendo um que não recebe parâmetro e define a mensagem de erro como "**Negative price.**" e um que recebe a mensagem de erro por parâmetro.

## 5. Sugestão de Arquitetura

- 📂 src
  - 📂 exceptions
    - 📄 NotFoundException.java
    - 📄 NegativePriceException.java
  - 📂 product
    - 📄 ProductController.java
    - 📄 ProductModel.java
  - 📄 Main.java

## 6. Especificações de `ProductModel`:

### 6.1. Atributos:

Todos os atributos de `ProductModel` devem ser **privados**. Todos os atributos devem ter `getters` e `setters`, a única exceção é o atributo **`barCode`**, que deve conter apenas o `getter`.

- **barCode**: Identificador único da model.
  - **Tipo de dado**: `String`.
- **name**: Nome do produto.
  - **Tipo de dado**: `String`.
- **priceInCents**: Representa o preço do produto em centavos.
  - **Tipo de dado**: `Integer`.
- **stock**: Representa a quantidade de produtos restantes.
  - **Tipo de dado**: `Integer`.

## 7. Especificações de `ProductController`:

### 7.1. Atributos:

Deve conter apenas um atributo chamado `products`. Esse atributo só pode ser acessado dentro do `controller`. Ele deve ser um `ArrayList` que começa vazio.

### 7.2. Métodos:

A implementação dos três métodos abaixo é obrigatória, todos eles devem existir na sua classe, porém, sinta-se livre para fazer a criação de métodos auxiliares caso ache necessário.

- **`create(ProductModel payload)`**:
  - **Especificações**: deve fazer a criação de um novo produto. O preço do produto deve ser positivo, ou seja, caso enviado um valor negativo, a exceção customizada **`NegativePriceException`** deve ser levantada com a mensagem: "**O preço do produto precisa ser um número positivo.**".
  - **Retorno**: deve ter como retorno a seguinte mensagem: "**Produto 'nomeDoProduto' adicionado.**".
- **`read()`** :
  - **Especificações**: deve trazer para o cliente todos os produtos existentes na aplicação.
  - **Retorno**: deve ter como retorno todos os produtos.
- **`retrievePrice(String barCode)`**:
  - **Especificações**: deve buscar o produto por código de barras. Caso o produto buscado não exista, deve levantar a exceção customizada **`NotFoundException`** com a mensagem: "**Product 'nomeDoProduto' not found.**".
  - **Retorno**: deve ter como retorno o preço do produto buscado.
