package cn.guzx.linkedList;

public class CirculationLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setId(1);
        node1.setName("第1个节点");

        CircleLinkedList linkedList = new CircleLinkedList();

        Node node2 = new Node();
        node2.setId(2);
        node2.setName("第2个节点");

//        linkedList.add(node2);
        linkedList.add(5);

        linkedList.showAllNode();

        linkedList.outNode(2, 3, 5);
    }
}

class CircleLinkedList {

    Node first = new Node();

    // 初始化，有一个头结点
    /*public CircleLinkedList(Node node) {
        first = node;
        current = first;
        first.setNext(current);
        current.setNext(first);
    }*/

    // 添加节点，单次手动添加
    /*public void add(Node node) {
        current.setNext(node);
        node.setNext(first);
        current = current.getNext();
    }*/

    // 添加节点，一次性自动添加
    public void add(int number) {
        Node current = new Node();
        for (int i = 1; i <= number; i++) {
            Node node = new Node();
            node.setId(i);
            node.setName("第" + i + "个节点");

            if (i == 1) {
                first = node;
                current = first;
            } else {
                current.setNext(node);
                node.setNext(first);
                current = current.getNext();
            }


        }
    }

    // 约瑟夫环问题
    // 从第几个开始，每次间隔多少个，初始一共有多少个
    public void outNode(int startIndex, int intervalIndex, int numbers) {
        Node temp = new Node();
        Node current = first;
        // 将temp移到first后面一个位置
        while (true) {
            if (current.getNext() == first) {
                temp = current;
                break;
            }
            current = current.getNext();
        }
        // 找到开始的位置
        for (int i = 1; i < startIndex; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }
        // 进行出圈
        while (true) {
            if (temp == first) {
                System.out.println("出圈：" + first);
                break;
            }
            for (int i = 0; i < intervalIndex - 1; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.println("出圈：" + first);
            first = first.getNext();
            temp.setNext(first);
        }
    }

    // 遍历所有节点
    public void showAllNode() {
        Node current = new Node();
        current = first;
        while (true) {
            System.out.println(current);
            current = current.getNext();
            if (current == first) {
                System.out.println("已经遍历完成！");
                break;
            }
        }
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
                '}';
    }
}
