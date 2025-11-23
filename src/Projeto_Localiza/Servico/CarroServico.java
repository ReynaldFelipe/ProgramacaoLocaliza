package Projeto_Localiza.Servico;

import Projeto_Localiza.Entidades.Carro;
import Projeto_Localiza.Repositorio.CarroRepositorioJDBC;

public class CarroServico {

    private CarroRepositorioJDBC repo = new CarroRepositorioJDBC();

    public void cadastrar(Carro carro) {

        // ============================
        // VALIDAÇÕES DE GOVERNANÇA
        // ============================

        if (carro.getChassi() == null || carro.getChassi().isEmpty()) {
            throw new IllegalArgumentException("O chassi é obrigatório!");
        }

        if (carro.getModelo() == null || carro.getModelo().isEmpty()) {
            throw new IllegalArgumentException("Modelo do carro não pode ser vazio!");
        }

        if (carro.getPlaca() == null || carro.getPlaca().isEmpty()) {
            throw new IllegalArgumentException("A placa é obrigatória!");
        }

        // Evita duplicidade de chassi — PK
        if (repo.buscar(carro.getChassi()) != null) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com o chassi " + carro.getChassi());
        }

        // Evita duplicidade de placa — best practice
        if (repo.listar().stream().anyMatch(c -> c.getPlaca().equalsIgnoreCase(carro.getPlaca()))) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com a placa " + carro.getPlaca());
        }

        // ============================
        // SALVA O CARRO
        // ============================

        repo.salvar(carro);
    }

    public void listar() {
        repo.listar().forEach(System.out::println);
    }

    public void atualizar(String chassi, Carro carroAtualizado) {

        if (repo.buscar(chassi) == null) {
            throw new IllegalArgumentException("Não existe veículo com o chassi " + chassi);
        }

        repo.atualizar(chassi, carroAtualizado);
    }

    public void remover(String chassi) {
        if (repo.buscar(chassi) == null) {
            throw new IllegalArgumentException("Não existe veículo com o chassi informado!");
        }
        repo.remover(chassi);
    }

    public Carro buscar(String chassi) {
        return repo.buscar(chassi);
    }
}
