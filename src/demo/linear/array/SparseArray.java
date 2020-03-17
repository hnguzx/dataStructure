package demo.linear.array;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

/*
  稀疏数组:当一个数组大部分为同一个值的时候，可以用稀疏数组来保存该数组
*/
public class SparseArray {

    @Test
    public void demo1() throws IOException {
        File file = new File("src/cn/files/t1.txt");
        PrintWriter writer = new PrintWriter(file);

        int[][] origArray = new int[5][6];
        int[][] sparseArray;
        int total = 0;
        int row = 0;
        origArray[0][2] = 1;
        origArray[1][2] = 1;
        for (int i = 0; i < origArray.length; i++) {
            for (int j = 0; j < origArray[i].length; j++) {
                System.out.printf("%d \t", origArray[i][j]);
                if (origArray[i][j] != 0) {
                    total++;
                }
            }
            System.out.println();
        }

        row = total + 1;
        sparseArray = new int[row][3];
        sparseArray[0][0] = origArray.length;
        sparseArray[0][1] = origArray[0].length;
        sparseArray[0][2] = total;


        int count = 1;
        for (int i = 0; i < origArray.length; i++) {
            for (int j = 0; j < origArray[i].length; j++) {
                if (origArray[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = origArray[i][j];
                    count++;
                }
            }
        }

        for (int[] ints : sparseArray) {
            for (int j = 0; j < ints.length; j++) {
                System.out.printf("%d \t", ints[j]);
                writer.print(ints[j] + "\t");
            }
            System.out.println();
            writer.print("\n");
        }
        writer.close();

        Scanner input = new Scanner(new File("src/cn/files/t1.txt"));

        int count2 = 0;

        while (input.hasNext()) {
            int t1 = input.nextInt();
            sparseArray[(count2 / 3)][count2++ % 3] = t1;
        }

        System.out.println("行：" + sparseArray.length + "列：" + sparseArray[0].length);
        System.out.println("读取回来的：");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.printf("%d \t", sparseArray[i][j]);
                writer.print(sparseArray[i][j] + "\t");
            }
            System.out.println();
            writer.print("\n");
        }


        int[][] restoreArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            restoreArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int i = 0; i < restoreArray.length; i++) {
            for (int j = 0; j < restoreArray[i].length; j++) {
                System.out.printf("%d \t", restoreArray[i][j]);
                if (restoreArray[i][j] != 0) {
                }
            }
            System.out.println();
        }
    }
}
