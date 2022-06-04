package com.boxcar.projects.leetcode;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
 */
public class _12_整数转罗马数字 {
    private static String[] ROMAN2 = new String[] {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    private static int[] IROMAN = new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    public static String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < 13; ++i) {
            int value = IROMAN[i];
            while (num >= value) {
                num -= value;
                roman.append(ROMAN2[i]);
            }
        }
        return roman.toString();
    }

    private static String[][] ROMAN = new String[][] {
            {"I", "IV", "V", "IX"},
            {"X", "XL", "L", "XC"},
            {"C", "CD", "D", "CM"},
            {"M", "M", "M", "M"}
    };
    private static byte[][] BROMAN = new byte[][] {
            {1, 4, 5, 9},
            {1, 4, 5, 9},
            {1, 4, 5, 9},
            {1, 1, 1, 1},
    };

    public static String intToRoman(int num) {
        String[] roman = new String[4];
        int index = 0;
        while (0 != num) {
            int tmp = num % 10;
            roman[index] = intToRoman(tmp, index);
            ++index;
            num /= 10;
        }
        StringBuffer tmp = new StringBuffer();
        for (int i = index - 1; i >= 0; --i) {
            tmp.append(roman[i]);
        }
        return tmp.toString();
    }

    private static String intToRoman(int num, int flag) {
        byte[] tmp = BROMAN[flag];
        int i = 0;
        for (i = 0; i < 4; ++i) {
            if (tmp[i] >= num) {
                break;
            }
        }
        if (4 == i) {
            --i;
        }
        if (num == tmp[i]) {
            return ROMAN[flag][i];
        }
        StringBuffer roman = new StringBuffer();
        if (num > 5) {
            roman.append(ROMAN[flag][2]);
            num -= 5;
        }
        for (int j = 0; j < num; ++j) {
            roman.append(ROMAN[flag][0]);
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman2(3));
        System.out.println(intToRoman2(4));
        System.out.println(intToRoman2(9));
        System.out.println(intToRoman2(58));
        System.out.println(intToRoman2(1994));
    }
}
