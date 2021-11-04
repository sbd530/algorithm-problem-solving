package baekjoon.bruteForce1.boj1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();

        String[] alp = new String[c];
        for (int i = 0; i < c; i++)
            alp[i] = sc.next();

        Arrays.sort(alp);

        solve(l, alp, "", 0);
    }

    private static void solve(int l, String[] alp, String pwd, int i) {
        if (pwd.length() == l){
            if (checkAeiou(pwd)) {
                System.out.println(pwd);
            }
            return;
        }
        if (i >= alp.length) return;

        // i번째 alp 사용
        solve(l, alp, pwd + alp[i], i + 1);
        // i번째 alp 사용 안함
        solve(l, alp, pwd, i + 1);
    }

    private static boolean checkAeiou(String pwd) {
        int aeiou = 0;
        int others = 0;
        for (char c : pwd.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                aeiou += 1;
            else
                others += 1;
        }
        return aeiou >= 1 && others >= 2;
    }
}
