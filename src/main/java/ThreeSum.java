import java.util.ArrayList;
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
        int[] nums2 = new int[]{-2,0,0,2,2};
        int[] nums3 = new int[]{1,-1,-1,0};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
    }

    /**
     * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 对数组排序，时间复杂度（NlogN），所以不影响整体
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 记录上一轮数值
        int firstNum = Integer.MIN_VALUE;
        // 转化为两数和问题，用双指针(N^2)
        for (int i = 0; i < nums.length - 2; i++) {
            // 第一个数大于0则不需要比较
            if (firstNum > 0) {
                break;
            }
            // 如果和上一个数相同则直接跳过
            if (firstNum == nums[i]) {
                continue;
            }
            firstNum = nums[i];
            // 分别设置两个指针同时接近
            int leftPoint = i + 1;
            int rightPoint = nums.length - 1;
            int lastSecondNum = Integer.MIN_VALUE;
            int lastThirdNum = Integer.MIN_VALUE;
            while (leftPoint < rightPoint) {
                if (lastSecondNum == nums[leftPoint]) {
                    leftPoint++;
                    continue;
                }
                if (lastThirdNum == nums[rightPoint]) {
                    rightPoint--;
                    continue;
                }
                int sum = nums[i] + nums[leftPoint] + nums[rightPoint];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], lastSecondNum = nums[leftPoint++], lastThirdNum =
                            nums[rightPoint--]));
                } else if (sum < 0) {
                    lastSecondNum = nums[leftPoint];
                    leftPoint++;
                } else {
                    lastThirdNum = nums[rightPoint];
                    rightPoint--;
                }
            }
        }
        return ans;
    }

}
