package club.leetCode.array;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/8/19 18:01
 * @describe 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 相关 35，34，69，367
 */
public class LeetCode_704 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 7, 8, 9, 10};
        int target = 9;

        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;

        while (left <= right) {
            // 注意数据范围
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
