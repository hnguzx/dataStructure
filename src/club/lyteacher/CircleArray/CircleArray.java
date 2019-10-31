package club.lyteacher.CircleArray;
/**
 * ��ʵ��ѭ������
 * ��һ��Ԥ���ռ�δ������
 */
import java.util.Scanner;

public class CircleArray {
	public static void main(String[] args) {
		CircleQuerer querer = new CircleQuerer(4);
		boolean loop = true;
		char input = ' ';
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.printf("s(show): ��ʾ����\t");
			System.out.printf("e(exit): �˳�����\t");
			System.out.printf("a(add): ������ݵ�����\t");
			System.out.printf("g(get): �Ӷ���ȡ������\t");
			System.out.printf("h(head): �鿴����ͷ������\t");
			input = scanner.next().charAt(0);// ����һ���ַ�
			switch (input) {
			case 's':
				try {
					querer.showAll();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				try {
					querer.add(value);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'g': // ȡ������
				try {
					int res = querer.get();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // �鿴����ͷ������
				try {
					int res = querer.showFirst();
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // �˳�
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}

class CircleQuerer {
	int maxSize;
	int first;
	int end;
	int[] arr;

	public CircleQuerer(int size) {
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
			System.out.println("�����������޷��������");
			return;
		}
		arr[end] = val;
		end = (end + 1) % maxSize;
	}

	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		int temp = arr[first];
		first = (first + 1) % maxSize;
		return temp;
	}

	public void showAll() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		System.out.println("��ǰ�������ж��ٸ�Ԫ�أ�"+size());
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
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		return arr[first];
	}
}