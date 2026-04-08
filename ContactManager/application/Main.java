package ContactManager.application;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.List;
import java.util.Scanner;

import ContactManager.model.Contato;
import ContactManager.model.Especialidade;
import ContactManager.service.ContatoService;
import ContactManager.util.Validador;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContatoService service = new ContatoService();

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Buscar por email");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Remover contato");
            System.out.println("5 - Buscar por especialidade");
            System.out.println("6 - Listar ordenado por nome");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    String email;
                    do {
                        System.out.print("Email: ");
                        email = sc.nextLine();

                        if (!Validador.emailValido(email)) {
                            System.out.println("Email inválido.");
                        }

                    } while (!Validador.emailValido(email));

                    int ano;
                    do {
                        System.out.print("Ano nascimento (4 dígitos): ");
                        ano = sc.nextInt();
                        if (ano < 1 || ano > 2026) {
                            System.out.println("Ano inválido. Digite um ano entre 1 e 2026.");
                        }
                    } while (ano < 1 || ano > 2026);

                    int mes;
                    do {
                        System.out.print("Mês: ");
                        mes = sc.nextInt();
                        if (mes < 1 || mes > 12) {
                            System.out.println("Mês inválido. Digite um valor entre 1 e 12.");
                        }
                    } while (mes < 1 || mes > 12);

                    int dia;
                    while (true) {
                        System.out.print("Dia: ");
                        dia = sc.nextInt();
                        try {
                            LocalDate.of(ano, mes, dia);
                            break; 
                        } catch (DateTimeException e) {
                            System.out.println("Dia inválido para o mês informado. Digite novamente.");
                        }
                    }
                    sc.nextLine(); 

                    Contato contato = new Contato(nome, email, LocalDate.of(ano, mes, dia));

                    System.out.print("Quantidade de especialidades: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Nome da especialidade: ");
                        String espNome = sc.nextLine();

                        System.out.print("Valor por hora: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        contato.adicionarEspecialidade(new Especialidade(espNome, valor));
                    }

                    if (service.adicionarContato(contato)) {
                        System.out.println("Contato cadastrado!");
                    } else {
                        System.out.println("Email já existente.");
                    }
                    break;

                case 2:
                    System.out.print("Email: ");
                    Contato encontrado = service.buscarPorEmail(sc.nextLine());
                    System.out.println(encontrado != null ? encontrado : "Contato não encontrado.");
                    break;

                case 3:
                    List<Contato> todos = service.listarTodos();
                    if (todos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        todos.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Email: ");
                    if (service.remover(sc.nextLine())) {
                        System.out.println("Removido!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Especialidade: ");
                    List<Contato> porEspecialidade = service.buscarPorEspecialidade(sc.nextLine());
                    if (porEspecialidade.isEmpty()) {
                        System.out.println("Nenhum contato com essa especialidade.");
                    } else {
                        porEspecialidade.forEach(System.out::println);
                    }
                    break;

                case 6:
                    List<Contato> ordenados = service.listarOrdenadoPorNome();
                    if (ordenados.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        ordenados.forEach(System.out::println);
                    }
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
