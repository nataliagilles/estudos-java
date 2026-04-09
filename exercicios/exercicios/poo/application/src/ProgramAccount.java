package exercicios.poo.application;

import exercicios.poo.entities.Account;
import java.util.Locale;
import java.util.Scanner;

public class ProgramAccount {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);
        Account account;

        System.out.print("Insira o número da conta:");
        int numero= sc.nextInt(); 
        System.out.println("Insira o nome do tiular da conta:");
        sc.nextLine();
        String titular= sc.nextLine();
        System.out.println("Será realizado um depósito?(s/n):");
        char response= sc.next().charAt(0);
        if (response == 's'){
            System.out.println("Insira o valor do depósito:");
            double depositoInicial = sc.nextDouble(); 
            account= new Account(numero, titular, depositoInicial);   
        } else{
            account= new Account(numero, titular);
        }

        System.out.println();
        System.out.print("Dados da conta:");
        System.out.println(account);
        

        System.out.println();
        System.out.print("Digite um valor para depósito: ");
        double valorDeposito= sc.nextDouble();
        account.deposito(valorDeposito);
        System.out.println("Dados da conta Atualizado");
        System.out.println(account);


        System.out.println();
        System.out.print("Digite um valor para saque: ");
        double valorSaque= sc.nextDouble();
        account.saque(valorSaque);
        System.out.println("Dados da conta Atualizado");
        System.out.println(account);


        sc.close();
    }
}