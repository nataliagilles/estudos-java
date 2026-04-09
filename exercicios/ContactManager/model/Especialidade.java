package ContactManager.model;

public class Especialidade {

    private String nome;
    private double valorHora;

    public Especialidade(String nome, double valorHora) {
        this.nome = nome;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + valorHora + "/hora)";
    }
}