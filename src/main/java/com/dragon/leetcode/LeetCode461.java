package com.dragon.leetcode;

public class LeetCode461 {
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int totalHammingDistance(int[] nums) {
        int total = 0;
        int k = nums.length - 1;
        for (int i = 0; i < k; i++) {
            for(int j = i + 1; j < k; j++) {
                total += hammingDistance(nums[i], nums[j]);
            }

            for(int m = k - 1; m > i; m--) {
                total += hammingDistance(nums[m], nums[k]);

            }
            total += hammingDistance(nums[i], nums[k]);
            k--;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }
}
