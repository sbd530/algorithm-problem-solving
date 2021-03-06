package baekjoon.bruteForce1.boj1248;

import java.util.Scanner;

public class Main {
    private static int n;
    private static int[][] sign;
    private static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = new int[n];
        sign = new int[n][n];
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = s.charAt(cnt);
                if (x == '0')
                    sign[i][j] = 0;
                else if (x == '+')
                    sign[i][j] = 1;
                else
                    sign[i][j] = -1;
                cnt += 1;
            }
        }

        solve(0);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    private static boolean solve(int index) {
        if (index == n) return true;
        if (sign[index][index] == 0) {
            ans[index] = 0;
            return check(index) && solve(index + 1);
        }
        for (int i = 1; i <= 10; i++) {
            ans[index] = sign[index][index] * i;
            if (check(index) && solve(index + 1))
                return true;
        }
        return false;
    }

    private static boolean check(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += ans[i];
            if (sign[i][index] == 0) {
                if (sum != 0) return false;
            } else if (sign[i][index] < 0) {
                if (sum >= 0) return false;
            } else if (sign[i][index] > 0) {
                if (sum <= 0) return false;
            }
        }
        return true;
    }

}
