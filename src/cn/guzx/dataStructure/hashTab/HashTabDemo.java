package cn.guzx.dataStructure.hashTab;

import java.util.List;

public class HashTabDemo {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setId(2);
        node1.setName("nike");

        Node node2 = new Node();
        node2.setId(5);
        node2.setName("hol");

        HashTab tab = new HashTab(5);
        tab.add(node1);
        tab.add(node2);
        tab.delete(5);
//        tab.delete(5);
        tab.find(2);
//        tab.list();

    }
}

class Node {
    private int id;
    private String name;
    private Node next;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}

class ListNode {
    private Node head;

    public void add(Node node) {
        if (head == null) {
            this.head = node;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void delete(int id) {
        if (head == null) {
            System.out.println("链表为空!");
            return;
        }
        if (id == head.getId()) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            if (id == temp.getNext().getId()) {
                System.out.println("查到了：" + temp);
                break;
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void find(int id){
        if(head==null){
            System.out.println("链表为空！");
            return;
        }
        Node temp = head;
        while (temp!=null){
            if(temp.getId() == id){
                System.out.println("找到了："+temp);
                break;
            }
            temp.setNext(temp.getNext());
        }
    }

    public void list() {
        if (head == null) {
            System.out.println("链表为空!");
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "head=" + head +
                '}';
    }
}

class HashTab {
    private ListNode[] tab;
    private int size;

    public HashTab(int size) {
        this.size = size;
        tab = new ListNode[size];
        for (int i = 0; i < size; i++) {
            tab[i] = new ListNode();
        }
    }

    // 序列化
    public int selectList(int nodeId) {
        return nodeId % size;
    }

    public void add(Node node) {
        int index = selectList(node.getId());
        tab[index].add(node);
    }

    public void delete(int id) {
        int index = selectList(id);
        tab[index].delete(id);
    }

    public void find(int id){
        int index = selectList(id);
        tab[index].find(id);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println(tab[i]);
        }
    }
}

