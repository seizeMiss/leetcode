package com.dragon.leetcode;


import java.util.*;

public class Leetcode107 {

    // 层次遍历
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<List<Integer>> stack = new Stack<>();

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
            stack.push(list);
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    // 层次遍历
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = queue.poll();

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }

                if (count % 2 == 0) {
                    stack.push(tmpNode.val);
                } else {
                    list.add(tmpNode.val);
                }
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            count++;
            res.add(list);
        }

        return res;
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        preOrder(root, arr);

        return arr;
    }

    public void preOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        arr.add(root.val);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        return arr;
    }

    public void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        postorder(root, arr);

        return arr;
    }

    public void postorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;

        System.out.println(levelOrderBottom(root));
        System.out.println(zigzagLevelOrder(root));

        Leetcode107 test = new Leetcode107();
        List<Integer> arr = test.preorderTraversal(root);
        System.out.println(arr);
        arr = test.inorderTraversal(root);
        System.out.println(arr);
        arr = test.postorderTraversal(root);
        System.out.println(arr);
    }
}
