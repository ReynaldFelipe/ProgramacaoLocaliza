package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Locacao;
import Projeto_Localiza.Interface.Crud;
import java.util.ArrayList;
import java.util.List;

public class LocacaoRepositorio implements Crud<Locacao> {
    private List<Locacao> locacoes = new ArrayList<>();

    @Override
    public void salvar(Locacao locacao) {
        locacoes.add(locacao);
    }

    @Override
    public void atualizar(String cpfCliente, Locacao locacaoAtualizada) {
        for (int i = 0; i < locacoes.size(); i++) {
            if (locacoes.get(i).getCliente().getCpf().equals(cpfCliente)) {
                locacoes.set(i, locacaoAtualizada);
                return;
            }
        }
        throw new RuntimeException("Locação do cliente " + cpfCliente + " não encontrada!");
    }

    @Override
    public void remover(String cpfCliente) {
        locacoes.removeIf(l -> l.getCliente().getCpf().equals(cpfCliente));
    }

    @Override
    public Locacao buscar(String cpfCliente) {
        return locacoes.stream()
                       .filter(l -> l.getCliente().getCpf().equals(cpfCliente))
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public List<Locacao> listar() {
        return locacoes;
    }
}
