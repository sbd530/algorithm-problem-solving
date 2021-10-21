package baekjoon.dp1.boj1890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        // DS
        long[][] d = new long[n + 1][n + 1];
        // INIT
        d[1][1] = 1;
        // LOOP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == n && j == n) break;
                if (i + a[i][j] <= n)
                    d[i + a[i][j]][j] += d[i][j];
                if (j + a[i][j] <= n)
                    d[i][j + a[i][j]] += d[i][j];
            }
        }
        System.out.println(d[n][n]);
    }
}
