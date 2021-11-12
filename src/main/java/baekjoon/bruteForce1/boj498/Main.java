package baekjoon.bruteForce1.boj498;

import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        // 0 = 가로, 1 = 세로
        int ans = 0;
        for (int s = 0; s < (1 << (n * m)); s++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j; // 칸 인덱스
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) != 0) {
                        cur = cur * 10 + a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }


            ans = max(ans, sum);
        }

        System.out.println(ans);
    }
}
