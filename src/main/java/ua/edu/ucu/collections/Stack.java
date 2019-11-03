package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst = new ImmutableLinkedList();

    public Object peek() {
        return lst.getLast();
    }

    public Object pop() {
        Object last = lst.getLast();
        lst = lst.removeLast();
        return last;
    }

    public int getSize() {
        return lst.size();
    }

    public String toString() {
        return lst.toString();
    }
    
    public void push(Object e) {
        lst = lst.addLast(e);
    }
}
