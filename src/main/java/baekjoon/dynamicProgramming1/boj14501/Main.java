package baekjoon.dynamicProgramming1.boj14501;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        // DS
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            d[i] = p[i];
        }
        // LOOP
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                if (i - j >= t[j])
                    d[i] = Math.max(d[i], d[j] + p[i]);

        int ans = 0;
        for (int i = 1; i <= n; i++)
            if (t[i] <= n + 1 - i)
                ans = Math.max(ans, d[i]);
        System.out.println(ans);
    }
}
