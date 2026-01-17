package exercicios.estrurtura_condicional;

import java.util.Scanner;

public class exc4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hr_inicio = sc.nextInt();
        int hr_final = sc.nextInt();
        int duracao;

        if (hr_inicio == hr_final) {
            duracao = 24;
        } else if (hr_final > hr_inicio) {
            duracao = hr_final - hr_inicio;
        } else {
            duracao = (24 - hr_inicio) + hr_final;
        }

        System.out.println("O JOGO DUROU " + duracao + " HORA(S)");

        sc.close();
    }
}
