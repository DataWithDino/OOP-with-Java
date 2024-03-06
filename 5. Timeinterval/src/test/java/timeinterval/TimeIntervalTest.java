package timeinterval;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TimeIntervalTest {


    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeIntervalTimeInt() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            TimeInterval ti = new TimeInterval(310);
            Assertions.assertEquals("[00:00:00,00:05:10]", ti.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testGetLower() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            TimeInterval ti = new TimeInterval(new Time(0, 5, 10), 310);
            Assertions.assertEquals("00:05:10", ti.getLower().toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testGetUpper() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            TimeInterval ti = new TimeInterval(new Time(0, 5, 10), 310);
            Assertions.assertEquals("00:10:20", ti.getUpper().toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testMove() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            TimeInterval ti = new TimeInterval(new Time(), 24 * 60 * 60);
            ti.move(0);
            Assertions.assertEquals("[00:00:00,00:00:00]", ti.toString());

            ti = new TimeInterval(new Time(23, 59, 59), 1);
            Assertions.assertEquals("[23:59:59,00:00:00]", ti.toString());
            ti.move(1);
            Assertions.assertEquals("[00:00:00,00:00:01]", ti.toString());

            ti = new TimeInterval(new Time(5, 30, 0), 60);
            Assertions.assertEquals("[05:30:00,05:31:00]", ti.toString());
            ti.move(1);
            Assertions.assertEquals("[05:30:01,05:31:01]", ti.toString());
        });
    }


}
