package cn.guzx.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        int[] origin = new int[80000];
        for (int i = 0; i < 80000; i++) {
            origin[i] = (int) (Math.random() * 10000);
        }

//        int[] origin = new int[]{9, 2, 1, 7, 2, 3, 5, 4, 6, 0, 12};
//        int[] origin = new int[]{53, 3, 542, 748, 14, 214};

        System.out.println("排序前：");
        System.out.println(new Date().getTime());
//        System.out.println(Arrays.toString(origin));
        // 八万个随机数据的测试时间
//        bubble(origin); // 9.3
//        select(origin); // 1.7s
//        insert(origin); // 0.5s
//        hill(origin); // 交换法：6.7s 移动法：0.01s
//         fast(origin, 0, origin.length - 1); // 0.03s
//        merge(origin, 0, origin.length - 1); // 2.5s
        bucket(origin); // 0.01s

        System.out.println("排序后：");
        System.out.println(new Date().getTime());
//        System.out.println(Arrays.toString(origin));

    }

    // 冒泡排序
    public static void bubble(int[] origin) {
        int temp = 0;
        boolean isContinue = false;
        for (int j = 0; j < origin.length; j++) {
            isContinue = false;
            for (int i = 0; i < origin.length - 1 - j; i++) {
                if (origin[i] > origin[i + 1]) {
                    isContinue = true;
                    temp = origin[i];
                    origin[i] = origin[i + 1];
                    origin[i + 1] = temp;
                }
            }
            if (!isContinue) {
                break;
            }
        }
    }

    // 选择排序
    public static void select(int[] origin) {
        int index;
        int value;

        for (int i = 0; i < origin.length; i++) {
            index = i;
            value = origin[i];
            for (int j = i + 1; j < origin.length; j++) {
                if (origin[j] < value) {
                    index = j;
                    value = origin[j];
                }
            }
            origin[index] = origin[i];
            origin[i] = value;
        }
    }

    // 插入排序
    public static void insert(int[] origin) {

        int index;
        int value;
        for (int i = 1; i < origin.length; i++) {
            index = i - 1;
            value = origin[i];
            while (index >= 0 && value < origin[index]) {
                origin[index + 1] = origin[index];
                index--;
            }
            origin[index + 1] = value;
        }
    }

    // 希尔排序
    public static void hill(int[] origin) {
        int increment = origin.length / 2; // 增量
        int index = 0;
        int value = 0;
        while (increment > 0) {
//            for (int i = increment; i < origin.length; i++) {
//                // 遍历各组数据
//                for (int j = i - increment; j >= 0; j -= increment) {
//                    if (origin[j] > origin[j + increment]) {
//                        value = origin[j + increment];
//                        origin[j + increment] = origin[j];
//                        origin[j] = value;
//                    }
//                }
//            }
            for (int i = increment; i < origin.length; i++) {
                // 遍历各组数据
                index = i; // 用于保存未排序的第一个数的下标
                value = origin[i]; // 用于保存未排序的第一个数
                if (index < origin.length) {
                    while (index - increment >= 0 && origin[index - increment] > value) {
                        origin[index] = origin[index - increment];
                        index -= increment;
                    }
                    origin[index] = value;
                }
            }
            increment = increment / 2;
        }
    }

    // 快速排序
    public static void fast(int[] origin, int left, int right) {
        int l = left;
        int r = right;
        int middleValue = origin[(left + right) / 2]; // 用于保存中间值
        int temp = 0; // 用于交换位置

        // 完成一次交换
        while (l < r) {
            // 左边元素小于中间元素，左指针右移，直到找到大于中间元素的数据
            while (origin[l] < middleValue) {
                l++;
            }
            // 右边元素大于中间元素，右指针左移，直到找到小于中间元素的数据
            while (origin[r] > middleValue) {
                r--;
            }

            // 遍历完所有元素
            if (l >= r) {
                break;
            }

            // 左右元素进行位置交换
            temp = origin[l];
            origin[l] = origin[r];
            origin[r] = temp;

            // 左边有与中间元素相等的元素
            if (origin[l] == middleValue) {
                l++;
            }
            // 右边有与中间元素相等的元素
            if (origin[r] == middleValue) {
                r--;
            }
        }
        // 左边两边同时走到中间，防止死循环
        if (l == r) {
            l++;
            r--;
        }
        // 右边遍历完后左边还有元素
        if (left < r) {
            fast(origin, left, r);
        }
        // 左边遍历完后左边还有元素
        if (right > l) {
            fast(origin, l, right);
        }
    }

    // 归并排序 分治
    public static void merge(int[] origin, int left, int right) {
        // 说明分解后的数组长度大于1
        if (left < right) {
            // 通过递归将原数组分解
            int mid = (right + left) / 2;
            // 向左分解
            merge(origin, left, mid);
            // 向右分解
            merge(origin, mid + 1, right);
            // 进行合并
            int l = left;
            int r = mid + 1;
            int t = 0;

            // 遍历两部分
            // 用于临时保存过程中的数据
            int[] temp = new int[origin.length];

            while (l <= mid && r <= right) {
                if (origin[l] < origin[r]) {
                    temp[t++] = origin[l++];
                } else {
                    temp[t++] = origin[r++];
                }
            }

            while (l <= mid) {
                temp[t++] = origin[l++];
            }
            while (r <= right) {
                temp[t++] = origin[r++];
            }

            t = 0;
            int tempLeft = left;
//            System.out.println("tempLeft：" + tempLeft + "right：" + right);
            while (tempLeft <= right) {
                origin[tempLeft++] = temp[t++];
            }
//            System.out.println(Arrays.toString(origin));
        }
    }

    // 基数排序（桶排序）
    public static void bucket(int[] origin) {
        int bocket[][] = new int[10][origin.length]; // 桶
        int temp[] = new int[bocket.length]; //用于保存每个桶中有效数据的个数

        // 获取最大数的位数
        int max = origin[0];
        for (int l = 0; l < origin.length; l++) {
            if (origin[l] > max) {
                max = origin[l];
            }
        }
        int lenght = (max + "").length();

        for (int k = 0, n = 1; k < lenght; k++, n *= 10) {
            // 将数据放入桶中
            for (int i = 0; i < origin.length; i++) {
                int digit = origin[i] / n % 10;
                bocket[digit][temp[digit]] = origin[i];
                temp[digit]++;
            }
            // 将数据从桶中取出
            int count = 0;
            for (int m = 0; m < temp.length; m++) {
                if (temp[m] != 0) {
                    for (int j = 0; j < temp[m]; j++) {
                        origin[count++] = bocket[m][j];
                    }
                }
                temp[m] = 0;
            }
        }
    }
}