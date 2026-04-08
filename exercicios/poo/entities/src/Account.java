package exercicios.poo.entities;

public class Account {
   
   private int numero;
   private String titular;
   private double balance;

   public Account(int numero, String titular) {
    this.numero = numero;
    this.titular = titular;
   }

   public Account(int numero, String titular, double depositoInicial) {
    this.numero = numero;
    this.titular = titular;
    deposito(depositoInicial);
   }

   public int getNumero() {
    return numero;
   }

   public String getTitular() {
    return titular;
   }

   public void setTitular(String titular) {
    this.titular = titular;
   }

   public double getBalance() {
    return balance;
   }

   public void deposito(double quantia){
    balance += quantia;
   }

    public void saque(double quantia){
        balance -= quantia + 5.0;
   }

   public String toString(){
        return "Account"
                + numero
                +",Titular:"
                + titular
                +",Balance: $ "
                +String.format(":.2f", balance);
   }
}
