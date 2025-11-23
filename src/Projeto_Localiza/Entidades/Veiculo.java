package Projeto_Localiza.Entidades;

public abstract class Veiculo {

    private String chassi; // 🔑 Novo identificador principal
    private String modelo;
    private String placa;
    private String categoria;
    private boolean arCondicionado;
    private boolean direcaoHidraulica;
    private int anoFabricacao;
    private int anoModelo;
    private int kmInicial;
    private int kmFinal;
    private String status;
    private float diaria;

    public Veiculo(String chassi, String modelo, String placa, String categoria, 
                   boolean arCondicionado, boolean direcaoHidraulica,
                   int anoFabricacao, int anoModelo, int kmInicial, 
                   int kmFinal, String status, float diaria) {

        this.chassi = chassi;
        this.modelo = modelo;
        this.placa = placa;
        this.categoria = categoria;
        this.arCondicionado = arCondicionado;
        this.direcaoHidraulica = direcaoHidraulica;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.status = status;
        this.diaria = diaria;
    }

    public abstract String obterDetalhesVeiculo();

    // -------------------- GETTERS E SETTERS --------------------

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isDirecaoHidraulica() {
        return direcaoHidraulica;
    }

    public void setDirecaoHidraulica(boolean direcaoHidraulica) {
        this.direcaoHidraulica = direcaoHidraulica;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(int kmInicial) {
        this.kmInicial = kmInicial;
    }

    public int getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(int kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getDiaria() {
        return diaria;
    }

    public void setDiaria(float diaria) {
        this.diaria = diaria;
    }

    @Override
    public String toString() {
        return "Veiculo [chassi=" + chassi + ", modelo=" + modelo + ", placa=" + placa +
                ", categoria=" + categoria + ", arCondicionado=" + arCondicionado +
                ", direcaoHidraulica=" + direcaoHidraulica + ", anoFabricacao=" +
                anoFabricacao + ", anoModelo=" + anoModelo + ", kmInicial=" +
                kmInicial + ", kmFinal=" + kmFinal + ", status=" + status +
                ", diaria=" + diaria + "]";
    }
}
