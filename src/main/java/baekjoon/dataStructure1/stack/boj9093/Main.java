package baekjoon.dataStructure1.stack.boj9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> sentences = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String sentence = br.readLine();
            sentences.add(sentence);
        }
        for (int i = 0; i < T; i++) {
            String sentence = sentences.get(i);
            String newSentence = convertSentence(sentence);
            System.out.println(newSentence);
        }
    }

    private static String convertSentence(String sentence) {

        char[] chars = sentence.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder newSentence = new StringBuilder();

        for (int j = 0; j < chars.length; j++) {
            if (chars[j] != ' ')
                stack.push(chars[j]);
            else if (chars[j] == ' ') {
                while (!stack.isEmpty())
                    newSentence.append(stack.pop());

                newSentence.append(' ');
            }
        }

        while (!stack.isEmpty())
            newSentence.append(stack.pop());

        return newSentence.toString();
    }
}
