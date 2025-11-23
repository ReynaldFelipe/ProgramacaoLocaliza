package Projeto_Localiza.Controle;

import Projeto_Localiza.Servico.ClienteServico;
import Projeto_Localiza.Entidades.Cliente;

public class ClienteControle {

    private ClienteServico servico = new ClienteServico();

    public void cadastrar(String nome, String cpf, String endereco, String telefone, String email) {
        servico.cadastrar(nome, cpf, endereco, telefone, email);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listar() {
        servico.listar();
    }

    public void atualizar(String cpf, String nome, String endereco, String telefone, String email) {
        servico.atualizar(cpf, nome, endereco, telefone, email);
        System.out.println("Cliente atualizado com sucesso!");
    }

    public void remover(String cpf) {
        servico.remover(cpf);
        System.out.println("Cliente removido com sucesso!");
    }

    public void buscar(String cpf) {
        Cliente c = servico.buscar(cpf);
        if (c != null) {
            System.out.println("Encontrado: " + c);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
