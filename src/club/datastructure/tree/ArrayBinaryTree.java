package club.datastructure.tree;

public class ArrayBinaryTree {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};
        ArrayTree arrayTree = new ArrayTree(arr);
        arrayTree.lastOrder();
    }
}

class ArrayTree {
    private int arr[];

    public ArrayTree(int[] arr) {
        this.arr = arr;
    }
    // 完全二叉树前序遍历
    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index) {
        System.out.println(arr[index]);

        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }

        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    // 完全二叉树中序遍历
    public void midOrder(){
        this.midOrder(0);
    }

    public void midOrder(int index) {
        
        if (index * 2 + 1 < arr.length) {
            midOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        if (index * 2 + 2 < arr.length) {
            midOrder(index * 2 + 2);
        }
    }

    // 完全二叉树后序遍历
    public void lastOrder(){
        this.lastOrder(0);
    }

    public void lastOrder(int index) {
        if (index * 2 + 1 < arr.length) {
            lastOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            lastOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}