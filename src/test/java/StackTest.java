import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack bestStack;
    @BeforeEach
    void setUp() {
        bestStack = new Stack();

    }


    @Test
    void push() {
        assertTrue(bestStack.getTail() == null);
        bestStack.push(3);
        assertTrue(bestStack.getTail() != null);

    }

    @Test
    void size() {
        assertEquals(0, bestStack.size());
        bestStack.push(1);
        bestStack.push(2);
        bestStack.push(3);
        assertEquals(3, bestStack.size());
        //assertFalse(bestStack.size() == 17);
    }

    @Test
    void pop() throws Exception {
        //leere liste => keine elemente
        assertThrows(Exception.class, ()-> bestStack.pop());
        //leere liste => keine elemente

        //prüfen des ersten if statement
        bestStack.push(4);
        assertEquals(4, bestStack.pop());
        //prüfen des ersten if statement

        //prüfen des zweiten if statement
        bestStack.push(6);
        bestStack.push(9);
        assertEquals(9, bestStack.pop());
        //prüfen des zweiten if statement


    }



    @Test
    void peek() throws Exception {
        // rückgabe von einem element
        assertThrows(Exception.class, ()-> bestStack.peek());
        bestStack.push(1);
        bestStack.push(2);
        bestStack.push(3);
        assertTrue(bestStack.peek() != null);
        assertEquals(3, bestStack.peek().getData());
    }

    @Test
    void testPop() throws Exception{
        //multiple pop method

        assertThrows(Exception.class, ()-> bestStack.pop());
        bestStack.push(1);
        bestStack.push(2);
        bestStack.push(3);
        bestStack.push(2);
        int[] result = bestStack.pop(3);
        assertArrayEquals(new int[] {2,3,2}, result);
        assertEquals(1, bestStack.getHead().getData());




    }
}