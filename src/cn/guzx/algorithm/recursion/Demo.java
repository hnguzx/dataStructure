package cn.guzx.algorithm.recursion;

public class Demo {
    

    public static void main(String[] args) {
        /*printNumber(5);
        System.out.println("阶乘结果：" + compute(3));
        System.out.println("金字塔打印");
        printPya(3);
        System.out.println("倒金字塔打印");
        printPyaRev(3);*/
        System.out.println("阶乘结果：" + compute(4));

        
    }

    // 顺序打印
    public static void printNumber(int n) {
        if (n > 1) {
            printNumber(n - 1);
        }
        System.out.println(n);
    }

    // 计算阶乘
    public static int compute(int n) {
        if (n > 1) {
            return compute(n - 1) * n;
        } else {
            return 1;
        }
    }

    // 打印金字塔
    public static void printPya(int n) {
        if (n > 1) {
            printPya(n - 1);
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // 打印倒金字塔
    public static void printPyaRev(int n) {
        if (n == 1) {
            System.out.print("*");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
            printPyaRev(n - 1);
        }
    }

    

    // 八皇后问题
    public static void eightQueen(int[][] chess, int startX, int StartY){

    }
}
