package club.datastructure.tree;

public class BinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setId(2);
        node1.setName("aaa");
        Node node2 = new Node();
        node2.setId(1);
        node2.setName("bbb");
        Node node3 = new Node();
        node3.setId(3);
        node3.setName("ccc");
        Node node4 = new Node();
        node4.setId(4);
        node4.setName("ddd");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);

        Tree tree = new Tree(node1);
//        tree.preTraverse();
//        tree.midTraverse();
//        tree.lastTraverse();
//        System.out.println(tree.preFind(3));
//        System.out.println(tree.minFind(1));
//        System.out.println(tree.lastFind(3));
        tree.preTraverse();
        tree.delete(3);
        System.out.println("删除后");
        tree.preTraverse();
    }
}

class Node {
    private int id;
    private String name;
    private Node right;
    private Node left;

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

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    //前序遍历
    public void preTraverse() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preTraverse();
        }
        if (this.right != null) {
            this.right.preTraverse();
        }
    }

    //中序遍历
    public void midTraverse() {
        if (this.left != null) {
            this.left.midTraverse();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midTraverse();
        }
    }

    //后序遍历
    public void lastTraverse() {
        if (this.left != null) {
            this.left.lastTraverse();
        }
        if (this.right != null) {
            this.right.lastTraverse();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public Node preFind(int id) {
        if (this.getId() == id) {
            return this;
        }
        Node temp = null;
        if (this.getLeft() != null) {
            temp = this.getLeft().preFind(id);
        }
        if (temp != null) {
            return temp;
        }
        if (this.getRight() != null) {
            temp = this.getRight().preFind(id);
        }
        return temp;
    }

    //中序遍历查找
    public Node midFind(int id) {
        Node temp = null;
        if (this.getLeft() != null) {
            temp = this.getLeft().midFind(id);
        }
        if (temp != null) {
            return temp;
        }
        if (this.getId() == id) {
            return this;
        }
        if (this.getRight() != null) {
            temp = this.getRight().midFind(id);
        }
        return temp;
    }

    //后序遍历查找
    public Node lastFind(int id) {
        Node temp = null;
        if (this.getLeft() != null) {
            temp = this.getLeft().midFind(id);
        }
        if (temp != null) {
            return temp;
        }
        if (this.getRight() != null) {
            temp = this.getRight().midFind(id);
        }
        if (temp != null) {
            return temp;
        }
        return this;
    }

    // 节点删除
    public void delete(int id) {
        if (this.getLeft() != null && this.getLeft().getId() == id) {
            this.setLeft(null);
            return;
        }
        if (this.getRight() != null && this.getRight().getId() == id) {
            this.setRight(null);
            return;
        }
        if(this.getLeft()!=null){
            delete(id);
        }
        if(this.getRight()!=null){
            delete(id);
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    // 前序遍历
    public void preTraverse() {
        if (this.root != null) {
            this.root.preTraverse();
        }
    }

    // 中序遍历
    public void midTraverse() {
        if (this.root != null) {
            this.root.midTraverse();
        }
    }

    // 后序遍历
    public void lastTraverse() {
        if (this.root != null) {
            this.root.lastTraverse();
        }
    }

    // 前序查找
    public Node preFind(int id) {
        return this.root.preFind(id);
    }

    // 中序查找
    public Node minFind(int id) {
        return this.root.midFind(id);
    }

    // 后序查找
    public Node lastFind(int id) {
        return this.root.lastFind(id);
    }

    // 节点删除
    public void delete(int id){
        if(this.root==null){
            System.out.println("二叉树为空！");
            return;
        }
        if(this.root.getId()==id){
            this.root = null;
            return;
        }
        this.root.delete(id);
    }

}
