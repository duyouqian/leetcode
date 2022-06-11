package com.boxcar.projects.leetcode;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class _26_删除有序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        int cnt = 1;
        int prev = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] == prev) {
                continue;
            }
            prev = nums[i];
            nums[cnt++] = nums[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2}));
    }
}
