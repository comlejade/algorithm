package recursion;

import javafx.util.Pair;

/**
 * 用递归的方式实现链表
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index Illegal.");
        }

        head = add(head, index, e);
        size++;
    }

    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size - 1, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index Illegal.");
        }

        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index Illegal.");
        }

        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index Illegal.");
        }
        set(head, index, e);
    }

    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }
        set(node, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }

        node.next = removeElement(node.next, e);

        if (node.e.equals(e)) {
            size--;
            return node.next;
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i, i);
            System.out.println(linkedList);
        }

        while (!linkedList.isEmpty()) {
            System.out.println("removed " + linkedList.removeLast());
        }
    }


}
