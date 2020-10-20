/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author suxiongye
 * @date 2020/10/20 3:47 下午
 * @description 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * Related Topics 数组 双指针
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(array));
    }

    /**
     * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode
     * -solution/
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        // 左右两指针往中间移动，先移动小的指针，因为如果以小的为边，大边不管怎么移动都不会超过，只可能找到更小的边
        int ans = 0;
        while (i < j) {
            int area = 0;
            if (height[j] <= height[i]) {
                area = height[j] * (j -i );
                j--;
            } else {
                area = height[i] * (j - i );
                i++;
            }
            ans = area > ans ? area : ans;
        }
        return ans;
    }

}
