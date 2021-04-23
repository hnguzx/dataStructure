/**
 * 二分查找法，非递归
 */
package club.algorithm.commonAlgorithm;

public class DichotomiaFind {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 9, 10};
        System.out.println(find(arr, 11));
    }

    public static int find(int arr[], int value) {
        int left = 0;
        int right = arr.length - 1;
//        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
//                result = mid;
                return mid;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
