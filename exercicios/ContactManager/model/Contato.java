package ContactManager.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contato {

    private String nome;
    private String email;
    private LocalDate nascimento;
    private List<Especialidade> especialidades = new ArrayList<>();

    public Contato(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void adicionarEspecialidade(Especialidade esp) {
        especialidades.add(esp);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nEmail: " + email +
                "\nNascimento: " + nascimento +
                "\nEspecialidades: " + especialidades + "\n";
    }
}