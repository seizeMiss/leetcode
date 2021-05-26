package com.dragon.leetcode;

import java.util.*;

public class LeetCode199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = queue.poll();

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }

                list.add(tmpNode.val);
            }
            // 获取list最后一个值,就是最右边的值
            res.add(list.get(list.size() - 1));
        }

        return res;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = queue.poll();

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                // 直接保存最后一个值
                if (i + 1 == size) {
                    res.add(tmpNode.val);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(8);
        root.left = root1;
        /*root.right = root2;
        root1.right = root3;
        root2.right = root4;
        root3.left = root5;
        root4.left = root6;*/
//        root4.right = root7;

        System.out.println(rightSideView2(root));
    }
}
