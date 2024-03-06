public class Weekdays_verbessert{
    public static void main(String[] args) {

        int day= Integer.parseInt(args[0]);
        int month= Integer.parseInt(args[1]);
        int year= Integer.parseInt(args[2]);
        zeller(day,month,year);
    }

    public static void zeller(int day, int month, int year){

        if(day>31 || day<1 || month>12 || month<1 || year>9999 || year<1000){
            System.out.println("Die Eingabewerte sind fehlerhaft");
            return;
        }

        if(month<=2){
            month+=12;
            year--;
        }

        int yearInc=year%100;
        int century = year / 100;
        int f= day+ (26*(month+1))/10 + 5*yearInc/4 + century/4 + 5*century -1 ;
        int w = f % 7;

        switch (w) {
            case 1:
                System.out.println("Montag");
                break;
            case 2:
                System.out.println("Dienstag");
                break;
            case 3:
                System.out.println("Mittwoch");
                break;
            case 4:
                System.out.println("Donnerstag");
                break;
            case 5:
                System.out.println("Freitag");
                break;
            case 6:
                System.out.println("Samstag");
                break;
            case 0:
                System.out.println("Sonntag");
                break;
        }
    }
}