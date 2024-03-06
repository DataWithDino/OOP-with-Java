package time;

public class Time {
    private int seconds;

    Time(){   //Default Konstruktor
        seconds=0;
    }
    Time(int seconds){   //Custom-Konstruktor
        this.seconds = seconds; //this. bezieht sich auf die Variable der Klasse, die den Parameter zugewiesen bekommt.
    }
    int getSeconds(){
        return seconds%60;
    }
    int getMinutes(){
        return (seconds % 3600) / 60;
    }
    int getHours(){
        return (seconds % 86400) / 3600;
    }
    int getTimeSeconds(){
        return seconds;
    }
    int diff(Time other){
        if (other == null) {
            return -1;
        }
        return Math.abs(this.seconds - other.seconds);
    }
    boolean equals(Time other){
        if (other == null) {
            return false;
        }
        if(this.seconds == other.seconds){
            return true;
        }
        else{
            return false;
        }
    }
    @Override public String toString(){
        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
        //"%02d"Platzhalter für Int
        /*String.format ist eine Methode aus der Klasse String(integriert in Java), die erlaubt
          formatierte Zeichenketten zu erstellen, die als Output ausgegeben werden.
          Man kann die Zeichenkette mit Platzhaltern für verschiedene Datentypen manipulieren
        */
    }

    public static void main(String[] args) {
        System.out.println(new Time().toString());
        System.out.println(new Time(59).toString());
        System.out.println(new Time(200).toString());
        System.out.println(new Time(9023876).toString());
        System.out.println(new Time(60).toString());
        System.out.println(new Time(3600 * 24 + 1).toString());

        System.out.println("_________________");
        Time time1 = new Time(300); // 10:37:56
        System.out.println(time1.diff(new Time(100)));
        System.out.println(time1.equals(new Time(300)));
        System.out.println(time1.equals(new Time(100)));
    }
}

