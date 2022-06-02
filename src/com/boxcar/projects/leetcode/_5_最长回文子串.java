package com.boxcar.projects.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class _5_最长回文子串 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (1 == len) {
            return s;
        }
        char[] list = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int maxCnt = 1;
        int maxBegin = 0;
        int maxEnd = 0;

        for (int high = 1; high < len; ++high) {
            for (int low = 0; low < high; ++low) {
                if (list[high] == list[low] && ((high - low) <= 2 || dp[low + 1][high - 1])) {
                    dp[low][high] = true;
                    if (high - low + 1 > maxCnt) {
                        maxCnt = high - low + 1;
                        maxBegin = low;
                        maxEnd = high;
                    }
                }
            }
        }
        return s.substring(maxBegin, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
