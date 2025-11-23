package Projeto_Localiza.Visual;

import java.util.Scanner;

public class MenuPrincipal {
    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Carros");
            System.out.println("3 - Gerenciar Funcionários");
            System.out.println("4 - Gerenciar Reservas");
            System.out.println("5 - Gerenciar Locações");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> new ClienteVisual().exibirMenu();
                case 2 -> new CarroVisual().exibirMenu();
                case 3 -> new FuncionarioVisual().exibirMenu();
                case 4 -> new ReservaVisual().exibirMenu();
                case 5 -> new LocacaoVisual().exibirMenu();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("⚠ Opção inválida, tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
