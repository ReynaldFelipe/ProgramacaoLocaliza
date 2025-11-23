package Projeto_Localiza.Controle;

import Projeto_Localiza.Entidades.Carro;
import Projeto_Localiza.Servico.CarroServico;

public class CarroControle {

    private CarroServico servico = new CarroServico();

    public void cadastrar(Carro carro) {
        servico.cadastrar(carro);
        System.out.println("Carro cadastrado com sucesso!");
    }

    public void listar() {
        servico.listar();
    }

    public void atualizar(String chassi, Carro carroAtualizado) {
        servico.atualizar(chassi, carroAtualizado);
        System.out.println("Carro atualizado com sucesso!");
    }

    public void remover(String chassi) {
        servico.remover(chassi);
        System.out.println("Carro removido com sucesso!");
    }

    public void buscar(String chassi) {
        Carro c = servico.buscar(chassi);
        if (c != null) {
            System.out.println("Encontrado: " + c);
        } else {
            System.out.println("Carro não encontrado!");
        }
    }
}
