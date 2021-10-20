package baekjoon.dp1.boj11048;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                a[i][j] = sc.nextInt();
        // DS
        int[][] d = new int[n + 1][m + 1];
        // INIT
        d[1][1] = a[1][1];
        // LOOP
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                d[i][j] = Math.max(d[i - 1][j - 1], Math.max(d[i - 1][j], d[i][j - 1])) + a[i][j];

        System.out.println(d[n][m]);
    }
}
