package Projeto_Localiza.Servico;

import Projeto_Localiza.Entidades.Cliente;
import Projeto_Localiza.Repositorio.ClienteRepositorioJDBC;

public class ClienteServico {

    private ClienteRepositorioJDBC repo = new ClienteRepositorioJDBC();

    public void cadastrar(String nome, String cpf, String endereco, String telefone, String email) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }

        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço é obrigatório!");
        }

        if (repo.buscar(cpf) != null) {
            throw new IllegalArgumentException("Já existe cliente com este CPF!");
        }

        repo.salvar(new Cliente(nome, cpf, endereco, telefone, email));
    }

    public void listar() {
        repo.listar().forEach(System.out::println);
    }

    public void atualizar(String cpf, String nome, String endereco, String telefone, String email) {
        repo.atualizar(cpf, new Cliente(nome, cpf, endereco, telefone, email));
    }

    public void remover(String cpf) {
        repo.remover(cpf);
    }

    public Cliente buscar(String cpf) {
        return repo.buscar(cpf);
    }
}
