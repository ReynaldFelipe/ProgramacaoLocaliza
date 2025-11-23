package Projeto_Localiza.Entidades;

public class Locacao {

    private int id;
    private Carro carroLocado;
    private Cliente cliente;
    private String dataInicio;
    private String dataFimEstimada;
    private String dataFimEfetiva;
    private int qtdDiarias;
    private float valorTotal;
    private float valorDiaria;
    private String formaPagamento;
    private float valorMultaAtrasoDiaria;

    public Locacao() {
    }

    public Locacao(Carro carroLocado, Cliente cliente, String dataInicio, String dataFimEstimada, float valorDiaria) {
        this.carroLocado = carroLocado;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFimEstimada = dataFimEstimada;
        this.valorDiaria = valorDiaria;
    }

    public Locacao(Carro carroLocado, Cliente cliente) {
        this.carroLocado = carroLocado;
        this.cliente = cliente;
    }

    // ---------- GETTERS E SETTERS ----------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carro getCarroLocado() {
        return carroLocado;
    }

    public void setCarroLocado(Carro carroLocado) {
        this.carroLocado = carroLocado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFimEstimada() {
        return dataFimEstimada;
    }

    public void setDataFimEstimada(String dataFimEstimada) {
        this.dataFimEstimada = dataFimEstimada;
    }

    public String getDataFimEfetiva() {
        return dataFimEfetiva;
    }

    public void setDataFimEfetiva(String dataFimEfetiva) {
        this.dataFimEfetiva = dataFimEfetiva;
    }

    public int getQtdDiarias() {
        return qtdDiarias;
    }

    public void setQtdDiarias(int qtdDiarias) {
        this.qtdDiarias = qtdDiarias;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getValorMultaAtrasoDiaria() {
        return valorMultaAtrasoDiaria;
    }

    public void setValorMultaAtrasoDiaria(float valorMultaAtrasoDiaria) {
        this.valorMultaAtrasoDiaria = valorMultaAtrasoDiaria;
    }

    @Override
    public String toString() {
        return "Locacao [id=" + id 
                + ", carro=" + carroLocado 
                + ", cliente=" + cliente 
                + ", dataInicio=" + dataInicio
                + ", dataFimEstimada=" + dataFimEstimada 
                + ", dataFimEfetiva=" + dataFimEfetiva 
                + ", qtdDiarias=" + qtdDiarias
                + ", valorTotal=" + valorTotal 
                + ", valorDiaria=" + valorDiaria 
                + ", formaPagamento=" + formaPagamento
                + ", valorMultaAtrasoDiaria=" + valorMultaAtrasoDiaria 
                + "]";
    }
}
