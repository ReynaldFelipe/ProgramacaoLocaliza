package Projeto_Localiza.Visual;

import Projeto_Localiza.Controle.FuncionarioControle;
import Projeto_Localiza.Entidades.Funcionario;
import java.util.Scanner;

public class FuncionarioVisual {

    private FuncionarioControle controle = new FuncionarioControle();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {

        int opcao;

        do {
            System.out.println("\n--- MENU FUNCIONÁRIO ---");
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

                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Cargo: ");
                        String cargo = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        Funcionario funcionario = new Funcionario(nome, cpf, endereco, matricula, cargo, email);
                        controle.cadastrar(funcionario);
                    }

                    case 2 -> controle.listar();

                    case 3 -> {
                        System.out.print("CPF do funcionário a atualizar: ");
                        String cpf = sc.nextLine();

                        System.out.print("Novo nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Novo endereço: ");
                        String endereco = sc.nextLine();

                        System.out.print("Nova matrícula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Novo cargo: ");
                        String cargo = sc.nextLine();

                        System.out.print("Novo email: ");
                        String email = sc.nextLine();

                        Funcionario funcionarioAtualizado = new Funcionario(nome, cpf, endereco, matricula, cargo, email);
                        controle.atualizar(cpf, funcionarioAtualizado);
                    }

                    case 4 -> {
                        System.out.print("CPF do funcionário a remover: ");
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
