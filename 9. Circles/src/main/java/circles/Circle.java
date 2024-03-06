package circles;

public class Circle implements ICircle{
    private final Point center;
    private final double r;
    public Circle(Point center, double r){
        if (r <= 0 || center == null) {
            throw new IllegalArgumentException("Radius muss größer als 0 und Punkt darf nicht null sein.");
        }
        this.center = center;
        this.r=r;
    }
    public Circle(Circle other){
        this(new Point(other.center), other.r);
    }
    @Override
    public Point getPoint(){
        return center;
    }
    @Override
    public double getRadius(){
        return r;
    }
    @Override
    public Circle move(int dx, int dy){
        Point newPoint =new Point (center.getX()+dx,center.getY()+dy);
        return new Circle(newPoint, this.r);
    }
    @Override
    public Circle resize(double diff){
        if(this.r+diff<=0){
            throw new IllegalArgumentException("Der neu berechnete Radius darf nicht 0 oder negativ sein.");
        }
        return new Circle (this.center, this.r+diff);
    }
    /*  Durch die Default-Methode im Interface braucht man diese nicht
    @Override
    public Circle moveAndResize(int dx, int dy, double diff){
        Circle newCircle = this.move(dx,dy);
        if(this.r+diff<=0){
            throw new IllegalArgumentException("Der neu berechnete Radius darf nicht 0 oder negativ sein.");
        }
        else{
        return newCircle.resize(diff);
        }
    }
    */
}
