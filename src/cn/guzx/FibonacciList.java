package cn.guzx;

import java.util.Arrays;

public class FibonacciList {

    public static void main(String[] args) {
        // int n = 10;
        // for (int i = 1; i <= n; i++) {
        // System.out.println(fibList(i));
        // }
        System.out.println(Arrays.toString(fibList2(8)));
    }

    // 递归生成斐波那契数列
    public static int fibList(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fibList(i - 1) + fibList(i - 2);
        }
    }

    // 非递归生成斐波那契数列
    public static int[] fibList2(int size) {

        int[] result = new int[size];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
