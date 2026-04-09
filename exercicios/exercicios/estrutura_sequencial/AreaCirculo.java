package exercicios.estrutura_sequencial;


import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args){

    Scanner sc= new Scanner(System.in);
    
    Double a;
    System.out.println("Digite o valor do raio do circulo");
    a= sc.nextDouble();
    
    Double quadrado= a * a;

    double x, area;
    x= 3.14159 ;
    area= x * quadrado;
    System.out.printf("A área do circulo é %.4f%n", area);

    sc.close();

    
    }
}
