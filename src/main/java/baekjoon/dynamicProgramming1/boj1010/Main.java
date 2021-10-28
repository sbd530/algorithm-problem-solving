package baekjoon.dynamicProgramming1.boj1010;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // DS
        int[][] d = new int[30][30];
        // INIT
        for (int i = 0; i <= 29; i++)
            d[i][0] = 1;
        // LOOP
        for (int i = 1; i <= 29; i++)
            for (int j = 1; j <= i; j++)
                d[i][j] = d[i - 1][j] + d[i - 1][j - 1];

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(d[m][n]);
        }
    }
}
