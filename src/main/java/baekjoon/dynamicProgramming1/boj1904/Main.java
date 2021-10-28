package baekjoon.dynamicProgramming1.boj1904;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 15746;
        int n = sc.nextInt();
        // DS
        int[] d = new int[n + 1];
        // INIT
        d[0] = d[1] = 1;
        // LOOP
        for (int i = 2; i <= n; i++)
            d[i] = (d[i - 1] + d[i - 2]) % mod;

        System.out.println(d[n] % mod);
    }
}
