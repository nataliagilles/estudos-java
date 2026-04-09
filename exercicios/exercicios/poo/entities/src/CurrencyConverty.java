package exercicios.poo.entities;

public class CurrencyConverty {
    public static final double IOF = 0.06;

    public double Pagar(double cotacao, double dolares){
        double total= cotacao * dolares;
        return total += total * IOF;
    }
}
