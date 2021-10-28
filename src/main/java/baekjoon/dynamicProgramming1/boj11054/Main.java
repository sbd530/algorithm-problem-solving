package baekjoon.dynamicProgramming1.boj11054;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // DS
        int[] a = new int[n + 1];
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        // LOOP1
        for (int i = 1; i <= n; i++) {
            d1[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i] && d1[i] < d1[j] + 1)
                    d1[i] = d1[j] + 1;
            }
        }
        // LOOP2
        for (int i = n; i >= 1; i--) {
            d2[i] = 1;
            for (int j = i; j <= n; j++) {
                if (a[j] < a[i] && d2[i] < d2[j] + 1)
                    d2[i] = d2[j] + 1;
            }
        }

        int ans = d1[1] + d2[1] - 1;
        for (int i = 2; i <= n; i++)
            ans = Math.max(ans, d1[i] + d2[i] - 1);
        System.out.println(ans);
    }
}
