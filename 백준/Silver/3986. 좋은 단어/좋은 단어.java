import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {
                if (stack.empty() || stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            if (stack.empty()) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}