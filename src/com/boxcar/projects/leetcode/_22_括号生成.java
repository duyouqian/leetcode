package com.boxcar.projects.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * (a)b
 */
public class _22_括号生成 {
    private static final List[] cache = new List[100];

    public static List<String> generateParenthesis(int n) {
        if (null != cache[n]) {
            return cache[n];
        }
        List<String> list = new ArrayList<>();
        if (0 == n) {
            list.add("");
        } else {
            for (int i = 0; i < n; ++i) {
                List<String> leftList = generateParenthesis(i);
                for (String left : leftList) {
                    List<String> rightList = generateParenthesis(n - 1 - i);
                    for (String right : rightList) {
                        list.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = list;
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }
}
