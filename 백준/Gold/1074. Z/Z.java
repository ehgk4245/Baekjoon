import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        recursion(n, r, c);

        System.out.println(count);
        br.close();
    }

    static void recursion(int n, int r, int c) {
        if (n == 1) {
            return;
        }

        int mid = n / 2;

        if (r < mid && c < mid) {
            recursion(mid, r, c);
        } else if (r < mid && c >= mid) {
            count += mid * mid;
            recursion(mid, r, c - mid);
        } else if (r >= mid && c < mid) {
            count += mid * mid * 2;
            recursion(mid, r - mid, c);
        } else {
            count += mid * mid * 3;
            recursion(mid, r - mid, c - mid);
        }
    }
}