package baekjoon.dynamicProgramming1.boj13398;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        // DS
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        // INIT1
        d1[1] = a[1];
        // LOOP1
        for (int i = 2; i <= n; i++)
            d1[i] = Math.max(a[i], d1[i - 1] + a[i]);
        // INIT2
        d2[n] = a[n];
        // LOOP2
        for (int i = n - 1; i >= 1; i--)
            d2[i] = Math.max(a[i], d2[i + 1] + a[i]);

        int ans = d1[1];
        for (int i = 2; i <= n; i++)
            ans = Math.max(ans, d1[i]);
        for (int i = 2; i <= n - 1; i++)
            ans = Math.max(ans, d1[i - 1] + d2[i + 1]);
        System.out.println(ans);
    }
}
