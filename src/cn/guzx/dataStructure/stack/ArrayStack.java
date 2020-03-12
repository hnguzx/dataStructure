package cn.guzx.dataStructure.stack;

import java.util.*;

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

//        String expression = "11+2*3+4*5";
        String expression = "1+((2+3)*4)-5";
//        System.out.println("计算结果是：" + stack.computerNumber(expression));

        System.out.println("中缀转前缀：");
        String result = stack.middleToFront(expression);
        System.out.println(result);
        System.out.println("计算前缀表达式的结果：");
        System.out.println(stack.computerFront(result));
        System.out.println("中缀转后缀：");
        String lastResult = stack.middleToLater(expression);
        System.out.println(lastResult);
        System.out.println("计算后缀表达式的结果：");
        System.out.println(stack.computerLast(lastResult));

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
            if (isOper(value)) { // 是操作符
                // 操作符栈为空
                if (!operation.isEmpty()) {
                    // 当前操作符的优先级小于栈顶操作符的优先级
                    if (operLevel(value) < operLevel(operation.peek())) {
                        number.push(computNumber(number.pop(), number.pop(), operation.pop()));
                        operation.push(value);
                    } else {
                        operation.push(value);
                    }
                } else {
                    operation.push(value);
                }
            } else { // 是数字
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
        if (c == '+' || c == '-' || c == '/' || c == '*' || c == '(' || c == ')') {
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

    // 进行计算 1+((2+3)*4)-5
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
                result = number2 - number1;
                break;
            default:
                break;
        }
        return result + 48;
    }

    // 中缀表达式转前缀表达式
    // 从右至左扫描中缀表达式。
    // 如果是操作数，则直接输出，作为前缀表达式的一个直接转换表达式Temp（最后，前缀表达式由该表达式翻转得到）；
    // 如果是运算符，则比较优先级：
    //  若该运算符优先级大于等于栈顶元素，则将该运算符入栈，
    //  否则栈内元素出栈并加到Temp表达式尾端，直到该运算符大于等于栈顶元素的优先级时，再将该运算符压入栈中。
    // 遇到右括号直接压入栈中，如果遇到一个左括号，那么就将栈元素弹出并加到Temp表达式尾端，但左右括号并不输出。
    // 最后，若运算符栈中还有元素，则将元素一次弹出并加到Temp表达式尾端，最后一步是将Temp表达式翻转。
    public String middleToFront(String middleStr) {
        // 从右至左扫描中缀表达式。
        // 如果是操作数，则直接输出，作为前缀表达式的一个直接转换表达式Temp（最后，前缀表达式由该表达式翻转得到）；
        // 如果是运算符，则比较优先级：
        // 若该运算符优先级大于等于栈顶元素，则将该运算符入栈，
        // 否则栈内元素出栈并加到Temp表达式尾端，直到该运算符大于等于栈顶元素的优先级时，再将该运算符压入栈中。
        // 遇到右括号直接压入栈中，如果遇到一个左括号，那么就将栈元素弹出并加到Temp表达式尾端，但左右括号并不输出。
        // 最后，若运算符栈中还有元素，则将元素一次弹出并加到Temp表达式尾端，最后一步是将Temp表达式翻转。
        String result = "";
        Stack2 numberStack2 = new Stack2(10);
        Stack2 operationStack = new Stack2(10);
        for (int i = middleStr.length() - 1; i >= 0; i--) {
            char value = middleStr.substring(i, i + 1).charAt(0);
            if (!isOper(value)) {
                result += value;
            } else {
                if (operationStack.isEmpty()) {
                    operationStack.push(value);
                } else if (value == ')') {
                    operationStack.push(value);
                } else if (value == '(') {
                    while (operationStack.peek() != ')') {
                        result += (char) operationStack.pop();
                    }
                    operationStack.pop();
                } else {
                    while (!operationStack.isEmpty() && isOper(operationStack.peek()) && operLevel(value) < operLevel(operationStack.peek())) {
                        if (operationStack.getCount() > 0) {
                            result += (char) operationStack.pop();
                        }
                    }
                    operationStack.push(value);
                }
            }
        }
        while (operationStack.getCount() > 0) {
            result += (char) operationStack.pop();
        }
        return result;
    }

    // 对前缀表达式进行计算
    //从右至左扫描表达式，遇到数字时，将数字压入堆栈，
    //遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（栈顶元素 和 次顶元素），
    //并将结果入栈；重复上述过程直到表达式最左端，最后运算得出的值即为表达式的结果
    public int computerFront(String str) {
        Stack<Integer> number = new Stack<>();
        String newStr = "";
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.substring(i, i + 1).charAt(0);
        }
        System.out.println("新的字符串：");
        System.out.println(newStr);
        // 扫描表达式
        for (int i = newStr.length() - 1; i >= 0; i--) {
            char value = newStr.substring(i, i + 1).charAt(0);
            if (!isOper(value)) {
                number.push((int) value);
            } else {
                number.push(computNumber(number.pop() - 48, number.pop() - 48, (char) value));
            }
        }

        return number.pop() - 48;
    }

    // 中缀表达式转后缀表达式
    // 左到右遍历中缀表达式的每个操作数和操作符。
    // 当读到操作数时，立即把它输出，即成为后缀表达式的一部分；
    // 若读到操作符，判断该符号与栈顶符号的优先级，
    //  若该符号优先级高于栈顶元素，则将该操作符入栈，
    //  否则就一次把栈中运算符弹出并加到后缀表达式尾端，直到遇到优先级低于该操作符的栈元素，然后把该操作符压入栈中。
    //  如果遇到”(”，直接压入栈中，如果遇到一个”)”，那么就将栈元素弹出并加到后缀表达式尾端，但左右括号并不输出。
    // 最后，如果读到中缀表达式的尾端，将栈元素依次完全弹出并加到后缀表达式尾端。
    public String middleToLater(String middleStr) {
        String number = "";
        Stack2 operation = new Stack2(100);
        for (int i = 0; i < middleStr.length(); i++) {
            char value = middleStr.substring(i, i + 1).charAt(0);
            if (!isOper(value)) {
                number+=value;
            } else {
                if (operation.isEmpty()) {
                    operation.push(value);
                } else if (value == '(') {
                    operation.push(value);
                } else if (value == ')') {
                    while (operation.peek() != '(' && !operation.isEmpty()) {
                        number+=(char)operation.pop();
                    }
                    operation.pop();
                } else if (operLevel(value) > operLevel(operation.peek())) {
                    operation.push(value);
                } else {
                    number+=(char)operation.pop();
                    while (operation.getCount() > 0 && operLevel(peek()) <= operLevel(value)) {
                        number+=(char)operation.pop();
                    }
                    operation.push(value);
                }
            }
        }
        while (operation.getCount() > 0) {
            number+=(char)operation.pop();
        }

        return number;
    }

    // 计算后缀表达式
    // 从左至右扫描表达式，遇到数字时，将数字压入堆栈，
    // 遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素）
    // 并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
    public int computerLast(String str) {
        Stack2 number = new Stack2(100);
        for (int i = 0; i < str.length(); i++) {
            char value = str.substring(i, i + 1).charAt(0);
            if (!isOper(value)) {
                number.push(value);
            } else {
                number.push(computNumber(number.pop()-48, number.pop()-48, value));
            }
        }
        return number.pop()-48;
    }
}
