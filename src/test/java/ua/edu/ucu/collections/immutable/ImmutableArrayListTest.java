package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {


    @Test
    public void testAdd() {
        ImmutableList arr1 = new ImmutableArrayList();
        ImmutableList got = arr1.add(2);
        String expres = "[2]";
        assertEquals(expres, got.toString());

    }



    @Test
    public void testAddInd() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 2);
        arr1 = arr1.add(1, 3);
        String expres = "[2, 3]";
        assertEquals(expres, arr1.toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdderror(){
        ImmutableList arr1 = new ImmutableArrayList();
        arr1.add(100, 2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveerror(){
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 2);
        arr1 = arr1.add(1, 3);
        ImmutableList got = arr1.remove(100);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllerror(){
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 2);
        arr1 = arr1.add(1, 3);
        Integer[] l = {1, 2};
        ImmutableList got = arr1.addAll(100, l);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexerror(){
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 2);
        arr1 = arr1.add(1, 3);
        Object got = arr1.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSeterror(){
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 2);
        arr1 = arr1.add(1, 3);
        Object got = arr1.set(4, 5);
    }



    @Test
    public void testAddAll() {
        Integer[] ls = {1, 2, 3, 4, 5};
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.addAll(ls);
        String res = "[1, 2, 3, 4, 5]";
        assertEquals(res, arr1.toString());
    }

    @Test
    public void testAddAllInd() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 6);
        arr1 = arr1.add(1, 7);
        String res = "[1, 2, 6, 7]";
        Integer l[] = {1, 2};
        arr1 = arr1.addAll(0, l);
        ImmutableList got = arr1;
        assertEquals(res, got.toString());
    }




    @Test
    public void testRemove() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0);
        arr1 = arr1.add(1);
        String res = "[0]";
        ImmutableList got = arr1.remove(1);
        assertEquals(res, got.toString());

    }

    @Test
    public void testSet() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0);
        arr1 = arr1.add(1);
        ImmutableList got = arr1.set(1, 0);
        String res = "[0, 0]";
        assertEquals(res, got.toString());
    }


    @Test
    public void testIndexOf() {
        ImmutableList newarr = new ImmutableArrayList();
        newarr = newarr.add(0, 3);
        newarr = newarr.add(1, 4);
        int got = newarr.indexOf(3);
        assertEquals(0, got);
    }

    @Test
    public void testSize() {
        ImmutableList newarr = new ImmutableArrayList();
        newarr = newarr.add(0, 3);
        newarr = newarr.add(1, 4);
        newarr = newarr.add(2, 5);

        Object got = newarr.size();
        String expres = "3";
        assertEquals(expres, got.toString());
    }


    @Test
    public void testClear() {
        ImmutableList newarr = new ImmutableArrayList();
        newarr = newarr.add(0, 3);
        newarr = newarr.add(1, 4);
        newarr = newarr.add(2, 5);
        ImmutableList got = newarr.clear();
        String expres = "[]";
        assertEquals(expres, got.toString());
    }

    @Test
    public void testIsEmpty() {
        ImmutableList newarr = new ImmutableArrayList();
        newarr = newarr.add(0, 3);
        newarr = newarr.add(1, 4);
        newarr = newarr.add(2, 5);
        boolean got = newarr.isEmpty();
        assertFalse(got);
    }

}

