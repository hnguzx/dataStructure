package club.lyteacher.LinkedList;

public class LinkedList {
	public static void main(String[] args) {
		
	}
}

class Linked {
	private LinkInfo headInfo = new LinkInfo(0, "");

	public void reverLinked() {
		if (headInfo.nextInfo == null || headInfo.nextInfo.nextInfo == null) {
			return;
		}
		// ��ʱͷ���
		LinkInfo reverInfo = new LinkInfo(0, "");
		// ���ڱ���
		LinkInfo tempInfo = headInfo.nextInfo;
		// ָ��ǰ�ڵ����һ�ڵ�
		LinkInfo nextInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo == null) {
				flag = false;
				break;
			} else {
				// ����һ���ڵ��ݴ���next��
				nextInfo = tempInfo.nextInfo;
				// ����ʱͷ���ָ��ԭ�����еĵڶ����ڵ�
				tempInfo.nextInfo = reverInfo.nextInfo;
				reverInfo.nextInfo = tempInfo;
				// �ƶ�����һ�ڵ�
				tempInfo = nextInfo;
			}
		}
		headInfo.nextInfo = reverInfo.nextInfo;
	}

	public void getLastK(int k) {
		if (headInfo.nextInfo == null) {
			System.out.println("����Ϊ�գ�");
		}
		int length = size();
		LinkInfo find = find(length - k + 1);
		System.out.println("������" + k + "�������ǣ�" + find);
	}

	public void clear() {
		if (headInfo.nextInfo == null) {
			System.out.println("�����Ѿ��ǿյ���!");
		} else {
			headInfo.nextInfo = null;
			System.out.println("�����Ѿ�������!");
		}
	}

	public int size() {
		if (headInfo.nextInfo == null) {
			System.out.println("����Ϊ��");
			return 0;
		}
		int length = 0;
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				flag = false;
				break;
			} else {
				length++;
				tempInfo = tempInfo.nextInfo;
			}
		}
		return length;
	}

	public void add(LinkInfo info) {
		LinkInfo tempInfo = headInfo;
		while (true) {
			if (tempInfo.nextInfo == null) {
				break;
			}
			tempInfo = tempInfo.nextInfo;
		}
		tempInfo.nextInfo = info;
	}

	public void addHead(LinkInfo info) {
		if (headInfo.nextInfo == null) {
			return;
		}
		info.nextInfo = headInfo.nextInfo;
		headInfo.nextInfo = info;
	}

	public void addBySort(LinkInfo info) {
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				tempInfo.nextInfo = info;
				flag = false;
				continue;
			}
			if (tempInfo.nextInfo.no > info.no) {
				info.nextInfo = tempInfo.nextInfo;
				tempInfo.nextInfo = info;
				flag = false;
			} else if(tempInfo.nextInfo.no == info.no){
				System.out.println("�ñ�ŵ������Ѵ��ڣ�");
				flag=false;
			}else{
				tempInfo = tempInfo.nextInfo;
			}
		}
	}

	public void deleteHead() {
		if (headInfo.nextInfo == null) {
			return;
		}
		LinkInfo temInfo = headInfo.nextInfo.nextInfo;
		headInfo.nextInfo = temInfo;
	}

	public void delete(int no) {
		if (headInfo.nextInfo == null) {
			System.out.println("����Ϊ��");
			return;
		}
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				System.out.println("��ǰ������û��Ҫɾ�������ݣ�" + no);
				flag = false;
				break;
			}
			if (tempInfo.nextInfo.no == no) {
				tempInfo.nextInfo = tempInfo.nextInfo.nextInfo;
				flag = false;
			} else {
				tempInfo = tempInfo.nextInfo;
			}

		}
	}

	public void update(LinkInfo info) {
		if (headInfo.nextInfo == null) {
			System.out.println("����Ϊ��");
			return;
		}
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				System.out.println("��ǰ������û��Ҫ�޸ĵ����ݣ���Ϊ�����������ݵ�������" + info);
				add(info);
				flag = false;
				break;
			}
			if (tempInfo.no == info.no) {
				tempInfo.name = info.name;
				flag = false;
			} else {
				tempInfo = tempInfo.nextInfo;
			}
		}
	}

	public LinkInfo find(int no) {
		if (headInfo.nextInfo == null) {
			System.out.println("����Ϊ��");
			return null;
		}
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				System.out.println("��ǰ������û��Ҫ���ҵ�����");
				flag = false;
				break;
			}
			if (tempInfo.no == no) {
				flag = false;
			} else {
				tempInfo = tempInfo.nextInfo;
			}
		}
		return tempInfo;
	}

	public void showAll() {
		if (headInfo.nextInfo == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��ʱ��������ͷָ�����һ������
		LinkInfo tempInfo = headInfo.nextInfo;
		while (true) {
			if (tempInfo == null) {
				break;
			}
			System.out.println(tempInfo.toString());
			tempInfo = tempInfo.nextInfo;
		}
	}
}

class LinkInfo {
	public int no;
	public String name;
	public LinkInfo nextInfo;

	public LinkInfo(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "LinkInfo [no=" + no + ", name=" + name + "]";
	}

}
