package Projeto_Localiza.Servico;

import Projeto_Localiza.Entidades.Funcionario;
import Projeto_Localiza.Repositorio.FuncionarioRepositorioJDBC;

public class FuncionarioServico {

    private FuncionarioRepositorioJDBC repo = new FuncionarioRepositorioJDBC();

    public void cadastrar(Funcionario funcionario) {

        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não pode ser vazio!");
        }

        if (funcionario.getEndereco() == null || funcionario.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("Endereço é obrigatório!");
        }

        if (repo.buscar(funcionario.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe funcionário com o CPF " + funcionario.getCpf());
        }

        repo.salvar(funcionario);
    }

    public void listar() { repo.listar().forEach(System.out::println); }

    public void atualizar(String cpf, Funcionario funcionarioAtualizado) {
        repo.atualizar(cpf, funcionarioAtualizado);
    }

    public void remover(String cpf) { repo.remover(cpf); }

    public Funcionario buscar(String cpf) { return repo.buscar(cpf); }
}
