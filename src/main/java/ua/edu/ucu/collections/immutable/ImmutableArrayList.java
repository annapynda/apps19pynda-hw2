package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] arr1;
    private int size;

    public ImmutableArrayList(Object[] arr1) {
        this.arr1 = arr1;
    }

    public ImmutableArrayList() {
        arr1= new Object[0];
    }



    public void check(int index) {
        if (arr1.length < index){
            throw new IndexOutOfBoundsException();

        }
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size, e);

    }



    @Override
    public ImmutableList add(int index, Object e) {
        check(index);
        Object [] arr2 = new Object[arr1.length + 1];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        arr2[arr1.length] = e;
        System.arraycopy(arr1, index, arr2, index + 1,  arr1.length - index);
        return new ImmutableArrayList(arr2);



    }


    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        check(arr1.length);
        Object [] arr2 = new Object[arr1.length + c.length];
        System.arraycopy(arr1, 0, arr2, 0, index);
        System.arraycopy(c, 0, arr2, index , c.length);
        System.arraycopy(arr1, index, arr2,
                index+c.length,arr1.length - index);
        return new ImmutableArrayList(arr2);

            

    }

    @Override
    public Object get(int index) {
        check(index);
        return arr1[index];
    }

    @Override
    public ImmutableList remove(int index) {
        check(index);
        Object [] arr2 = new Object[arr1.length-1];
        System.arraycopy(arr1, 0, arr2, 0, index);
        System.arraycopy(arr1, index+1, arr2, index, arr1.length-1-index);
        return new ImmutableArrayList(arr2);

    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        check(index);
        arr1[index] =e;

        return new ImmutableArrayList(arr1);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arr1.length; i++) {
            if (e == arr1[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arr1.length;
    }

    @Override
    public ImmutableArrayList clear()  {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return arr1.length == 0;
    }

    @Override
    public Object[] toArray() {
        return arr1;

    }

    @Override
    public String toString() {
        return Arrays.toString(arr1);
    }










}
