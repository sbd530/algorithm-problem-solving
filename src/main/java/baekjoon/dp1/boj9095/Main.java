package baekjoon.dp1.boj9095;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] d = new int[11];
        d[0] = 1;

        for (int i = 1; i <= 10; i++) {
            d[i] += d[i - 1];
            if (i-2 >= 0)
                d[i] += d[i - 2];
            if (i-3 >= 0)
                d[i] += d[i - 3];
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append(d[n]).append("\n");
        }
        System.out.println(sb);
    }
}
