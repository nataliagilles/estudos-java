package exercicio_logica;

import java.util.Scanner;

public class exc4 {
    public static void main(String[] args){
    /**Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
    hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
    decimais.
    Exemplos:
    Entrada: Saída:
    25
    100
    5.50
    NUMBER = 25
    SALARY = U$ 550.00 */
    
    Scanner sc= new Scanner(System.in);

    int num_funcionario, hora_trabalhada;
    Double valor_hora;
    
    System.out.println("Digite o número do funcionário:");
    num_funcionario= sc.nextInt();
    
    System.out.println("Digite as horas trabalhadas do funcionário:");
    hora_trabalhada= sc.nextInt();

    System.out.println("Digite o valor por hora funcionário:");
    valor_hora= sc.nextDouble();

    Double salario= hora_trabalhada * valor_hora;
    
    System.out.printf("O funcionário número"+ num_funcionario + "tem o salário %.2f%n", salario);

    sc.close();

    }   
}
