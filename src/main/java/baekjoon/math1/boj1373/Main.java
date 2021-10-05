package baekjoon.math1.boj1373;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char ZERO_ASCII = '0';

        String input = br.readLine();
        int length = input.length();

        if (length % 3 == 1)
            bw.write(input.charAt(0));
        else if (length % 3 == 2)
            bw.write(((input.charAt(0) - ZERO_ASCII) * 2
                    + (input.charAt(1) - ZERO_ASCII)) + "");

        for (int i = length % 3; i < length; i += 3)
            bw.write(((input.charAt(i) - ZERO_ASCII) * 4
                    + (input.charAt(i + 1) - ZERO_ASCII) * 2
                    + (input.charAt(i + 2) - ZERO_ASCII)) + "");

        bw.flush();
    }
}
