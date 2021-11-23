package baekjoon.tree1.boj2250;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static class Node {
        int left, right;
        int order, depth;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] a = new Node[10001];
    static int[] left = new int[10001];
    static int[] right = new int[10001];
    static int[] cnt = new int[10001];
    static int order = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x] = new Node(y, z);

            if (y != -1)
                cnt[y]  += 1;
            if (z != -1)
                cnt[z] += 1;
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0)
                root = i;
        }
        inorder(root, 1);
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;

            if (left[depth] == 0)
                left[depth] = order;
            else
                left[depth] = min(left[depth], order);

            right[depth] = max(right[depth], order);
            maxDepth = max(maxDepth, depth);
        }

        int ans = 0;
        int ansLevel = 0;
        for (int i = 1; i <= maxDepth; i++) {
            if (ans < right[i] - left[i] + 1) {
                ans = right[i] - left[i] + 1;
                ansLevel = i;
            }
        }

        System.out.println(ansLevel + " " + ans);
    }

    static void inorder(int node, int depth) {
        if (node == -1) return;

        inorder(a[node].left, depth + 1);
        a[node].order = ++order;
        a[node].depth = depth;
        inorder(a[node].right, depth + 1);
    }
}