package cn.guzx.linkedList;

/**
 * 有头结点的链表
 */

public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Person person1 = new Person();
        person1.setId(1);
        person1.setName("李虎");

        Person person2 = new Person();
        person2.setId(2);
        person2.setName("李渊");

        Person person3 = new Person();
        person3.setId(3);
        person3.setName("李世民");

        Person person4 = new Person();
        person4.setId(3);
        person4.setName("唐太宗");


        linkedList.add(person1);
        linkedList.addOrderById(person3);
        linkedList.addOrderById(person3);
        linkedList.addOrderById(person2);

        linkedList.showNodeInfo();

        linkedList.update(person4);
        linkedList.showNodeInfo();

        linkedList.delete(2);
        linkedList.delete(1);
        linkedList.delete(2);
        linkedList.showNodeInfo();
    }
}

class LinkedList {

    private Person headNode = new Person();

    public LinkedList() {
        headNode.setId(0);
        headNode.setName("");
        headNode.setPerson(null);
    }

    public boolean isEmpty() {
        return headNode.getPerson() == null;
    }

    // 按插入顺序添加
    public void add(Person node) {
        Person temp = new Person();
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
    public void addOrderById(Person node) {
        Person temp = headNode;
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
    public void update(Person node) {
        Person temp = headNode;
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
        Person temp = headNode;
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

    // 展示所有节点信息
    public void showNodeInfo() {
        Person temp = new Person();
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

class Person {
    private int id; // 节点元素的id
    private String name;    // 节点元素的名称
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
