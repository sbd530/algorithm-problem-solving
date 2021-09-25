package baekjoon.dataStructure1.stack.boj9012;

import java.io.*;

public class Main {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String vps = br.readLine();
            int leftCount = 0;

            for (char ch : vps.toCharArray())
                if (ch == '(')
                    leftCount += 1;
                else if (ch == ')')
                    if (leftCount > 0)
                        leftCount -= 1;
                    else
                        {leftCount -= 1; break;}

            if (leftCount == 0)
                bw.write(YES);
            else
                bw.write(NO);

            bw.write("\n");
        }

        bw.flush();
    }
}
