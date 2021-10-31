package baekjoon.bruteForce1.boj1748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        int n = Integer.parseInt(temp);
        int len = temp.length();

        int ans = 0;
        if (len > 1) {
            for (int i = 0; i < (len - 1); i++) {
                ans += (i + 1) * 9 * Math.pow(10, i);
            }
        }

        ans += len * (n + 1 - Math.pow(10, len - 1));
        System.out.println(ans);
    }
}
