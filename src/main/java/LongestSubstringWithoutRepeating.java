/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author su
 * @date 2020-10-14 22:22
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * Related Topics 哈希表 双指针 字符串 Sliding Window
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 滑动窗口 + hashmap + 双指针
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int maxLength = end - start + 1;
        Map<Character, Integer> charMap = new HashMap<>();
        while (end < s.length()) {
            if (charMap.containsKey(s.charAt(end))) {
                // 如果有重复出现，更新左指针，避免与窗口外之前的字符重合，所以下一个滑动窗口取当前值和上一个重合字符下一个位置的最大值
                start = Math.max(start, charMap.get(s.charAt(end)) + 1);
            }
            // 放入字符出现最后一个位置
            charMap.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;

        }
        return maxLength;
    }
}
