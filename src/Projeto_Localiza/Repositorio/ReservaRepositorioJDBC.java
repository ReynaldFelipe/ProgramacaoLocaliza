package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Reserva;
import Projeto_Localiza.Interface.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorioJDBC implements Crud<Reserva> {

    @Override
    public void salvar(Reserva reserva) {
        String sql = "INSERT INTO reserva (cliente, carro, data_reserva, previsao_recebimento) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reserva.getCliente());
            stmt.setString(2, reserva.getCarro());
            stmt.setString(3, reserva.getDataReserva());
            stmt.setString(4, reserva.getPrevisaoRecebimento());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar reserva: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(String cliente, Reserva reservaAtualizada) {
        String sql = "UPDATE reserva SET carro=?, data_reserva=?, previsao_recebimento=? WHERE cliente=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reservaAtualizada.getCarro());
            stmt.setString(2, reservaAtualizada.getDataReserva());
            stmt.setString(3, reservaAtualizada.getPrevisaoRecebimento());
            stmt.setString(4, cliente);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar reserva: " + e.getMessage());
        }
    }

    @Override
    public void remover(String cliente) {
        String sql = "DELETE FROM reserva WHERE cliente=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover reserva: " + e.getMessage());
        }
    }

    @Override
    public Reserva buscar(String cliente) {
        String sql = "SELECT * FROM reserva WHERE cliente=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Reserva(
                        rs.getString("cliente"),
                        rs.getString("carro"),
                        rs.getString("data_reserva"),
                        rs.getString("previsao_recebimento")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar reserva: " + e.getMessage());
        }
    }

    @Override
    public List<Reserva> listar() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reservas.add(new Reserva(
                        rs.getString("cliente"),
                        rs.getString("carro"),
                        rs.getString("data_reserva"),
                        rs.getString("previsao_recebimento")
                ));
            }

            return reservas;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar reservas: " + e.getMessage());
        }
    }
}
