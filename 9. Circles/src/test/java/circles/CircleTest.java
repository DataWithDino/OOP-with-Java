package circles;
import circles.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CircleTest {
    @Test
    public void ConstructorValidInputTest() {
        Point center = new Point(1, 1);
        Circle circle = new Circle(center, 5);
        Assertions.assertNotNull(circle);
        Assertions.assertEquals(1, circle.getPoint().getX());
        Assertions.assertEquals(1, circle.getPoint().getY());
        Assertions.assertEquals(5, circle.getRadius());
    }

    @Test
    public void ConstructorInvalidInputTest() {
        Point center = null;
        Point finalCenter = center;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Circle(finalCenter, 5);
        });

        center = new Point(1, 1);
        Point finalCenter1 = center;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Circle(finalCenter1, -5);
        });
    }

    @Test
    public void copyConstructorTest() {
        Circle original = new Circle(new Point(2, 3), 3);
        Circle copy = new Circle(original);
        Assertions.assertNotSame(original, copy);
        Assertions.assertNotSame(original.getPoint(), copy.getPoint());
        Assertions.assertEquals(original.getRadius(), copy.getRadius());
    }

    @Test
    public void moveTest() {
        Circle circle = new Circle(new Point(1, 1), 5);
        Circle movedCircle = circle.move(3, 4);
        Assertions.assertEquals(4, movedCircle.getPoint().getX());
        Assertions.assertEquals(5, movedCircle.getPoint().getY());
    }

    @Test
    public void resizeValidInputTest() {
        Circle circle = new Circle(new Point(1, 1), 5);
        Circle resizedCircle = circle.resize(3);
        Assertions.assertEquals(8, resizedCircle.getRadius());
    }

    @Test
    public void resizeInvalidInputTest() {
        Circle circle = new Circle(new Point(1, 1), 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            circle.resize(-6);
        });
    }

    //nicht wirklich nötig, da nur schon getestete Methoden verwendet werden
    @Test
    public void moveAndResizeTest() {
        Circle originalCircle = new Circle(new Point(1, 1), 5);
        Circle newCircle = originalCircle.moveAndResize(2, 3, 1.5);

        Assertions.assertEquals(6.5, newCircle.getRadius());
        Assertions.assertEquals(3, newCircle.getPoint().getX());
        Assertions.assertEquals(4, newCircle.getPoint().getY());
    }

    @Test
    public void moveAndResizeInvalidTest() {
        Circle originalCircle = new Circle(new Point(1, 1), 5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            originalCircle.moveAndResize(1, 1, -6);
        });
    }

}
