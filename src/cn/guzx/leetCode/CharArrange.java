package cn.guzx.leetCode;

import java.util.Arrays;

public class CharArrange {
    public static void main(String[] args) {
        System.out.println(isRepeat("abc", "bca"));
    }

    public static boolean isRepeat(String s1, String s2) {
        char result1[] = s1.toCharArray();
        char result2[] = s2.toCharArray();

        Arrays.sort(result1);
        Arrays.sort(result2);

        return Arrays.toString(result1).equals(Arrays.toString(result2));
    }
}