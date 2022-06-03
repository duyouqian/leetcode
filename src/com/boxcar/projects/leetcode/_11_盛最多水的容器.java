package com.boxcar.projects.leetcode;

/**
 *给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是i, 0)和i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */
public class _11_盛最多水的容器 {
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int left = height[i];
            int right = height[j];
            max = Math.max(max, Math.min(left, right) * (j - i));
            if (left < right) {
                ++i;
            } else  {
                --j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
