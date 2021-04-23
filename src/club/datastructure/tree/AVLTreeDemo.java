package club.datastructure.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AvlNode(arr[i]));
        }
        System.out.println("中序遍历：");
        avlTree.infixOrder();
        System.out.println("当前树的高度为：" + avlTree.getRoot().getHeight());
        System.out.println("当前树的左子树高度为：" + avlTree.getRoot().getLeft().getHeight());
        System.out.println("当前树的右子树高度为：" + avlTree.getRoot().getRight().getHeight());
//        avlTree.getRoot().leftRotate();
//        System.out.println("经过左旋转后：");
//        avlTree.getRoot().rightRotate();
//        System.out.println("经过右旋转后：");
//        System.out.println("当前树的高度为：" + avlTree.getRoot().getHeight());
//        System.out.println("当前树的左子树高度为：" + avlTree.getRoot().getLeft().getHeight());
//        System.out.println("当前树的右子树高度为：" + avlTree.getRoot().getRight().getHeight());

    }
}

class AvlTree {
    private AvlNode root;

    public AvlNode getRoot() {
        return root;
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树排序树为空");
        }
    }

    // 添加节点
    public void add(AvlNode node) {
        if (this.root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }


}

class AvlNode {
    int value;
    AvlNode left;
    AvlNode right;

    public AvlNode(int value) {
        this.value = value;
    }

    // 获取以当前节点为根节点的子树的高度
    public int getHeight() {
        return Math.max(this.getLeft() == null ? 0 : this.getLeft().getHeight(), this.getRight() == null ? 0 : this.getRight().getHeight()) + 1;
    }

    // 获取左子树高度
    public int getLeftHeight() {
        if (this.getLeft() == null) {
            return 0;
        } else {
            return this.getLeft().getHeight();
        }
    }

    // 获取右子树高度
    public int getRightHeight() {
        if (this.getRight() == null) {
            return 0;
        } else {
            return this.getRight().getHeight();
        }
    }

    // 左旋转
    public void leftRotate() {
        // 以当前根节点的值创建一个新的节点
        AvlNode newNode = new AvlNode(this.getValue());

        // 将新节点的左子树设置为当前节点的左子树
        newNode.setLeft(this.getLeft());

        // 将新节点的右子树设置为当前节点的右子树的左子树
        newNode.setRight(this.getRight().getLeft());

        // 将当前节点的值替换为当前节点的右节点的值
        this.setValue(this.getRight().getValue());

        // 将当前节点的右子树设置为当前节点右子树的右子树
        this.setRight(this.getRight().getRight());

        // 将当前节点的左子树设置为新的节点
        this.setLeft(newNode);

    }

    // 右旋转
    public void rightRotate() {
        // 以当前根节点的值创建一个新的节点
        AvlNode newNode = new AvlNode(this.getValue());

        newNode.setLeft(this.getLeft().getRight());
        newNode.setRight(this.getRight());

        this.setValue(this.getLeft().getValue());

        this.setLeft(this.getLeft().getLeft());
        this.setRight(newNode);
    }

    // 中序遍历
    public void infixOrder() {
        if (this.getLeft() != null) {
            this.getLeft().infixOrder();
        }
        System.out.println(this.getValue());
        if (this.getRight() != null) {
            this.getRight().infixOrder();
        }
    }

    // 添加节点
    public void add(AvlNode node) {
        if (node == null) {
            return;
        }
        if (node.getValue() < this.getValue()) {
            if (this.getLeft() != null) {
                this.getLeft().add(node);
            } else {
                this.setLeft(node);
            }
        } else {
            if (this.getRight() != null) {
                this.getRight().add(node);
            } else {
                this.setRight(node);
            }
        }

        // 当添加完一个节点后，如果右子树的高度-左子树的高度>1,那么还需要进行左旋转
        if (this.getRightHeight() - this.getLeftHeight() > 1) {
            // 子树的左子树高度大
            if (this.getRight() != null && this.getRight().getLeftHeight() > this.getRight().getRightHeight()) {
                // 子树的右子树进行右旋转
                getRight().rightRotate();
            }
            // 当前节点进行左旋转
            this.leftRotate();
            return;
        }

        // 当添加完一个节点后，如果左子树的高度-右子树的高度>1,那么还需要进行右旋转
        if (this.getLeftHeight() - this.getRightHeight() > 1) {
            // 子树的左子树高度大
            if (this.getLeft() != null && this.getLeft().getRightHeight() > this.getLeft().getLeftHeight()) {
                // 子树的右子树进行右旋转
                this.getLeft().leftRotate();
            }
            // 当前节点进行左旋转
            rightRotate();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AvlNode getLeft() {
        return left;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }
}
