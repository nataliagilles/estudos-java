package exercicios.estrurtura_condicional;

import java.util.Scanner;

public class exc6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valor = sc.nextDouble();
        
        String mensagem = 
            valor >= 0 && valor <= 25 ? "Intervalo [0,25]" :
            valor > 25 && valor <= 50 ? "Intervalo (25,50]" :
            valor > 50 && valor <= 75 ? "Intervalo (50,75]" :
            valor > 75 && valor <= 100 ? "Intervalo (75,100]" :
            "Fora de intervalo";
            
        System.out.println(mensagem);
        sc.close();
    }
}   
