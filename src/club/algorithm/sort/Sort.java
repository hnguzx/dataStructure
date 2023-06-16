package club.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

public class Sort {
    public static void main(String[] args) {
//        int[] origin = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            origin[i] = (int) (Math.random() * 1000000);
//        }

        int[] origin = new int[]{9, 2, 1, 7, 2, 3, 5, 4, 6, 0, 8, 5, 3, 0};

        System.out.println("排序前：");
        System.out.println(new Date().getTime());
//        System.out.println(Arrays.toString(origin));

//        bubble(origin);
//        select(origin);
//        insert(origin);

        // 八百万个随机数据的测试时间
        fast(origin, 0, origin.length - 1); // 800万 917ms
//        quickSort(origin, 0, origin.length - 1); // 800万 632ms
//        mergeSort(origin, 0, origin.length - 1); // 800万 1109ms
//        hill(origin); // 800万 1598ms
//        bucket(origin); // 800万 370ms
//        heap(origin); // 800万 1687ms

        System.out.println("排序后：");
        System.out.println(new Date().getTime());
        System.out.println(Arrays.toString(origin));

    }

    // 冒泡排序，时间复杂度较高，适合数据量较小时使用
    public static void bubble(int[] origin) {
        int temp = 0;
        boolean isContinue; // 标志着一个循环数组的排序是否有变化，如果没有，可提前结束排序
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

    // 选择排序，与冒泡排序类似，时间复杂度较高，一般不推荐使用
    public static void select(int[] origin) {
        int index; // 当前要进行排序的数据的下标
        int value; // 当前要进行排序的数据的值

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

    // 插入排序，时间复杂度较高，在处理部分有序的数据时，可以使用。
    public static void insert(int[] origin) {
        int index; // 数组中已排序的部分的最后一个数组的下标
        int value; // 数组中未排序的部分的第一个数组的值

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

    // 快速排序，分治思想。平均性能优秀，但在最差的情况下与冒泡排序是一样的
    public static void fast(int[] origin, int left, int right) {
        // 将数组分为左右两部分
        int l = left; // 左边起始下标
        int r = right; // 右边起始下标
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
                r--;
            }
            // 右边有与中间元素相等的元素
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

    public static void quickSort(int[] origin, int left, int right) {
        if (right > left) {
            int mediumIndex = partition(origin, left, right);
            quickSort(origin, left, mediumIndex - 1);
            quickSort(origin, mediumIndex + 1, right);
        }
    }

    public static int partition(int[] origin, int left, int right) {
        int mediumValue = origin[right];
        int secondIndex = left;
        for (int i = left; i < right; i++) {
            if (origin[i] <= mediumValue) {
                int temp = origin[i];
                origin[i] = origin[secondIndex];
                origin[secondIndex] = temp;
                secondIndex++;
            }
        }
        int temp = origin[secondIndex];
        origin[secondIndex] = origin[right];
        origin[right] = temp;
        return secondIndex;
    }

    // 归并排序，分治思想。
    public static void mergeSort(int[] origin, int left, int right) {
        // 说明分解后的数组长度大于1
        if (left < right) {
            // 通过递归将原数组分解
            int mid = (right + left) / 2;
            // 向左分解
            mergeSort(origin, left, mid);
            // 向右分解
            mergeSort(origin, mid + 1, right);
            merge(origin, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    // 希尔排序
    public static void hill(int[] origin) {
        int increment = origin.length / 2; // 增量，即要将原数组分解成小数组的数量
        int index = 0; // 用于保存后面的第一个数的下标
        int value = 0; // 用于保存后面的第一个数
        while (increment > 0) {
            for (int i = increment; i < origin.length; i++) {
                // 遍历各组数据
                index = i;
                value = origin[i];
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

    // 基数排序（桶排序）
    public static void bucket(int[] origin) {
        int bocket[][] = new int[10][origin.length]; // 桶
        int temp[] = new int[bocket.length]; // 用于保存每个桶中有效数据的个数

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
                // 放入哪个桶中
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

    // 堆排序
    public static void heap(int[] origin) {
        // 叶子节点不用管，从最后一个非叶子节点开始 index = origin.length / 2 - 1
        // 找到该子树中的最大节点，放到子树的堆顶
        int temp = 0;
        // 将数组构建成堆
        for (int i = origin.length / 2 - 1; i >= 0; i--) {
            adjustArray(origin, i, origin.length);
        }

        // 将堆顶元素与末尾元素进行交换，将最大元素沉到数组尾部
        for (int j = origin.length - 1; j > 0; j--) {
            temp = origin[j];
            origin[j] = origin[0];
            origin[0] = temp;
            // 对数组剩下的元素继续进行整理，将其整理为大顶堆
            adjustArray(origin, 0, j);
        }

    }

    // 将一个最多三个数的数组组成堆的数组调整为大顶堆
    public static void adjustArray(int arr[], int i, int length) {
        int temp = arr[i]; // 最后一个非叶子节点

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 左节点小于右节点
                k++;
            }
            if (arr[k] > temp) { // 找到该子树中最大的一个节点,将其赋值给最后一棵子树的树顶
                arr[i] = arr[k];
                i = k;
            } else {
                break; // 原来的树顶就是最大的值
            }
        }

        arr[i] = temp; // 将开始树顶的位置赋值给被交换的节点
    }
}