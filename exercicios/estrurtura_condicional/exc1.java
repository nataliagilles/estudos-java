package exercicios.estrurtura_condicional;

import java.util.Scanner;
public class exc1 {
    public static void main(String[] args){

    Scanner sc= new Scanner(System.in);
    
    int num;
    System.out.println("Digite um número inteiro:");
    num= sc.nextInt();

    if(num % 2 == 0){
        System.out.println(num+ " É um número PAR");

    }
    else{
        System.out.println(num + " É um número ÍMPAR");
    }

    sc.close();
    }
}
