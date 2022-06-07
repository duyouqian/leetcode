package com.boxcar.projects.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, dn
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 */
public class _18_四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i1 = 0, ni1 = n - 3; i1 < ni1; ++i1) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) {
                continue;
            }
            if ((long) nums[i1] + nums[i1 + 1] + nums[i1 + 2] + nums[i1 + 3] > target) {
                break;
            }
            if ((long) nums[i1] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }
            int vi1 = nums[i1];
            for (int i2 = i1 + 1, ni2 = n - 2; i2 < ni2; ++i2) {
                if (i2 > (i1 + 1) && nums[i2] == nums[i2 - 1]) {
                    continue;
                }
                if ((long) nums[i1] + nums[i2] + nums[i2 + 1] + nums[i2 + 2] > target) {
                    break;
                }
                if ((long) nums[i1] + nums[i2] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                int vi2 = nums[i2];
                int i3 = i2 + 1;
                int i4 = n - 1;
                while (i3 < i4) {
                    int sum = vi1 + vi2 + nums[i3] + nums[i4];
                    if (sum == target) {
                        if (target == sum) {
                            List<Integer> item = new ArrayList<>();
                            item.add(nums[i1]);
                            item.add(nums[i2]);
                            item.add(nums[i3]);
                            item.add(nums[i4]);
                            list.add(item);
                        }

                        int i30 = i3 + 1;
                        while (i30 < i4 && nums[i30] == nums[i3]) {
                            ++i30;
                        }
                        i3 = i30;
                        int i40 = i4 - 1;
                        while (i3 < i40 && nums[i40] == nums[i4]) {
                            --i40;
                        }
                        i4 = i40;
                    } else if (sum > target) {
                        int i40 = i4 - 1;
                        while (i3 < i40 && nums[i40] == nums[i4]) {
                            --i40;
                        }
                        i4 = i40;
                    } else {
                        int i30 = i3 + 1;
                        while (i30 < i4 && nums[i30] == nums[i3]) {
                            ++i30;
                        }
                        i3 = i30;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        // System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
