package baekjoon.dynamicProgramming1.boj11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }
        int ans = d[1];
        for (int i = 2; i <= n; i++)
            if (ans < d[i])
                ans = d[i];

        System.out.println(ans);
    }
}
