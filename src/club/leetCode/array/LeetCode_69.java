package club.leetCode.array;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/8/20 17:46
 * @describe 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class LeetCode_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x >> 1;
        while (left < right) {
            int mid = left + (right - left + 1 >> 1);
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                // 保留整数位
                left = mid;
            }
        }
        return left;
    }
}
