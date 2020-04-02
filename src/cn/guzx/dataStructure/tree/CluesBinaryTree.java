package cn.guzx.dataStructure.tree;

public class CluesBinaryTree {
    public static void main(String[] args) {
        Node2 node1 = new Node2();
        node1.setId(1);
        node1.setName("aaa");

        Node2 node2 = new Node2();
        node2.setId(2);
        node2.setName("bbb");

        Node2 node3 = new Node2();
        node3.setId(3);
        node3.setName("ccc");

        Node2 node4 = new Node2();
        node4.setId(4);
        node4.setName("ddd");

        Node2 node5 = new Node2();
        node5.setId(5);
        node5.setName("eee");

        Node2 node6 = new Node2();
        node6.setId(6);
        node6.setName("fff");

        Node2 node7 = new Node2();
        node7.setId(7);
        node7.setName("fff");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node5);
        node2.setRight(node7);
        node3.setRight(node4);
        node3.setLeft(node6);

        Tree2 tree2 = new Tree2();
//        tree2.midThreadBinaryTree(node1);
//        tree2.midList(node1);
//        tree2.beforeThreadBinaryTree(node1);
//        tree2.beforeList(node1);
        tree2.afterThreadBinaryTree(node1);
        tree2.afterList(node1);
    }
}

class Tree2 {

    private Node2 pre; // 用于指向当前节点的前一个前驱节点

    // 线索化二叉树(中序)
    public void midThreadBinaryTree(Node2 node2) {
        // node2为当前节点
        if (node2 == null) {
            return;
        }
        // 线索化左子树
        midThreadBinaryTree(node2.getLeft());

        // 处理当前节点的前驱节点，判断是否有左子节点
        if (node2.getLeft() == null) {
            // 当前节点的左指针指向前驱节点
            node2.setLeft(pre);
            // 修改当前节点的左指针类型
            node2.setLeftType(1);
        }

        // 处理右子树和后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node2);
            pre.setRightType(1);
        }

        pre = node2; // pre后移

        // 线索化右子树
        midThreadBinaryTree(node2.getRight());
    }

    // 线索化二叉树(前序)
    // 如果该节点存在左子节点，那么就不会有前驱节点，如果存在右子节点，就不会有后继节点
    public void beforeThreadBinaryTree(Node2 node2) {
        if (node2 == null) {
            return;
        }

        // 设置前驱节点
        if (node2.getLeft() == null) {
            node2.setLeft(pre);
            node2.setLeftType(1);
        }
        // 设置后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node2);
            pre.setRightType(1);
        }

        pre = node2;

        // 线索化左子树,!=1说明没有前驱节点
        if (node2.getLeftType() != 1) {
            beforeThreadBinaryTree(node2.getLeft());
        }

        // 线索化右子树,!=1说明没有后继节点
        if (node2.getRightType() != 1) {
            beforeThreadBinaryTree(node2.getRight());
        }
    }

    // 线索化二叉树(后序)
    public void afterThreadBinaryTree(Node2 node2) {
        if (node2 == null) {
            return;
        }

        // 线索化左子树,!=1说明没有前驱节点
        afterThreadBinaryTree(node2.getLeft());

        // 线索化右子树,!=1说明没有后继节点
        afterThreadBinaryTree(node2.getRight());

        // 设置前驱节点
        if (node2.getLeft() == null) {
            node2.setLeft(pre);
            node2.setLeftType(1);
        }
        // 设置后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node2);
            pre.setRightType(1);
        }

        pre = node2;
    }

    // 遍历线索化二叉树(中序)
    public void midList(Node2 node2) {
        Node2 temp = node2;
        while (temp != null) {
            // 找到最左边的节点
            while (temp.getLeftType() == 0) {
                temp = temp.getLeft();
            }
            System.out.println(temp);
            // 如果当前节点的右子节点为后继节点
            while (temp.getRightType() == 1) {
                temp = temp.getRight();
                System.out.println(temp);
            }
            temp = temp.getRight();
        }
    }

    // 遍历线索化二叉树(前序)
    public void beforeList(Node2 node2) {
        Node2 temp = node2;
        while (temp != null) {
            // 遍历所有左子节点
            while (temp.getLeftType() == 0) {
                System.out.println(temp);
                temp = temp.getLeft();
            }
            // 输出后继节点
            System.out.println(temp);
            temp = temp.getRight();
        }
    }

    // 遍历线索化二叉树(后序)
    public void afterList(Node2 node2) {
        Node2 temp = node2;
        while (temp != null && temp.getLeftType() == 0) {
            // 遍历所有左子节点
            temp = temp.getLeft();
        }

        while (temp != null) {
            if(temp.getRightType()==1){
                System.out.println(temp);
                pre = temp;
                temp = temp.getRight();
            }else{
                // 上个处理的节点是当前节点的右节点
                if(temp.getRight() == pre){
                    System.out.println(temp);
                    if(temp==node2){
                        return;
                    }
                    pre = temp;
                    temp = temp.getRight();
                }else{

                }
            }

        }
    }

}

class Node2 {
    private int id;
    private String name;
    private Node2 right;
    private Node2 left;
    private int rightType; // 0表示右子树，1表示后继节点
    private int leftType;   // 0表示左子树，1表示前驱节点

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

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

    public Node2 getRight() {
        return right;
    }

    public void setRight(Node2 right) {
        this.right = right;
    }

    public Node2 getLeft() {
        return left;
    }

    public void setLeft(Node2 left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}