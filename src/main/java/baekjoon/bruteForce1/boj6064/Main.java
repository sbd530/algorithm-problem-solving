package baekjoon.bruteForce1.boj6064;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            boolean found = false;
            for (int i = x; i < (m * n); i += m) {
                if (i % n == y) {
                    sb.append(i + 1).append("\n");
                    found = true;
                    break;
                }
            }
            if (!found)
                sb.append(-1).append("\n");
        }
        System.out.println(sb);
    }
}
