package org.example;

class LinkedList{

    private Node head;
    private Node tail;

    public int getHead() {
        return head.value;
    }

    public int getTail() {
        return tail.value;
    }

    public void add(int value){
        Node tempNode = new Node();
        tempNode.value = value;
        if (head != null){
            if (size() == 1) tail = head;
        tempNode.next = head;
        head.previous = tempNode;
        }
        head = tempNode;
    }

    public void append(int value){
        Node tempNode = new Node();
        tempNode.value = value;
        if (tail != null){
            if (size() == 1) head = tail;
        tempNode.previous = tail;
        tail.next = tempNode;
        }
        tail = tempNode;
    }

    public int size(){
        int size = 1;
        if (head == null) return 0;
        Node tempNode = head;
        while (tempNode.next != null){
            size++;
            tempNode = tempNode.next;
        }
        return size;
    }

    public void remove(){
        if (head != null) head = head.next;
    }

    public int getValueByIndex(int index){
        if (index > size() - 1) throw new ArrayIndexOutOfBoundsException();
        int i = 0;
        Node tempNode = head;
        while (i < index) {
            tempNode = tempNode.next;
            i++;
        }
        return tempNode.value;
    }

    public void reverse(){
        Node current = head;
        Node tempNode = null;
        boolean tailFlag = true;

        while (current != null){
            tempNode = current.previous;
            current.previous = current.next;
            current.next = tempNode;
            current = current.previous;
            if (tailFlag){
                tail = current.previous;
                tailFlag = false;
            }
        }
        if (tempNode != null){
            head = tempNode.previous;
        }
    }
}



class Node{
    public int value;
    public Node next;
    public Node previous;
}

class Main1{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.append(-1);
        ll.add(3);
        ll.append(-2);
        ll.reverse();
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.getValueByIndex(i));
        }
    }
}

