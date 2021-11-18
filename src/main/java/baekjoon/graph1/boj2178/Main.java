package baekjoon.graph1.boj2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        queue.add(new Position(0, 0));
        visit[0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Position position = queue.remove();
            int x = position.x, y = position.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (0 <= nx && nx < n)
                    if (0 <= ny && ny < m)
                        if (!visit[nx][ny] && map[nx][ny] == 1) {
                            queue.add(new Position(nx, ny));
                            distance[nx][ny] = distance[x][y] + 1;
                            visit[nx][ny] = true;
                        }
            }
        }

        System.out.println(distance[n - 1][m - 1]);
    }
}