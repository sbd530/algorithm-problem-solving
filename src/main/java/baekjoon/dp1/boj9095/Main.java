package baekjoon.dp1.boj9095;

import java.util.Scanner;

public class Main {

    private static int[] memo = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
    }

    private static int d(int n) {
        if (n == 1) return 1;

        memo[n] = d(n-3) + d(n-2) + d(n-1);

        return memo[n];
    }
}
