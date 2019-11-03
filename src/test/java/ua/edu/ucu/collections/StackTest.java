package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testpush() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        Stack res = s;
        assertEquals("1, 2", res.toString());
    }

    @Test
    public void testpeek() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        Object res = s.peek();
        assertEquals(2, res);
    }


    @Test
    public void testpop() {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        Object res = s.pop();
        assertEquals(3, res);
    }

    @Test
    public void testSize() {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        int res = s.getSize();
        assertEquals(2, res);
    }

    @Test
    public void testToString() {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        String res = s.toString();
        String exp = "1, 3";
        assertEquals(exp, res);

    }



}
