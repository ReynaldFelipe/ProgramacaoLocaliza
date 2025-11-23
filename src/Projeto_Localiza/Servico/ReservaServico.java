package Projeto_Localiza.Servico;

import Projeto_Localiza.Entidades.Reserva;
import Projeto_Localiza.Repositorio.ReservaRepositorioJDBC;

public class ReservaServico {

    private ReservaRepositorioJDBC repo = new ReservaRepositorioJDBC();

    public void cadastrar(Reserva reserva) {

        if (reserva.getCliente().isEmpty())
            throw new IllegalArgumentException("CPF do cliente é obrigatório!");

        if (repo.buscar(reserva.getCliente()) != null)
            throw new IllegalArgumentException("Já existe reserva para este cliente!");

        repo.salvar(reserva);
    }

    public void listar() {
        repo.listar().forEach(System.out::println);
    }

    public void atualizar(String cliente, Reserva reservaAtualizada) {
        repo.atualizar(cliente, reservaAtualizada);
    }

    public void remover(String cliente) {
        repo.remover(cliente);
    }

    public Reserva buscar(String cliente) {
        return repo.buscar(cliente);
    }
}
