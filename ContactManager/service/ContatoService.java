package ContactManager.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ContactManager.model.Contato;
import ContactManager.repository.ContatoRepository;

public class ContatoService {
    private ContatoRepository repository = new ContatoRepository();

    public boolean adicionarContato(Contato contato) {
        return repository.salvar(contato);
    }

    public Contato buscarPorEmail(String email) {
        return repository.buscarPorEmail(email);
    }

    public boolean remover(String email) {
        return repository.remover(email);
    }

    public List<Contato> listarTodos() {
        return new ArrayList<>(repository.listarTodos().values());
    }

    public List<Contato> listarOrdenadoPorNome() {
        return repository.listarTodos()
                .values()
                .stream()
                .sorted(Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Contato> buscarPorEspecialidade(String especialidade) {
        return repository.listarTodos()
                .values()
                .stream()
                .filter(contato ->
                        contato.getEspecialidades()
                                .stream()
                                .anyMatch(esp ->
                                        esp.getNome().equalsIgnoreCase(especialidade)))
                .collect(Collectors.toList());
    }
}