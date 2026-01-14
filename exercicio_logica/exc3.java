package exercicio_logica;

import java.util.Scanner;

public class exc3 {
    public static void main(String[] args){
    /**Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto
    de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D). 
        Exemplos:
        Entrada: Saída:
        5
        6
        7
        8
        DIFERENCA = -26 */
    
        Scanner sc= new Scanner(System.in);
        
        int a,b,c,d; 
        System.out.println("Digite quatro valores inteiros:");
        a= sc.nextInt();
        b= sc.nextInt();
        c= sc.nextInt();
        d= sc.nextInt();

        int diferenca= a*b - c*d;
        System.out.println("A diferenca é" + diferenca);

        sc.close();



    
    
    
    
    
    } 
}
