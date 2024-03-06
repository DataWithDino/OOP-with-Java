package a3;

/**
 * Enum für Flugklassen mit Preisfaktor.
 * In diesem Enum müssen keine Änderungen gemacht werden.
 */
enum FlightClass {

	ECONOMY(0.1), BUSINESS(0.2), FIRST(0.3);
	
	private final double factor;

	FlightClass(double factor) {
		this.factor = factor;
	}

	double getFactor() {
		return factor;
	}
	
}
