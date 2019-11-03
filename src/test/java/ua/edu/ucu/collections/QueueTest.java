package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testenqueue() {
        Queue s = new Queue();
        s.enqueue(1);
        s.enqueue(2);
        assertEquals("2, 1", s.toString());
    }


    @Test
    public void testpeek() {
        Queue s = new Queue();
        s.enqueue(1);
        s.enqueue(2);
        Object p = s.peek();
        assertEquals(1, p);
    }

    @Test
    public void testdeque() {
        Queue s = new Queue();
        s.enqueue(1);
        s.enqueue(2);
        s.dequeue();
        assertEquals("2", s.toString());
    }

    @Test
    public void testSize() {
        Queue s = new Queue();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(8);
        s.dequeue();
        assertEquals(3, s.getSize());
    }

    @Test
    public void testtoString(){
        Queue s = new Queue();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        assertEquals("3, 2, 1", s.toString());
    }



}
