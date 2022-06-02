package com.boxcar.projects.leetcode;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class _6_Z字形变换 {
    public static String convert2(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }
        char[] list = s.toCharArray();
        StringBuffer newS = new StringBuffer();
        int len = s.length();
        int len_1 = len - 1;
        int t = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < len;) {
                newS.append(list[j]);
                j += t;
                if (0 != i && len_1 != i) {
                    int _ = j - 2 * i;
                    if (_ < len) {
                        newS.append(list[_]);
                    }
                }
            }
        }
        return newS.toString();
    }

    public static String convert(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }
        int len = s.length();
        char[] list = s.toCharArray();
        char[][] tmp = new char[numRows][1000];
        int dir = 0;
        int x = 0, y = 0;
        for (int i = 0; i < len;) {
            if (0 == dir) {
                // down
                y = 0;
                for (int j = 0; j < numRows && i < len; ++j) {
                    tmp[y++][x] = list[i++];
                }
                dir = 1;
            } else if (1 == dir) {
                // up
                y = numRows - 1;
                ++x;
                for (int j = 2; j < numRows && i < len; ++j) {
                    tmp[--y][x++] = list[i++];
                }
                dir = 0;
            }
        }
        StringBuffer newS = new StringBuffer();
        for (int _y = 0; _y < numRows; ++_y) {
            for (int _x = 0; _x <= x; ++_x) {
                if (0 != tmp[_y][_x]) {
                    newS.append(tmp[_y][_x]);
                }
            }
        }
        return newS.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 7; ++i) {
            String c1 = convert("PAYPALISHIRING", i);
            String c2 = convert2("PAYPALISHIRING", i);
            System.out.printf("%d. c1: %s c2: %s %s\n", i, c1, c2, c1.equals(c2));
        }
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
