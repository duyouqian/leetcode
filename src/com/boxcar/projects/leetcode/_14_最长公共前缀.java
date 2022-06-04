package com.boxcar.projects.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class _14_最长公共前缀 {
    public static String longestCommonPrefix2(String[] strs) {
        int n = strs.length;
        int minLen = strs[0].length();
        for (int i = 1; i < n; ++i) {
            minLen = Math.min(minLen, strs[i].length());
        }
        int low = 0, high = minLen;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommon(strs, n, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private static boolean isCommon(String[] strs, int n, int len) {
        for (int i = 0; i < len; ++i) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < n; ++j) {
                if (strs[j].charAt(i) != tmp) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int cnt = -1;
        boolean find = true;
        for (int i = 0, len = strs[0].length(); i < len; ++i) {
            char tmp = strs[0].charAt(i);
            find = true;
            for (int j = 1; j < n; ++j) {
                if (i >= strs[j].length()) {
                    find = false;
                    break;
                }
                if (tmp != strs[j].charAt(i)) {
                    find = false;
                    break;
                }
            }
            if (!find) {
                break;
            }
            cnt = i;
        }
        if (-1 == cnt) {
            return "";
        }
        return strs[0].substring(0, cnt + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
