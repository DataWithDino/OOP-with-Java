package a1;

import java.util.Objects;

public class Address {

    private final String street;
    private final int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Address address = (Address) obj;
        return number == address.number &&
                Objects.equals(street, address.street);
    }

}
