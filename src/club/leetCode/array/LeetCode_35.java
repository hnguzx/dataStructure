package club.leetCode.array;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/8/20 14:03
 * @describe    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *              如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class LeetCode_35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 8;
        System.out.println(searchInsert(nums, target));
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
