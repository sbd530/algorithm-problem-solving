package baekjoon.dp1.boj2293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        // DS
        int[] d = new int[10_001];
        // INIT
        d[0] = 1;
        // LOOP
        for (int i = 1; i <= n; i++)
            for (int j = a[i]; j <= k; j++)
                if (j >= a[i])
                    d[j] += d[j - a[i]];

        System.out.println(d[k]);
    }
}
