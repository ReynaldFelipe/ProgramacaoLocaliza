package Projeto_Localiza.Repositorio;

import Projeto_Localiza.Entidades.Carro;
import Projeto_Localiza.Interface.Crud;
import java.util.ArrayList;
import java.util.List;

public class CarroRepositorio implements Crud<Carro> {
    private List<Carro> carros = new ArrayList<>();

    @Override
    public void salvar(Carro carro) {
        carros.add(carro);
    }

    @Override
    public void atualizar(String placa, Carro carroAtualizado) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getPlaca().equalsIgnoreCase(placa)) {
                carros.set(i, carroAtualizado);
                return;
            }
        }
        throw new RuntimeException("Carro com placa " + placa + " não encontrado!");
    }

    @Override
    public void remover(String placa) {
        carros.removeIf(c -> c.getPlaca().equalsIgnoreCase(placa));
    }

    @Override
    public Carro buscar(String placa) {
        return carros.stream()
                     .filter(c -> c.getPlaca().equalsIgnoreCase(placa))
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public List<Carro> listar() {
        return carros;
    }
}
