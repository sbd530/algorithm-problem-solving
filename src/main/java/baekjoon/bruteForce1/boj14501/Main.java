package baekjoon.bruteForce1.boj14501;

import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    private static int n;
    private static int[] t;
    private static int[] p;
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        solve(1, 0);
        System.out.println(ans);
    }

    private static void solve(int day, int sum) {
        if (day == n + 1) {
            ans = max(ans, sum);
            return;
        }
        if (day > n + 1)
            return;

        solve(day + 1, sum);
        solve(day + t[day], sum + p[day]);
    }
}