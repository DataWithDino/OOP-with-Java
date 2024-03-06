package timeinterval;

public class TimeInterval {
    //Objektvariablen
    private Time lower_limit_interval;
    private int time_interval;
    //Konstruktoren
    TimeInterval(Time start_time, int added_seconds){
        this.lower_limit_interval = new Time(start_time);
        this.time_interval=added_seconds;
    }
    TimeInterval(int time_interval){
        this.lower_limit_interval = new Time(0,0,0);
        this.time_interval=time_interval;
    }
    //Methoden
    Time getLower(){
        return lower_limit_interval;
    }
    Time getUpper(){
        int upper_limit_seconds = lower_limit_interval.getTimeSeconds()+time_interval;
        return new Time(upper_limit_seconds);
    }
    void move(int seconds){
        lower_limit_interval=new Time(lower_limit_interval.getTimeSeconds()+seconds);
    }
    @Override public String toString(){
        return "[" + lower_limit_interval.toString() + "," + getUpper().toString() + "]";
    }

    public static void main(String[] args) {
        System.out.println(new TimeInterval(new Time(0,0,0), 60).toString());
        System.out.println(new TimeInterval(60).toString());
        System.out.println(new TimeInterval(new Time(0,200,0), 60).toString());
        System.out.println(new TimeInterval(new Time(12, 50, 00), 59).toString());
    }
}
