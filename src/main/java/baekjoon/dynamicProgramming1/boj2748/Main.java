package baekjoon.dynamicProgramming1.boj2748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // DS
        long[] d = new long[n + 1];
        // INIT
        d[0] = 0L;
        d[1] = 1L;
        // LOOP
        for (int i = 2; i <= n; i++)
            d[i] = d[i - 2] + d[i - 1];

        System.out.println(d[n]);
    }
}
