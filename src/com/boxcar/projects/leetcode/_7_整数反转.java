package com.boxcar.projects.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 */
public class _7_整数反转 {
    public static int reverse2(int x) {
        int min = Integer.MIN_VALUE / 10;
        int max = Integer.MAX_VALUE / 10;
        int newX = 0;
        while (0 != x) {
            if (newX > max || newX < min) {
                return 0;
            }
            newX = newX * 10 + x % 10;
            x /= 10;
        }
        return newX;
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        boolean flag = x < 0 ? true : false;
        if (flag) {
            x = -x;
        }
        int[] tmp = new int[11];
        int index = 0;
        long newX = 0;
        while (x > 0) {
            tmp[index++] = x % 10;
            x /= 10;
        }
        --index;
        for (int i = 0; i <= index; ++i) {
            int t = tmp[i];
            if (0 == t) {
                continue;
            }
            newX += t * Math.pow(10, index - i);
            if (newX > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (flag ? -newX : newX);
    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));

        System.out.println(reverse2(0));
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
        System.out.println(reverse2(1534236469));
        System.out.println(reverse2(-2147483648));
    }
}
