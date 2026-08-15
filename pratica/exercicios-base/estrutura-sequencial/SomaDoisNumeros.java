package exercicios.estrutura_sequencial;

import java.util.Scanner;

public class SomaDoisNumeros {
    public static void main(String[] args){
        
    Scanner sc= new Scanner(System.in);

    int a, b;
    System.out.println("Digite um número inteiro");
    a= sc.nextInt();
    System.out.println("Digite outro número inteiro");
    b= sc.nextInt();
    
    int soma = a + b;
    System.out.println("Soma=" + soma);

    sc.close();

    }
}
