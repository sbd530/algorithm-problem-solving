package baekjoon.dp1.boj11057;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 10_007;
        int[][] d = new int[n + 1][10];

        for (int i = 0; i <= 9; i++)
            d[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = 0; j <= 9; j++)
                for (int k = 0; k <= j; k++)
                    d[i][j] = (d[i][j] + d[i - 1][k]) % mod;

        int ans = 0;
        for (int j = 0; j <= 9; j++)
            ans += d[n][j];

        System.out.println(ans % mod);
    }
}
