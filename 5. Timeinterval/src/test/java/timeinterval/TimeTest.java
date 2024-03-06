package timeinterval;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

class TimeTest {


    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testConstructor1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(59);
            Assertions.assertEquals(59, time.getSeconds());
            Assertions.assertEquals(0, time.getMinutes());
            Assertions.assertEquals(0, time.getHours());
            Assertions.assertEquals(59, time.getTimeSeconds());
            Assertions.assertEquals("00:00:59", time.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testConstructor2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time();
            Assertions.assertEquals(0, time.getSeconds());
            Assertions.assertEquals(0, time.getMinutes());
            Assertions.assertEquals(0, time.getHours());
            Assertions.assertEquals(0, time.getTimeSeconds());
            Assertions.assertEquals("00:00:00", time.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testConstructor3() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(200);
            Assertions.assertEquals(20, time.getSeconds());
            Assertions.assertEquals(3, time.getMinutes());
            Assertions.assertEquals(0, time.getHours());
            Assertions.assertEquals(200, time.getTimeSeconds());
            Assertions.assertEquals("00:03:20", time.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testConstructor4() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(9023876);
            Assertions.assertEquals(56, time.getSeconds());
            Assertions.assertEquals(37, time.getMinutes());
            Assertions.assertEquals(10, time.getHours());
            Assertions.assertEquals(9023876, time.getTimeSeconds());
            Assertions.assertEquals("10:37:56", time.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testConstructor5() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(60);
            Assertions.assertEquals(0, time.getSeconds());
            Assertions.assertEquals(1, time.getMinutes());
            Assertions.assertEquals(0, time.getHours());
            Assertions.assertEquals(60, time.getTimeSeconds());
            Assertions.assertEquals("00:01:00", time.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testConstructor6() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(3600 * 24 + 1);
            Assertions.assertEquals(1, time.getSeconds());
            Assertions.assertEquals(0, time.getMinutes());
            Assertions.assertEquals(0, time.getHours());
            Assertions.assertEquals(3600 * 24 + 1, time.getTimeSeconds());
            Assertions.assertEquals("00:00:01", time.toString());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testConstructor7() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(0, 0, 10000);
            Assertions.assertEquals(40, time.getSeconds());
            Assertions.assertEquals(46, time.getMinutes());
            Assertions.assertEquals(2, time.getHours());
            Assertions.assertEquals(10000, time.getTimeSeconds());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testConstructor8() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time = new Time(0, 0);
            Assertions.assertEquals(0, time.getSeconds());
            Assertions.assertEquals(0, time.getMinutes());
            Assertions.assertEquals(0, time.getHours());
            Assertions.assertEquals(0, time.getTimeSeconds());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testConstructor9() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time2 = new Time(5, 60);
            Assertions.assertEquals(0, time2.getSeconds());
            Assertions.assertEquals(0, time2.getMinutes());
            Assertions.assertEquals(6, time2.getHours());
            Assertions.assertEquals(21600, time2.getTimeSeconds());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testCopyConstructor() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(12, 4, 43);
            Assertions.assertEquals(43483, new Time(time1).getTimeSeconds());
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testEquals1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(200);
            Time time2 = new Time(200);
            Assertions.assertTrue(time1.equals(time2));
        });
    }


    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testEquals2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(200);
            Time time2 = new Time(201);
            Assertions.assertFalse(time1.equals(time2));
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testEquals3() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(3600 * 24 + 1);
            Time time2 = new Time(1);
            Assertions.assertFalse(time1.equals(time2));
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testEquals4() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(3600);
            Assertions.assertFalse(time1.equals(null));
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testDiff1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(3600 * 24 + 1);
            Time time2 = new Time(1);
            Assertions.assertEquals(86400, time1.diff(time2));
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testDiff2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(1);
            Time time2 = new Time(1);
            Assertions.assertEquals(0, time1.diff(time2));
        });
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testDiff3() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Time time1 = new Time(1);
            Assertions.assertEquals(-1, time1.diff(null));
        });
    }


}