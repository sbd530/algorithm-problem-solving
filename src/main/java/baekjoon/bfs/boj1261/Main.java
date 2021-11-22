package baekjoon.bfs.boj1261;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        Deque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(0, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            Pair pair = deque.pollFirst();
            int x = pair.x;
            int y = pair.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (0 <= nextX && nextX < n) {
                    if (0 <= nextY && nextY < m) {
                        if (dist[nextX][nextY] == -1) {
                            if (a[nextX][nextY] == 0) {
                                dist[nextX][nextY] = dist[x][y];
                                deque.addFirst(new Pair(nextX, nextY));
                            } else {
                                dist[nextX][nextY] = dist[x][y] + 1;
                                deque.addLast(new Pair(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}