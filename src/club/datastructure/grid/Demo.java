/**
 * 使用数组表示图（邻接矩阵）
 */
package club.datastructure.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
//        Grid grid = new Grid(5);
        Grid grid = new Grid(8);
//        String nodes[] = {"A", "B", "C", "D", "E"};
        String nodes[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 将所有节点添加到图中
        for (String node : nodes) {
            grid.vertexList.add(node);
        }
        // 添加边
//        grid.addEdges(0, 1, 1); // A -> B
//        grid.addEdges(0, 2, 1); // A -> B
//        grid.addEdges(1, 2, 1); // A -> B
//        grid.addEdges(1, 3, 1); // A -> B
//        grid.addEdges(1, 4, 1); // A -> B
        grid.addEdges(0, 1, 1);
        grid.addEdges(0, 2, 1);
        grid.addEdges(1, 3, 1);
        grid.addEdges(1, 4, 1);
        grid.addEdges(3, 7, 1);
        grid.addEdges(4, 7, 1);
        grid.addEdges(2, 5, 1);
        grid.addEdges(2, 6, 1);
        grid.addEdges(5, 6, 1);
        // 显示该图所对应的邻接矩阵
        grid.showAll();

//        grid.depthTraverse();
        grid.broadTraverse();

    }
}

class Grid {
    ArrayList<String> vertexList; // 用于保存所有顶点
    int[][] edges; // 用于保存对应的邻接矩阵
    int numOfEdges; // 用于保存边的数量
    boolean[] isVisited; // 用于保存每个顶点是否被访问的状态

    /**
     * 初始化图
     *
     * @param n 顶点的数量
     */
    public Grid(int n) {
        edges = new int[n][n];
        numOfEdges = 0;
        vertexList = new ArrayList<>();
    }

    /**
     * 添加节点
     *
     * @param str
     */
    public void addNode(String str) {
        vertexList.add(str);
    }

    /**
     * 添加边
     *
     * @param node1
     * @param node2
     * @param weight 权值：1表示有边，0表示没有边
     */
    public void addEdges(int node1, int node2, int weight) {
        // 无向图
        edges[node1][node2] = weight;
        edges[node2][node1] = weight;
        numOfEdges++;
    }

    /**
     * 获取节点的数量
     *
     * @return
     */
    public int getNumberNode() {
        return vertexList.size();
    }

    /**
     * 判断node1和node2之间有没有边，有则返回1，没有返回0
     *
     * @param node1
     * @param node2
     * @return
     */
    public int getWeight(int node1, int node2) {
        return edges[node1][node2];
    }

    /**
     * 获取边的数量
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 获取对应下标的数据
     *
     * @param index
     * @return
     */
    public String getValueOfIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 显示图的邻接矩阵
     */
    public void showAll() {
        for (int[] arr : edges) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 获取指定节点的第一个邻接节点的下标
     *
     * @param index
     * @return
     */
    public int getFirstNode(int index) {
        // 这个j是不是可以从index开始？？？
        // 还有节点
//        for (int j = 0; j < vertexList.size(); j++) {
        for (int j = index; j < vertexList.size(); j++) {
            // 该节点有与其它节点相连
            if (edges[index][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     *
     * @param node1
     * @param node2
     * @return
     */
    public int getNextNode(int node1, int node2) {
        // 存在下一个节点
        for (int j = node2 + 1; j < vertexList.size(); j++) {
            // 且与下一个节点是相连的
            if (edges[node1][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     *
     * @param isVisit 该节点是否已经访问过了
     * @param i       要访问的节点的下标，从第一个开始
     */
    public void depthTraverse(boolean isVisit[], int i) {
        System.out.println("遍历到了：" + vertexList.get(i));
        // 将该节点设置为已访问
        isVisited[i] = true;
        // 获取该节点的第一个邻接节点的坐标
        int nextIndex = getFirstNode(i);
        // 说明存在邻接节点
        while (nextIndex != -1) {
            // 判断是否已经访问过了
            if (!isVisit[nextIndex]) {
                depthTraverse(isVisited, nextIndex);
            } else {
                nextIndex = getNextNode(i, nextIndex);
            }
        }
    }

    public void depthTraverse() {
        isVisited = new boolean[vertexList.size()];
        // 遍历所有节点
        for (int i = 0; i < getNumberNode(); i++) {
            if (!isVisited[i]) {
                depthTraverse(isVisited, i);
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param isVisit 该节点是否已经访问过了
     * @param i       要访问的节点的下标，从第一个开始
     */
    public void broadTraverse(boolean isVisit[], int i) {
        int head; // 表示队列头结点对应的下标
        int next; // 表示邻接节点对应的下标
        // 用于保存该节点能访问到的节点
        Queue queue = new LinkedList<String>();
        // 取出该节点
        System.out.print("->"+getValueOfIndex(i));
        // 表示已访问过
        isVisited[i] = true;
        // 将访问过的节点加入队列
        queue.add(i);

        // 队列不为空
        if (!queue.isEmpty()) {
            // 将已访问过的节点出队列
            head = (int) queue.poll();
            // 获取下一个可以访问到的节点的下标
            next = getFirstNode(head);
            while (next != -1) {
                // 节点存在且没有被访问过
                if (!isVisited[next]) {
                    System.out.print("->"+getValueOfIndex(next));
                    isVisited[next] = true;
                    queue.add(next);
                }
                // 获取该节点可以访问的下一个节点的下标
                next = getNextNode(head, next);
            }
        }
    }

    public void broadTraverse() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                broadTraverse(isVisited, i);
            }
        }
    }
}


