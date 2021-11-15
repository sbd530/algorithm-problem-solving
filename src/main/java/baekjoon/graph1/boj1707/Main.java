package baekjoon.graph1.boj1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int[] visit = new int[n + 1];
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0)
                    dfs(graph, visit, i, 1);
            }
            for (int i = 1; i <= n; i++) {
                for (int j : graph.get(i)) {
                    if (visit[i] == visit[j])
                        flag = false;
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visit, int x, int group) {
        visit[x] = group;
        for (int y : graph.get(x)) {
            if (visit[y] == 0)
                dfs(graph, visit, y, group == 1 ? 2 : 1);
        }
    }
}
