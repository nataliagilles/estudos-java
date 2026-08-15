package exercicios.estrutura_sequencial;


import java.util.Scanner;

public class DiferencaProdutos {
    public static void main(String[] args){

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
