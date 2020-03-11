package cn.guzx.stack;

/**
 * 数组实现栈
 */
public class ArrayStack {
    public static void main(String[] args) {
        Stack2 stack = new Stack2(3);
        /*stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("当前共有：" + stack.getCount());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("展示栈中所有数据");
        stack.showAll();
        System.out.println("展示栈中所有数据");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());*/

        String expression = "1+2*3+4*5";
        System.out.println("计算结果是：" + stack.computerNumber(expression));

    }
}

class Stack2 {
    private int size; // 栈的容量
    private int[] arrayList; // 用于保存数据
    private int head; // 指向栈顶

    public Stack2(int size) {
        this.size = size;
        arrayList = new int[size];
        head = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        head++;
        arrayList[head] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空");
            return 0;
        }
        int result = arrayList[head];
        head--;
        return result;
    }

    public int peek() {
        return arrayList[head];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head + 1 == size;
    }

    public int getCount() {
        return head + 1;
    }

    public void showAll() {
        for (int i = head; i >= 0; i--) {
            System.out.println(arrayList[i]);
        }
    }

    // 表达式计算
    public static int computerNumber(String str) {

        // 最终结果
        int result = 0;
        Stack2 number = new Stack2(10);
        Stack2 operation = new Stack2(10);

        // 扫描表达式
        for (int i = 0; i < str.length(); i++) {
            char value = str.substring(i, i + 1).charAt(0);
            // 是操作符

            if (isOper(value)) {
                // 操作符栈为空
                if (!operation.isEmpty()) {
                    // 当前操作符的优先级小于栈顶操作符的优先级
                    if (operLevel(value) < operLevel(operation.peek())) {
                        number.push(computNumber(number.pop(), number.pop(), operation.pop()));
                    }
                } // 是数字
                operation.push(value);
            } else {
                number.push(value);
            }
        }

        // 进行计算
        while (!operation.isEmpty()) {
            result = computNumber(number.pop(), number.pop(), operation.pop());
            number.push(result);
        }

        return number.pop();
    }

    // 判读字符是否是操作符号
    public static boolean isOper(int c) {
        if (c == '+' || c == '-' || c == '/' || c == '*') {
            return true;
        }
        return false;
    }

    // 判断操作符的等级
    public static int operLevel(int c) {
        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 进行计算
    public static int computNumber(int number1, int number2, int oper) {
        int result = 0;
        switch (oper) {
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            default:
                break;
        }
        return result;
    }
}
