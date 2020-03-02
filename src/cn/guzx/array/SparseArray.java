package cn.guzx.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SparseArray {

    public static void main(String[] args) throws FileNotFoundException {
        // 初始数组
        int[][] originArray = new int[5][5];
        originArray[0][0] = 1;
        originArray[1][1] = 2;
        originArray[2][2] = 3;
        originArray[3][3] = 4;
        originArray[4][4] = 5;

        // 获取总有效数据的数量
        int count = 0;
        for (int[] list : originArray) {
            for (int value : list) {
                if (value != 0) {
                    count++;
                }
            }
        }

        System.out.println("原始数组");
        for (int[] array : originArray) {
            for (int value : array) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }

        // 压缩后的数组
        int[][] compress = new int[count + 1][3];
        compress[0][0] = originArray.length;
        compress[0][1] = originArray[0].length;
        compress[0][2] = count;
        int index = 1;
        // 进行压缩
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[0].length; j++) {
                if (originArray[i][j] != 0) {
                    compress[index][0] = i;
                    compress[index][1] = j;
                    compress[index][2] = originArray[i][j];
                    index++;
                }
            }
        }
        File file = new File("cn.file.spareArray.txt");
        PrintWriter printWriter = new PrintWriter(file);
        System.out.println("压缩后数组");
        for (int[] array : compress) {
            for (int value : array) {
                System.out.printf("%d\t", value);
                printWriter.print(value);
            }
            System.out.println();
        }
        // 将压缩后数组写入磁盘




        // 解压缩
        int[][] decompress = new int[compress[0][0]][compress[0][1]];
        for (int i = 1; i <= compress[0][2]; i++) {
            decompress[compress[i][0]][compress[i][1]] = compress[i][2];
        }
        System.out.println("解压后数组");
        for (int[] array : decompress) {
            for (int value : array) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }

    }
}
