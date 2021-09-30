package baekjoon.math1.boj1929;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        boolean[] trueIfErased = new boolean[n + 1];
        trueIfErased[0] = trueIfErased[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (trueIfErased[i])
                continue;
            for (int j = i*2; j <= n; j += i)
                trueIfErased[j] = true;
        }

        for (int i = m; i <= n; i++)
            if (!trueIfErased[i])
                bw.write(i + "\n");

        bw.flush();
    }
}
