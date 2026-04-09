package exercicios.laco_repeticao;

import java.util.Scanner;

public class PesquisaCombustivel {
	public static void main(String[] args) {
  
    Scanner sc= new Scanner(System.in);

    int alcool= 0;
    int gasolina= 0;
    int diesel= 0;

    int escolha= sc.nextInt();

    while (escolha != 4){
        if(escolha == 1){
            alcool++;
        }else if(escolha == 2 ){
            gasolina++;
        }else if(escolha == 3){
            diesel++;
        }
        
        escolha= sc.nextInt();
    }
    System.out.println("Muito obrigado");
    System.out.println("Álcool: " +alcool);
    System.out.println("Gasolina: " +gasolina);
    System.out.println("Diesel: "+ diesel);

    sc.close();
    
    }
}
