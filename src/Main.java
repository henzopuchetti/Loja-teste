import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

    System.out.println("=== Cadastro de Usuário ===");
    System.out.print("Nome do Usuário: ");
    String nome = sc.nextLine();

    String cpf;
    while (true) {
        System.out.print("CPF do Usuário (10 a 12 dígitos): ");
        cpf = sc.nextLine();
        if (cpf.matches("\\d{10,12}")) break;
        System.out.println("CPF inválido! Digite somente números com 10 a 12 dígitos.");
    }

    String email;
    while (true) {
        System.out.print("Email: ");
        email = sc.nextLine();
        if (email.contains("@")) break;
        System.out.println("Email inválido! Deve conter '@'.");
    }

    Usuario usuario = new Usuario(nome, cpf, email);
    usuarios.add(usuario);

    System.out.println("\n=== Cadastro de Produtos ===");
    String resposta;
    do {
        System.out.print("Nome do produto: ");
        String nomeProduto = sc.nextLine();

        System.out.print("Preço do Produto: ");
        double preco = Double.parseDouble(sc.nextLine());

        System.out.print("Quantidade em estoque: ");
        int qtd = Integer.parseInt(sc.nextLine());

        produtos.add(new Produto(nomeProduto, preco, qtd));

        System.out.print("Deseja cadastrar outro produto? (sim/não): ");
        resposta = sc.nextLine().trim().toLowerCase();
    } while (resposta.equals("sim"));

        System.out.println("\n=== Nova Venda ===");
        Venda venda = new Venda(usuario);
        while (true) {
            System.out.println("\nProdutos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(i + ": " + produtos.get(i));
            }

            System.out.print("Escolha o índice do produto (se deseja finalizar, digite: -1): ");
            int indice = Integer.parseInt(sc.nextLine());
            if (indice == -1) break;

            Produto escolhido = produtos.get(indice);
            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(sc.nextLine());

            if (qtd <= escolhido.getQuantidade()) {
                venda.adicionarItem(new ItemVenda(escolhido, qtd));
                escolhido.reduzirEstoque(qtd);
            } else {
                System.out.println("Estoque do produto insuficiente!");
            }
        }

        vendas.add(venda);

        System.out.println("\n=== Resumo da Venda ===");
        System.out.println(venda);

        System.out.println("\n=== Estoque Atualizado ===");
        for (Produto p : produtos) {
            System.out.println(p);
        }
        sc.close();
    }
}
