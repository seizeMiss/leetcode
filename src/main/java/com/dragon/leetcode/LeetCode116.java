package com.dragon.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode116 {
    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 同一层进行连接
            Node tmpNode = queue.get(0);
            for (int i = 1; i < size; i++) {
                tmpNode.next = queue.get(i);
                tmpNode = queue.get(i);
            }

            for (int i = 0; i < size; i++) {
                tmpNode = queue.poll();

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }

        }


        return root;
    }

    public static void printNode(Node node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            System.out.println("null");
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmpNode = queue.poll();

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }


                res.add(String.valueOf(tmpNode.val));

                if (tmpNode.next == null) {
                    res.add("#");
                }
            }
        }

        System.out.println(res);
    }


    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;

        printNode(connect(root1));
    }

}
