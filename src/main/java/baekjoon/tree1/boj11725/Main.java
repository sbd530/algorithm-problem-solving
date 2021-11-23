package baekjoon.tree1.boj11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visit = new boolean[n + 1];
        int[] parent = new int[n + 1];
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a.get(u).add(v);
            a.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a.get(x)) {
                if (!visit[y]) {
                    visit[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
