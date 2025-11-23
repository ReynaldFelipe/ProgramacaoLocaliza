package Projeto_Localiza.Entidades;

public class Carro extends Veiculo {

    public Carro(String chassi, String modelo, String placa, String categoria,
                 boolean arCondicionado, boolean direcaoHidraulica,
                 int anoFabricacao, int anoModelo, int kmInicial,
                 int kmFinal, String status, float diaria) {

        super(chassi, modelo, placa, categoria, arCondicionado, direcaoHidraulica,
              anoFabricacao, anoModelo, kmInicial, kmFinal, status, diaria);
    }

    @Override
    public String obterDetalhesVeiculo() {
        return "Carro modelo " + getModelo() + " - Categoria: " + getCategoria();
    }

    @Override
    public String toString() {
        return "Carro: " + super.toString();
    }
}
