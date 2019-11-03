package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] myarr;
    private int size;

    public ImmutableArrayList(Object[] myarr) {
        this.myarr = myarr;
    }

    public ImmutableArrayList() {
        myarr = new Object[0];
    }

    public void check(int index) {
        if (myarr.length < index) {
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
        Object [] arrSec = new Object[myarr.length + 1];
        System.arraycopy(myarr, 0, arrSec, 0, myarr.length);
        arrSec[myarr.length] = e;
        System.arraycopy(myarr, index, arrSec, index + 1, myarr.length - index);
        return new ImmutableArrayList(arrSec);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        check(myarr.length);
        Object [] arrSec = new Object[myarr.length + c.length];
        System.arraycopy(myarr, 0, arrSec, 0, index);
        System.arraycopy(c, 0, arrSec, index , c.length);
        System.arraycopy(myarr, index, arrSec,
                index + c.length,myarr.length - index);
        return new ImmutableArrayList(arrSec);
    }

    @Override
    public Object get(int index) {
        check(index);
        return myarr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        check(index);
        Object [] arrSec = new Object[myarr.length - 1];
        System.arraycopy(myarr, 0, arrSec, 0, index);
        System.arraycopy(myarr, index+1, arrSec, index, myarr.length-1-index);
        return new ImmutableArrayList(arrSec);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        check(index);
        myarr[index] = e;
        return new ImmutableArrayList(myarr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < myarr.length; i++) {
            if (e == myarr[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return myarr.length;
    }

    @Override
    public ImmutableArrayList clear()  {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return myarr.length == 0;
    }

    @Override
    public Object[] toArray() {
        return myarr;
    }

    @Override
    public String toString() {
        return Arrays.toString(myarr);
    }
}
