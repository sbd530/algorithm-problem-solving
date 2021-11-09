package baekjoon.bruteForce1.boj2529;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Main {
    private static int n;
    private static final char[] a = new char[20];
    private static final ArrayList<String> ans = new ArrayList<>();
    private static final boolean[] check = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = sc.next().toCharArray()[0];

        solve(0, "");

        sort(ans);
        int m = ans.size();
        System.out.println(ans.get(m - 1));
        System.out.println(ans.get(0));
    }

    private static void solve(int index, String num) {
        if (index == n + 1) {
            ans.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (check[i])
                continue;
            if (index == 0 || isValid(num.charAt(index - 1), (char) (i + '0'), a[index - 1])) {
                check[i] = true;
                solve(index + 1, num + i);
                check[i] = false;
            }
        }
    }

    private static boolean isValid(char x, char y, char op) {
        if (op == '<') {
            if (x > y)
                return false;
        }
        if (op == '>') {
            if (x < y)
                return false;
        }
        return true;
    }
}
