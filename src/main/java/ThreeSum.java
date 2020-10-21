import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author suxiongye
 * @date 2020/10/21 4:33 下午
 * @description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * 的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * Related Topics 数组 双指针
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
        System.out.println(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 对数组排序，时间复杂度（NlogN）
        Arrays.sort(nums);
        return null;
    }

}
