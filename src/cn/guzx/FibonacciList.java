package cn.guzx;

public class FibonacciList {

    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i <= n; i++) {
            System.out.println(fibList(i));
        }
    }

    public static int fibList(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fibList(i - 1) + fibList(i - 2);
        }
    }
}
