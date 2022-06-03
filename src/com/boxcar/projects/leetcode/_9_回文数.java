package com.boxcar.projects.leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class _9_回文数 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long newX = 0;
        int tmpX = x;
        while (0 != tmpX) {
            if (newX >= Integer.MAX_VALUE) {
                return false;
            }
            newX = newX * 10 + tmpX % 10;
            tmpX /= 10;
        }
        return newX == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123));
    }
}
