package a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagementTest {

    private Dozent dozent;

    @BeforeEach
    void init() {
        dozent = new Dozent("Prof. Dr. Maier", "Mathematik","R3.031", "Lothstraße", 64);
    }

    @Test
    void test1() {
        assertFalse(dozent.equals(new Dozent("Prof. Dr. Huber", "Mathematik", "R3.031", "Lothstraße", 64)));
    }

    @Test
    void test2() {
        assertFalse(dozent.equals(new Dozent("Prof. Dr. Maier", "Informatik","R3.034", "Lothstraße", 64)));
    }

    @Test
    void test3() {
        assertFalse(dozent.equals(new Dozent("Prof. Dr. Maier", "Mathematik","R3.034", "Lothstraße", 64)));
    }

    @Test
    void test4() {
        assertFalse(dozent.equals(new Dozent("Prof. Dr. Maier", "Mathematik","R3.031", "Dachauerstraße", 64)));
    }

    @Test
    void test5() {
        assertTrue(dozent.equals(new Dozent("Prof. Dr. Maier", "Mathematik","R3.031", "Lothstraße", 64)));
    }



}