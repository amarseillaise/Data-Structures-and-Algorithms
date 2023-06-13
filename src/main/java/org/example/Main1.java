package org.example;

class LinkedList {
    private Node head;
    private Node tail;

    public int get(int item) {
        if (item > size()) throw new ArrayIndexOutOfBoundsException();// 1 08
        Node tmp = head;
        while (item > 0) {
            tmp = tmp.next;
            item--;
        }

        return tmp.value;

    }

    public int size() {
        int size = 1;
        if (head == null) return 0;
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }

    public void remove() {
        if (head != null)
            head = head.next;
    }

    public void add(int digit) {
        Node node = new Node();
        node.value = digit;
        if (head != null){
            if (size() == 1) {
                tail = head;}
            node.next = head;
            head.previous = node;
        }
        head = node;
    }
}

class Node {
    public int value;
    public Node next;
    public Node previous;
}

public class Main1 {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }
    }
}

