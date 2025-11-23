package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Cliente;
import Projeto_Localiza.Interface.Crud;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements Crud<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizar(String cpf, Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.set(i, clienteAtualizado);
                return;
            }
        }
        throw new RuntimeException("Cliente com CPF " + cpf + " não encontrado!");
    }

    @Override
    public void remover(String cpf) {
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }

    @Override
    public Cliente buscar(String cpf) {
        return clientes.stream()
                       .filter(c -> c.getCpf().equals(cpf))
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }
}
