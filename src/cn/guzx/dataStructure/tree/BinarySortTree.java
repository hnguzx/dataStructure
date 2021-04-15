package cn.guzx.dataStructure.tree;

public class BinarySortTree {
    public static void main(String[] args) {
        SortTree sortTree = new SortTree();
        int arr[] = new int[]{7, 3, 12, 10, 5, 1, 9, 2};
        for (int i = 0; i < arr.length; i++) {
            sortTree.addNode(new SortNode(arr[i]));
        }
        System.out.println("中序遍历：");
        sortTree.midTraverse();
        System.out.println("删除节点：");
        sortTree.deleteNode(3);
        System.out.println("中序遍历：");
        sortTree.midTraverse();
    }
}

class SortTree {
    private SortNode root;

    public SortNode getRoot() {
        return root;
    }

    public void setRoot(SortNode root) {
        this.root = root;
    }

    public void addNode(SortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void midTraverse() {
        if (root == null) {
            return;
        } else {
            root.midTraverse();
        }
    }

    public SortNode searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(value);
        }
    }

    public SortNode searchParentNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParentNode(value);
        }
    }

    /**
     * @param node 以该节点作为二叉排序树的根节点
     * @return 当前二叉排序树中最小节点的值
     */
    public int deleteRightTreeMin(SortNode node) {
        SortNode targetNode = node;
        while (targetNode.getLeft() != null) {
            targetNode = targetNode.getLeft();
        }
        // 将右子树中最小节点删除
        deleteNode(targetNode.getValue());
        // 将右子树中最小节点的值返回
        return targetNode.getValue();
    }

    /**
     *
     * @param node 以该节点作为二叉排序树的根节点
     * @return 当前二叉排序树中最大节点的值
     */
    public int deleteLeftTreeMin(SortNode node) {
        SortNode targetNode = node;
        while (targetNode.getRight() != null) {
            targetNode = targetNode.getRight();
        }
        // 将右子树中最小节点删除
        deleteNode(targetNode.getValue());
        // 将右子树中最小节点的值返回
        return targetNode.getValue();
    }

    /**
     * 删除指定节点
     *
     * @param value
     */
    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            // 查找到需要删除的节点
            SortNode targetNode = searchNode(value);
            if (targetNode == null) {
                return;
            }
            // 该二叉排序树只有一个节点root，且该节点即为要删除的节点
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            // 查找到目标节点的父节点
            SortNode parentNode = searchParentNode(value);
            // 目标节点为叶子节点
            if (targetNode.getLeft() == null && targetNode.getRight() == null) {
                if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
                    parentNode.setLeft(null);
                } else if (parentNode.getRight() != null && parentNode.getRight().getValue() == value) {
                    parentNode.setRight(null);
                }
                // 要删除的节点为某颗子树的根节点，且该子树有两个子节点
            } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                // 查找到右子树中最小节点的值
//                int minVal = deleteRightTreeMin(targetNode.getRight());
//                targetNode.setValue(minVal);
                int maxVal = deleteLeftTreeMin(targetNode.getLeft());
                // 将这个最新值替换被删除节点的值
                targetNode.setValue(maxVal);
                // 要删除的节点为某颗子树的根节点，且该子树只有一个子节点
            } else {
                // 目标节点有左子节点
                if (targetNode.getLeft() != null) {
                    // 需要考虑是否是只有两个节点的二叉排序树
                    if (parentNode == null) {
                        root = targetNode.getLeft();
                    } else {
                        // 目标节点为父节点的左子节点
                        if (parentNode.getLeft().getValue() == value) {
                            parentNode.setLeft(targetNode.getLeft());
                            // 目标节点为父节点的右子节点
                        } else {
                            parentNode.setRight(targetNode.getLeft());
                        }
                    }
                    // 目标节点有右子节点
                } else {
                    // 需要考虑是否是只有两个节点的二叉排序树
                    if (parentNode == null) {
                        root = targetNode.getRight();
                    } else {
                        // 目标节点为父节点的右子节点
                        if (parentNode.getRight().getValue() == value) {
                            parentNode.setRight(targetNode.getRight());
                            // 目标节点为父节点的右子节点
                        } else {
                            parentNode.setLeft(targetNode.getRight());
                        }
                    }
                }
            }
        }

    }
}

class SortNode {
    private int value;
    private SortNode right;
    private SortNode left;

    public SortNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SortNode getRight() {
        return right;
    }

    public void setRight(SortNode right) {
        this.right = right;
    }

    public SortNode getLeft() {
        return left;
    }

    public void setLeft(SortNode left) {
        this.left = left;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void addNode(SortNode node) {
        if (node == null) {
            return;
        }
        if (node.getValue() < this.value) {
            if (this.getLeft() != null) {
                this.getLeft().addNode(node);
            } else {
                this.setLeft(node);
            }
        } else {
            if (this.getRight() != null) {
                this.getRight().addNode(node);
            } else {
                this.setRight(node);
            }
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param value
     * @return
     */
    public SortNode searchNode(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.getLeft() == null) {
                return null;

            }
            return this.getLeft().searchNode(value);
        } else {
            if (this.getRight() == null) {
                return null;
            }
            return this.getRight().searchNode(value);
        }
    }

    /**
     * 查找要删除的节点的父节点
     *
     * @param value
     * @return
     */
    public SortNode searchParentNode(int value) {
        if (this.getLeft() != null && this.getLeft().getValue() == value || this.getRight() != null && this.getRight().getValue() == value) {
            return this;
        } else {
            if (this.getLeft() != null && value < this.getValue()) {
                return this.getLeft().searchParentNode(value);
            } else if (this.getRight() != null && value >= this.getValue()) {
                return this.getRight().searchParentNode(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 中序遍历
     */
    public void midTraverse() {
        if (this.getLeft() != null) {
            this.getLeft().midTraverse();
        }
        System.out.println(this);
        if (this.getRight() != null) {
            this.getRight().midTraverse();
        }
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}
