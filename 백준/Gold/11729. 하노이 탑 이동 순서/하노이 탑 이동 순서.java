import java.io.*;

public class Main {

    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        recursion(1, 3, n);

        bw.write(count + "\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int start, int end, int n) throws IOException {
        if (n == 0) {
            return;
        }
        recursion(start, 6 - end - start, n - 1);
        sb.append(start).append(" ").append(end).append("\n");
        count++;
        recursion(6 - end - start, end, n - 1);
    }
}