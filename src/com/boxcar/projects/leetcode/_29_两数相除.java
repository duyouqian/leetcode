package com.boxcar.projects.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 */
public class _29_两数相除 {
    public static int divide(int dividend, int divisor) {
        if (Integer.MIN_VALUE == dividend) {
            if (1 == divisor) {
                return Integer.MIN_VALUE;
            }
            if (-1 == divisor) {
                return Integer.MAX_VALUE;
            }
        }
        if (Integer.MIN_VALUE == divisor) {
            return Integer.MIN_VALUE == dividend ? 1 : 0;
        }
        if (0 == dividend) {
            return 0;
        }
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        int ans = 0;
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(dividend, divisor, mid);
            if (check) {
                ans = mid;
                if (Integer.MAX_VALUE == mid) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }

    private static boolean quickAdd(int X, int Y, int Z) {
        // X, Y <= 0, Z >= 0
        // Z * Y >= X
        int R = 0, ADD = Y;
        while (0 != Z) {
            if (0 != (Z & 1)) {
                // R + ADD >= X
                if (R < (X - ADD)) {
                    return false;
                }
                R += ADD;
            }
            if (1 != Z) {
                if (ADD < (X - ADD)) {
                    return false;
                }
                ADD += ADD;
            }
            Z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
    }
}
