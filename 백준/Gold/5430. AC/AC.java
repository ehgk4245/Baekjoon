import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        boolean isReversed = false;
        boolean isError = false;
        for (int i = 0; i < n; i++) {
            char[] command = br.readLine().toCharArray();
            int m = Integer.parseInt(br.readLine());
            String s = br.readLine();

            if (m != 0) {
                String[] split = s.substring(1, s.length() - 1).split(",");
                for (String string : split) {
                    deque.addLast(Integer.parseInt(string));
                }
            }

            outer :
            for (char c : command) {
                switch (c) {
                    case 'R' :
                        isReversed = !isReversed;
                        break;

                    case 'D' :
                        if (deque.isEmpty()) {
                            isError = true;
                            break outer;
                        }
                        if (isReversed) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                        break;
                }
            }

            if(isError) {
                sb.append("error").append("\n");
                isError = false;
                isReversed = false;
                continue;
            }

            boolean isEmpty = false;
            if (deque.isEmpty()) {
                isEmpty = true;
            }
            sb.append("[");
            if (isReversed) {
                while (!deque.isEmpty()) {
                    if (deque.size() == 1) {
                        sb.append(deque.removeLast()).append("]");
                    } else {
                        sb.append(deque.removeLast()).append(",");
                    }
                }
            } else {
                while (!deque.isEmpty()) {
                    if (deque.size() == 1) {
                        sb.append(deque.removeFirst()).append("]");
                    } else {
                        sb.append(deque.removeFirst()).append(",");
                    }
                }
            }
            if (isEmpty) {
                sb.append("]");
            }
            sb.append("\n");
            isReversed = false;
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
