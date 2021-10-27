package baekjoon.dp1.boj9084;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = sc.nextInt();
            int m = sc.nextInt();
            int[] cache = new int[m + 1];
            cache[0] = 1;

            for (int i = 1; i <= n; i++)
                for (int j = a[i]; j <= m; j++)
                    cache[j] += cache[j - a[i]];

            sb.append(cache[m]).append("\n");
        }
        System.out.println(sb);
    }
}
