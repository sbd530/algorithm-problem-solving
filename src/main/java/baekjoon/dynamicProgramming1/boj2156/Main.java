package baekjoon.dynamicProgramming1.boj2156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // DS
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        // INIT
        d[1] = a[1];
        if (n >= 2) d[2] = a[1] + a[2];
        // LOGIC
        for (int i = 3; i <= n; i++)
            d[i] = Math.max(d[i - 1], Math.max(d[i - 2] + a[i], d[i - 3] + a[i] + a[i-1]));

        System.out.println(d[n]);
    }
}
