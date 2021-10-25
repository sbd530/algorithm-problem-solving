package baekjoon.dp1.boj11066;

import java.util.Scanner;

public class Main {
    /**
     * 파일을 연속적으로 통합하려면 이웃한 파일끼리 밖에 못합친다.
     * dp[i][j] == i부터 j번째 파일을 통합할 때 필요한 최소 비용  [i <= j]
     * dp[i][i] == a[i]
     * dp[i][i+1] == a[i]+a[i+1]
     * dp[i][i+2] == min{ a[i]+a[i+1], a[i+1]+a[i+2] } + sum{ a[i], a[i+1], a[i+2] }
     * dp[from][to] == min{ dp[from][i]+dp[i+1][to] } + sum{ a[from], ..., a[to] }   [i-LOOP : from <= i < to]
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            int[] sum = new int[n + 1]; // sum 캐시
            int[][] cache = new int[n + 1][n + 1]; // dp 캐시
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                sum[i] = sum[i - 1] + a[i];
            }

            for (int gap = 1; gap < n; gap++) {
                for (int from = 1; from + gap <= n; from++) {
                    int to = from + gap;
                    cache[from][to] = Integer.MAX_VALUE; // 최소값 로직을 위해
                    for (int i = from; i < to; i++)
                        cache[from][to] = Math.min(cache[from][to],
                                cache[from][i] + cache[i + 1][to] + sum[to] - sum[from - 1]);
                }
            }

            sb.append(cache[1][n]).append("\n");
        }
        System.out.println(sb);
    }
}
