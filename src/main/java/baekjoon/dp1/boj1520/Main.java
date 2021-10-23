package baekjoon.dp1.boj1520;

import java.util.Scanner;

public class Main {
    private static int m, n;
    private static int[][] a, cache;
    private static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        cache = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                cache[i][j] = -1;

        int ans = dfs(1, 1);
        System.out.println(ans);
    }

    private static int dfs(int x, int y) {
        if (x == m && y == n)
            return 1;
        if (cache[x][y] != -1)
            return cache[x][y];
        cache[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx < 1 || ny < 1 || nx > m || ny > n)
                continue;
            if (a[x][y] > a[nx][ny])
                cache[x][y] += dfs(nx, ny);
        }
        return cache[x][y];
    }
}
