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
        Node nf;
        if (index == 0) {
            size += 1;
            nf = new Node(e);
            Node ns = nf;
            Node nt = head;
            while (nt != null) {
                Node ncop = nt.clone();
                ns.setNext(ncop);
                ns = ncop;
                nt = nt.getNext();
            }
            return new ImmutableLinkedList(nf, size);

        }
        else {
            size += 1;
            Node present = head;
            Node nodes = new Node(present.getData());
            Node nodet = nodes;
            while (present.getNext() != null) {
                present = present.getNext();
                nodet.setNext(new Node(present.getData()));
                nodet = nodet.getNext();
            }
            Node nodef = nodes;
            int i = 0;
            while (i + 1 != index) {
                nodef = nodef.getNext();
                i++;
            }
            Node res = new Node(e);
            res.setNext(nodef.getNext());
            nodef.setNext(res);
            return new ImmutableLinkedList(nodes, size);
        }
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        check(index);
        Node nf;
        if (index == 0) {
            size += c.length;
            nf = new Node(c[0]);
            Node ns = nf;
            for (int i = 1; i < c.length; i++) {
                Node element = new Node(c[i]);
                ns.setNext(element);
                ns = element;
            }

            Node present = head;
            while (present != null) {
                Node n = present.clone();
                ns.setNext(n);
                ns = n;
                present = present.getNext();
            }
        }
        else
            {
            size += c.length;
            nf = head.clone();
            Node ns = nf;
            Node current = head ;
            for (int i = 0; i < index-1; i++) {
                Node n = current.getNext().clone();
                ns.setNext(n);
                ns = n;
                current = current.getNext();
            }
            for (int i = 0; i < c.length; i++) {
                Node nodec = new Node(c[i]);
                ns.setNext(nodec);
                ns = nodec;
            }

            Node nodef;
            if (current.getNext().getData() == null) {
                nodef = current;
            }
            else
                {
                nodef = current.getNext();
            }
            while (nodef != null) {
                Node n = nodef.clone();
                ns.setNext(n);
                ns = n;
                nodef = nodef.getNext();
            }
        }

        return new ImmutableLinkedList(nf,size);

    }

    @Override
    public Object get(int index) {
        check(index);
        Node nf = head;
        int i = 0;

        while (i != index) {
            nf = nf.getNext();
            i++;
        }
        return nf.getData();
    }

    @Override
    public ImmutableList remove(int index) {
        check(index);
        size -= 1;
        Node nf;
        if (index != 0) {
            nf = head.clone();
            Node ns = nf;
            Node nt = head;
            for (int i = 0; i < index - 1; i++) {
                Node nn = nt.getNext().clone();
                ns.setNext(nn);
                ns = nn;
                nt = nt.getNext();
            }
            Node pres = nt.getNext();
            while (pres.getNext() != null) {
                Node res = pres.getNext().clone();
                ns.setNext(res);
                ns = res;
                pres = pres.getNext();
            }

        }
        else
            {
            nf = head.getNext();
            Node ns = nf;
            Node nt = nf.getNext();
            while (nt != null) {
                Node nn = nt.clone();
                ns.setNext(nn);
                ns = nn;
                nt = nt.getNext();
            }
        }
        return new ImmutableLinkedList(nf, size);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        check(index);
        return remove(index).add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node nf = head;
        int i = 0;
        while (nf != null) {
            if (nf.getData() == e) {
                return i;
            }
            i++;
            nf = nf.getNext();
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
        Node nf = head;
        for (int i = 0; i < size; i++) {
            lst[i] = nf.getData();
            nf = nf.getNext();
        }
        return lst;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node nf = head;
        res.append(nf.data);

        while (nf.nextNode != null) {
            nf = nf.nextNode;
            res.append(", ").append(nf.data);
        }
        return res.toString();
    }
}
