package baekjoon.bruteForce1.boj1107;

import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {

    private static final boolean[] broken = new boolean[10];
    private static final int CUR_CHANNEL = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            broken[b] = true;
        }

        int ans = abs(n - CUR_CHANNEL);

        for (int channel = 0; channel <= 1_000_000; channel++) {
            int length = ifPossibleGetLengthOrZero(channel);
            if (length > 0) {
                ans = min(ans, length + abs(channel - n));
            }
        }

        System.out.println(ans);
    }

    private static int ifPossibleGetLengthOrZero(int channel) {
        if ( channel == 0)
            return broken[0] ? 0 : 1;

        int length = 0;
        while (channel > 0) {
            if (broken[channel % 10])
                return 0;
            length += 1;
            channel /= 10;
        }
        return length;
    }
}
