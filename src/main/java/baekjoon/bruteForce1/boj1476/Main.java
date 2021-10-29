package baekjoon.bruteForce1.boj1476;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt() - 1;
        int s = sc.nextInt() - 1;
        int m = sc.nextInt() - 1;
        final int MOD_E  = 15, MOD_S = 28, MOD_M = 19;

        int n = 0;
        while (true){
            if (n % MOD_E == e && n % MOD_S == s && n % MOD_M == m) {
                System.out.println(n + 1);
                System.exit(0);
            }
            n += 1;
        }
    }
}
