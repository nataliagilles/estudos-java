package exercicios.poo.application;

import java.util.Locale;
import java.util.Scanner;


import exercicios.poo.entities.Students;

public class ProgramStudents {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);

        Students students= new Students();

        students.name= sc.nextLine();
        students.grade1= sc.nextDouble();
        students.grade2= sc.nextDouble();
        students.grade3= sc.nextDouble();

        System.out.printf("FINAL GRADE: %.2f%n", students.Gradefinal());
        
        if (students.Gradefinal() < 60.0){
            System.out.println("Reprovado");
            System.out.printf("Resultado %.2f%n", students.resultado());
        } else{
            System.out.println("Aprovado!");
        }
        sc.close();
    
    }
}
