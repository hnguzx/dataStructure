package cn.guzx.dataStructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 8, 9, 6, 1, 3};
        HuffmanNode node = createHuffmanTree(arr);
        node.preOrder();
    }

    /**
     * 创建赫夫曼树，并返回赫夫曼树的根节点
     * @param arr
     * @return
     */
    public static HuffmanNode createHuffmanTree(int[] arr) {
        // 构建一个HuffmanNode的list
        List<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
        for (int value : arr) {
            nodes.add(new HuffmanNode(value));
        }
        // 循环构建赫夫曼树，直到只有一个节点时结束
        while (nodes.size() > 1) {
            Collections.sort(nodes); // 从小到大排列
            // 取出当前权值最小的两个数
            HuffmanNode node1 = nodes.get(0);
            HuffmanNode node2 = nodes.get(1);
            // 构建一棵新的二叉树
            HuffmanNode newNode = new HuffmanNode(node1.getValue() + node2.getValue());
            newNode.setLeft(node1);
            newNode.setRight(node2);
            // 将处理过的节点移除
            nodes.remove(node1);
            nodes.remove(node2);
            // 将新创建的节点加入原list
            nodes.add(newNode);
        }
        // 返回赫夫曼树的根节点
        return nodes.get(0);
    }

    // 前序遍历赫夫曼树
    public void preOrder(HuffmanNode root) {
        if (root == null) {
            return;
        } else {
            root.preOrder();
        }

    }

    /**
     * 生成赫夫曼编码表
     * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入HuffmanCodes集合
     * @param node  传入的节点
     * @param code  路径：左0右1
     * @param stringBuilder 用于拼接路径
     * @return
     */
//    public Map<Byte, String> getCodes(HuffmanNode node,String code,StringBuilder stringBuilder) {
//        if (node == null) {
//            return null;
//        }
//        StringBuilder temp = new StringBuilder(stringBuilder);
//        temp.append(code);
//        if(node.getValue()){
//
//        }
//    }

}

class HuffmanNode implements Comparable<HuffmanNode> {

    private int value;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().preOrder();
        }
        if (this.getRight() != null) {
            this.getRight().preOrder();
        }
    }

    // 升序
    @Override
    public int compareTo(HuffmanNode o) {
        return this.getValue() - o.getValue();
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }
}