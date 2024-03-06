package a1;

import java.util.Objects;

public class Room {

    private final String roomNr;

    public Room(String roomNr) {
        this.roomNr = roomNr;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Room room = (Room) obj;
        return Objects.equals(roomNr, room.roomNr);
    }
}