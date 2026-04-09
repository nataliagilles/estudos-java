package ContactManager.repository;

import java.util.HashMap;
import java.util.Map;

import ContactManager.model.Contato;

public class ContatoRepository {

    private Map<String, Contato> contatos = new HashMap<>();

    public boolean salvar(Contato contato) {
        if (contatos.containsKey(contato.getEmail())) {
            return false;
        }
        contatos.put(contato.getEmail(), contato);
        return true;
    }

    public Contato buscarPorEmail(String email) {
        return contatos.get(email);
    }

    public boolean remover(String email) {
        return contatos.remove(email) != null;
    }

    public Map<String, Contato> listarTodos() {
        return contatos;
    }
}