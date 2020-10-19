/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author suxiongye
 * @date 2020/10/16 4:10 下午
 * @description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * Related Topics 字符串 动态规划
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String string1 = "cbbd";
        String string2 = "babad";
        String string3 = "aaaaa";
        System.out.println(longestPalindrome(string1));
        System.out.println(longestPalindrome(string2));
        System.out.println(longestPalindrome(string3));

    }

    public static String longestPalindrome(String s) {
        // 动态规划数组
        boolean[][] dyArrays = new boolean[s.length()][s.length()];
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            dyArrays[i][i] = true;
            ans = s.substring(i, i + 1);
        }
        // 动态规划方程：a[i][i] = true,a[i][i+1] = a[i]==a[i+1],a[i][j] = (a[i+1,j - 1] == true?) && (s[i] == s[j])
        // 从短字符串到长字符串遍历,l为字符串长度-1，相当于左斜下方对角线开始遍历
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                // 字符串尾部索引 = 起始索引 + 长度
                int j = i + l;
                if (l == 0) {
                    dyArrays[i][j] = true;
                } else if (l == 1) {
                    dyArrays[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dyArrays[i][j] = dyArrays[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dyArrays[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}
