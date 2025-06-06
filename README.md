
# Sistema de Cadastro e Venda de Produtos

Este projeto é um sistema simples em Java que permite cadastrar usuários, cadastrar produtos, realizar vendas e controlar o estoque dos produtos disponíveis. 

---

## Funcionalidades

- Cadastro de usuário com validação básica de CPF e email.
- Cadastro de múltiplos produtos, incluindo nome, preço e quantidade em estoque.
- Realização de vendas para um usuário cadastrado, escolhendo produtos disponíveis e suas quantidades.
- Controle automático do estoque após as vendas.
- Exibição do resumo da venda e do estoque atualizado ao final da operação.

---

## Estrutura do Projeto

O projeto está organizado em pacotes e classes com responsabilidades bem definidas:

### Pacote `model`

- **`Usuario`**: Representa o cliente, contendo nome, CPF e email.
- **`Produto`**: Representa um produto com nome, preço e quantidade em estoque. Possui método para reduzir o estoque.
- **`ItemVenda`**: Representa um item da venda, associando um produto e a quantidade comprada. Calcula o subtotal.
- **`Venda`**: Contém o cliente e uma lista de itens vendidos, calcula o total da venda e exibe o resumo.

### Classe principal

- **`Main`**: Controla a interação com o usuário pelo console, permitindo:
  - Cadastro do usuário.
  - Cadastro de múltiplos produtos (com opção de continuar ou não).
  - Realização de uma venda, selecionando produtos e quantidades até finalizar.
  - Exibe o resumo da venda e o estoque atualizado dos produtos.

---

## Como executar

1. Compile todas as classes do pacote `model` e a classe `Main`.
2. Execute a classe `Main`.
3. Siga as instruções no console para:
   - Cadastrar um usuário (nome, CPF válido e email válido).
   - Cadastrar produtos (nome, preço, quantidade). Pergunta se deseja cadastrar outro.
   - Realizar uma venda selecionando os produtos pelo índice e informando a quantidade desejada.
   - Finalize a venda digitando `-1` quando desejar encerrar a compra.
4. Ao final, o programa exibirá:
   - O resumo da venda, com os produtos, quantidades e valores.
   - O estoque atualizado dos produtos após a venda.

---

## Validações e Regras

- CPF deve conter apenas números e ter entre 10 e 12 dígitos.
- Email deve conter o caractere `@`.
- Na venda, o usuário não pode comprar mais unidades do que o estoque disponível.
- O estoque é atualizado automaticamente após cada item vendido.
- O programa aceita múltiplos produtos e uma única venda por execução.

---

## Exemplo de uso

```
=== Cadastro de Usuário ===
Nome do Usuário: João Silva
CPF do Usuário (10 a 12 dígitos): 12345678901
Email: joao@example.com

=== Cadastro de Produtos ===
Nome do produto: Teclado
Preço do Produto: 50.0
Quantidade em estoque: 10
Deseja cadastrar outro produto? (sim/não): sim
Nome do produto: Mouse
Preço do Produto: 25.0
Quantidade em estoque: 5
Deseja cadastrar outro produto? (sim/não): não

=== Nova Venda ===

Produtos disponíveis:
0: Teclado - R$50.0 (10 disponíveis)
1: Mouse - R$25.0 (5 disponíveis)
Escolha o índice do produto (se deseja finalizar, digite: -1): 0
Quantidade: 2

Produtos disponíveis:
0: Teclado - R$50.0 (8 disponíveis)
1: Mouse - R$25.0 (5 disponíveis)
Escolha o índice do produto (se deseja finalizar, digite: -1): 1
Quantidade: 1

Produtos disponíveis:
0: Teclado - R$50.0 (8 disponíveis)
1: Mouse - R$25.0 (4 disponíveis)
Escolha o índice do produto (se deseja finalizar, digite: -1): -1

=== Resumo da Venda ===
Usuário: João Silva, CPF: 12345678901, Email: joao@example.com
  Teclado x2 = R$100.0
  Mouse x1 = R$25.0
TOTAL: R$125.0

=== Estoque Atualizado ===
Teclado - R$50.0 (8 disponíveis)
Mouse - R$25.0 (4 disponíveis)
```

---

## Requisitos

- Java JDK 8 ou superior.
- Ambiente para executar aplicações Java via terminal ou IDE (Eclipse, IntelliJ, VS Code, etc).

---

