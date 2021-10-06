package baekjoon.dp1.boj1463;

import java.io.*;

public class Main {

    private static int[] d;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        bw.write(Integer.toString(f(n)));
        bw.flush();
    }

    private static int f(int n) {
        if (n == 1) return 0;
        if (d[n] != 0) return d[n];
        d[n] = f(n - 1) + 1;
        if (n % 2 == 0) {
            int temp = f(n / 2) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        if (n % 3 == 0) {
            int temp = f(n / 3) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        return d[n];
    }
}
