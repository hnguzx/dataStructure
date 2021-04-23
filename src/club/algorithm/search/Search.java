package club.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        int origin[] = new int[10];
        for (int i = 0; i < 10; i++) {
            origin[i] = i * 2;
        }
        System.out.println(Arrays.toString(origin));
        // int index = linearFind(origin,2);
        // int index = halfFind(origin,0,origin.length-1,2);
        // List<Integer> index = halfFind2(origin,0,origin.length-1,2);
        // int index = interpolationFind(origin, 0, origin.length - 1, 15);
        int index =fabonacciFind(origin,8);
        System.out.println(index);
    }

    // 线性查找
    public static int linearFind(int[] origin, int value) {
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // 二分查找，查找单值
    public static int halfFind(int[] origin, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (value < origin[mid]) {
            return halfFind(origin, left, mid - 1, value);
        } else if (value > origin[mid]) {
            return halfFind(origin, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    // 二分查找，查找多值
    public static List<Integer> halfFind2(int[] origin, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return new ArrayList<Integer>();
        }
        if (value < origin[mid]) {
            return halfFind2(origin, left, mid - 1, value);
        } else if (value > origin[mid]) {
            return halfFind2(origin, mid + 1, right, value);
        } else {
            List<Integer> results = new ArrayList<Integer>();

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || origin[temp] != value) {
                    break;
                }
                results.add(temp);
                temp--;
            }

            results.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > origin.length - 1 || origin[temp] != value) {
                    break;
                }
                results.add(temp);
                temp++;
            }

            return results;
        }
    }

    // 插值查找
    public static int interpolationFind(int[] origin, int left, int right, int value) {
        if (left > right || value > origin[origin.length - 1] || value < origin[0]) {
            return -1;
        }
        int sign = left + (right - left) * (value - origin[left]) / (origin[right] - origin[left]);

        if (value > origin[sign]) {
            return interpolationFind(origin, sign + 1, right, value);
        } else if (value < origin[sign]) {
            return interpolationFind(origin, left, sign - 1, value);
        } else {
            return sign;
        }
    }

    // 斐波那契查找
    public static int fabonacciFind(int[] origin, int value) {
        int left = 0;
        int right = origin.length - 1;
        int k = 0; // 表示第K个斐波那契数
        int mid = 0;
        // 获取斐波那契数列
        int f[] = fibList2(20);
        // 找到最接近且不小于原数组长度的斐波那契数
        while (right > f[k]) {
            k++;
        }

        // 实际数组的长度可能会小于该斐波那契数，多余的位置用最大值替换
        int temp[] = Arrays.copyOf(origin, f[k]);
        for (int i = right; i < f[k]; i++) {
            temp[i] = origin[right];
        }

        // 开始查找，left<=right说明数组还没遍历完
        while (left <= right) {
            mid = left + f[k - 1] - 1;
            // 寻找的值小于中间值
            if (value < origin[mid]) {
                right = mid - 1;
                k--;
            // 寻找的值大于中间值
            } else if (value > origin[mid]) {
                left = mid + 1;
                k -= 2;
            } else {
                // 后面多个一样的值得时候，取小的那个值
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
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
