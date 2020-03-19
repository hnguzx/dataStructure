package cn.guzx.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        int[] origin = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            origin[i] = (int) (Math.random() * 100000);
        }

//         int[] origin = new int[] { 9, 8, 1, 7, 2, 3, 5, 4, 6, 0 };

        System.out.println("排序前：");
        System.out.println(new Date());
//         System.out.println(Arrays.toString(origin));

        // bubb(origin); // 18s
        // select(origin); // 2s
        // insert(origin); // 4s
//         hill(origin); // 交换法：13s 移动法：<1s 8000000 4s
        fast(origin, 0, origin.length - 1); // <1s 8000000 2s

        System.out.println("排序后：");
        System.out.println(new Date());
//         System.out.println(Arrays.toString(origin));

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
            if (index != i) {
                origin[index + 1] = value;
            }
        }
    }

    // 希尔排序
    public static void hill(int[] origin) {
        int increment = origin.length / 2; // 增量
        int index = 0;
        int value = 0;
        while (increment > 0) {
            /*
             * for (int i = increment; i < origin.length; i++) { // 遍历各组数据 for (int j = i -
             * increment; j >= 0; j -= increment) { if (origin[j] > origin[j + increment]) {
             * value = origin[j + increment]; origin[j + increment] = origin[j]; origin[j] =
             * value; } } }
             */
            /*
             * for (int i = 0; i < origin.length; i++) { // 遍历各组数据 for (int j = i +
             * increment; j <origin.length; j += increment) { if (origin[i] > origin[j]) {
             * value = origin[i]; origin[i] = origin[j]; origin[j] = value; }
             *
             * } }
             */
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

        // 说明还没完成所有元素的排序
        while (l < r ) {
            // 左边元素小于中间元素，左指针右移
            while (origin[l] < middleValue) {
                l ++;
            }
            // 右边元素大于中间元素，右指针左移
            while (origin[r] > middleValue) {
                r --;
            }

            // 遍历完所有元素
            if (l >= r) {
                break;
            }

            // 左右元素进行位置交换
            temp = origin[l];
            origin[l] = origin[r];
            origin[r] = temp;

            // 右边有与中间元素相等的元素
            if (origin[l] == middleValue) {
                r--;
            }
            // 左边有与中间元素相等的元素
            if (origin[r] == middleValue) {
                l++;
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

    // 归并排序
    public static void merge() {

    }
}