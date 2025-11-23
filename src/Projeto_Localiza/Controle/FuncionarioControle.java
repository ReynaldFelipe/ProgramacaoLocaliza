package Projeto_Localiza.Controle;

import Projeto_Localiza.Entidades.Funcionario;
import Projeto_Localiza.Servico.FuncionarioServico;

public class FuncionarioControle {

    private FuncionarioServico servico = new FuncionarioServico();

    public void cadastrar(Funcionario funcionario) {
        servico.cadastrar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listar() { servico.listar(); }

    public void atualizar(String cpf, Funcionario funcionarioAtualizado) {
        servico.atualizar(cpf, funcionarioAtualizado);
        System.out.println("Funcionário atualizado com sucesso!");
    }

    public void remover(String cpf) {
        servico.remover(cpf);
        System.out.println("Funcionário removido com sucesso!");
    }

    public void buscar(String cpf) {
        Funcionario f = servico.buscar(cpf);
        System.out.println(f != null ? "Encontrado: " + f : "Funcionário não encontrado!");
    }
}
