import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(function(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
        bw.flush();
        bw.close();
        br.close();
    }

    static long function(int a, int b, int m) {
        if (b == 0) return 1;
        long num = function(a, b / 2, m);
        num = num * num % m;
        if (b % 2 == 0) return num;
        return num * a % m;
    }
}