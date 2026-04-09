package ContactManager.model;

import java.io.Serializable;

public class Especialidade implements Serializable {
    private static final long serialVersionUID = 1L;

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