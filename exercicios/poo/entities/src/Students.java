package exercicios.poo.entities;

public class Students {
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;

    public double Gradefinal(){
        return grade1+ grade2 + grade3;
    }
    public double resultado(){
        if (Gradefinal() < 60.0){
            return 60.0- Gradefinal();
        }else{
            return 0.0;
        }
    }  
}
