package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList lst = new ImmutableLinkedList();

    public Object peek() {
        return lst.getLast();
    }

    public Object dequeue() {
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

    public void enqueue(Object e) {
        lst = lst.addFirst(e);
    }
}
