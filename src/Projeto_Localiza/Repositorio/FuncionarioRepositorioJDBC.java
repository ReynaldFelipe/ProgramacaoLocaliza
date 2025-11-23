package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Funcionario;
import Projeto_Localiza.Interface.Crud;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorioJDBC implements Crud<Funcionario> {

    @Override
    public void salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (cpf, nome, endereco, matricula, cargo, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getMatricula());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(String cpf, Funcionario funcionarioAtualizado) {
        String sql = "UPDATE funcionario SET nome=?, endereco=?, matricula=?, cargo=?, email=? WHERE cpf=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionarioAtualizado.getNome());
            stmt.setString(2, funcionarioAtualizado.getEndereco());
            stmt.setString(3, funcionarioAtualizado.getMatricula());
            stmt.setString(4, funcionarioAtualizado.getCargo());
            stmt.setString(5, funcionarioAtualizado.getEmail());
            stmt.setString(6, cpf);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    @Override
    public void remover(String cpf) {
        String sql = "DELETE FROM funcionario WHERE cpf=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover funcionário: " + e.getMessage());
        }
    }

    @Override
    public Funcionario buscar(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Funcionario(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("matricula"),
                    rs.getString("cargo"),
                    rs.getString("email")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário: " + e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                funcionarios.add(new Funcionario(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("matricula"),
                    rs.getString("cargo"),
                    rs.getString("email")
                ));
            }

            return funcionarios;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage());
        }
    }
}
