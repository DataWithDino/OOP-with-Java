package piggybank;

public class Piggybank {
    String name;
    String color;
    private int savings;

    //Konstruktoren sind Methoden!
    //Default Konstruktor
    Piggybank(){
        savings = 0;
    }
    //Benutzerdefinierter Konstruktor
    Piggybank(String bankName,String bankColor,int bankSavings){
        //Die Variablen der Klasse krieger die Parameter vom Konstruktor zugewiesen
        name=bankName;
        color=bankColor;
        savings=bankSavings;
    }

    //Eleganter wäre es mit "this."
    /*
    Piggybank(String name,String color,int savings){
        //this. bezieht sich auf die Variablen der Klasse
        //Die Variablen kriegen die Parameter von dem Kontruktor zugewiesen
        this.name=name;
        this.color=color;
        this.savings=savings;
    }
    */

    void addSavings (int anzahl){
    savings=savings+(anzahl*2);
    }

    void takeMoney (int anzahl){
        savings=savings-(anzahl*2);
    }
    int getAmmount(){
        return savings;
    }

    public static void main(String[] args) {
        //Zuweisung von Variablen zum Default Konstruktor
        Piggybank bank1 = new Piggybank();
        bank1.name="Dino";
        bank1.color= "red";
        bank1.savings=20;
        System.out.println(bank1.getAmmount()); // dadurch, dass es eine void main Methode ist, brauchen wir print
        bank1.addSavings(5);
        System.out.println(bank1.getAmmount());
        bank1.takeMoney(5);
        System.out.println(bank1.getAmmount());

        //Default Konstruktor
        Piggybank bank2 = new Piggybank();
        System.out.println(bank2.getAmmount());

        //Benutzerdefinierter Konstruktor
        Piggybank bank3 = new Piggybank("Mina","purple", 1000000);
        System.out.println(bank3.name);
        System.out.println(bank3.savings);
    }
}
