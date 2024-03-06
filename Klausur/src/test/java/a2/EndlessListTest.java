package a2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EndlessListTest {

    @Test
    void testListEmptyForward() {
        EndlessList endlessList = new EndlessList();
        Assertions.assertEquals("[]", endlessList.traverseForward(2).toString());
        Assertions.assertEquals("[]", endlessList.traverseForward(1).toString());
        Assertions.assertEquals("[]", endlessList.traverseForward(0).toString());
    }

    @Test
    void testListEmptyBackward() {
        EndlessList endlessList = new EndlessList();
        Assertions.assertEquals("[]", endlessList.traverseBackward(2).toString());
        Assertions.assertEquals("[]", endlessList.traverseBackward(1).toString());
        Assertions.assertEquals("[]", endlessList.traverseBackward(0).toString());
    }

    @Test
    void testListSingleElementForward() {
        EndlessList endlessList = new EndlessList();
        endlessList.addValue(21);
        Assertions.assertEquals("[21, 21]", endlessList.traverseForward(2).toString());
        Assertions.assertEquals("[21]", endlessList.traverseForward(1).toString());
        Assertions.assertEquals("[]", endlessList.traverseForward(0).toString());
    }

    @Test
    void testListSingleElementBackward() {
        EndlessList endlessList = new EndlessList();
        endlessList.addValue(18);
        Assertions.assertEquals("[18, 18]", endlessList.traverseBackward(2).toString());
        Assertions.assertEquals("[18]", endlessList.traverseBackward(1).toString());
        Assertions.assertEquals("[]", endlessList.traverseBackward(0).toString());
    }

    @Test
    void testTraverseForward() {
        EndlessList endlessList = new EndlessList();
        for (int i = 1; i <= 5; i++) {
            endlessList.addValue(i);
        }
        // Die Liste hat fünf Werte und wird zweimal mit dem Uhrzeigersinn durchlaufen.
        Assertions.assertEquals("[1, 2, 3, 4, 5, 1, 2, 3, 4, 5]", endlessList.traverseForward(2).toString());
    }

    @Test
    void testTraverseBackward() {
        EndlessList endlessList = new EndlessList();
        for (int i = 1; i <= 4; i++) {
            endlessList.addValue(i);
        }
        // Die Liste hat vier Werte und wird dreimal gegen den Uhrzeigersinn durchlaufen.
        Assertions.assertEquals("[1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2]", endlessList.traverseBackward(3).toString());
    }
}