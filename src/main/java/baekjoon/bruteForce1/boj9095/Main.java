package baekjoon.bruteForce1.boj9095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append(solve(0, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int sum, int goal) {
        if (sum > goal) return 0;
        if (sum == goal) return 1;
        int cur = 0;
        for (int i = 1; i <= 3; i++)
            cur += solve(sum + i, goal);
        return cur;
    }

}
