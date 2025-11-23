package Projeto_Localiza.Entidades;

public class Reserva {

    private String cliente;                 // CPF do cliente
    private String carro;                   // Placa ou chassi (conforme seu sistema)
    private String dataReserva;             // YYYY-MM-DD
    private String previsaoRecebimento;     // YYYY-MM-DD

    public Reserva(String cliente, String carro, String dataReserva, String previsaoRecebimento) {
        this.cliente = cliente;
        this.carro = carro;
        this.dataReserva = dataReserva;
        this.previsaoRecebimento = previsaoRecebimento;
    }

    public String getCliente() { return cliente; }
    public String getCarro() { return carro; }

    public String getDataReserva() { return dataReserva; }
    public void setDataReserva(String dataReserva) { this.dataReserva = dataReserva; }

    public String getPrevisaoRecebimento() { return previsaoRecebimento; }
    public void setPrevisaoRecebimento(String previsaoRecebimento) { this.previsaoRecebimento = previsaoRecebimento; }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente='" + cliente + '\'' +
                ", carro='" + carro + '\'' +
                ", dataReserva='" + dataReserva + '\'' +
                ", previsaoRecebimento='" + previsaoRecebimento + '\'' +
                '}';
    }
}
