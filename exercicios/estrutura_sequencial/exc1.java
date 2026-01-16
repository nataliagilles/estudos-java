package exercicios.estrutura_sequencial;


import java.util.Scanner;

public class exc1 {
    public static void main(String[] args){
    
    /**Faça um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses números com uma
mensagem explicativa, conforme exemplos. */
        
    Scanner sc= new Scanner(System.in);

    int a, b;
    System.out.println("Digite um número inteiro");
    a= sc.nextInt();
    System.out.println("Digite outro número inteiro");
    b= sc.nextInt();
    
    int soma = a + b;
    System.out.println("Soma" + soma);

    sc.close();

    }
}
