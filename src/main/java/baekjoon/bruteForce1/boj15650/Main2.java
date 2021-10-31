package baekjoon.bruteForce1.boj15650;

import java.util.Scanner;

public class Main2 {
    private static int[] a = new int[9];
    private static int n, m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        recur(1, 0);
        System.out.println(sb);
    }

    private static void recur(int index, int selected) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (index > n)
            return;

        a[selected] = index;
        recur(index + 1, selected + 1);
        a[selected] = 0;
        recur(index + 1, selected);
    }
}
