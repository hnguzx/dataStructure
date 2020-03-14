package cn.guzx.dataStructure.linkedList;

import java.util.Stack;

/**
 * 有头结点的单向链表
 */

public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Person2 person1 = new Person2();
        person1.setId(1);
        person1.setName("李虎");

        Person2 person2 = new Person2();
        person2.setId(3);
        person2.setName("李渊");

        Person2 person3 = new Person2();
        person3.setId(5);
        person3.setName("李世民");

        Person2 person4 = new Person2();
        person4.setId(7);
        person4.setName("唐太宗");


        linkedList.addOrderById(person1);
        linkedList.addOrderById(person3);
        linkedList.addOrderById(person4);
        linkedList.addOrderById(person2);

        LinkedList linkedList2 = new LinkedList();
        Person2 person12 = new Person2();
        person12.setId(2);
        person12.setName("李虎2");

        Person2 person22 = new Person2();
        person22.setId(4);
        person22.setName("李渊2");

        Person2 person32 = new Person2();
        person32.setId(6);
        person32.setName("李世民2");

        Person2 person42 = new Person2();
        person42.setId(8);
        person42.setName("唐太宗2");


        linkedList2.addOrderById(person12);
        linkedList2.addOrderById(person22);
        linkedList2.addOrderById(person32);
        linkedList2.addOrderById(person42);

        linkedList.showNodeInfo();
        linkedList2.showNodeInfo();

        LinkedList linkedList3 = linkedList.mergeList(linkedList, linkedList2);
        linkedList3.showNodeInfo();


       /* System.out.println("当前有效节点数：" + linkedList.getCount());
        linkedList.showNodeInfo();
        System.out.println("进行逆序打印");
        linkedList.reversePrint();
        System.out.println("进行翻转");
        linkedList.reverseLinkedList();
        linkedList.showNodeInfo();

        System.out.println("倒数第3个是" + linkedList.getReverseNode(3));

        linkedList.update(person4);
        linkedList.showNodeInfo();

        *//*linkedList.delete(2);
        linkedList.delete(1);*//*
        linkedList.showNodeInfo();


        linkedList.mergeList()

        System.out.println("当前有效节点数：" + linkedList.getCount());*/
    }
}

class LinkedList {

    private Person2 headNode = new Person2();

    public LinkedList() {
        headNode.setId(0);
        headNode.setName("");
        headNode.setPerson(null);
    }

    public boolean isEmpty() {
        return headNode.getPerson() == null;
    }

    // 按插入顺序添加
    public void add(Person2 node) {
        Person2 temp = new Person2();
        temp = headNode;
        while (true) {
            if (temp.getPerson() == null) {
                break;
            }
            temp = temp.getPerson();
        }
        temp.setPerson(node);
    }

    // 按编号顺序插入
    public void addOrderById(Person2 node) {
        Person2 temp = headNode;
        boolean flag = false; //判断是否进行添加
        while (true) {
            if (temp.getPerson() == null) {
                flag = true;
                break;
            }
            if (temp.getPerson().getId() > node.getId()) {
                flag = true;
                break;
            }
            if (temp.getPerson().getId() == node.getId()) {
                System.out.println("该节点已经存在，无法添加");
                break;
            }
            temp = temp.getPerson();
        }
        if (flag) {
            node.setPerson(temp.getPerson());
            temp.setPerson(node);
        }
    }

    // 按编号对节点信息进行修改
    public void update(Person2 node) {
        Person2 temp = headNode;
        boolean flag = false; // 标志是否找到要修改的节点
        while (true) {
            if (temp.getId() == node.getId()) {
                flag = true;
                break;
            }
            if (temp.getPerson() == null) {
                System.out.println("该id所表示的节点不存在");
                break;
            }
            temp = temp.getPerson();
        }
        if (flag) {
            temp.setName(node.getName());
        }
    }

    // 按编号进行删除
    public void delete(int id) {
        Person2 temp = headNode;
        boolean flag = false; // 标志是否找到要删除的节点
        while (true) {
            if (temp.getPerson() == null) {
                System.out.println("没有找到要删除的节点元素");
                break;
            }
            if (temp.getPerson().getId() == id) {
                flag = true;
                break;
            }
            temp = temp.getPerson();
        }
        if (flag) {
            temp.setPerson(temp.getPerson().getPerson());
        }
    }

    // 获取有效数据数量
    public int getCount() {
        int count = 0;
        Person2 temp = headNode;
        if (temp.getPerson() == null) {
            System.out.println("空链表");
            return count;
        }
        while (true) {
            if (temp.getPerson() != null) {
                count++;
                temp = temp.getPerson();
            } else {
                break;
            }
        }
        return count;
    }

    // 获取倒数第N个节点
    public Person2 getReverseNode(int n) {
        // 首先获取一共有多少个节点
        int count = getCount();

        if (n < 1 || n > count) {
            System.out.println("没有该位置的节点");
            return null;
        }

        Person2 temp = headNode;
        for (int i = 0; i < count - n; i++) {
            temp = temp.getPerson();
        }
        return temp.getPerson();
    }

    // 将链表翻转
    public void reverseLinkedList() {

        if (headNode.getPerson() == null || headNode.getPerson().getPerson() == null) {
            System.out.println("无需翻转");
            return;
        }
        Person2 temp = headNode.getPerson(); // 当前节点
        Person2 next = null; // 用于保存当前节点的下一个节点
        Person2 newHead = new Person2();
        while (true) {
            if (temp == null) {
                break;
            }
            next = temp.getPerson(); // 将当前节点的后一个节点保存
            temp.setPerson(newHead.getPerson()); // 将新节点指向原头节点的后一个节点
            newHead.setPerson(temp);    // 将新链表的头指向新节点
            temp = next; // 将临时节点后移
        }
        headNode.setPerson(newHead.getPerson()); // 将原链表头结点指向新链表的头结点的后一个节点
    }

    // 将链表中的元素逆转打印
    public void reversePrint() {
        Person2 temp = headNode.getPerson();
        Stack<Person2> list = new Stack<>();
        while (true) {
            if (temp == null) {
                break;
            }
            list.push(temp);
            temp = temp.getPerson();
        }
        while (list.size() > 0) {
            System.out.println(list.pop());
        }
    }

    // 将两个有序链表合并，仍然保持有序
    public LinkedList mergeList(LinkedList linkedList1, LinkedList linkedList2) {
        LinkedList newLinkedList = linkedList1;
        Person2 temp = linkedList2.getHeadNode(linkedList2);
        Person2 tt = null;
        for (int i = 0; i < linkedList2.getCount(); i++) {
            tt = temp;
            if (temp.getPerson() == null) {
                newLinkedList.addOrderById(tt);
                break;
            }
            temp = temp.getPerson();
            newLinkedList.addOrderById(tt);
        }
        return newLinkedList;
    }

    // 获取链表的头结点
    public Person2 getHeadNode(LinkedList linkedList) {
        return headNode.getPerson();
    }

    // 展示所有节点信息
    public void showNodeInfo() {
        Person2 temp = new Person2();
        temp = headNode;
        while (true) {
            if (temp.getPerson() == null) {
                break;
            }
            System.out.print(temp.getPerson());
            temp = temp.getPerson();
        }
        System.out.println("");
    }
}

class Person2 {
    private int id; // 节点元素的id
    private String name;    // 节点元素的名称
    private Person2 next;   // 指向当前节点的下一个节点

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

    public Person2 getPerson() {
        return next;
    }

    public void setPerson(Person2 person) {
        this.next = person;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
