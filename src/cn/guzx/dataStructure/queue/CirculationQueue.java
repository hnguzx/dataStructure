package cn.guzx.dataStructure.queue;

/**
 * 留有一个空余位置
 */

public class CirculationQueue {
    public static void main(String[] args) {
        Queue3 queue = new Queue3(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("当前队列头是：" + queue.getHead());
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.showQueue();
        queue.delete();
        queue.delete();
        queue.delete();
        queue.add(5);
        queue.add(6);
        queue.delete();
        queue.delete();
        queue.delete();
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.showQueue();
        System.out.println("当前队列头是：" + queue.getHead());
    }
}

class Queue3 {
    private int size; // 初始大小
    private int head; // 指向队列头后一个下标
    private int tail; // 指向队列尾部下标
    private int[] array; //用于保存数据

    public Queue3(int size) {
        this.size = size;
        head = 0;
        tail = 0;
        array = new int[size];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        // 留一个空余位置
        return (head + 1) % size == tail;
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("队列已达到最大值");
            return;
        }
        array[head] = value;
        head = (head + 1) % size;
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        tail = (tail + 1) % size;
    }

    public int getHead() {
        return array[head-1];
    }

    public int getCount() {
        int count = 0;
        if (isEmpty()) {
            return count;
        }
        count = (head + size - tail) % size;
        return count;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < getCount(); i++) {
            System.out.printf("%d\t", array[(tail + i) % size]);
        }
        System.out.println();
    }
}
