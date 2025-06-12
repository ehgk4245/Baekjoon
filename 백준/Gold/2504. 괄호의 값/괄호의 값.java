import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int value = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();

        outer :
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(' :
                    stack.push(c);
                    value *= 2;
                    break;
                case '[' :
                    stack.push(c);
                    value *= 3;
                    break;
                case ')' :
                    if (stack.empty() || stack.peek() != '(') {
                        result = 0;
                        break outer;
                    }
                    stack.pop();
                    if (s.charAt(i - 1) == '(') {
                        result += value;
                        value /= 2;
                    } else {
                        value /= 2;
                    }
                    break;
                case ']' :
                    if (stack.empty() || stack.peek() != '[') {
                        result = 0;
                        break outer;
                    }
                    stack.pop();
                    if (s.charAt(i - 1) == '[') {
                        result += value;
                        value /= 3;
                    } else {
                        value /= 3;
                    }
                    break;
            }
        }
        if (!stack.empty()) {
            result = 0;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}