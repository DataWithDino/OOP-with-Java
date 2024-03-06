package circles;
import circles.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PointTest {
    private Point point;
    @BeforeEach
    void setUP(){
        point = new Point(1,2);
    }

    @Test
    void getXTest(){
        Assertions.assertEquals(1, point.getX());
    }
    @Test
    void getYTest(){
        Assertions.assertEquals(2, point.getY());
    }
    @Test
    void toStringTest(){
        Assertions.assertEquals("(1.0, 2.0)", point.toString());
    }
    @Test
    void copyConstructorTest(){
        Point copiedPoint = new Point(point);
        Assertions.assertEquals(1, copiedPoint.getX());
        Assertions.assertEquals(2, copiedPoint.getY());
        Assertions.assertEquals("(1.0, 2.0)", copiedPoint.toString());
    }
}
