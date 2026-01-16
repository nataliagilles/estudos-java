package exercicios.estrutura_sequencial;

import java.util.Scanner;

public class exc5 {
    public static void main(String[] args){
    /**Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
    código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago.
    Exemplos:
    Entrada: Saída:
    12 1 5.30
    16 2 5.10
    VALOR A PAGAR: R$ 15.50 */
    
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
