package ua.edu.ucu.collections.immutable;

public class Node implements Cloneable {
    protected Node nextNode;
    protected Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node node) {
        this.data = data;
        this.nextNode = node;
    }

    public Object getData()
    {
        return data;
    }

    public Node getNext()
    {
        return nextNode;
    }

    public void setNext(Node next)
    {
        this.nextNode = next;
    }

    public Node clone()
    {
        return new Node(data);
    }
}
