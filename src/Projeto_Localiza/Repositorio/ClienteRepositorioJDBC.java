package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Cliente;
import Projeto_Localiza.Interface.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorioJDBC implements Crud<Cliente> {

    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(String cpf, Cliente clienteAtualizado) {
        String sql = "UPDATE cliente SET nome=?, endereco=?, telefone=?, email=? WHERE cpf=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, clienteAtualizado.getNome());
            stmt.setString(2, clienteAtualizado.getEndereco());
            stmt.setString(3, clienteAtualizado.getTelefone());
            stmt.setString(4, clienteAtualizado.getEmail());
            stmt.setString(5, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    @Override
    public void remover(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscar(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email")
                ));
            }
            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
    }
}
