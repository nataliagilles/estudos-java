package ContactManager.repository;

import ContactManager.model.Contato;
import ContactManager.util.ArquivoUtil;

import java.util.Map;

public class ContatoRepository {

    private Map<String, Contato> contatos;

    public ContatoRepository() {
        this.contatos = ArquivoUtil.carregar();
    }

    public boolean salvar(Contato contato) {
        if (contatos.containsKey(contato.getEmail())) {
            return false;
        }
        contatos.put(contato.getEmail(), contato);
        ArquivoUtil.salvar(contatos);
        return true;
    }

    public Contato buscarPorEmail(String email) {
        return contatos.get(email);
    }

    public boolean remover(String email) {
        boolean removido = contatos.remove(email) != null;
        if (removido) {
            ArquivoUtil.salvar(contatos);
        }
        return removido;
    }

    public Map<String, Contato> listarTodos() {
        return contatos;
    }

    // NOVO ATUALIZAR CONTATO
    public boolean atualizar(Contato contato) {
        if (contatos.containsKey(contato.getEmail())) {
            contatos.put(contato.getEmail(), contato);
            ArquivoUtil.salvar(contatos);
            return true;
        }
        return false;
    }
}