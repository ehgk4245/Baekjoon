import java.io.*;

public class Main {

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            count = 1;
            bw.write(recursion(s, 0, s.length() - 1) + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int recursion(String s, int a, int b) {
        if (a >= b) return 1;
        if (s.charAt(a) != s.charAt(b)) return 0;
        count++;
        return recursion(s, a + 1, b - 1);
    }
}