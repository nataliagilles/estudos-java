package exercicios.estrurtura_condicional;
import java.util.Scanner;
public class exc2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.println("Digite um número inteiro:");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("Número negativo");
        } else {
            System.out.println("Número não é negativo");
        }

        sc.close();
    }
}


