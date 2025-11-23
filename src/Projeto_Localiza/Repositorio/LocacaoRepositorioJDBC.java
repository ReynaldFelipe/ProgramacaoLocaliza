package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Carro;
import Projeto_Localiza.Entidades.Cliente;
import Projeto_Localiza.Entidades.Locacao;
import Projeto_Localiza.Interface.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocacaoRepositorioJDBC implements Crud<Locacao> {

    private final CarroRepositorioJDBC carroRepo = new CarroRepositorioJDBC();
    private final ClienteRepositorioJDBC clienteRepo = new ClienteRepositorioJDBC();

    @Override
    public void salvar(Locacao locacao) {
        String sql = "INSERT INTO locacao (placa, cpf, dataInicio, dataFimEstimada, "
                + "dataFimEfetiva, qtdDiarias, valorTotal, valorDiaria, formaPagamento, valorMultaAtrasoDiaria) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, locacao.getCarroLocado().getPlaca());
            stmt.setString(2, locacao.getCliente().getCpf());
            stmt.setString(3, locacao.getDataInicio());
            stmt.setString(4, locacao.getDataFimEstimada());
            stmt.setString(5, locacao.getDataFimEfetiva());
            stmt.setInt(6, locacao.getQtdDiarias());
            stmt.setFloat(7, locacao.getValorTotal());
            stmt.setFloat(8, locacao.getValorDiaria());
            stmt.setString(9, locacao.getFormaPagamento());
            stmt.setFloat(10, locacao.getValorMultaAtrasoDiaria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar locação: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(String idString, Locacao locacaoAtualizada) {
        int id = Integer.parseInt(idString);

        String sql = "UPDATE locacao SET placa=?, cpf=?, dataInicio=?, dataFimEstimada=?, "
                + "dataFimEfetiva=?, qtdDiarias=?, valorTotal=?, valorDiaria=?, formaPagamento=?, valorMultaAtrasoDiaria=? "
                + "WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, locacaoAtualizada.getCarroLocado().getPlaca());
            stmt.setString(2, locacaoAtualizada.getCliente().getCpf());
            stmt.setString(3, locacaoAtualizada.getDataInicio());
            stmt.setString(4, locacaoAtualizada.getDataFimEstimada());
            stmt.setString(5, locacaoAtualizada.getDataFimEfetiva());
            stmt.setInt(6, locacaoAtualizada.getQtdDiarias());
            stmt.setFloat(7, locacaoAtualizada.getValorTotal());
            stmt.setFloat(8, locacaoAtualizada.getValorDiaria());
            stmt.setString(9, locacaoAtualizada.getFormaPagamento());
            stmt.setFloat(10, locacaoAtualizada.getValorMultaAtrasoDiaria());
            stmt.setInt(11, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar locação: " + e.getMessage());
        }
    }

    @Override
    public void remover(String idString) {
        int id = Integer.parseInt(idString);

        String sql = "DELETE FROM locacao WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover locação: " + e.getMessage());
        }
    }

    @Override
    public Locacao buscar(String idString) {
        int id = Integer.parseInt(idString);

        String sql = "SELECT * FROM locacao WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) return null;

            Carro carro = carroRepo.buscar(rs.getString("placa"));
            Cliente cliente = clienteRepo.buscar(rs.getString("cpf"));

            Locacao loc = new Locacao(carro, cliente);
            loc.setId(rs.getInt("id"));
            loc.setDataInicio(rs.getString("dataInicio"));
            loc.setDataFimEstimada(rs.getString("dataFimEstimada"));
            loc.setDataFimEfetiva(rs.getString("dataFimEfetiva"));
            loc.setQtdDiarias(rs.getInt("qtdDiarias"));
            loc.setValorTotal(rs.getFloat("valorTotal"));
            loc.setValorDiaria(rs.getFloat("valorDiaria"));
            loc.setFormaPagamento(rs.getString("formaPagamento"));
            loc.setValorMultaAtrasoDiaria(rs.getFloat("valorMultaAtrasoDiaria"));

            return loc;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar locação: " + e.getMessage());
        }
    }

    @Override
    public List<Locacao> listar() {
        List<Locacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM locacao";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carro carro = carroRepo.buscar(rs.getString("placa"));
                Cliente cliente = clienteRepo.buscar(rs.getString("cpf"));

                Locacao loc = new Locacao(carro, cliente);
                loc.setId(rs.getInt("id"));
                loc.setDataInicio(rs.getString("dataInicio"));
                loc.setDataFimEstimada(rs.getString("dataFimEstimada"));
                loc.setDataFimEfetiva(rs.getString("dataFimEfetiva"));
                loc.setQtdDiarias(rs.getInt("qtdDiarias"));
                loc.setValorTotal(rs.getFloat("valorTotal"));
                loc.setValorDiaria(rs.getFloat("valorDiaria"));
                loc.setFormaPagamento(rs.getString("formaPagamento"));
                loc.setValorMultaAtrasoDiaria(rs.getFloat("valorMultaAtrasoDiaria"));

                lista.add(loc);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar locações: " + e.getMessage());
        }

        return lista;
    }
}
