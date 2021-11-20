package baekjoon.graph1.boj16929;

import java.util.Scanner;

public class Main {
    private static char[][] map;
    private static boolean[][] visit;
    private static int n, m;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++)
            map[i] = sc.next().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) continue;
                boolean flag = solve(i, j, -1, -1, map[i][j]);
                if (flag) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }

    private static boolean solve(int x, int y, int prevX, int prevY, char c) {
        if (visit[x][y])
            return true;

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (0 <= nextX && nextX < n)
                if (0 <= nextY && nextY < m)
                    if (!(nextX == prevX && nextY == prevY))
                        if (map[nextX][nextY] == c)
                            if (solve(nextX, nextY, x, y, c))
                                return true;
        }

        return false;
    }
}
