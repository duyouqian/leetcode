package com.boxcar.projects.leetcode;

/**
 * 使其能将字符串转换成一个 32 位有符号整数
 */
public class _8_字符串转换整数 {
    public static int myAtoi(String s) {
        if (null == s) {
            return 0;
        }
        int len = s.length();
        if (0 == len) {
            return 0;
        }
        char[] list = s.toCharArray();
        long newS = 0;
        boolean flag = true;
        boolean begin = false;
        for (int i = 0; i < len; ++i) {
            char ch = list[i];
            if (ch >= '0' && ch <= '9') {
                begin = true;
                if (flag) {
                    newS = newS * 10 + (((int) (ch - '0')) % 10);
                    if (newS >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    newS = newS * 10 - (((int) (ch - '0')) % 10);
                    if (newS <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                if (begin) {
                    break;
                }
                if ('+' == ch) {
                    flag = true;
                    begin = true;
                } else if ('-' == ch) {
                    flag = false;
                    begin = true;
                } else {
                    flag = true;
                    if (' ' != ch) {
                        break;
                    }
                }
            }
        }
        return (int) newS;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("words and 987"));
    }
}
