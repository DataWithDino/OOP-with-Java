package timeinterval;

public class Time {
    private final int seconds;

    //Konstanten
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_DAY = 86400;
    Time(){   //Default Konstruktor
        seconds=0;
    }
    Time(int seconds){   //Custom-Konstruktor
        this.seconds = seconds; //this. bezieht sich auf die Variable der Klasse, die den Parameter zugewiesen bekommt.
    }
    Time(int hours, int minutes, int seconds){
        this.seconds=seconds + (minutes*SECONDS_PER_MINUTE) + (hours*SECONDS_PER_HOUR);
    }
    Time(int hours, int minutes){
        int sekunden=0;
        this.seconds=sekunden + (minutes*SECONDS_PER_MINUTE) + (hours*SECONDS_PER_HOUR);
    }
    Time (Time other){
        this.seconds=other.seconds;
    }
    int getSeconds(){
        return seconds%SECONDS_PER_MINUTE;
    }
    int getMinutes(){
        return (seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
    }
    int getHours(){
        return (seconds % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
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

        System.out.println("_________________");
        System.out.println(new Time(2, 0, 0).toString());
        System.out.println(new Time(26, 0, 0).toString());
        System.out.println(new Time(24, 0, 0).toString());
        System.out.println(new Time(25, 60, 60).toString());
        System.out.println(new Time(25, 60).toString());
        Time time = new Time(2, 0);
        Time copy = new Time(time);
        copy.toString();
        System.out.println(copy);
    }
}
