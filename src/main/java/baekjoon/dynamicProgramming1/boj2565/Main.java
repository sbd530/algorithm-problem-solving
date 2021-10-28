package baekjoon.dynamicProgramming1.boj2565;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        // A 순서로 전깃줄을 정렬해서 B 수열을 만든다.
        Arrays.sort(a, Comparator.comparingInt(x -> x[0]));
        // B 수열에서 LIS 길이를 구한다.
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j <= i; j++)
                if (a[j][1] < a[i][1])
                    d[i] = Math.max(d[i], d[j] + 1);
        }
        int lis = 0;
        for (int i = 1; i <= n; i++)
            lis = Math.max(lis, d[i]);

        // (제거할 전깃줄 개수) = (전깃줄 개수) - (LIS 길이)
        System.out.println(n - lis);
    }
}
