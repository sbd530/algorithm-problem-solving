package baekjoon.graph1.boj4963;

import java.util.Scanner;

public class Main {
    static int m, n;
    static int[][] lands;
    static int[][] groups;
    static int cnt;
    static final int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static final int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();
            if (n == 0 && m == 0) break;
            lands = new int[n][m];
            groups = new int[n][m];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    lands[i][j] = sc.nextInt();

            cnt = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (lands[i][j] == 1 && groups[i][j] == 0) {
                        cnt += 1;
                        dfs(i, j);
                    }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        groups[x][y] = cnt;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n)
                if (0 <= ny && ny < m)
                    if (lands[nx][ny] == 1 && groups[nx][ny] == 0)
                        dfs(nx, ny);
        }
    }
}