package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Funcionario;
import Projeto_Localiza.Interface.Crud;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio implements Crud<Funcionario> {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void atualizar(String cpf, Funcionario funcionarioAtualizado) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCpf().equals(cpf)) {
                funcionarios.set(i, funcionarioAtualizado);
                return;
            }
        }
        throw new RuntimeException("Funcionário com CPF " + cpf + " não encontrado!");
    }

    @Override
    public void remover(String cpf) {
        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
    }

    @Override
    public Funcionario buscar(String cpf) {
        return funcionarios.stream()
                           .filter(f -> f.getCpf().equals(cpf))
                           .findFirst()
                           .orElse(null);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarios;
    }
}
