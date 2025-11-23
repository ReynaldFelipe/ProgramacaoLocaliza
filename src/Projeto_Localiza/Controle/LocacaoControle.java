package Projeto_Localiza.Controle;

import Projeto_Localiza.Entidades.Locacao;
import Projeto_Localiza.Servico.LocacaoServico;

public class LocacaoControle {

    private LocacaoServico servico = new LocacaoServico();

    public void cadastrar(Locacao locacao) {
        servico.cadastrar(locacao);
        System.out.println("Locação cadastrada com sucesso!");
    }

    public void listar() {
        servico.listar();
    }

    public void atualizar(int id, Locacao locacaoAtualizada) {
        servico.atualizar(id, locacaoAtualizada);
        System.out.println("Locação atualizada com sucesso!");
    }

    public void remover(int id) {
        servico.remover(id);
        System.out.println("Locação removida com sucesso!");
    }

    public void buscar(int id) {
        Locacao l = servico.buscar(id);
        if (l != null) {
            System.out.println("Encontrada: " + l);
        } else {
            System.out.println("Locação não encontrada!");
        }
    }
}
