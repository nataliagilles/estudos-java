/** para fazer entrada de dados
     1º import
     2º declarar a variavel scanner sc
      3° já colocar o close para encerrar
      4º montar a variavel
  * */

import java.util.Scanner;

public class entradadados {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String x;
        x= sc.next();
        System.out.println("Você digitou " + x);

        sc.close();
        
        //ler um número inteiro
        int y;
        y= sc.nextInt();
        System.out.println("Você digitou " + y);

        sc.close();

        
        //ler um número de ponto flutuante     
        double z;
        z= sc.nextDouble();
        System.out.println("Você digitou " + z);

        sc.close();

        //ler varios dados na mesma linha
        int a;
        double b; 
        String c;
        
        a= sc.nextInt();
        b= sc.nextDouble();
        c= sc.next();

        System.out.println("Você digitou:");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        sc.close();         

    
    }
}   
