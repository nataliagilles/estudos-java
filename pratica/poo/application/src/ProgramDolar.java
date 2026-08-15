package exercicios.poo.application;

import java.util.Locale;
import java.util.Scanner;
import exercicios.poo.entities.CurrencyConverty;

public class ProgramDolar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);  
        
        CurrencyConverty converter= new CurrencyConverty();

        System.out.print("Qual é o valor do dolar?:");
        double dolar_valor= sc.nextDouble();

        System.out.print("Qual é o valor que irá comprar de dolar em reais?:");
        double comprar= sc.nextDouble();

        double total= converter.Pagar(comprar, dolar_valor);

        System.out.printf("Valor a ser pago em reais = %.2f%n", total);

        sc.close();
    }

}
