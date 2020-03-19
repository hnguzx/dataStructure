package cn.guzx.algorithm.sort;


import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        int[] origin = new int[100000];
        for (int i = 0; i < 100000; i++) {
            origin[i] = (int) (Math.random() * 100000);
        }

//        int[] origin = new int[]{9, 8, 1, 7, 2, 3, 5, 4, 6, 0};

        System.out.println("排序前：");
        System.out.println(new Date());
        // System.out.println(Arrays.toString(origin));

        // bubb(origin); // 18s
        // select(origin); // 2s
//        insert(origin); // 4s
        hill(origin); // 交换法：13s  移动法：1s

        System.out.println("排序后：");
        System.out.println(new Date());
        System.out.println(Arrays.toString(origin));

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
            /*for (int i = increment; i < origin.length; i++) {
                // 遍历各组数据
                for (int j = i - increment; j >= 0; j -= increment) {
                    if (origin[j] > origin[j + increment]) {
                        value = origin[j + increment];
                        origin[j + increment] = origin[j];
                        origin[j] = value;
                    }
                }
            }*/
            /*for (int i = 0; i < origin.length; i++) {
                // 遍历各组数据
                for (int j = i + increment; j <origin.length; j += increment) {
                    if (origin[i] > origin[j]) {
                        value = origin[i];
                        origin[i] = origin[j];
                        origin[j] = value;
                    }

                }
            }*/
            for (int i = increment; i < origin.length; i++) {
                // 遍历各组数据
                // 98172 35460
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
    public static void fast(int[] origin){

    }

    // 归并排序
    public static void merge(){

    }
}