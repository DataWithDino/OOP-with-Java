package a3;

/**
 * Klasse für Liedzeilen.
 * Hier sind keine Änderungen notwendig.
 */
public class Line {

    private final String line;

    public Line(String line) {
        if (line == null || line.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.line = line;
    }

    @Override
    public String toString() {
        return line;
    }
}
