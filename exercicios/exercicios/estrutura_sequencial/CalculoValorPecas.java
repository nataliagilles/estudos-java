package exercicios.estrutura_sequencial;

import java.util.Scanner;

public class CalculoValorPecas {
    public static void main(String[] args){
    
    Scanner sc= new Scanner(System.in);
    
    int cod_1, cod_2, num_1, num_2; 
    Double valoruni_1, valoruni_2;

    /** ----------------------peça 1---------------------------------------- */
    System.out.println("Digite o código da primeira peça:");
    cod_1= sc.nextInt();
    System.out.println("Digite o número de peças:");
    num_1= sc.nextInt();
    System.out.println("Digite o valor por unidade:");
    valoruni_1= sc.nextDouble();

    /** ----------------------peça 2---------------------------------------- */
    System.out.println("Digite o código da segunda peça:");
    cod_2= sc.nextInt();
    System.out.println("Digite o número de peças:");
    num_2= sc.nextInt();
    System.out.println("Digite o valor por unidade:");
    valoruni_2= sc.nextDouble();

    Double valor_peca1= num_1 * valoruni_1;
    Double valor_peca2= num_2 * valoruni_2;

    Double total= valor_peca1 + valor_peca2;
    
    System.out.println("Códigos das peças:"+ cod_1 + cod_2);
    System.out.printf("Valor a pagar: R$ %.2f%n", total);

    sc.close();

    
    }   
}
