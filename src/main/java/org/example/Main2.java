//Реализовать класс работающий по принципу HashMap. Включая внутренний массив узлов с индексацией по хешу и описание узла. Добавить в класс методы:
//        Object put(Integer key , Integer value) добавить элемент
//        Object get(Integer key) получить значение соответствующее ключу
//        Object remove(Integer key) удалить элемент с соответствующем ключём
//        Object replays(Integer key, Integer v) заменить значение
//        int size() количество элементов
//        boolean containsKey(Integer key) проверка наличия ключа и значения
//        boolean containsValue(Integer v)

package org.example;

class Node1 {
    Integer value, key;
    int hash;
    Node1 next;
}

public class Main2 {

    Node1 head;
    Node1[] array = new Node1[16];

    public Object replace(Integer key, Integer v) {
        int index = Math.abs(key.hashCode() % 16);
        if (array[index] != null) {
            Node1 tempNode = array[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object get(Integer key) {
        int index = Math.abs(key.hashCode() % 16);
        if (array[index] != null) {
            Node1 tempNode = array[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object remove(Integer key) {
        int index = Math.abs(key.hashCode() % 16);
        if (array[index] != null) {
            Node1 tempNode = array[index];
            if (tempNode.key == key && tempNode.next == null) {
                array[index] = null;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null) {
                array[index] = tempNode.next;
                return tempNode.value;
            }
            while (tempNode.next != null) {
                if (tempNode.next.key == key) {
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object put(int v, int k) {
        Node1 temp = new Node1();
        temp.value = v;
        temp.key = k;
        temp.hash = Math.abs(temp.key.hashCode() % 16);
        if (array[temp.hash] != null) {
            Node1 tempNode = array[temp.hash];
            while (tempNode != null) {
                if (tempNode.key == k) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
            temp.next = array[temp.hash];
        }
        array[temp.hash] = temp;
        return null;
    }

    public int size(){
        int size = 0;
        for (Node1 tempMainNode: array
             ) {
            while (tempMainNode != null){
                size++;
                tempMainNode = tempMainNode.next;
            }
        }
        return size;
    }

    public boolean containsKey(Integer key){
        for (Node1 tempMainNode: array
        ) {
            while (tempMainNode != null){
                if (tempMainNode.key.intValue() == key.intValue()) return true;
                tempMainNode = tempMainNode.next;
            }
        }
        return false;
    }

    public boolean containsValue(Integer v){
        for (Node1 tempMainNode: array
        ) {
            while (tempMainNode != null){
                if (tempMainNode.value.intValue() == v.intValue()) return true;
                tempMainNode = tempMainNode.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main2 hm = new Main2();
        for (int i = 0; i < 32; i++) {
            hm.put(i + 1, i);
        }

        hm.put(1, 136);
        hm.put(0, 44);
        hm.put(1343, -416);

        System.out.println(hm.get(-15));
        hm.put(651, -15);
        System.out.println(hm.get(-15));
        hm.replace(-15, 156);
        System.out.println(hm.get(-15));
        hm.remove(-15);
        System.out.println(hm.get(-15));


        System.out.println(hm.size());
        System.out.println(hm.containsKey(44));
        System.out.println(hm.containsKey(65418));
        System.out.println(hm.containsValue(1343));
        System.out.println(hm.containsValue(651));
    }
}