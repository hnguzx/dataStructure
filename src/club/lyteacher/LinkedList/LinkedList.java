package club.lyteacher.LinkedList;
/**
 * 单向链表
 * @author guzx
 *
 */
public class LinkedList {
	public static void main(String[] args) {
		Linked linked= new Linked();
		LinkInfo info1 =new LinkInfo(1,"guzx");
		LinkInfo info2 =new LinkInfo(2,"lianghong");
		LinkInfo info3 =new LinkInfo(3,"changchun");
		linked.add(info1);
		linked.addHead(info2);
		linked.addHead(info3);
		linked.showAll();
		linked.reverLinked();
		linked.showAll();
	}
}
/**
 * 链表
 * @author guzx
 *
 */
class Linked {
	private LinkInfo headInfo = new LinkInfo(0, "");

	/**
	 *使用三个指针 将链表反转
	 */
	public void reverLinked() {
		if (headInfo.nextInfo == null || headInfo.nextInfo.nextInfo == null) {
			System.out.println("链表为空或只有一个元素，无需反转！");
			return;
		}
		//反转的临时表头
		LinkInfo reverInfo = new LinkInfo(0, "");
		//链表中的第一个元素
		LinkInfo tempInfo = headInfo.nextInfo;
		//临时保存当前的第二个元素
		LinkInfo nextInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo == null) {
				flag = false;
				break;
			} else {
				//先将后面一个元素取出，用于移动元素
				nextInfo = tempInfo.nextInfo;
				//头部添加元素
				tempInfo.nextInfo = reverInfo.nextInfo;
				reverInfo.nextInfo = tempInfo;
				//temp后移
				tempInfo = nextInfo;
			}
		}
		headInfo.nextInfo = reverInfo.nextInfo;
	}

	//获取倒数第K个元素
	public void getLastK(int k) {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空");
		}
		int length = size();
		LinkInfo find = find(length - k + 1);
		System.out.println("倒数第" + k + "个元素为：" + find);
	}

	//清空链表
	public void clear() {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空！");
		} else {
			headInfo.nextInfo = null;
			System.out.println("链表已清空！");
		}
	}

	//获取链表的长度
	public int size() {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空！");
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

	//在末尾新增
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
	
	//在头部新增
	public void addHead(LinkInfo info) {
//		if (headInfo.nextInfo == null) {
//			return;
//		}
		info.nextInfo = headInfo.nextInfo;
		headInfo.nextInfo = info;
	}

	//按编号顺序新增
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
				System.out.println("已存在该序号的元素，不可重复添加！");
				flag=false;
			}else{
				tempInfo = tempInfo.nextInfo;
			}
		}
	}

	//删除头部元素
	public void deleteHead() {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空，无法执行删除操作！");
			return;
		}
		LinkInfo temInfo = headInfo.nextInfo.nextInfo;
		headInfo.nextInfo = temInfo;
	}

	//删除指定编号的元素
	public void delete(int no) {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空，无法执行删除操作！");
			return;
		}
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				System.out.println("不存在指定编号的元素：" + no);
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

	//更新指定编号的元素
	public void update(LinkInfo info) {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空，无法执行更新操作");
			return;
		}
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				System.out.println("链表中未找到指定元素，先将元素添加到链表中！" + info);
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

	//查找指定编号的元素
	public LinkInfo find(int no) {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空！");
			return null;
		}
		LinkInfo tempInfo = headInfo;
		boolean flag = true;
		while (flag) {
			if (tempInfo.nextInfo == null) {
				System.out.println("未查找到指定编号的元素");
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
	
	//显示链表中的所有元素
	//显示链表中的所有元素
	public void showAll() {
		if (headInfo.nextInfo == null) {
			System.out.println("链表为空");
			return;
		}
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

/**
 * 节点元素
 * @author guzx
 *
 */
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
