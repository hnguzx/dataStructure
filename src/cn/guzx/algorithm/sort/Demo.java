package cn.guzx.algorithm.sort;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        // int[] orgin = new int[100000];
        // for (int i = 0; i < 100000; i++) {
        // orgin[i] = (int) (Math.random() * 100000);
        // }

        int[] orgin = new int[10];
        // for (int i = 8; i > 0; i--) {
        //     orgin[8 - i] = i;
        // }
        orgin[0]= 8;
        orgin[1]= 9;
        orgin[2]= 1;
        orgin[3]= 7;
        orgin[4]= 2;
        orgin[5]= 3;
        orgin[6]= 5;
        orgin[7]= 4;
        orgin[8]= 6;
        orgin[9]= 0;

        System.out.println("排序前：");
        System.out.println(new Date());
        for (int i : orgin) {
            System.out.print(i + " ");
        }
        // System.out.println();

        // bubb(orgin); // 18s
        // select(orgin); // 2s
        // insert(orgin); // 4s
        xier(orgin);

        System.out.println("排序后：");
        System.out.println(new Date());
        for (int i : orgin) {
            System.out.print(i + " ");
        }

    }

    public static void bubb(int[] orgin) {
        int temp = 0;
        for (int i = 0; i < orgin.length; i++) {
            for (int j = i + 1; j < orgin.length; j++) {
                if (orgin[i] > orgin[j]) {
                    temp = orgin[i];
                    orgin[i] = orgin[j];
                    orgin[j] = temp;
                }
            }
        }
    }

    public static void select(int[] orgin) {
        int index;
        int value;

        for (int i = 0; i < orgin.length; i++) {
            index = i;
            value = orgin[i];
            for (int j = i + 1; j < orgin.length; j++) {
                if (orgin[j] < value) {
                    index = j;
                    value = orgin[j];
                }
            }
            orgin[index] = orgin[i];
            orgin[i] = value;
        }

    }

    public static void insert(int[] orgin) {

        int index;
        int value;
        for (int i = 1; i < orgin.length; i++) {
            index = i - 1;
            value = orgin[i];
            while (index >= 0 && value < orgin[index]) {
                orgin[index + 1] = orgin[index];
                index--;
            }
            if (index != i) {
                orgin[index + 1] = value;
            }
        }
    }

    public static void xier(int[] orgin) {
        int increment = orgin.length / 2; // 增量
        int index = 0;
        int value = 0;
        while (increment != 1) {
            for (int i = 0; i < orgin.length / 2; i++) {
                value = orgin[i];
                index = i;
                while (i + increment < orgin.length && orgin[index] > orgin[index + increment] ) {
                    index = i + increment;
                    value = orgin[i + increment];
                }
                orgin[i + increment] = orgin[i];
                orgin[i] = value;
            }
            increment = increment / 2;
        }
    }
}