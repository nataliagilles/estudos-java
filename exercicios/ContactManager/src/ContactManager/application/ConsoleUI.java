package ContactManager.application;

import ContactManager.model.Contato;
import ContactManager.model.Especialidade;
import ContactManager.service.ContatoService;
import ContactManager.util.Validador;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;
    private final ContatoService service;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.service = new ContatoService();
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Buscar por email");
        System.out.println("3 - Listar todos");
        System.out.println("4 - Remover contato");
        System.out.println("5 - Buscar por especialidade");
        System.out.println("6 - Listar ordenado por nome");
        System.out.println("7 - Editar contato");
        System.out.println("0 - Sair");
    }

    private int lerOpcao() {
        System.out.print("Opção: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número.");
            scanner.next(); // descarta entrada inválida
            System.out.print("Opção: ");
        }
        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpa buffer
        return opcao;
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> adicionarContato();
            case 2 -> buscarPorEmail();
            case 3 -> listarTodos();
            case 4 -> removerContato();
            case 5 -> buscarPorEspecialidade();
            case 6 -> listarOrdenadoPorNome();
            case 7 -> editarContato();
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida.");
        }
    }

    // ========= Métodos de cada caso =========

    private void adicionarContato() {
        String nome = lerNome();
        String email = lerEmailUnico();
        LocalDate nascimento = lerDataNascimento();

        Contato contato = new Contato(nome, email, nascimento);

        int qtd = lerQuantidadeEspecialidades();
        for (int i = 0; i < qtd; i++) {
            Especialidade esp = lerEspecialidade();
            contato.adicionarEspecialidade(esp);
        }

        if (service.adicionarContato(contato)) {
            System.out.println("Contato cadastrado com sucesso!");
        } else {
            System.out.println("Erro: email já cadastrado."); // Caso raro, pois já validamos
        }
    }

    private void editarContato() {
        System.out.print("Digite o email do contato que deseja editar: ");
        String email = scanner.nextLine();

        Optional<Contato> optional = service.buscarPorEmail(email);
        if (optional.isEmpty()) {
            System.out.println("Contato não encontrado.");
            return;
        }

        Contato contatoExistente = optional.get();
        System.out.println("\n--- Dados atuais ---");
        System.out.println(contatoExistente);
        System.out.println("--- Digite os novos dados ---");

        String novoNome = lerNome();
        LocalDate novaData = lerDataNascimento();

        Contato contatoAtualizado = new Contato(novoNome, email, novaData);

        int qtd = lerQuantidadeEspecialidades();
        for (int i = 0; i < qtd; i++) {
            Especialidade esp = lerEspecialidade();
            contatoAtualizado.adicionarEspecialidade(esp);
        }

        if (service.atualizarContato(contatoAtualizado)) {
            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar contato.");
        }
    }

    private void buscarPorEmail() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Optional<Contato> optional = service.buscarPorEmail(email);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void listarTodos() {
        List<Contato> todos = service.listarTodos();
        if (todos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            todos.forEach(System.out::println);
        }
    }

    private void removerContato() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (service.remover(email)) {
            System.out.println("Contato removido!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void buscarPorEspecialidade() {
        System.out.print("Especialidade: ");
        String nomeEspecialidade = scanner.nextLine();
        List<Contato> resultados = service.buscarPorEspecialidade(nomeEspecialidade);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum contato com essa especialidade.");
        } else {
            resultados.forEach(System.out::println);
        }
    }

    private void listarOrdenadoPorNome() {
        List<Contato> ordenados = service.listarOrdenadoPorNome();
        if (ordenados.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            ordenados.forEach(System.out::println);
        }
    }

    // ========== Métodos auxiliares de leitura ========

    private String lerNome() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        while (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            System.out.print("Nome: ");
            nome = scanner.nextLine().trim();
        }
        return nome;
    }

    private String lerEmailUnico() {
        String email;
        boolean valido;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine().trim();
            valido = Validador.emailValido(email);
            if (!valido) {
                System.out.println("Email inválido. Use um formato válido (ex: nome@gmail.com).");
            } else {
                // Verifica se já existe
                if (service.buscarPorEmail(email).isPresent()) {
                    System.out.println("Este email já está cadastrado. Tente outro.");
                    valido = false;
                }
            }
        } while (!valido);
        return email;
    }

    private LocalDate lerDataNascimento() {
        int ano, mes, dia;
        ano = lerAno();
        mes = lerMes();
        dia = lerDia(ano, mes);
        return LocalDate.of(ano, mes, dia);
    }

    private int lerAno() {
        int ano;
        while (true) {
            System.out.print("Ano nascimento (4 dígitos): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número válido.");
                scanner.next();
            }
            ano = scanner.nextInt();
            scanner.nextLine();
            if (ano >= 1 && ano <= LocalDate.now().getYear()) {
                break;
            }
            System.out.println("Ano inválido. Digite um ano entre 1 e " + LocalDate.now().getYear() + ".");
        }
        return ano;
    }

    private int lerMes() {
        int mes;
        while (true) {
            System.out.print("Mês (1-12): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número.");
                scanner.next();
            }
            mes = scanner.nextInt();
            scanner.nextLine();
            if (mes >= 1 && mes <= 12) {
                break;
            }
            System.out.println("Mês inválido. Digite um valor entre 1 e 12.");
        }
        return mes;
    }

    private int lerDia(int ano, int mes) {
        int dia;
        while (true) {
            System.out.print("Dia: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número.");
                scanner.next();
            }
            dia = scanner.nextInt();
            scanner.nextLine();
            try {
                LocalDate.of(ano, mes, dia);
                break; 
            } catch (DateTimeException e) {
                System.out.println("Dia inválido para o mês informado. Digite novamente.");
            }
        }
        return dia;
    }

    private int lerQuantidadeEspecialidades() {
        int qtd;
        while (true) {
            System.out.print("Quantidade de especialidades: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número.");
                scanner.next();
            }
            qtd = scanner.nextInt();
            scanner.nextLine();
            if (qtd >= 0) {
                break;
            }
            System.out.println("Quantidade deve ser maior ou igual a zero.");
        }
        return qtd;
    }

    private Especialidade lerEspecialidade() {
        System.out.print("Nome da especialidade: ");
        String nome = scanner.nextLine().trim();
        while (nome.isEmpty()) {
            System.out.println("Nome da especialidade não pode ser vazio.");
            System.out.print("Nome da especialidade: ");
            nome = scanner.nextLine().trim();
        }

        double valor;
        while (true) {
            System.out.print("Valor por hora: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Digite um valor numérico.");
                scanner.next();
            }
            valor = scanner.nextDouble();
            scanner.nextLine();
            if (valor >= 0) {
                break;
            }
            System.out.println("Valor deve ser maior ou igual a zero.");
        }
        return new Especialidade(nome, valor);
    }
}