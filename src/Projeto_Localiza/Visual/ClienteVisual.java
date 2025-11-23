package Projeto_Localiza.Visual;

import Projeto_Localiza.Controle.ClienteControle;
import java.util.Scanner;

public class ClienteVisual {

    private ClienteControle controle = new ClienteControle();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("5 - Buscar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {

                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        controle.cadastrar(nome, cpf, endereco, telefone, email);
                    }

                    case 2 -> controle.listar();

                    case 3 -> {
                        System.out.print("CPF do cliente a atualizar: ");
                        String cpf = sc.nextLine();

                        System.out.print("Novo nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Novo endereço: ");
                        String endereco = sc.nextLine();

                        System.out.print("Novo telefone: ");
                        String telefone = sc.nextLine();

                        System.out.print("Novo email: ");
                        String email = sc.nextLine();

                        controle.atualizar(cpf, nome, endereco, telefone, email);
                    }

                    case 4 -> {
                        System.out.print("CPF do cliente a remover: ");
                        String cpf = sc.nextLine();
                        controle.remover(cpf);
                    }

                    case 5 -> {
                        System.out.print("CPF para buscar: ");
                        String cpf = sc.nextLine();
                        controle.buscar(cpf);
                    }
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
