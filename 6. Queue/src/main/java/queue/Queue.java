package queue;
public class Queue {
    private Customer head;
    private Customer tail;

    void add(Customer customer){
        //wenn Schlange leer, der Kunde ist gleichzeitig der erste und letzte Kunde
        if(isEmpty()){
            tail=customer;
            head=customer;
        }else{
            tail.setNext(customer);//Wenn Liste nicht leer, wird der übergebene Kunde "der nächste Kunde"
            tail=customer;         //also auch der letzte in der Schlange
        }
    }
    void insert(String name, Customer customer){
        if (name==null){//Wenn kein name übergeben wird, den kunden einfach hinzufügen
            add(customer);
            return;
        }
        if(isEmpty()){ //Wenn Schlange leer ist, Kunde einfach hinzufügen
            add(customer);
            return;
        }
        Customer currentCustomer = head;
        Customer previousCustomer = null;

        //dient zum Suchen vom Kunde mit dem Name name
        //Durchsuchen der Schlange bis name auftaucht oder Schlange zu Ende ist
        while (currentCustomer != null && currentCustomer.getName()!=name) {
            previousCustomer = currentCustomer;
            currentCustomer = currentCustomer.getNext();
        }

        if (currentCustomer != null) { // wenn der Kunde mit dem Namen name gefunden wurde
            if (previousCustomer != null) {//wenn der gefundene Kunde nicht der erste ist
                // Insert in the middle of the queue
                previousCustomer.setNext(customer);
                customer.setNext(currentCustomer);
            } else {// Der gefundene Kunde ist der erste in der Warteschlange
                //der "alte" erste Kunde(head) hinter dem neuen Kunden platziert
                //In dem der Next-Zeiger von dem neuen Kunden auf den "alter" ersten Kunden zeigt
                customer.setNext(head);
                head = customer;//Der neue Kunde steht am Anfang der Warteschlange
            }
        } else {
            add(customer);// Wenn kein Kunde mit name gefunden wird, einfach den neuen Kunden hinzufügen
        }
    }

    Customer remove(){
        //entfernt ersten Kunden
        if(isEmpty()){
            return null;
        }
        //Der entfernte Kunde ist der erste
        Customer removedCustomer = head;
        head=head.getNext();//Der neue "erster Kunde" wird der nächste(2.) Kunde
        if(head==null){
            tail=null; //wenn der erste Kunde null ist, ais auch der letzte null
        }
        return removedCustomer;
    }
    Customer remove (String name){
        if (isEmpty()) {
            return null;
        }
        Customer currentCustomer = head;
        Customer previousCustomer = null;

        //dient zum Suchen vom Kunde mit dem Name name
        //Durchsuchen der Schlange bis name auftaucht oder Schlange zu Ende ist
        while (currentCustomer != null && currentCustomer.getName()!=name) {
            previousCustomer = currentCustomer;
            currentCustomer = currentCustomer.getNext();
        }


        if (currentCustomer != null) {//Wenn der Kunde gefunden wurde
            if (previousCustomer != null) {//wenn der gefundene Kunde nicht der erste ist
                previousCustomer.setNext(currentCustomer.getNext());//"next-Zeiger" des vorherigen Kunden auf den "next-Zeiger" des gefundenen Kunden
                if (currentCustomer.getNext() == null) {//wenn der gefundene Kunde der letzte in der Warteschlange war
                    tail = previousCustomer;
                }
            } else {// Der gefundene Kunde ist der erste in der Warteschlange
                head = currentCustomer.getNext();//Der gefundene Kunde(also der erste Kunde) wird gelöscht und der nächste Kunde wird der neue "ester Kunde"
                if (head == null) {//Wenn der gefundene Kunde der alleine in der Schlange war
                    tail = null;   // wird die Schlange leer(tail)
                }
            }
            //der gefundene Kunde wird gelöscht, in dem sein Kundenobjekt next(Next-zeiger) auf null gesetzt wird
            currentCustomer.setNext(null);
            return currentCustomer;//gefundener und gelöschter Kunde
        } else {//kein Name wurde gefunden
            return null;
        }
    }
    @Override public String toString(){
        //Liste am Anfang leer
        String liste="";
        Customer currentCustomer = head;
        while (currentCustomer != null) {
            liste += currentCustomer.getName();
            //Wenn es einen weiteren Kunden gibt, braucht man ein Komma, ansonsten ist die Liste fertig
            if (currentCustomer.getNext() != null) {
                liste+=",";
            }
            //"currentC" wird der nächste Kunde
            currentCustomer = currentCustomer.getNext();
        }
        return liste;
    }
    boolean isEmpty() {
        //Wenn head und tail gleich null sind(also Schlange ist leer), gibt es TRUE zurück
        return this.head == null && this.tail == null;
    }
}
