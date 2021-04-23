package club.algorithm.commonAlgorithm;

/**
 * 动态规划问题
 */
public class DynamicPlanning {
    public static void main(String[] args) {
        // 物品的价值
        int[] value = {1500, 3000, 2000};
        // 物品的重量
        int[] weight = {1, 4, 3};
        // 背包的容量
        int capacity = 4;
        // 物品的个数
        int number = weight.length;

        // int [i][j]表示前i个物品中能够装入容量为j的背包中的最大价值
        int val[][] = new int[number + 1][capacity + 1];
        // 为了记录放入商品的情况
        int path[][] = new int[number + 1][capacity + 1];

        for (int i = 0; i < val.length; i++) {
            val[i][0] = 0;
        }

        for (int i = 0; i < val[0].length; i++) {
            val[0][i] = 0;
        }

        for (int i = 1; i < val.length; i++) {
            for (int j = 1; j < val[0].length; j++) {
                if (weight[i - 1] > j) {
                    val[i][j] = val[i - 1][j];
                } else {
                    if (val[i - 1][j] < value[i - 1] + val[i-1][j - weight[i - 1]]) {
                        val[i][j] = value[i - 1] + val[i - 1][j - weight[i - 1]];
                        path[i][j]=1;
                    } else {
                        val[i][j] = val[i - 1][j];
                    }
                }
            }
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包中\n", i);
                j -= weight[i - 1];
            }
            i--;
        }
    }
}
