package exercicios.estrutura_sequencial;


import java.util.Scanner;

public class exc2 {
    public static void main(String[] args){
    /**Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
    casas decimais conforme exemplos.
    Fórmula da área: area = π . raio2
    Considere o valor de π = 3.14159 */  
    
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
