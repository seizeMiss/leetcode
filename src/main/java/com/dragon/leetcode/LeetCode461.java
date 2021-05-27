package com.dragon.leetcode;

public class LeetCode461 {
    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if (((int)str.charAt(i)) == 49) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(100, 10000000));
    }
}
