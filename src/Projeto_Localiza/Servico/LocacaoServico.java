package Projeto_Localiza.Servico;

import Projeto_Localiza.Entidades.Locacao;
import Projeto_Localiza.Repositorio.LocacaoRepositorioJDBC;

public class LocacaoServico {

    private LocacaoRepositorioJDBC repo = new LocacaoRepositorioJDBC();

    public void cadastrar(Locacao locacao) {
        if (locacao.getCarroLocado() == null) {
            throw new IllegalArgumentException("É necessário informar um carro para a locação!");
        }
        if (locacao.getCliente() == null) {
            throw new IllegalArgumentException("É necessário informar um cliente para a locação!");
        }

        repo.salvar(locacao);
    }

    public void listar() {
        repo.listar().forEach(System.out::println);
    }

    public void atualizar(int id, Locacao locacaoAtualizada) {
        repo.atualizar(String.valueOf(id), locacaoAtualizada);
    }

    public void remover(int id) {
        repo.remover(String.valueOf(id));
    }

    public Locacao buscar(int id) {
        return repo.buscar(String.valueOf(id));
    }
}
