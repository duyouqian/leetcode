package com.boxcar.projects.leetcode;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 */
public class _10_正则表达式匹配 {
    public static boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sn; ++i) {
            for (int j = 1; j <= pn; ++j) {
                if ('*' == p.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sn][pn];
    }

    private static boolean match(String s, String p, int i, int j) {
        if (0 == i) {
            return false;
        }
        if ('.' == p.charAt(j - 1)) {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", ".*c"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aab", "a*"));
        System.out.println(isMatch("aaa", "a*"));
        System.out.println(isMatch("aa", "a"));
    }
}
