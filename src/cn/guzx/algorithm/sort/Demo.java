package cn.guzx.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        int[] origin = new int[80000];
        for (int i = 0; i < 80000; i++) {
            origin[i] = (int) (Math.random() * 80000);
        }

//        System.out.println("开始时间：" + new Date());
//        bubble(origin);
//        System.out.println("结束时间：" + new Date());

        System.out.println("开始时间：" + new Date());
        select(origin);
        System.out.println("结束时间：" + new Date());
        System.out.println("排序结果：");
        for (int i =0;i<20;i++){
            System.out.print(origin[i]+",");
        }

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
        for (int i = 0; i < origin.length - 1; i++) {
            int temp = origin[i]; // 当前最小数
            int minIndex = i;   // 当前最小数的下标
            for (int j = i + 1; j < origin.length; j++) {
                if (origin[minIndex] > origin[j]) {
                    temp = origin[j];
                    minIndex = j;
                }
            }
            origin[minIndex] = origin[i];
            origin[i] = temp;
        }
    }

    // 插入排序
    public static void insert(int[] origin){}

}