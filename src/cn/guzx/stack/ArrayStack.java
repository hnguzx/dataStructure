package cn.guzx.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数组实现栈
 */
public class ArrayStack {
    public static void main(String[] args) {
        Stack2 stack = new Stack2(3);
        /*
         * stack.push(1); stack.push(2); stack.push(3); stack.push(4);
         * System.out.println("当前共有：" + stack.getCount());
         * System.out.println(stack.pop()); System.out.println(stack.pop());
         * System.out.println("展示栈中所有数据"); stack.showAll();
         * System.out.println("展示栈中所有数据"); System.out.println(stack.pop());
         * System.out.println(stack.pop()); stack.push(5);
         * System.out.println(stack.pop());
         */

        String expression = "1+((2+3)*4)–5";
        // System.out.println("计算结果是：" + stack.computerNumber(expression));

        System.out.println("中缀转前缀：");
        String result = stack.middleToFront(expression);
        System.out.println(result);

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

    // 获取栈顶元素的值
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
    public int computerNumber(String str) {

        // 最终结果
        int result = 0;
        Stack2 number = new Stack2(10);
        Stack2 operation = new Stack2(10);
        String inputNumber = "";

        // 扫描表达式
        for (int i = 0; i < str.length(); i++) {
            char value = str.substring(i, i + 1).charAt(0);
            // 是操作符 111+2*3+4*5

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
                inputNumber += value - 48;
                if (i < str.length() - 1) {
                    while (!isOper(str.substring(i + 1, i + 2).charAt(0))) {
                        inputNumber += value - 48;
                        i++;
                    }
                }
                number.push(Integer.parseInt(inputNumber));
                inputNumber = "";
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
        if (c == '+' || c == '-' || c == '/' || c == '*'|| c == '('|| c == ')') {
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

    // 进行计算 1+2*3+4*5
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

    // 中缀表达式转前缀表达式
    public String middleToFront(String middleStr) {
        // 从右至左扫描中缀表达式。
        // 如果是操作数，则直接输出，作为前缀表达式的一个直接转换表达式Temp（最后，前缀表达式由该表达式翻转得到）；
        // 如果是运算符，则比较优先级：
        // 若该运算符优先级大于等于栈顶元素，则将该运算符入栈，
        // 否则栈内元素出栈并加到Temp表达式尾端，直到该运算符大于等于栈顶元素的优先级时，再将该运算符压入栈中。
        // 遇到右括号直接压入栈中，如果遇到一个左括号，那么就将栈元素弹出并加到Temp表达式尾端，但左右括号并不输出。
        // 最后，若运算符栈中还有元素，则将元素一次弹出并加到Temp表达式尾端，最后一步是将Temp表达式翻转。
        // 111+2*3+4*5 ===>  54*32*+111+
        String result = "";
        Stack2 numberStack2 = new Stack2(100);
        Stack2 operationStack = new Stack2(100);
        for (int i = middleStr.length() - 1; i >= 0; i--) {
            char value = middleStr.substring(i, i + 1).charAt(0);
            if (!isOper(value)) {
                // result += value;
                numberStack2.push(value);
            } else {
                if (operationStack.isEmpty()) {
                    operationStack.push(value);
                } else if (value == ')') {
                    operationStack.push(value);
                } else if (value == '(') {
                    while (operationStack.peek() != ')') {
                        result+=(char)operationStack.pop();
                    }
                    operationStack.pop();
                } else {
                    while (!operationStack.isEmpty() && isOper(operationStack.peek()) && operLevel(value) <= operLevel(operationStack.peek())) {
                        if (operationStack.size > 0) {
                            result+=(char)operationStack.pop();
                        }
                    }

                    operationStack.push(value);
                }
            }
        }
        while(operationStack.getCount()>0){
            result+=(char)operationStack.pop();
        }
        return result;
    }

    // 对前缀表达式进行计算
    // public int computerFront(String str) {
    // List<Integer> number = new ArrayList<>();
    // Stack<Integer> operation = new Stack<>();

    // // 扫描表达式
    // for (int i = 0; i < str.length(); i++) {
    // char value = str.substring(i, i + 1).charAt(0);
    // if (isOper(value)) {
    // // 操作符栈为空

    // }
    // }

    // return 0;
    // }
}
