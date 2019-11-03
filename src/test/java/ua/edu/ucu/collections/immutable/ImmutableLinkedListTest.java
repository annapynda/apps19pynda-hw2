package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAddMethod() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        String exp = "1, 2";
        lst = lst.add(1);
        lst = lst.add(2);
        assertEquals(lst.toString(), exp);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdderror(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = (ImmutableLinkedList) lst.add(100, 2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllerror(){
        Integer[] l = {1, 2};
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = (ImmutableLinkedList) lst.addAll(100, l);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(2);
        lst = (ImmutableLinkedList) lst.get(3);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(2);
        lst = (ImmutableLinkedList) lst.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSeterror(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(2);
        lst = (ImmutableLinkedList) lst.set(100, 5);
    }



    @Test
    public void testAddIndMethod() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        String exp = "1, 2";
        lst = (ImmutableLinkedList) lst.add(0, 1);
        lst = (ImmutableLinkedList) lst.add(1, 2);
        assertEquals(lst.toString(), exp);
    }


    @Test
    public void testAddAllMathod() {
        ImmutableList lst = new ImmutableLinkedList();
        lst = lst.add(0, 1);
        lst = lst.add(1, 2);
        lst = lst.add(2, 3);
        lst = lst.add(3, 4);
        Integer [] l = {100, 200};
        ImmutableList actualResult = lst.addAll(3, l);
        String exp = "1, 2, 3, 100, 200, 4";

        assertEquals(exp, actualResult.toString());
    }





    @Test
    public void testSizeMethod() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        int exp = 3;
        lst = lst.add(1);
        lst = lst.add(2);
        lst = lst.add(2);
        assertEquals(lst.size(), exp);
    }

    @Test
    public void testIsEmptyMethod() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        boolean exp = false;
        lst = lst.add(1);
        lst = lst.add(2);
        lst = lst.add(2);
        assertEquals(lst.isEmpty(), exp);
    }

    @Test
    public void testClearMethod() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        a = a.add(1);
        ImmutableLinkedList b = (ImmutableLinkedList) a.clear();
        assertEquals(b.toString(), "null");
    }

    @Test
    public void testIndexOf(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(1);
        lst = lst.add(2);
        assertEquals(lst.indexOf(1), 0);
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(1);
        lst = lst.add(2);
        Object[] res = lst.toArray();
        Object[] exp = {1, 2};
        assertArrayEquals(res, exp);
    }

    @Test
    public void testGetMethod() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = (ImmutableLinkedList) lst.add(0, 1);
        lst = (ImmutableLinkedList) lst.add(1, 2);
        lst = (ImmutableLinkedList) lst.add(2, 3);
        lst = (ImmutableLinkedList) lst.add(3, 4);
        Object res = lst.get(0);
        String exp = "1";
        assertEquals(res.toString(), exp);


    }

    @Test
    public void testRemoveMethod() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = (ImmutableLinkedList) lst.add(0, 1);
        lst = (ImmutableLinkedList) lst.add(1, 2);
        lst = (ImmutableLinkedList) lst.add(2, 3);
        lst = (ImmutableLinkedList) lst.add(3, 4);
        Object res = lst.remove(0);
        String exp = "2, 3, 4";
        assertEquals(res.toString(), exp);
    }

    @Test
    public void testSetMethod(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = (ImmutableLinkedList) lst.add(0, 1);
        lst = (ImmutableLinkedList) lst.add(1, 2);
        lst = (ImmutableLinkedList) lst.add(2, 3);
        ImmutableLinkedList b = (ImmutableLinkedList) lst.set(0,0);
        String exp = "0, 2, 3";
        assertEquals(exp, b.toString());


    }






}