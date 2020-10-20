/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author suxiongye
 * @date 2020/10/20 9:50 上午
 * @description 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * <p>
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * Related Topics 字符串 动态规划 回溯算法
 */

public class RegularExpressionMatching {
    /**
     * 动态规划：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by
     * -leetcode-solution/
     * 递归：https://leetcode-cn.com/problems/regular-expression-matching/solution/javadi-gui-yi-bu-yi-bu-de-you-hua-dao
     * -ji-bai-100yi/
     *
     * @param s 源字符串
     * @param p 正则字符串
     * @return 结果
     * 动态规划方程
     * a[0][0] = true
     * a[i][j] = a[i - 1][j - 1] && s[i] == p[j] (if p[j] != '*' && i > 0)
     * = a[i - 1][j](忽略s的字符) or a[i][j - 2] (if p[j] == '*' && p[j - 1] == s[i])
     * = a[i][j -2](忽略p的字符+*表达式) (if p[j] == '*' && !p[j - 1] == s[i])
     */
    public static boolean isMatch(String s, String p) {
        // 避免多次调用charAt、length方法
        int m = s.length();
        int n = p.length();
        char[] arrayS = s.toCharArray();
        char[] arrayP = p.toCharArray();
        boolean[][] a = new boolean[m + 1][n + 1];
        // 两个空串默认为匹配
        a[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果是非*的字符，直接判断当前字符是否相等
                if (arrayP[j - 1] != '*') {
                    if (i > 0 && (arrayS[i - 1] == arrayP[j - 1] || arrayP[j - 1] == '.')) {
                        a[i][j] = a[i - 1][j - 1];
                    }
                } else {
                    // 针对*前没有字符特殊处理
                    if (j < 2) {
                        return false;
                    }
                    a[i][j] = a[i][j - 2];
                    // 如果是*,则判断正则前一个字符是否跟当前字符一致
                    if (i > 0 && (arrayS[i - 1] == arrayP[j - 2] || arrayP[j - 2] == '.')) {
                        // 一致的话可以不看该字符
                        a[i][j] |= a[i - 1][j];
                    }
                }
            }
        }
        return a[m][n];
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(isMatch("aa", "*a"));
    }
}
