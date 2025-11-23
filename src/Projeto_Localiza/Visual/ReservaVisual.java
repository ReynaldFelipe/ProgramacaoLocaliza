package Projeto_Localiza.Visual;

import Projeto_Localiza.Controle.ReservaControle;
import Projeto_Localiza.Entidades.Reserva;
import java.util.Scanner;

public class ReservaVisual {

    private ReservaControle controle = new ReservaControle();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {

        int opcao;

        do {
            System.out.println("\n--- MENU RESERVA ---");
            System.out.println("1 - Registrar");
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
                        System.out.print("CPF do cliente: ");
                        String cliente = sc.nextLine();

                        System.out.print("Carro: ");
                        String carro = sc.nextLine();

                        System.out.print("Data reserva (AAAA-MM-DD): ");
                        String dataReserva = sc.nextLine();

                        System.out.print("Previsão recebimento (AAAA-MM-DD): ");
                        String previsao = sc.nextLine();

                        Reserva r = new Reserva(cliente, carro, dataReserva, previsao);
                        controle.cadastrar(r);
                    }

                    case 2 -> controle.listar();

                    case 3 -> {
                        System.out.print("CPF do cliente da reserva: ");
                        String cliente = sc.nextLine();

                        System.out.print("Novo carro: ");
                        String carro = sc.nextLine();

                        System.out.print("Nova data reserva (AAAA-MM-DD): ");
                        String dataReserva = sc.nextLine();

                        System.out.print("Nova previsão recebimento (AAAA-MM-DD): ");
                        String previsao = sc.nextLine();

                        Reserva r = new Reserva(cliente, carro, dataReserva, previsao);
                        controle.atualizar(cliente, r);
                    }

                    case 4 -> {
                        System.out.print("CPF do cliente da reserva: ");
                        String cliente = sc.nextLine();
                        controle.remover(cliente);
                    }

                    case 5 -> {
                        System.out.print("CPF do cliente para buscar reserva: ");
                        String cliente = sc.nextLine();
                        controle.buscar(cliente);
                    }
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
