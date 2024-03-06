package a1;

import java.util.Objects;

public class Office extends Room {

    private final String department;
    private final Address address;

    public Office(String department, String roomNr, String street, int number) {
        super(roomNr);
        this.address = new Address(street, number);
        this.department = department;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Office office = (Office) obj;
        return Objects.equals(department, office.department) &&
                Objects.equals(address, office.address);
    }
}
