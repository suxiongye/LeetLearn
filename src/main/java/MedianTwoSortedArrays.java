/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author suxiongye
 * @date 2020/10/15 7:48 下午
 * @description 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * Related Topics 数组 二分查找 分治算法
 */
public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 5, 6, 7, 8, 9, 20};
        int[] array2 = new int[]{1, 10, 17, 18};
        System.out.println(findMedianSortedArrays(array1, array2));
    }

    /**
     * 参考：https://blog.csdn.net/bjweimengshu/article/details/97717144
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 从小数组开始找
        if (nums1.length > nums2.length) {
           return findMedianSortedArrays(nums2, nums1);
        }
        // 记录中位数左右两边的值
        int medium1 = 0, medium2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        int right = m;
        int left = 0;
        while (left <= right) {
            // 计算切分点
            int cut1 = (left + right) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;
            // 处理边界，计算切点左右两边值
            // 如果数组1切到最左边，则切点左边设置为最小值，避免参与比较
            int ml = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            // 如果数组1切到最右边边，则切点右边设置为最大值，避免参与比较
            int mr = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int nl = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int nr = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];
            // 切点过大，左移
            // 等价于找最大的cut1，使得ml <= nr，否则会往后找
            if (ml <= nr) {
                left = cut1 + 1;
                medium1 = Math.max(ml, nl);
                medium2 = Math.min(mr, nr);
            } else {
                right = cut1 - 1;
            }
        }
        return (m + n) % 2 == 0 ? (medium1 + medium2) / 2.0 : medium1;
    }

    // 解法1 ：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de
    // -zhong-wei-s-114/

}
