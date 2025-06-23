import java.io.*;
import java.util.Arrays;

public class Main {

    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int len = (int) Math.pow(3, n);
            arr = new char[len];
            Arrays.fill(arr, '-');
            recursion(0, len);

            for (char c : arr) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int index, int len) {
        if (len == 1) return;
        int mid = index + len / 3;
        for (int i = mid; i < mid + len / 3; i++) {
            arr[i] = ' ';
        }
        recursion(index, len / 3);
        recursion(mid + len / 3, len / 3);
    }

}