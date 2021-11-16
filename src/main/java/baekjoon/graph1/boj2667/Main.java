package baekjoon.graph1.boj2667;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] houses;
    static int[][] groups;
    static int cnt = 0;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        houses = new int[n][n];
        groups = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < n; j++) {
                houses[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (houses[i][j] == 1 && groups[i][j] == 0) {
                    cnt += 1;
                    dfs(i, j);
                }
            }
        }

        int[] answers = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (groups[i][j] != 0)
                    answers[groups[i][j] - 1] += 1;
            }
        }
        Arrays.sort(answers);
        System.out.println(cnt);
        for (int answer : answers)
            System.out.println(answer);
    }

    static void dfs(int x, int y) {
        groups[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n)
                if (0 <= ny && ny < n)
                    if (houses[nx][ny] == 1 && groups[nx][ny] == 0)
                        dfs(nx, ny);
        }
    }
}
