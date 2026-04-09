package exercicios.estrutura_sequencial;


import java.util.Scanner;

public class SalarioFuncionario {
    public static void main(String[] args){
    
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
