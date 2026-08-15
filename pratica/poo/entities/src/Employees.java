package exercicios.poo.entities;

public class Employees {
    public String nome;
    public double salario;
    public double taxa;

    public double salario_liquido(){
        return salario - taxa;
    }

    public void aumento_salario(double porcentagem){
        salario += salario * porcentagem/ 100.0; 
    }
    public String toString(){
        return nome + ", $" + String.format("%.2f", salario_liquido());

    }




}
