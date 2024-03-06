

public class Insurance2 {
    public static void main(String[] args) {
        Praemie(3,true,2,130);
        Praemie(1,false,3,70);
        Praemie(3,true,0,90);
        Praemie(0,false,3,43);
        Praemie(2,true,1,0);
    }
    public static void Praemie(int erwachsene, boolean senioren, double kinder, double qm){
        double p;
        if (qm < 1) {
             System.out.println("Die Wohnfläche muss größer 0 sein.");
             return;
         }
        else if(erwachsene<1){
            System.out.println("Es muss mindestens ein Erwachsener im Haushalt leben.");
            return;
        }
         else if(erwachsene == 1 || erwachsene == 2 ){
              p=10+(qm/2);
         }
        else if(erwachsene == 3 ){
            p=15+qm;
        }
        else{
            p=20+(qm*1.5);
        }

        double p_kid = kinder * 3.50;
        double praemie= p+ p_kid;
        if (senioren) {
            praemie *= 0.9;
        }
        System.out.printf("%.2f%n",praemie);
        }


}
