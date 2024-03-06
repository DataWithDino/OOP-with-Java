package queue;
class Customer {
    //Objektvariablen
    private final String name;
    private Customer next;
    //Konstruktor
    Customer(String name){
        this.name=name;
        this.next= null;
    }
    //Methoden
    String getName(){
        return name;
    }
    Customer getNext(){
        return next;
    }
    public void setNext(Customer next){
        //der übergebene Kunde(Kunden-Objekt), wird der nächste Kunde
        this.next=next;
    }
}
