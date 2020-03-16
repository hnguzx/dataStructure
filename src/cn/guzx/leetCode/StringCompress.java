package cn.guzx.leetCode;

import java.util.Stack;

public class StringCompress {
    public static void main(String[] args) {
        // a2b1c5a3
        System.out.println("结果是：" + compress("bbbac"));
    }

    public static String compress(String str) { String result = "";
    int count = 1;
    for (int i = 0; i < str.length(); i++) {
        int value = str.substring(i, i + 1).charAt(0);
        int j = i + 1;
        while (j < str.length()) {
            if (value == str.substring(j, j + 1).charAt(0)) {
                count++;
                i++;
                j++;
            } else {
                break;
            }
        }
        String temp = (char) value + "" + count;
        result += temp;
        count = 1;
    }

    return result.length() >= str.length() ? str : result;
    }
}