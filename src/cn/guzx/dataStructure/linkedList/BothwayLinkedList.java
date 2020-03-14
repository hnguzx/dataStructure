package cn.guzx.dataStructure.linkedList;

public class BothwayLinkedList {
    public static void main(String[] args) {
        // DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("百度");

        Person person2 = new Person();
        person2.setId(2);
        person2.setName("阿里巴巴");

        Person person3 = new Person();
        person3.setId(3);
        person3.setName("腾讯");

        Person person4 = new Person();
        person4.setId(4);
        person4.setName("网易");

        DoubleLinkedList2 linkedList2 = new DoubleLinkedList2(person1);
        System.out.println("是否为空：" + linkedList2.isEmpty());
        linkedList2.addOrderById(person3);
        linkedList2.addOrderById(person4);
        linkedList2.addOrderById(person2);
        System.out.println("显示链表中所有数据：");
        linkedList2.showNodeInfo();
        System.out.println("进行修改：");

        Person person5 = new Person();
        person5.setId(4);
        person5.setName("鹅肠");

        linkedList2.update(person5);
        linkedList2.showNodeInfo();

        System.out.println("进行删除：");
        linkedList2.delete(2);
        linkedList2.showNodeInfo();

        System.out.println("现在有：" + linkedList2.getCount());

        /*doubleLinkedList.add(person1);
        doubleLinkedList.addOrderById(person4);
        System.out.println("当前有效数据数是：" + doubleLinkedList.getCount());
        doubleLinkedList.addOrderById(person3);
        doubleLinkedList.addOrderById(person2);
        System.out.println("当前有效数据数是：" + doubleLinkedList.getCount());
        doubleLinkedList.showNodeInfo();

        Person person5 = new Person();
        person5.setId(-2);
        person5.setName("搜狐");

        doubleLinkedList.update(person5);
        doubleLinkedList.showNodeInfo();

        doubleLinkedList.delete(2);
        doubleLinkedList.delete(3);
        doubleLinkedList.delete(-2);

        doubleLinkedList.showNodeInfo();*/
    }
}

/**
 * 有头结点的双向链表
 */
class DoubleLinkedList {

    private Person headNode = new Person();

    public DoubleLinkedList() {
        headNode.setId(0);
        headNode.setName("");
        headNode.setNext(null);
        headNode.setPre(null);
    }

    // 判断是否为空
    public boolean isEmpty() {
        return headNode.getNext() == null && headNode.getPre() == null;
    }

    // 按插入顺序添加
    public void add(Person node) {
        Person temp = new Person();
        temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
    }

    // 按编号顺序插入
    public void addOrderById(Person node) {
        Person temp = headNode;
        boolean flag = false; // 判断是否进行添加
        while (true) {
            if (temp.getNext() == null) {
                flag = true;
                break;
            }
            if (temp.getNext().getId() > node.getId()) {
                flag = true;
                break;
            }
            if (temp.getNext().getId() == node.getId()) {
                System.out.println("该节点已经存在，无法添加");
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            node.setNext(temp.getNext());
            node.setPre(temp);
            temp.setNext(node);
            temp.getNext().setPre(node);
        }

    }

    // 按编号对节点信息进行修改
    public void update(Person node) {
        Person temp = headNode;
        boolean flag = false; // 标志是否找到要修改的节点
        while (true) {
            if (temp.getId() == node.getId()) {
                flag = true;
                break;
            }
            if (temp.getNext() == null) {
                System.out.println("该id所表示的节点不存在");
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(node.getName());
        }
    }

    // 按编号进行删除
    public void delete(int id) {
        Person temp = headNode;
        boolean flag = false; // 标志是否找到要删除的节点
        while (true) {
            if (temp.getNext() == null) {
                System.out.println("没有找到要删除的节点元素");
                break;
            }
            if (temp.getNext().getId() == id) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
            if (temp.getNext() != null) { // 最后一个节点
                temp.setPre(temp.getNext().getPre());
            }

        }
    }

    // 获取有效数据数量
    public int getCount() {
        int count = 0;
        Person temp = headNode;
        if (temp.getNext() == null) {
            System.out.println("空链表");
            return count;
        }
        while (true) {
            if (temp.getNext() != null) {
                count++;
                temp = temp.getNext();
            } else {
                break;
            }
        }
        return count;
    }

    // 展示所有节点信息
    public void showNodeInfo() {
        Person temp = new Person();
        temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            System.out.print(temp.getNext());
            temp = temp.getNext();
        }
        System.out.println("");
    }
}

/**
 * 无头结点的双向链表
 */
class DoubleLinkedList2 {

    private Person headNode;

    public DoubleLinkedList2(Person person) {
        headNode = person;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    // 按插入顺序添加
    public void add(Person node) {
        Person temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
    }

    // 按编号顺序插入
    public void addOrderById(Person node) {
        Person temp = headNode;
        boolean flag = false; // 判断是否进行添加
        while (true) {
            if (temp.getId() > node.getId()) {
                flag = true;
                break;
            }
            if (temp.getId() == node.getId()) {
                System.out.println("该节点已经存在，无法添加");
                break;
            }
            if (temp.getNext() == null) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            if (temp.getPre() == null || temp.getNext() == null) {
                node.setPre(temp);
                temp.setNext(node);
            } else {
                temp.getPre().setNext(node);
                node.setPre(temp.getPre());
                temp.setPre(temp);
                node.setNext(temp);
            }

        }

    }

    // 按编号对节点信息进行修改
    public void update(Person node) {
        Person temp = headNode;
        boolean flag = false; // 标志是否找到要修改的节点
        while (true) {
            if (temp.getId() == node.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(node.getName());
        }
    }

    // 按编号进行删除
    public void delete(int id) {
        Person temp = headNode;
        boolean flag = false; // 标志是否找到要删除的节点
        while (true) {
            if (temp.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            if (temp.getPre() == null) {
                headNode = temp.getNext();
            } else if (temp.getNext() == null) {
                temp.getPre().setNext(null);
            } else {
                temp.getPre().setNext(temp.getNext());
                temp.getNext().setPre(temp.getPre());
            }

        }
    }

    // 获取有效数据数量
    public int getCount() {
        int count = 0;
        Person temp = headNode;
        if (temp == null) {
            System.out.println("空链表");
            return count;
        }
        while (true) {
            if (temp != null) {
                count++;
                temp = temp.getNext();
            } else {
                break;
            }
        }
        return count;
    }

    // 展示所有节点信息
    public void showNodeInfo() {
        Person temp = headNode;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.print(temp);
            temp = temp.getNext();
        }
        System.out.println("");
    }
}

class Person {
    private int id; // 节点元素的id
    private String name;    // 节点元素的名称
    private Person next;    // 指向当前节点的下一个节点
    private Person pre;     // 指向当前节点的上一个节点

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

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getPre() {
        return pre;
    }

    public void setPre(Person pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}