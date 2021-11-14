package baekjoon.graph1.boj1260;

import java.util.*;

public class Main {
    static ArrayList<Integer>[] a;
    static boolean[] c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        clearC(n);
        dfs(start);
        System.out.println();

        clearC(n);
        bfs(start);
        System.out.println();
    }

    static void dfs(int x) {
        if (c[x]) return;

        c[x] = true;
        System.out.print(x + " ");
        for (int y : a[x])
            if (!c[y])
                dfs(y);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (!c[y]) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

    static void clearC(int n) {
        c = new boolean[n + 1];
    }
}
