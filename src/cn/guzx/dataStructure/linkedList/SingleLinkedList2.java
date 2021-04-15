package cn.guzx.dataStructure.linkedList;

import java.util.Stack;

/**
 * 有头结点的单向链表
 */

public class SingleLinkedList2 {

    public static void main(String[] args) {

        Person2 person1 = new Person2();
        person1.setId(1);
        person1.setName("李虎");

        Person2 person2 = new Person2();
        person2.setId(2);
        person2.setName("李渊");

        Person2 person3 = new Person2();
        person3.setId(3);
        person3.setName("李世民");

        Person2 person4 = new Person2();
        person4.setId(3);
        person4.setName("唐太宗");

        LinkedList2 linkedList2 = new LinkedList2(person1);

        linkedList2.add(person2);
        linkedList2.add(person3);
        linkedList2.update(person4);
        linkedList2.delete(2);

        linkedList2.showNodeInfo();

        System.out.println("当前一共有：" + linkedList2.getCount());
        System.out.println("倒数第2个是：" + linkedList2.getReverseNode(2));
        System.out.println("逆序打印");
        linkedList2.reversePrint();
        System.out.println("进行翻转");
        linkedList2.reverseLinkedList();
        linkedList2.showNodeInfo();
    }
}

class LinkedList2 {

    private Person2 headNode = null;
    private Person2 last = null;

    public LinkedList2(Person2 person) {
        headNode = person;
        last = headNode;
    }

    public boolean isEmpty() {
        return headNode.getPerson() == null;
    }

    // 按插入顺序添加
    public void add(Person2 node) {
        Person2 l = last;
        l.setPerson(node);
        last = last.getPerson();
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
        if (temp == null) {
            System.out.println("空链表");
            return count;
        }
        while (true) {
            if (temp != null) {
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
        return temp;
    }

    // 将链表翻转
    public void reverseLinkedList() {

        if (headNode == null || headNode.getPerson() == null) {
            System.out.println("无需翻转");
            return;
        }
        Person2 temp = headNode; // 当前节点
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
        headNode = newHead.getPerson(); // 将原链表头结点指向新链表的头结点的后一个节点
    }

    // 将链表中的元素逆转打印
    public void reversePrint() {
        Person2 temp = headNode;
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

    // 展示所有节点信息
    public void showNodeInfo() {
        Person2 temp = headNode;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.print(temp);
            temp = temp.getPerson();
        }
        System.out.println("");
    }
}

