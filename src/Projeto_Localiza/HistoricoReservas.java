package Projeto_Localiza;

import Projeto_Localiza.Entidades.Reserva;
import java.util.Stack;

public class HistoricoReservas {
    public static void main(String[] args) {

        Stack<Reserva> historicoReservas = new Stack<>();

        // Inserindo reservas (com datas)
        historicoReservas.push(new Reserva("11111111111", "ABC1234", "2025-01-10", "2025-01-12"));
        historicoReservas.push(new Reserva("22222222222", "XYZ5678", "2025-01-11", "2025-01-13"));
        historicoReservas.push(new Reserva("33333333333", "JHG9988", "2025-01-12", "2025-01-14"));

        System.out.println("Histórico atual de Reservas:");
        historicoReservas.forEach(System.out::println);

        Reserva cancelada = historicoReservas.pop();
        System.out.println("\nReserva cancelada: " + cancelada);

        System.out.println("\nHistórico após cancelamento:");
        historicoReservas.forEach(System.out::println);

        // Procurar por CPF do cliente
        String clienteBusca = "11111111111";

        boolean encontrada = false;
        for (Reserva r : historicoReservas) {
            if (r.getCliente().equals(clienteBusca)) {
                System.out.println("\nReserva encontrada: " + r);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("\nNenhuma reserva encontrada para o cliente: " + clienteBusca);
        }
    }
}
