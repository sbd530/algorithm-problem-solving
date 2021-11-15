package baekjoon.graph1.boj11724;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] check = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(graph, check, i);
                ans += 1;
            }
        }
        System.out.println(ans);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] check, int x) {
        if (check[x]) return;

        check[x] = true;
        for (int y : graph.get(x)) {
            if (!check[y])
                dfs(graph, check, y);
        }
    }
}
