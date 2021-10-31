package baekjoon.bruteForce1.boj15650;

import java.util.Scanner;

public class Main {
    private static int[] a = new int[9];
    private static int n, m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        recur(0, 1);
        System.out.println(sb);
    }

    private static void recur(int index, int start) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            a[index] = i;
            recur(index + 1, i + 1);
        }
    }
}
