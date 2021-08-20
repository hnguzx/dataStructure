package club.leetCode.array;

import java.util.Arrays;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/8/20 14:43
 * @describe 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class LeetCode_34 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 9};
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                if (nums[right] > target) {
                    right--;
                } else if (nums[left] < target) {
                    left++;
                } else {
                    result[0] = left;
                    result[1] = right;
                    break;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
