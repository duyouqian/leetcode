package com.boxcar.projects.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 栈的应用
 */
public class _20_有效的括号 {
    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int ch = s.charAt(i);
            if ('(' == ch || '{' == ch || '[' == ch) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                int prev = stack.pop();
                if (')' == ch) {
                    if ('(' != prev) {
                        return false;
                    }
                } else if ('}' == ch) {
                    if ('{' != prev) {
                        return false;
                    }
                } else if (']' == ch) {
                    if ('[' != prev) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
