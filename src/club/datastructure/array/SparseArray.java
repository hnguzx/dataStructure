package club.datastructure.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class SparseArray {

    public static void main(String[] args) throws FileNotFoundException {
        int[][] originArray = new int[5][5];
        originArray[0][0] = 1;
        originArray[1][1] = 2;
        originArray[2][2] = 3;
        originArray[3][3] = 4;
        originArray[4][4] = 5;

        int count = getValidAmount(originArray);
        printArray(originArray);

        int[][] compressArray = compressArray(originArray, count);

        printArray(compressArray);

        File file = writerFile(compressArray);
        int[][] decompress = readFile(file);

        printArray(decompress);
    }

    /**
     * 获取数组中的有效数据量
     * @param originalData
     * @return
     */
    public static int getValidAmount(int[][] originalData) {
        int amount = 0;
        for (int[] list : originalData) {
            for (int value : list) {
                if (value != 0) {
                    amount++;
                }
            }
        }
        return amount;
    }

    /**
     * 打印数组
     * @param arrays
     */
    public static void printArray(int[][] arrays) {
        for (int[] array : arrays) {
            for (int value : array) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }

    /**
     * 压缩数组
     * @param originalData
     * @param count
     * @return
     */
    public static int[][] compressArray(int[][] originalData, int count) {
        int[][] compress = new int[count + 1][3];
        compress[0][0] = originalData.length;
        compress[0][1] = originalData[0].length;
        compress[0][2] = count;
        int index = 1;
        for (int i = 0; i < originalData.length; i++) {
            for (int j = 0; j < originalData[0].length; j++) {
                if (originalData[i][j] != 0) {
                    compress[index][0] = i;
                    compress[index][1] = j;
                    compress[index][2] = originalData[i][j];
                    index++;
                }
            }
        }
        return compress;
    }

    /**
     * 将数据写入文件中
     * @param arrays
     * @return
     */
    public static File writerFile(int[][] arrays) {
        File file = new File("src/club/file/spareArray.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            for (int[] array : arrays) {
                for (int value : array) {
                    printWriter.printf("%d\t", value);
                }
                printWriter.printf("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        return file;
    }

    /**
     * 从文件中读取数据
     * @param file
     * @return
     */
    public static int[][] readFile(File file) {
        Scanner read = null;
        int[][] decompress = new int[0][];
        try {
            read = new Scanner(file);
            decompress = new int[read.nextInt()][read.nextInt()];
            read.nextLine();
            while (read.hasNext()) {
                decompress[read.nextInt()][read.nextInt()] = read.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                read.close();
            }
        }
        return decompress;
    }
}
