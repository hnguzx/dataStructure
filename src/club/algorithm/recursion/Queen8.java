package club.algorithm.recursion;

public class Queen8 {
    /**
     * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击， 即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
     * 
     * @param args
     */
    public static int[] checkboard = new int[8];
    static int count = 0;

    public static void main(String[] args) {
        place(0);
        System.out.printf("一共有%d种解决方案", count);
    }

    /**
     * 第一个皇后先放第一行第一列 第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
     * 继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
     * 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
     * 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
     */

    // 放置数据,n表示是第几个数据---行
    private static void place(int n) {
        if (n == checkboard.length) {
            count++;
            printResult(checkboard);
            return;
        }

        for (int i = 0; i < checkboard.length; i++) {
            checkboard[n] = i;
            if (judge(n)) {
                place(n + 1);
            }
        }
    }

    // 判断位置是否可以放置，n表示是第几个数据
    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // checkboard[i]==checkboard[n]:同一列
            // Math.abs(n - i) == Math.abs(checkboard[n] - checkboard[i]):对角线
            if (checkboard[i] == checkboard[n]
                    || Math.abs(n - i) == Math.abs(checkboard[n] - checkboard[i])) {
                return false;
            }
        }
        return true;
    }

    // 打印一次成功的结果
    private static void printResult(int[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.printf("%d\t", results[i]);
        }
        System.out.println();
    }
}