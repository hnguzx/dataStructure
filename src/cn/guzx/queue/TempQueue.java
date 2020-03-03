package cn.guzx.queue;

public class TempQueue {
    public static void main(String[] args) {
        Queue2 queue = new Queue2(5);
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

class Queue2 {
    private int size; // 队列的长度
    private int head; // 指向队列头下标
    private int tail; // 指向队列尾部下标
    private int[] array; // 用于保存数据

    public Queue2(int size) {
        this.size = size;
        array = new int[size];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head == size;
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("队列已达到最大值");
            return;
        }
        array[head] = value;
        head++;
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("队列已经为空，无法删除");
            return;
        }
        tail++;
    }

    public int getHead() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        return array[head - 1];
    }

    public int getCount() {
        int count = 0;
        if (isEmpty()) {
            return count;
        }
        for (int i = tail; i < head; i++) {
            count++;
        }
        return count;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列已经为空");
            return;
        }
        for (int i = tail; i < head; i++) {
            System.out.printf("%d\t", array[i]);
        }
    }
}
