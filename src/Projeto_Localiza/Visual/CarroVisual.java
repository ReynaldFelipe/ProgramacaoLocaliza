package Projeto_Localiza.Visual;

import Projeto_Localiza.Controle.CarroControle;
import Projeto_Localiza.Entidades.Carro;
import java.util.Scanner;

public class CarroVisual {
    private CarroControle controle = new CarroControle();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU CARRO ---");
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

                    // =========================
                    // CADASTRAR
                    // =========================
                    case 1 -> {
                        System.out.print("Chassi: ");
                        String chassi = sc.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = sc.nextLine();

                        System.out.print("Placa: ");
                        String placa = sc.nextLine();

                        System.out.print("Categoria: ");
                        String categoria = sc.nextLine();

                        System.out.print("Ar-condicionado (true/false): ");
                        boolean ar = sc.nextBoolean();

                        System.out.print("Direção hidráulica (true/false): ");
                        boolean dir = sc.nextBoolean();

                        System.out.print("Ano fabricação: ");
                        int anoFab = sc.nextInt();

                        System.out.print("Ano modelo: ");
                        int anoMod = sc.nextInt();

                        System.out.print("KM inicial: ");
                        int kmI = sc.nextInt();

                        System.out.print("KM final: ");
                        int kmF = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Status: ");
                        String status = sc.nextLine();

                        System.out.print("Diária: ");
                        float diaria = sc.nextFloat();
                        sc.nextLine();

                        Carro carro = new Carro(
                                chassi, modelo, placa, categoria, ar, dir,
                                anoFab, anoMod, kmI, kmF, status, diaria
                        );

                        controle.cadastrar(carro);
                    }

                    // =========================
                    // LISTAR
                    // =========================
                    case 2 -> controle.listar();

                    // =========================
                    // ATUALIZAR
                    // =========================
                    case 3 -> {
                        System.out.print("Chassi do carro a atualizar: ");
                        String chassi = sc.nextLine();

                        System.out.print("Novo modelo: ");
                        String modelo = sc.nextLine();

                        System.out.print("Nova placa: ");
                        String placa = sc.nextLine();

                        System.out.print("Nova categoria: ");
                        String categoria = sc.nextLine();

                        System.out.print("Ar-condicionado (true/false): ");
                        boolean ar = sc.nextBoolean();

                        System.out.print("Direção hidráulica (true/false): ");
                        boolean dir = sc.nextBoolean();

                        System.out.print("Ano fabricação: ");
                        int anoFab = sc.nextInt();

                        System.out.print("Ano modelo: ");
                        int anoMod = sc.nextInt();

                        System.out.print("KM inicial: ");
                        int kmI = sc.nextInt();

                        System.out.print("KM final: ");
                        int kmF = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Status: ");
                        String status = sc.nextLine();

                        System.out.print("Diária: ");
                        float diaria = sc.nextFloat();
                        sc.nextLine();

                        Carro carroAtualizado = new Carro(
                                chassi, modelo, placa, categoria, ar, dir,
                                anoFab, anoMod, kmI, kmF, status, diaria
                        );

                        controle.atualizar(chassi, carroAtualizado);
                    }

                    // =========================
                    // REMOVER
                    // =========================
                    case 4 -> {
                        System.out.print("Chassi do carro a remover: ");
                        String chassi = sc.nextLine();
                        controle.remover(chassi);
                    }

                    // =========================
                    // BUSCAR
                    // =========================
                    case 5 -> {
                        System.out.print("Chassi para buscar: ");
                        String chassi = sc.nextLine();
                        controle.buscar(chassi);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // limpa buffer em caso de erro
            }
        } while (opcao != 0);
    }
}
