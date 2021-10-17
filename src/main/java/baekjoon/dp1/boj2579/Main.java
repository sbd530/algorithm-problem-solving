package baekjoon.dp1.boj2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        // DS
        int[] d = new int[n + 1];
        // INIT
        d[1] = a[1];
        if(n >= 2) d[2] = a[1] + a[2];
        // LOOP
        for (int i = 3; i <= n; i++)
            d[i] = Math.max(d[i - 3] + a[i - 1], d[i - 2]) + a[i];

        System.out.println(d[n]);
    }
}
