package ua.edu.ucu.collections.immutable;


public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private int size;

    public void check(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public ImmutableLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public ImmutableLinkedList() {
        head = new Node(null);
        size = 0;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return (ImmutableLinkedList) add(size, e);
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size-1);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size-1);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        check(index);
        if (index == 0 && isEmpty()) {
            size += 1;
            head = new Node(e);
            return new ImmutableLinkedList(head, size);
        }
        Node n1;
        if (index == 0) {
            size += 1;
            n1 = new Node(e);
            Node n2 = n1;
            Node n3 = head;
            while (n3 != null) {
                Node ncop = n3.clone();
                n2.setNext(ncop);
                n2 = ncop;
                n3 = n3.getNext();
            }
            return new ImmutableLinkedList(n1, size);

        }
        else {
            size += 1;
            Node present = head;
            Node node2 = new Node(present.getData());
            Node node3 = node2;
            while (present.getNext() != null) {
                present = present.getNext();
                node3.setNext(new Node(present.getData()));
                node3 = node3.getNext();
            }
            Node node4 = node2;
            int i = 0;
            while (i + 1 != index) {
                node4 = node4.getNext();
                i++;
            }
            Node res = new Node(e);
            res.setNext(node4.getNext());
            node4.setNext(res);
            return new ImmutableLinkedList(node2, size);
        }
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        check(index);
        Node n1;
        if (index == 0) {
            size += c.length;
            n1 = new Node(c[0]);
            Node n2 = n1;
            for (int i = 1; i < c.length; i ++) {
                Node element = new Node(c[i]);
                n2.setNext(element);
                n2 = element;
            }

            Node present = head;
            while(present != null){
                Node n = present.clone();
                n2.setNext(n);
                n2 = n;
                present = present.getNext();
            }
        }else{
            size+=c.length;
            n1 = head.clone();
            Node n2 = n1;
            Node current = head ;
            for (int i = 0; i < index-1; i++) {
                Node n = current.getNext().clone();
                n2.setNext(n);
                n2 = n;
                current = current.getNext();
            }
            for (int i = 0; i < c.length; i ++) {
                Node nodec = new Node(c[i]);
                n2.setNext(nodec);
                n2 = nodec;
            }

            Node nodef;
            if (current.getNext().getData() == null) {
                nodef = current;
            }
            else {
                nodef = current.getNext();
            }
            while(nodef != null){
                Node n = nodef.clone();
                n2.setNext(n);
                n2 = n;
                nodef = nodef.getNext();
            }
        }

        return new ImmutableLinkedList(n1,size);

    }

    @Override
    public Object get(int index) {
        check(index);
        Node n1 = head;
        int i = 0;

        while (i != index) {
            n1 = n1.getNext();
            i++;
        }
        return n1.getData();
    }

    @Override
    public ImmutableList remove(int index) {
        check(index);
        size -= 1;
        Node n1;
        if (index != 0) {
            n1 = head.clone();
            Node n2 = n1;
            Node n3 = head;
            for (int i = 0; i < index - 1; i++) {
                Node nn = n3.getNext().clone();
                n2.setNext(nn);
                n2 = nn;
                n3 = n3.getNext();
            }
            Node pres = n3.getNext();
            while (pres.getNext() != null) {
                Node res = pres.getNext().clone();
                n2.setNext(res);
                n2 = res;
                pres = pres.getNext();
            }

        } else {
            n1 = head.getNext();
            Node n2 = n1;
            Node n3 = n1.getNext();
            while (n3 != null) {
                Node nn = n3.clone();
                n2.setNext(nn);
                n2 = nn;
                n3 = n3.getNext();
            }
        }
        return new ImmutableLinkedList(n1, size);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        check(index);
        return remove(index).add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node n1 = head;
        int i = 0;
        while (n1 != null) {
            if (n1.getData() == e) {
                return i;
            }
            i++;
            n1 = n1.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new  ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object [] lst = new Object[size];
        Node n1 = head;
        for (int i = 0; i < size; i++) {
            lst[i] = n1.getData();
            n1 = n1.getNext();
        }
        return lst;
    }

    @Override
    public String toString() {
        String res = "";
        Node n1 = head;
        res += n1.data;

        while (n1.nextNode != null) {
            n1 = n1.nextNode;
            res += ", "  + n1.data;
        }
        return res;
    }
}
