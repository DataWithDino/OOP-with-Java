public class Beispiel {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Einlesen eines int-Werts an der Stelle 0 im String-Array args
        int intValue = Integer.parseInt(args[0]);

        // Einlesen eines double-Werts an der Stelle 1 im String-Array args
        double doubleValue = Double.parseDouble(args[1]);

        // Einlesen eines Strings an der Stelle 2 im String-Array args
        String stringValue = args[2];

        // Einlesen eines Charakters an der Stelle 0 des Strings an der Stelle 3 im String-Array args
        char charValue = args[3].charAt(0);

        System.out.println(intValue + " " + doubleValue + " " + stringValue + " " + charValue);

        // Einfache Ausgabe von Werten
        System.out.println("Das ist ein Beispieltext, der auf der Kommandozeile ausgegeben wird. Am Ende wird eine neue Zeile angehängt.");
        System.out.print("Das ist ein Beispieltext, der auf der Kommandozeile ausgegeben wird. Am Ende gibt es keine neue Zeile.");
        System.out.println("Das " + "ist" + "ein" + "Beispiel" + "wie man mehrere" + "Strings zu einem String zusammenhängen kann.");
        System.out.println("Noch " + " besser, " + " wenn " + " man " + " die Leerzeichen " + " mit berücksichtigt.");

        // String-Konkatenation bei der Ausgabe
        System.out.println("Das ist eine " + 2);
        System.out.println("Die " + 3 + " folgt darauf");
        System.out.println(4 + " und " + 5 + " sind die nächsten in der Reihe");

        // Verknüpfung von Strings und Variablen in der Ausgabe
        int value1 = 2 + 2;
        double value2 = 3.0;
        String value3 = "Hello World";
        System.out.println("Der Wert der Variable value1 ist: " + value1 + ".");
        System.out.println("Der Wert der Variable value2 ist dagegen: " + value2 + ".");
        System.out.println(value3);

        // Formatierte Ausgabe von Werten
        System.out.printf("%5d%n", 3); // Fünf Stellen Platz, rechtsbündig
        System.out.printf("%06.2f%n", 3.0);
        System.out.printf("%s%n", "Hello World");

        // Formatierung von komplexen Ausgaben
        int first = 2;
        int second = 2;
        System.out.printf("Die Summe von %d und %d ist: %d%n", first, second, first + second);
        System.out.printf("Die Zahl PI gekürzt auf die ersten drei Stellen hinter dem Komma: %.3f%n", Math.PI);

        // Die Formatierung lässt sich auch für die Klasse String verwenden (in diesem Fall String.format):
        String s1 = String.format("*%-5d*", 3); // Fünf Stellen Platz, linksbündig
        System.out.println(s1);

        String s2 = String.format("*%06.2f*", 3.0); // Sechs Stellen Platz, zwei Stellen hinter dem Komma, vorne mit 0 aufgefüllt.
        System.out.println(s2);
    }
}