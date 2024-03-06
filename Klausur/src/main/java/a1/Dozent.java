package a1;

import java.util.Objects;

public class Dozent extends Person {

    private final Office office;

    public Dozent(String name, String dept, String roomNr, String street, int number) {
        super(name);
        this.office = new Office(dept, roomNr, street, number);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Dozent dozent = (Dozent) obj;
        return Objects.equals(office, dozent.office);
    }
}
