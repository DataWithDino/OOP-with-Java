package kw43.ggtkgv;
public class GgtKgv {

    private int getGgt(final int a, final int b) {
        // TODO: Ergänzen Sie hier die Berechnung des Ggt für die Werte a und b.
        int ggtA = Math.abs(a); //Deklaration, da final int keine Rechnung erlaubt
        int ggtB = Math.abs(b); //Math.abs verwandelt negative Zahlen in positive

        if (a == 0) {
            return b;
        } else {
            while (ggtB != 0) {
                if (ggtA > ggtB) {
                    ggtA = ggtA - ggtB;
                } else {
                    ggtB = ggtB - ggtA;
                }
            }
        // TODO: Passen Sie entsprechend den return-Wert an.
        return ggtA;
            }
    }

    private int getKgv(final int a, final int b) {
        // TODO: Ergänzen Sie hier die Berechnung des Ggt für die Werte a und b.
        int kgv = (Math.abs(a) * Math.abs(b)) / getGgt(a, b);
        // TODO: Passen Sie entsprechend den return-Wert an.
        return kgv;
    }

    /**
     * Berechnet ggt und kgv für zwei eingegebene positive Integer.
     * Negative Werte werden in positive Werte umgewandelt.
     *
     * @param args zwei ganzzahlige Werte
     */
    public static void main(String[] args) {

        // Einlesen der Werte für a und b
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // Objekt zur Klasse initialisieren
        GgtKgv ggtKgv = new GgtKgv();

        // Aufruf der Methoden und formatierte Ausgabe
        System.out.printf("Ggt von %d und %d: %d%n", a, b, ggtKgv.getGgt(a, b));

        // TODO: Ergänzen Sie hier die Ausgabe für den Kgv der beiden Werte.
        System.out.printf("Kgv von %d und %d: %d%n", a, b, ggtKgv.getKgv(a, b));
    }

}

