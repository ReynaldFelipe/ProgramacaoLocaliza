package Projeto_Localiza.Controle;

import Projeto_Localiza.Entidades.Reserva;
import Projeto_Localiza.Servico.ReservaServico;

public class ReservaControle {

    private ReservaServico servico = new ReservaServico();

    public void cadastrar(Reserva reserva) {
        servico.cadastrar(reserva);
        System.out.println("Reserva registrada!");
    }

    public void listar() {
        servico.listar();
    }

    public void atualizar(String cliente, Reserva reservaAtualizada) {
        servico.atualizar(cliente, reservaAtualizada);
        System.out.println("Reserva atualizada!");
    }

    public void remover(String cliente) {
        servico.remover(cliente);
        System.out.println("Reserva removida!");
    }

    public void buscar(String cliente) {
        Reserva r = servico.buscar(cliente);
        System.out.println(r != null ? "Encontrada: " + r : "Reserva não encontrada!");
    }
}
