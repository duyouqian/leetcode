package com.boxcar.projects.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 */
public class _28_实现strStr {
    public static int strStr(String haystack, String needle) {
        int pn = needle.length();
        int[][] dfa = new int[256][pn];
        dfa[needle.charAt(0)][0] = 1;
        for (int i = 0, j = 1; j < pn; ++j) {
            for (int k = 0; k < 256; ++k) {
                dfa[k][j] = dfa[k][i];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            i = dfa[needle.charAt(j)][i];
        }
        int i, j, tn = haystack.length();
        for (i = 0, j = 0; i < tn && j < pn; ++i) {
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == pn) {
            return i - pn;
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }
}
