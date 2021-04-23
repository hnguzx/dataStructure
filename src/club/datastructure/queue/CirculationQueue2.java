package club.datastructure.queue;

/**
 * 无空余位置
 */

public class CirculationQueue2 {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
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

class Queue {
    private int size;
    private int head; //预备要在该下标下添加数据
    private int tail; //预备要在该下标下删除数据
    private int[] array; //用于保存数据

    private int currentSize; // 用于记录当前队列中数据的数量

    public Queue(int size) {
        this.size = size;
        head = 0;
        tail = 0;
        array = new int[size];
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == size;
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("队列已经满");
            return;
        }
        array[head] = value;
        currentSize++;
        head = (head + 1) % size;

    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        currentSize--;
        tail = (tail + 1) % size;
    }

    public int getHead() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        return array[(head - 1 + size) % size];
    }

    public int getCount() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        return currentSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            System.out.printf("%d\t", array[(tail + i) % size]);
        }
        System.out.println();
    }
}

