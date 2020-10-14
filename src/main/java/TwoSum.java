import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author suxiongye
 * @date 2020/10/14 4:04 下午
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * Related Topics 数组 哈希表
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(TwoSum.twoSumHash(nums, 9)));

    }

    /**
     * hashmap的方式
     *
     * @param nums   数组
     * @param target 目标和
     * @return 答案下标数组
     */
    public static int[] twoSumHash(int[] nums, int target) {
        // 构造hashmap，value为之前遍历的索引值，key为target - nums[之前遍历索引]，如果key存在则返回当前值索引和key
        Map<Integer, Integer> indexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                return new int[]{indexMap.get(nums[i]), i};
            } else {
                // 放入预期值和当前值索引
                indexMap.put(target - nums[i], i);
            }
        }
        return null;
    }

    /**
     * 杨氏矩阵方式（针对有序数组情况可以头尾指针往前走）
     * https://time.geekbang.org/column/article/284707
     *
     * @param nums   数组
     * @param target 目标和
     * @return 答案下标数组
     */
    public static int[] twoSumYang(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        // 前后往中间走
        while (head < tail) {
            if (nums[head] + nums[tail] == target) {
                return new int[]{head, tail};
            } else if (nums[head] + nums[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return null;
    }
}
