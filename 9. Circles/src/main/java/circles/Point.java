package circles;

import java.util.Locale;

public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Point(Point other){
        this.x=other.x;
        this.y=other.y;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "(%.1f, %.1f)", x, y);
    }

}
