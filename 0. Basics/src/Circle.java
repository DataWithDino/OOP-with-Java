public class Circle {
    public static void main(String[] args) {
        double radius=3.5 ;
        System.out.printf("Area: %.2f%n", CalculateArea(radius));
        System.out.printf("Circumference: %.2f%n", CalculateCircumference(radius));
    }
    public static double CalculateArea(double radius) {
        double Area= Math.PI * radius * radius;
        return Area;

    }
    public static double CalculateCircumference(double radius) {
        double Circumference= radius * (2 * Math.PI);
        return Circumference;
    }
}
