package baekjoon.dataStructure1.queue.boj1158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++){
            q.add(i);
        }

        bw.write("<");
        int count = 0;
        while (!q.isEmpty()) {
            count += 1;
            int num = q.poll();

            if (count != K) {
                q.add(num);
            }
            else {
                bw.write(String.valueOf(num));
                count = 0;
                if (!q.isEmpty()) {
                    bw.write(", ");
                }
            }
        }

        bw.write(">");
        bw.flush();
    }
}
