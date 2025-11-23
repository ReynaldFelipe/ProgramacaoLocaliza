package Projeto_Localiza.Entidades;

public class Funcionario {
    private String nome;
    private String cpf;
    private String endereco;
    private String matricula;
    private String cargo;
    private String email;

    public Funcionario(String nome, String cpf, String endereco, String matricula, String cargo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.matricula = matricula;
        this.cargo = cargo;
        this.email = email;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", cpf=" + cpf +
               ", endereco=" + endereco + ", matricula=" + matricula +
               ", cargo=" + cargo + ", email=" + email + "]";
    }
}
