package Projeto_Localiza.Visual;

import Projeto_Localiza.Controle.LocacaoControle;
import Projeto_Localiza.Entidades.Carro;
import Projeto_Localiza.Entidades.Cliente;
import Projeto_Localiza.Entidades.Locacao;
import java.util.Scanner;

public class LocacaoVisual {
    private LocacaoControle controle = new LocacaoControle();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU LOCAÇÃO ---");
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

                    // ==========================
                    // CADASTRAR LOCAÇÃO
                    // ==========================
                    case 1 -> {

                        // --------------------------
                        // CLIENTE
                        // --------------------------
                        System.out.print("Nome do cliente: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF do cliente: ");
                        String cpf = sc.nextLine();

                        System.out.print("Endereço do cliente: ");
                        String endereco = sc.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email);

                        // --------------------------
                        // CARRO
                        // --------------------------
                        System.out.print("Chassi do carro: ");
                        String chassi = sc.nextLine();

                        System.out.print("Modelo do carro: ");
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

                        // --------------------------
                        // LOCAÇÃO
                        // --------------------------
                        System.out.print("Data início (AAAA-MM-DD): ");
                        String dataInicio = sc.nextLine();

                        System.out.print("Data fim estimada (AAAA-MM-DD): ");
                        String dataFim = sc.nextLine();

                        Locacao locacao = new Locacao(carro, cliente, dataInicio, dataFim, diaria);
                        controle.cadastrar(locacao);
                    }

                    // ==========================
                    // LISTAR
                    // ==========================
                    case 2 -> controle.listar();

                    // ==========================
                    // ATUALIZAR
                    // ==========================
                    case 3 -> {
                        System.out.print("ID da locação a atualizar: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // CLIENTE
                        System.out.print("Novo nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Novo CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Novo endereço: ");
                        String endereco = sc.nextLine();

                        System.out.print("Novo telefone: ");
                        String telefone = sc.nextLine();

                        System.out.print("Novo email: ");
                        String email = sc.nextLine();

                        Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email);

                        // CARRO
                        System.out.print("Novo chassi do carro: ");
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

                        System.out.print("Nova data início (AAAA-MM-DD): ");
                        String dataInicio = sc.nextLine();

                        System.out.print("Nova data fim (AAAA-MM-DD): ");
                        String dataFim = sc.nextLine();

                        Locacao locacaoAtualizada = new Locacao(carroAtualizado, cliente, dataInicio, dataFim, diaria);
                        controle.atualizar(id, locacaoAtualizada);
                    }

                    // REMOVER
                    case 4 -> {
                        System.out.print("ID da locação a remover: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        controle.remover(id);
                    }

                    // BUSCAR
                    case 5 -> {
                        System.out.print("ID da locação para buscar: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        controle.buscar(id);
                    }
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine();
            }

        } while (opcao != 0);
    }
}
