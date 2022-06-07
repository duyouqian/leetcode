package com.boxcar.projects.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class _17_电话号码的字母组合 {
    private static final char[][] number = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'x', 'w', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (0 == digits.length()) {
            return list;
        }
        backtrack(list, digits, 0, new StringBuffer());
        return list;
    }

    private static void backtrack(List<String> list, String digits, int index, StringBuffer buffer) {
        if (index == digits.length()) {
            list.add(buffer.toString());
        } else {
            int numberIndex = digits.charAt(index) - '0' - 2;
            char[] numberTmp = number[numberIndex];
            for (int i = 0, ni = numberTmp.length; i < ni; ++i) {
                buffer.append(numberTmp[i]);
                backtrack(list, digits, index + 1, buffer);
                buffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
