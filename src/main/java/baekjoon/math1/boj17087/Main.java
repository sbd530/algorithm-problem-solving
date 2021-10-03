package baekjoon.math1.boj17087;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int s = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Math.abs(Integer.parseInt(temp[i]) - s);

        int gcd = a[0];
        for (int i = 1; i < n; i++)
               gcd = getGCD(gcd, a[i]);

        bw.write(String.valueOf(gcd));
        bw.flush();
    }

    private static int getGCD(int x, int y) {
        if (y == 0)
            return x;
        else
            return getGCD(y, x % y);
    }
}
