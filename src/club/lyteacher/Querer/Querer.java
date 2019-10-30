package club.lyteacher.Querer;

import java.util.Scanner;

public class Querer {
	public static void main(String[] args) {
		ArrayQuerer querer = new ArrayQuerer(3);
		boolean loop = true;
		char input = ' ';
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.printf("s(show): 显示队列\t");
			System.out.printf("e(exit): 退出程序\t");
			System.out.printf("a(add): 添加数据到队列\t");
			System.out.printf("g(get): 从队列取出数据\t");
			System.out.printf("h(head): 查看队列头的数据\t");
			input = scanner.next().charAt(0);// 接收一个字符
			switch (input) {
			case 's':
				try {
					querer.showAll();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				try {
					querer.add(value);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'g': // 取出数据
				try {
					int res = querer.get();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // 查看队列头的数据
				try {
					int res = querer.showFirst();
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // 退出
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}

class ArrayQuerer {
	int maxSize;
	int first;
	int end;
	int[] arr;

	public ArrayQuerer(int size) {
		maxSize=size;
		first=0;
		end=0;
		arr = new int[maxSize];
	}

	public boolean isEmpty() {
		return first == end;
	}

	public boolean isFull() {
		return end == maxSize;
	}

	public void add(int val) {
		if (isFull()) {
			System.out.println("队列已满，无法添加数据");
			return;
		}
		arr[end++] = val;
	}

	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，无法取出数据");
		}
		return arr[first++];
	}

	public void showAll() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，无法取出数据");
		}
		for (int i = first; i < end; i++) {
			System.out.println(arr[i]);
		}
	}

	public int showFirst() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，无法取出数据");
		}
		return arr[first];
	}
}
