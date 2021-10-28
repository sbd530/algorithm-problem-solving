package baekjoon.dynamicProgramming1.boj9465;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {
            // DS
            int n = sc.nextInt();
            int[][] d = new int[n + 1][3];
            int[][] a = new int[n + 1][2];
            // INIT
            for (int i = 1; i <= n; i++)
                a[i][0] = sc.nextInt();
            for (int i = 1; i <= n; i++)
                a[i][1] = sc.nextInt();
            // LOGIC
            for (int i = 1; i <= n; i++) {
                d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][0];
                d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][1];
            }
            int ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
