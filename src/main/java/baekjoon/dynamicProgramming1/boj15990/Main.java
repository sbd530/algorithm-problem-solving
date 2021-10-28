package baekjoon.dynamicProgramming1.boj15990;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int maxValue = 100_000;
        long m = 1_000_000_009L;
        long[][] d = new long[maxValue + 1][4];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= maxValue; i++) {
            if (i > 1)
                d[i][1] = d[i-1][2] + d[i-1][3];
            else if (i == 1)
                d[i][1] = 1;

            if (i > 2)
                d[i][2] = d[i-2][1] + d[i-2][3];
            else if (i == 2)
                d[i][2] = 1;

            if (i > 3)
                d[i][3] = d[i-3][1] + d[i-3][2];
            else if (i == 3)
                d[i][3] = 1;

            d[i][1] %= m;
            d[i][2] %= m;
            d[i][3] %= m;
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append((d[n][1] + d[n][2] + d[n][3]) % m).append("\n");
        }
        System.out.print(sb);
    }
}
