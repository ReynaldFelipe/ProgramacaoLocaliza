package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Reserva;
import Projeto_Localiza.Interface.Crud;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorio implements Crud<Reserva> {
    private List<Reserva> reservas = new ArrayList<>();

    @Override
    public void salvar(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public void atualizar(String cliente, Reserva reservaAtualizada) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getCliente().equalsIgnoreCase(cliente)) {
                reservas.set(i, reservaAtualizada);
                return;
            }
        }
        throw new RuntimeException("Reserva do cliente " + cliente + " não encontrada!");
    }

    @Override
    public void remover(String cliente) {
        reservas.removeIf(r -> r.getCliente().equalsIgnoreCase(cliente));
    }

    @Override
    public Reserva buscar(String cliente) {
        return reservas.stream()
                       .filter(r -> r.getCliente().equalsIgnoreCase(cliente))
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public List<Reserva> listar() {
        return reservas;
    }
}
