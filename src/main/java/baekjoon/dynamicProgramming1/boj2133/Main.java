package baekjoon.dynamicProgramming1.boj2133;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // DS
        int[] d = new int[31];
        // INIT
        d[0] = 1;
        // LOOP
        for (int i = 2; i <= n; i += 2) {
            d[i] = 3 * d[i - 2];
            for (int j = i - 4; j >= 0; j -= 2)
                d[i] += 2 * d[j];
        }
        System.out.println(d[n]);
    }
}
