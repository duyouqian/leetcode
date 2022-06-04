package com.boxcar.projects.leetcode;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 *
 */
public class _13_罗马数字转整数 {
    private static int[] ROMAN = new int[26];
    private static int[] PROMAN = new int[26];
    static {
        ROMAN['I' - 'A'] = 1;
        ROMAN['V' - 'A'] = 5;
        ROMAN['X' - 'A'] = 10;
        ROMAN['L' - 'A'] = 50;
        ROMAN['C' - 'A'] = 100;
        ROMAN['D' - 'A'] = 500;
        ROMAN['M' - 'A'] = 1000;

        for (int i = 0; i < 26; ++i) {
            PROMAN[i] = -1;
        }
        PROMAN['I' - 'A'] = -1;
        PROMAN['V' - 'A'] = 'I' - 'A';
        PROMAN['X' - 'A'] = 'I' - 'A';
        PROMAN['L' - 'A'] = 'X' - 'A' ;
        PROMAN['C' - 'A'] = 'X' - 'A';
        PROMAN['D' - 'A'] = 'C' - 'A';
        PROMAN['M' - 'A'] = 'C' - 'A';
    }

    public static int romanToInt(String s) {
        int num = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            int index = s.charAt(i) - 'A';
            num += ROMAN[index];
            if (i > 0 && (PROMAN[index] == (s.charAt(i - 1) - 'A'))) {
                num -= ROMAN[s.charAt(i - 1) - 'A'];
                --i;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV"));  // 4
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
        System.out.println(romanToInt("CMXCIX"));// 999
        System.out.println(romanToInt("XLIX"));// 49
    }
}
