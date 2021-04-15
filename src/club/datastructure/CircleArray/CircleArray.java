package club.datastructure.CircleArray;

import java.util.Scanner;

public class CircleArray {
	public static void main(String[] args) {
		CircleQueue queue = new CircleQueue(4);
		boolean loop = true;
		char input = ' ';
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.printf("s(show)");
			System.out.printf("e(exit)");
			System.out.printf("a(add)");
			System.out.printf("g(get)");
			System.out.printf("h(head)");
			input = scanner.next().charAt(0);
			switch (input) {
			case 's':
				try {
					queue.showAll();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'a':
				System.out.println("");
				int value = scanner.nextInt();
				try {
					queue.add(value);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'g':
				try {
					int res = queue.get();
					System.out.printf("", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.showFirst();
					System.out.printf("", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}

class CircleQueue {
	int maxSize;
	int first;
	int end;
	int[] arr;

	public CircleQueue(int size) {
		maxSize = size;
		first = 0;
		end = 0;
		arr = new int[maxSize];
	}

	public boolean isEmpty() {
		return first == end;
	}

	public boolean isFull() {
		return (end + 1) % maxSize == first;
	}

	public void add(int val) {
		if (isFull()) {
			System.out.println("");
			return;
		}
		arr[end] = val;
		end = (end + 1) % maxSize;
	}

	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("");
		}
		int temp = arr[first];
		first = (first + 1) % maxSize;
		return temp;
	}

	public void showAll() {
		if (isEmpty()) {
			throw new RuntimeException("");
		}
		System.out.println(""+size());
		for (int i = first; i < first + size(); i++) {
			System.out.println(arr[i%maxSize]);
		}
	}

	public int size() {
		System.out.println("end:"+end+"first:"+first+"maxSize:"+maxSize);
		return (end - first + maxSize) % maxSize;
	}

	public int showFirst() {
		if (isEmpty()) {
			throw new RuntimeException("");
		}
		return arr[first];
	}
}