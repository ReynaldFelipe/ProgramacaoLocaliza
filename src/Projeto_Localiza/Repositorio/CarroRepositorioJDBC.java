package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Carro;
import Projeto_Localiza.Interface.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroRepositorioJDBC implements Crud<Carro> {

    @Override
    public void salvar(Carro carro) {
        String sql = """
            INSERT INTO carro 
            (chassi, placa, modelo, categoria, arCondicionado, direcaoHidraulica,
             anoFabricacao, anoModelo, kmInicial, kmFinal, status, diaria)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getChassi());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getModelo());
            stmt.setString(4, carro.getCategoria());
            stmt.setBoolean(5, carro.isArCondicionado());
            stmt.setBoolean(6, carro.isDirecaoHidraulica());
            stmt.setInt(7, carro.getAnoFabricacao());
            stmt.setInt(8, carro.getAnoModelo());
            stmt.setInt(9, carro.getKmInicial());
            stmt.setInt(10, carro.getKmFinal());
            stmt.setString(11, carro.getStatus());
            stmt.setFloat(12, carro.getDiaria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar carro: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(String chassi, Carro carroAtualizado) {
        String sql = """
            UPDATE carro SET placa=?, modelo=?, categoria=?, arCondicionado=?, 
                             direcaoHidraulica=?, anoFabricacao=?, anoModelo=?, 
                             kmInicial=?, kmFinal=?, status=?, diaria=? 
            WHERE chassi=?
            """;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carroAtualizado.getPlaca());
            stmt.setString(2, carroAtualizado.getModelo());
            stmt.setString(3, carroAtualizado.getCategoria());
            stmt.setBoolean(4, carroAtualizado.isArCondicionado());
            stmt.setBoolean(5, carroAtualizado.isDirecaoHidraulica());
            stmt.setInt(6, carroAtualizado.getAnoFabricacao());
            stmt.setInt(7, carroAtualizado.getAnoModelo());
            stmt.setInt(8, carroAtualizado.getKmInicial());
            stmt.setInt(9, carroAtualizado.getKmFinal());
            stmt.setString(10, carroAtualizado.getStatus());
            stmt.setFloat(11, carroAtualizado.getDiaria());
            stmt.setString(12, chassi);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar carro: " + e.getMessage());
        }
    }

    @Override
    public void remover(String chassi) {
        String sql = "DELETE FROM carro WHERE chassi=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chassi);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover carro: " + e.getMessage());
        }
    }

    @Override
    public Carro buscar(String chassi) {
        String sql = "SELECT * FROM carro WHERE chassi=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chassi);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Carro(
                    rs.getString("chassi"),
                    rs.getString("modelo"),
                    rs.getString("placa"),
                    rs.getString("categoria"),
                    rs.getBoolean("arCondicionado"),
                    rs.getBoolean("direcaoHidraulica"),
                    rs.getInt("anoFabricacao"),
                    rs.getInt("anoModelo"),
                    rs.getInt("kmInicial"),
                    rs.getInt("kmFinal"),
                    rs.getString("status"),
                    rs.getFloat("diaria")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar carro: " + e.getMessage());
        }
    }

    @Override
    public List<Carro> listar() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                carros.add(new Carro(
                    rs.getString("chassi"),
                    rs.getString("modelo"),
                    rs.getString("placa"),
                    rs.getString("categoria"),
                    rs.getBoolean("arCondicionado"),
                    rs.getBoolean("direcaoHidraulica"),
                    rs.getInt("anoFabricacao"),
                    rs.getInt("anoModelo"),
                    rs.getInt("kmInicial"),
                    rs.getInt("kmFinal"),
                    rs.getString("status"),
                    rs.getFloat("diaria")
                ));
            }

            return carros;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar carros: " + e.getMessage());
        }
    }
}
