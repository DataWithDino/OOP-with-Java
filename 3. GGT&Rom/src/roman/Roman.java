package kw43.roman;

public class Roman {

    private static final String[] ROMAN = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static final int[] ARABIC =   {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String getRoman(int value) {

        // Platzhalter für römische Darstellung der Zahl.
        String result = "";

        // Hilfsvariable zur Erhaltung des ursprünglichen Arguments value (saubere Programmierung).
        int tmp = value;

        //Die Bedingung war falsch. Die Schleife ist weitergelaufen auch, wenn die römische Zahl nicht erfüllt war.
        //Jetzt läuft die Schleife bis man keine positive Zahl mehr repräsentieren soll.
        //Die Schleife checkt ob value größer oder gleich der römischen Zahlt ist.
        //Wenn ja ---> append
        //Wenn nein ---> for-loop geht zur nächsten kleineren rom. Zahl
        // Schleife über die arabischen Zahlen beginnend bei 1000
        for (int j = ARABIC.length - 1; j >= 0;) {

            // Solange die arabische Zahl vollständig in tmp passt
            if (tmp >= ARABIC[j]) {

                // Hänge das entsprechende römische Zeichen hinten an das result an.
                result += ROMAN[j];

                // Ziehe die arabische Zahl von tmp ab.
                tmp -= ARABIC[j];
            }
            else{
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Wert für positiven Integer einlesen
        int arabicValue = Integer.parseInt(args[0]);
        if (arabicValue <= 0) {
            System.out.println("Eingabe fehlerhaft");
            return;
        }
        // Aufruf der Methode zur Berechnung der römischen Zahl.
        String result = new Roman().getRoman(arabicValue);
        System.out.printf("%d: %s%n", arabicValue, result);
    }

}
