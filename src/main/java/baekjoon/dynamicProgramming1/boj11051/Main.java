package baekjoon.dynamicProgramming1.boj11051;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 10_007;
        // DS
        int[][] d = new int[1001][1001];
        // INIT
        for (int i = 0; i <= 1000; i++)
            d[i][0] = 1;
        // LOOP
        for (int i = 1; i <= 1000; i++)
            for (int j = 1; j <= i; j++)
                d[i][j] = (d[i - 1][j] + d[i - 1][j - 1]) % mod;

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(d[n][k] % mod);
    }
}