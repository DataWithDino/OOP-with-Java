package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class QueueTest {

    private static final String TOM = "Tom";
    private static final String ANNIE = "Annie";
    private static final String MAX = "Max";
    private static final String JOSIE = "Josie";
    private static final String OLLI = "Olli";
    private static final String JUDY = "Judy";

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testAdd() {
        Queue queue = new Queue();
        queue.add(new Customer(TOM));
        queue.add(new Customer(ANNIE));
        queue.add(new Customer(MAX));
        Assertions.assertEquals(String.format("%s,%s,%s", TOM, ANNIE, MAX), queue.toString());
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testRemove() {
        Queue queue = new Queue();
        Assertions.assertNull(queue.remove());
        Customer tom = new Customer(TOM);
        queue.add(tom);
        Assertions.assertEquals(tom, queue.remove());
        queue.add(tom);
        Customer annie = new Customer(ANNIE);
        queue.add(annie);
        Customer max = new Customer(MAX);
        queue.add(max);
        Assertions.assertEquals(tom, queue.remove());
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testRemoveString() {
        Queue queue = new Queue();
        Assertions.assertNull(queue.remove(TOM));
        Customer tom = new Customer(TOM);
        queue.add(tom);
        Customer annie = new Customer(ANNIE);
        queue.add(annie);
        queue.add(new Customer(MAX));
        Assertions.assertEquals(null, queue.remove(OLLI));
        Assertions.assertEquals(annie, queue.remove(ANNIE));
        Assertions.assertEquals(tom, queue.remove(TOM));
        Assertions.assertEquals(MAX, queue.toString());
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testToString() {
        Queue queue = new Queue();
        Assertions.assertEquals("", queue.toString());
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testInsert() {
        // einfuegen bei leerer Schlange
        Queue queue = new Queue();
        queue.insert(OLLI, new Customer(TOM));
        Assertions.assertEquals(TOM, queue.toString());

        // einfuegen am Anfang der Schlange
        queue.add(new Customer(MAX));
        queue.add(new Customer(ANNIE));
        queue.insert(TOM, new Customer(OLLI));
        Assertions.assertEquals(String.format("%s,%s,%s,%s", OLLI, TOM, MAX, ANNIE), queue.toString());

        // einfuegen in der Mitte der Schlange
        queue.insert(MAX, new Customer(JUDY));
        Assertions.assertEquals(String.format("%s,%s,%s,%s,%s", OLLI, TOM, JUDY, MAX, ANNIE), queue.toString());

        // einfuegen am Ende der Schlange
        queue.insert("Mary", new Customer(JOSIE));
        Assertions.assertEquals(String.format("%s,%s,%s,%s,%s,%s", OLLI, TOM, JUDY, MAX, ANNIE, JOSIE), queue.toString());
    }



}