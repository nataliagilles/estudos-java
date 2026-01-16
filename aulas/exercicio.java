void main(){
    String product1= "Computer";
    String product2= "Office desk";

    int age= 30;
    int code= 5290;
    char gender= 'F';

    double price1= 2100.0;
    double price2= 650.50;
    double measure= 53.234567;

    System.out.println("Produtcs");
    System.out.printf("%s, wich price is %.2f%n", product1, price1);
    System.out.printf("%s, wich price is %.2f%n", product2, price2);
    System.out.println();
    System.out.printf("Record %d years old, code %d and gender %c%n", age, code, gender);
    System.out.println();
    System.out.printf("Mouse with eigth decimal places %.8fn", measure);
    System.out.printf("Rouded (three decimal places):%3.f%n", measure);
    Locale.setDefault(Locale.US);
    System.out.printf("US decimal point: %.3f%n", measure);

}