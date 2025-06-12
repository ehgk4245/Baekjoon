import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char[] charArray = s.replaceAll("\\(\\)", "*").toCharArray();

        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (Character c : charArray) {
            if (c == '*') {
                count += stack.size();
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}