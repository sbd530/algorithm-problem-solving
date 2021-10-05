package baekjoon.math1.boj17103;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var primes = new ArrayList<Integer>();
        var check = new boolean[1_000_001];

        for (int i = 2; i <= 1_000_000; i++) {
            if (!check[i]) {
                primes.add(i);
                for (int j = i + i; j <= 1_000_000; j += i)
                    check[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for (var p : primes) {
                if (n - p >= 2 && p <= n - p) {
                    if (!check[n - p])
                        answer += 1;
                } else {
                    break;
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
