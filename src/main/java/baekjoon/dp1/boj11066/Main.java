package baekjoon.dp1.boj11066;

import java.util.Scanner;

public class Main {
    /**
     * 파일을 연속적으로 통합하려면 이웃한 파일끼리 밖에 못합친다.
     * dp[i][j] == i부터 j번째 파일을 통합할 때 필요한 최소 비용  [i <= j]
     * dp[i][i] == a[i]
     * dp[i][i+1] == a[i]+a[i+1]
     * dp[i][i+2] == min{ a[i]+a[i+1], a[i+1]+a[i+2] } + { a[i]+a[i+1]+a[i+2] }
     * dp[i][j] == min{ dp[i][k]+dp[i][k+1] } + { a[i]+...+a[j] }   [k-LOOP : i ~ j-1]
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            int[][] cache = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    cache[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        cache[i][j] = Math.min(cache[i][j], cache[i][k] + cache[i][k + 1]);
                    }
                    for (int k = i; k <= j; k++) {
                        cache[i][j] += a[k];
                    }
                }
            }

            sb.append(cache[1][n]).append("\n");
        }

        System.out.println(sb);
    }
}
