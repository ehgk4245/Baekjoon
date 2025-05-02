import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        int start = 0;
        boolean bool = true;

        outer :
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = start + 1; j <= num; j++) {
                st.push(j);
                sb.append("+\n");
                start++;
            }

            if (st.peek() != num) {
                bw.write("NO");
                bool = false;
                break outer;
            } else {
                st.pop();
                sb.append("-\n");
            }
        }

        if (bool) {
            bw.write(sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
