import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 100000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        Stack<Top> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                    result[i - 1] = 0;
                    stack.push(new Top(i, height));
                    break;
                }
                Top top = stack.peek();
                if (top.height < height) {
                    stack.pop();
                } else {
                    result[i - 1] = top.index;
                    stack.push(new Top(i, height));
                    break;
                }
            }
        }

        for (int i : result) {
            sb.append(i + " ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
    static class Top {

        private final int index;
        private final int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
