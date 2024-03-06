package a3;

/**
 * Klasse zur Repräsentation von Flughäfen.
 * In dieser Klasse müssen keine Änderungen gemacht werden!
 */
public class Airport {

    /** Name des Flughafens */
	private String name;

    /**
     * Custom-Kontruktor für Flughafen
     * @param name Name des Flughafens
     */
	public Airport(String name) {
		this.name = name;
	}

    /**
     * Getter für den Namen des Flughafens.
     * @return Name des Flughafens
     */
	public String getName() {
	    return name;
    }
	
	@Override
	public String toString() {
		return name;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airport airport = (Airport) o;
        return getName().equals(airport.getName());
    }


}
